package com.rxx.socketdemo.socket.nio.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.msg.MsgHandler;

/**
 * @Title      :NIOSocketServerHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月17日 上午10:04:35
 */
public class NIOSocketServerHandler implements Runnable {

    private Selector selector;
    
    public NIOSocketServerHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        // 遍历 selector
        while(true){
            try {
                // 无论是否有读写操作发生，selector 每隔 1s 都会被唤醒一次
                selector.select(1000);
                // 阻塞，只有当至少一个注册事件发生时才会继续
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handlerInput(selectionKey);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if(selectionKey != null) {
                            selectionKey.cancel(); 
                            if(selectionKey.channel() != null){
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

    /**
     * 处理消息
     * @param selectionKey
     * @throws IOException 
     */
    private void handlerInput(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isValid()){
            // 处理新接入的请求消息
            if(selectionKey.isAcceptable()){
                // 通过 ServerSocketChannel 的 accept 创建 ServerSocket 实例
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                // 完成该操作意味着三次握手成功， TCP 物理链路正式建立
                SocketChannel socketChannel = serverSocketChannel.accept();
                // 增加一个客户端
                NIOSocketServer.clientCount ++; 
                System.out.println(BaseConstant.CLIENT_COUNT_PLUS_MSG + NIOSocketServer.clientCount);
                // 设置为非阻塞
                socketChannel.configureBlocking(false);
                // 注册为读
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            
            // 读消息
            if(selectionKey.isReadable()){
                SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                // 创建 ByteBuffer，并且开辟一个 1M 的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                // 读取请求码流，并返回取到的字节数
                int len = socketChannel.read(buffer);
                // 读取到字节，对字节进行编码
                if(len > 0){
                    // 将缓冲区当前的 limit 设置为 position=0。用于后序对缓冲区的读取操作
                    buffer.flip();
                    // 根据 缓冲区可读取的字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    // 将缓冲区可读字节数组复制到新建的数组中  
                    buffer.get(bytes);
                    String msg  = new String(bytes, BaseConstant.CHARSET);
                    if(BaseConstant.QUIT.equals(msg)){
                        NIOSocketServer.clientCount --;
                        System.out.println(BaseConstant.CLIENT_COUNT_MINUS_MSG + NIOSocketServer.clientCount);
                        return;
                    }
                    byte[] result = MsgHandler.acceptMsg(msg);
                    // 发送应答消息
                    doWrite(socketChannel, result);
                }
            }
            
        }
    }

    private void doWrite(SocketChannel socketChannel, byte[] bytes) throws IOException {
        // 根据数组容量创建  ByteBuffer 
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        // 将字节数组放在缓冲区
        byteBuffer.put(bytes);
        // flit 操作
        byteBuffer.flip();
        // 发送缓冲区的字节数组
        socketChannel.write(byteBuffer);
        // 这里不包含“写半包”的代码
    }

}

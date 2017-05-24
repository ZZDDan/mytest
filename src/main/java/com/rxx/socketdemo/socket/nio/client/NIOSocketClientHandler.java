package com.rxx.socketdemo.socket.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.rxx.socketdemo.bean.BaseConstant;

/**
 * @Title      :NIOSocketClientHandler
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月17日 上午11:06:17
 */
public class NIOSocketClientHandler implements Runnable {

    private Selector selector;
    private SocketChannel socketChannel;
    private InetSocketAddress inetSocketAddress;
    private boolean stop;
    
    public NIOSocketClientHandler(Selector selector, SocketChannel socketChannel, InetSocketAddress inetSocketAddress) {
        this.selector = selector;
        this.socketChannel = socketChannel;
        this.inetSocketAddress = inetSocketAddress;
    }

    @Override
    public void run() {
        // 连接服务端
        try {
            if(!socketChannel.connect(inetSocketAddress)){
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); 
        }

        // 循环遍历 Selector 
        while(!stop){
            try {
                // 无论读或写是否发生，Select 每隔 1s 唤醒一次
                selector.select(1000);
                //阻塞，只有至少一个 注册事件发生时，才会继续
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                if(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handlerInput(selectionKey);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if(selectionKey != null){
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
        // selectionKey 是否有效
        if(selectionKey.isValid()){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            // 用于检查套接字是否已经建立了连接，从而避免在进行其他操作时抛出NotYetConnectedException异常
            if(selectionKey.isConnectable()){
                if(!socketChannel.finishConnect()){
                    System.exit(1); 
                }
            }
            // 读消息
            if(selectionKey.isReadable()){
                // 创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                // 读取请求码流，返回读取到的字节数
                int len = socketChannel.read(byteBuffer);
                // 读取到字节，对字节进行编解码
                if(len > 0){
                    // 将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    byteBuffer.flip();
                    // 根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    // 将缓冲区可读字节数组复制到新建的数组中  
                    byteBuffer.get(bytes);
                    String result = new String(bytes, "UTF-8");
                    System.out.println(BaseConstant.CLIENT_ACCEPTED_MSG + result);
                }else if(len<0){  
                    //链路已经关闭，释放资源
                    selectionKey.cancel();  
                    socketChannel.close();  
                }  
            }
        }
    }
    
    /**
     * 向通道中写消息
     * @param channel
     * @param msg
     * @throws IOException
     */
    private void doWrite(SocketChannel channel, String msg) throws IOException{
        // 将消息编码为字节数组
        byte[] bytes = msg.getBytes();
        // 根据数组容量创建 ByteBuffer 
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        // 将字节数组复制到缓冲区
        byteBuffer.put(bytes);
        // flip操作
        byteBuffer.flip();
        // 发送缓冲区的字节数组 
        channel.write(byteBuffer);
        // ****此处不含处理“写半包”的代码  
    }

    /**
     * 发送消息
     * @param msg
     * @throws IOException
     */
    public void sendMsg(String msg) throws IOException{
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel, msg);
    }

    /**
     * 关闭客户端
     */
    public void close() {
        stop = true;
        if(socketChannel != null){
            try {
                socketChannel.close();
                socketChannel = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.rxx.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rxx.socket.bio.ChartServer;

/**
 * @Title      :NIOServer
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:28:17
 */
public class NIOServer implements Runnable {  
  
    private final static int BLOCK_SIZE = 1024;  
    private ServerSocketChannel serverSocketChannel;  
    private Selector selector;  
    private ByteBuffer readBuffer;  
    private Charset cs = Charset.forName("utf-8");  
      
    public NIOServer(String ip , int port) {  
          
        try {  
            readBuffer = ByteBuffer.allocateDirect(BLOCK_SIZE);  
            serverSocketChannel = ServerSocketChannel.open();  
            serverSocketChannel.bind(new InetSocketAddress(ip, port));  
            serverSocketChannel.configureBlocking(false);  
            selector = Selector.open();  
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  
              
            System.out.println("the server is started");  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
    @Override  
    public void run() {  
        int count = 0;  
        while(true){  
            try {  
                count = selector.select();  
                if(count <=0)continue;  
                  
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();  
                while(iterator.hasNext()){  
                    SelectionKey sk = iterator.next();  
                    handlerSK(sk);  
                    iterator.remove();  
                }  
            } catch (Exception e) {  
            }  
        }  
          
          
    }  
  
    private void handlerSK(SelectionKey sk) throws IOException {  
//      ServerSocketChannel ssChannel = null;  
        SocketChannel sChannel = null;  
        if(sk.isAcceptable()){  //if the SelectionKey.OP_ACCEPT  
//          ssChannel = (ServerSocketChannel) sk.channel();  
            sChannel = serverSocketChannel.accept();  
            sChannel.configureBlocking(false);  
            sChannel.register(selector, SelectionKey.OP_READ);  
              
            if(sChannel.isConnected()){  
                System.out.println("host:"+sChannel.getLocalAddress()+"is connected");  
            }  
              
        }else if(sk.isReadable()){ //SelectionKey.OP_READ  
            sChannel = (SocketChannel) sk.channel();  
              
            int len = 0;  
            readBuffer.clear();  
            while((len = sChannel.read(readBuffer)) >0){  
                readBuffer.flip();  
                System.out.println(String.valueOf(cs.decode(readBuffer).array()));  
            }  
            sChannel.register(selector, SelectionKey.OP_WRITE);  
        }else if(sk.isWritable()){ //SelectionKey.OP_WRITE  
            sChannel = (SocketChannel) sk.channel();  
              
            readBuffer.clear();  
            readBuffer.put("woshiserver".getBytes(cs));  
            readBuffer.flip();  
              
            sChannel.write(readBuffer);  
              
            sChannel.register(selector, SelectionKey.OP_READ);  
        }  
    }  
    
    public static void main(String[] args) {
        NIOServer nioServer = new NIOServer("127.0.0.1", 9002);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(nioServer);
    }
}

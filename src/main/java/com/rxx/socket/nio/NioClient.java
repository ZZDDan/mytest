package com.rxx.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rxx.socket.bio.Client;

/**
 * @Title      :NioClient
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月6日 下午5:29:06
 */
public class NioClient implements Runnable{  
  
    private Charset cs = Charset.forName("utf-8");  
    private SocketChannel socketChannel;  
    private Selector selector;  
    private String ip;  
    private int port;  
    Scanner sc = null;  
    public NioClient(String ip, int port) {  
        this.ip = ip;  
        this.port = port;  
        try {  
            sc = new Scanner(System.in);  
            socketChannel = SocketChannel.open();  
            socketChannel.configureBlocking(false);  
            selector = Selector.open();  
            socketChannel.register(selector, SelectionKey.OP_CONNECT);  
              
            socketChannel.connect(new InetSocketAddress(ip, port));  
      
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    @Override  
    public void run() {  
        Iterator<SelectionKey> itor = null;  
        int len = 0;  
        try {  
            while(true){  //轮询事件  
                while((len = selector.select()) >0){  //存在要处理的事件  
                    itor = selector.selectedKeys().iterator();  
                    System.out.println("len:"+len);  
                    while(itor.hasNext()){  
                        SelectionKey sk = itor.next();  
                        process(sk);  
                        itor.remove();  //删除  
                          
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    private void process(SelectionKey sk) {  
          
        try {  
              
            if(sk.isConnectable()){  //channel可】连接  
                  
                SocketChannel channel =  (SocketChannel) sk.channel();  
                if(channel.isConnectionPending()){  
                    channel.finishConnect();  
                }  
                  
                if(channel.isConnected()){  
                    System.out.println(channel.getRemoteAddress().toString());  
                }  
                  
                channel.register(selector, SelectionKey.OP_WRITE);  
            }  
            if(sk.isReadable()){  //channel可读  
                SocketChannel channel =  (SocketChannel) sk.channel();  
                ByteBuffer bb = ByteBuffer.allocate(1024);  
                int len;  
                byte[] b = new byte[1024];  
                System.out.println("读取中,..");  
                while((len = channel.read(bb))>0){  
                    bb.flip();  
                    System.out.println(String.valueOf(cs.decode(bb).array()));  
                      
                }  
                channel.register(selector, SelectionKey.OP_WRITE);  
            }else if(sk.isWritable()){  
                SocketChannel channel =  (SocketChannel) sk.channel();  
                ByteBuffer bb = ByteBuffer.allocate(1024);  
                bb.put("woshizhangsan".getBytes(cs));  
                bb.flip();  
                channel.write(bb);  
                  
                channel.register(selector, SelectionKey.OP_READ);  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        exec.execute(new NioClient("127.0.0.1", 9002));
    }
}

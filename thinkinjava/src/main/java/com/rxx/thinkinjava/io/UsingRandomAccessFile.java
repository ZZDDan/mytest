package com.rxx.thinkinjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 16:44
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() throws IOException {
        // 读操作
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        // 写文件
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        // 显示
        display();

        // 写文件
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();
        // 显示
        display();
    }

}

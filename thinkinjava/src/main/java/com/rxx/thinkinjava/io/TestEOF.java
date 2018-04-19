package com.rxx.thinkinjava.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:24
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        String file = "thinkinjava\\src\\main\\java\\com\\rxx\\thinkinjava\\io\\TestEOF.java";
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }

}

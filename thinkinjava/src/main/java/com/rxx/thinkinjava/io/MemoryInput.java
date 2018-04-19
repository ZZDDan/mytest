package com.rxx.thinkinjava.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:28
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("thinkinjava\\src\\main\\java\\com\\rxx\\thinkinjava\\io\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

}

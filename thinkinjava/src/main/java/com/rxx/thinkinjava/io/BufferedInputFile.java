package com.rxx.thinkinjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:07
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("thinkinjava\\src\\main\\java\\com\\rxx\\thinkinjava\\io\\BufferedInputFile.java"));
    }
}

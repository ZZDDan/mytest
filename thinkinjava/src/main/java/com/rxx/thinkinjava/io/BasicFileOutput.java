package com.rxx.thinkinjava.io;

import java.io.*;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:04
 */
public class BasicFileOutput {

    public static void main(String[] args) throws IOException {
        String file = "BasicFileOutput.out";
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("thinkinjava/src/main/java/com/rxx/thinkinjava/io/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        in.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}

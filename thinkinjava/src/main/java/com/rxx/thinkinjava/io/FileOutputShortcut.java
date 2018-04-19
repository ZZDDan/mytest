package com.rxx.thinkinjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:13
 */
public class FileOutputShortcut {

    public static void main(String[] args) throws IOException {
        String file = "FileOutputShortcut.out";
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read("thinkinjava/src/main/java/com/rxx/thinkinjava/io/FileOutputShortcut.java")));
        // Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
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

package com.rxx.thinkinjava.io;

import java.io.*;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:36
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        // 构建流
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("thinkinjava/src/main/java/com/rxx/thinkinjava/io/Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        // 设置系统标准流
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        // 测试
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }
        out.close(); // Remember this!
        System.setOut(console);
    }

}

package com.rxx.jdkcommon.io;

import org.junit.Test;

import java.io.*;

/**
 * @author :zhangdan
 * @Description: 标准的输入输出流
 * @Company :
 * @date :2018/4/10 15:33
 */
public class StandardStreamTest {


    /**
    注意：该测试不能在 junit 单元测试下执行
     */
    public static void main(String[] args) throws IOException {

        InputStream in = System.in;

        // 0. 输入数字：5，输出：53，因为 System.in.read()返回的是输入数值的 ASCII 码(一个 int 整数)。
        int num = in.read();
        System.out.print("Enter a line:");
        System.out.println("num=" + num);

        // 1. 这是从键盘读入一行数据,返回的是一个数据对应的字符串
        BufferedReader stdin = new BufferedReader(new InputStreamReader(in));
        System.out.print("Enter a line:");
        System.out.println("num=" + stdin.readLine());

        stdin.close();
    }

    @Test
    public void testStandardOut(){

        PrintStream out1 = System.out;
        PrintStream out2 = System.out;

        System.setOut(out1);
        out1.println(out1.toString());

        System.setOut(out2);
        out1.println(out2.toString());

    }
    // 运行结果：
    // java.io.PrintStream@5e8c92f4
    // java.io.PrintStream@5e8c92f4


    @Test
    public void testStandardErr(){
        PrintStream err = System.err;
        err.println(err.toString());
    }
    // 运行结果：（显示是红色的）
    // java.io.PrintStream@5e8c92f4

}

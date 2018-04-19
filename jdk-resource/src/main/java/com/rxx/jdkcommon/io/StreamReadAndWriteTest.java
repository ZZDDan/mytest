package com.rxx.jdkcommon.io;

import org.junit.Test;

import java.io.*;

/**
 * @author :zhangdan
 * @Description: 测试 InputStreamReader 和 OutputStreamWriter 
 * @Company :
 * @date :2018/4/10 17:17
 */
public class StreamReadAndWriteTest {

    @Test
    public void test() throws IOException {
        System.out.println(System.getProperty("java.class.path"));
        String  userDir = System.getProperty("user.dir");
        String dir = userDir + "/src/main/java/com/rxx/jdkcommon/io/";

        InputStreamReader isr = new InputStreamReader(new FileInputStream(dir + "StreamReadAndWriteTest.java"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dir + "test/StreamReadAndWriteTest.java"), "utf-8");

        int i;
        while((i = isr.read()) != -1){
            System.out.print((char)i);
            osw.write((char)i);
        }

        osw.close();
        isr.close();
    }

    @Test
    public void testPrintWriter() throws FileNotFoundException {
        String  userDir = System.getProperty("user.dir");
        String dir = userDir + "/src/main/java/com/rxx/jdkcommon/io/";
        PrintStream printStream = new PrintStream(new FileOutputStream(dir + "PrintWriterTest.java"),true);
        System.setOut(printStream);
        System.out.println(dir);
        printStream.close();
    }

    @Test
    public void testDataStream() throws IOException {
        String  userDir = System.getProperty("user.dir");
        String dir = userDir + "/src/main/java/com/rxx/jdkcommon/io/";

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(dir + "/test/DataStreamTest.txt"));
        dos.writeDouble(12.34);
        dos.writeBoolean(false);
        dos.writeChar('A');
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream(dir + "/test/DataStreamTest.txt"));
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        dis.close();

    }
}

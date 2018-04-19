package com.rxx.thinkinjava.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/11 17:19
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        String file = "thinkinjava\\src\\main\\java\\com\\rxx\\thinkinjava\\io\\FormattedMemoryInput.java";
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(file).getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }

}

package com.rxx.socketdemo.msg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.script.ScriptException;

import com.rxx.socketdemo.bean.BaseConstant;
import com.rxx.socketdemo.util.Calculator;

/**
 * @Title      :MsgType
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月19日 上午9:47:26
 */
public enum MsgType {

    CALCULAR {// 计算表达式
        @Override
        public byte[] interpret(String expression) {
            // 处理数据
            String result = null;
            try {
                result = Calculator.cal(expression).toString();
                Thread.sleep((long)Double.parseDouble(result) * 100);
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            return result.getBytes();
        }
    }, 
    READ_FILE {// 读取文件
        @Override
        public byte[] interpret(String filepath) {
            File file = new File(filepath);
            InputStream is = null;
            long len = file.length();
            if(len > 5 * 1024 * 1024){
                return BaseConstant.MSG_ALERT.getBytes();
            }
            byte[] b = new byte[(int) file.length()];//5MB 1byte=1B  1KB=1024B  1MB=1024MB
            try {
                is = new FileInputStream(file);
                is.read(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return b;
        }
    };
    
    public abstract byte[] interpret(String msg);
}

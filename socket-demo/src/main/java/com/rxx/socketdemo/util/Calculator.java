package com.rxx.socketdemo.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Title      :Calculator
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月11日 下午5:13:07
 */
public class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Object cal(String expression) throws ScriptException{
        return jse.eval(expression);
    }
}

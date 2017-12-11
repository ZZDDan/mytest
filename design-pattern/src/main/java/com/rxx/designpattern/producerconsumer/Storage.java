package com.rxx.designpattern.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 18:08
 */
public abstract class Storage {

    private int maxLen = 10;
    private int minLen = 1;
    private List<Object> list = new ArrayList<>();
    private Object object = new Object();

    public abstract void produce();
    public abstract void consume();

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }

    public int getMinLen() {
        return minLen;
    }

    public void setMinLen(int minLen) {
        this.minLen = minLen;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}

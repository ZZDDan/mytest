package com.rxx.utils.dom;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/**
 * Created by zhang on 2017/9/13.
 */
public class AttackXmlResult {

    private static final Logger logger = Logger.getLogger(AttackXmlResult.class);

    /**
     * 解析 xml
     * @param result
     * @return
     */
    public static EventDealResult parseDealResult(String result) {
        // 创建数据对象
        //Map<String, Map<String, String>> map = new HashMap<>();
        EventDealResult eventDealResult = new EventDealResult();

        // 读取数据
        SAXReader reader = new SAXReader();
        Document read;
        try {
            read = reader.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
        } catch (DocumentException | UnsupportedEncodingException e) {
            logger.error("获取数据失败", e);
            return eventDealResult;
        }

        // 获取根元素
        Element rootElement = read.getRootElement();
        Iterator it = rootElement.elementIterator();

        // =====错误信息节点和数据节点=====
        while (it.hasNext()){
            getEleData(eventDealResult, it);
        }
        return eventDealResult;
    }

    private static void getEleData(EventDealResult eventDealResult, Iterator it) {
        Element infoEle = (Element) it.next();
        // "节点名：" + infoDet.getName() + "--节点值：" + bookChild.getStringValue()
        //Map<String, String> infoMap = new HashMap();
        //map.put(info.getName(), infoMap);

        String name = infoEle.getName();
        int index = name.indexOf("_");

        if(index == -1){
            getEleData(eventDealResult, infoEle.elementIterator());
            return;
        }

        name = "get" + Character.toUpperCase(name.charAt(0))
                + name.substring(1, index)
                + Character.toUpperCase(name.charAt(index+1))
                + name.substring(index+2, name.length());
        Object infoObj;
        try {
            infoObj = MethodUtils.invokeMethod(eventDealResult, name);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            logger.error("通过反射获取对象失败", e);
            return;
        }

        // =====错误信息节点和数据节点的具体明细=====
        Iterator itt = infoEle.elementIterator();
        while (itt.hasNext()) {
            Element infoDetEle = (Element) itt.next();
            // "节点名：" + infoDetEle.getName() + "--节点值：" + infoDetEle.getStringValue()
            //infoMap.put(infoDetEle.getName(), infoDetEle.getStringValue());
            String gname = infoDetEle.getName();
            int gindex = name.indexOf("_");
            // 将下划线字符串转为驼峰字符串
            gname = "set" + Character.toUpperCase(gname.charAt(0))
                    + gname.substring(1, gindex)
                    + Character.toUpperCase(gname.charAt(gindex+1))
                    + gname.substring(gindex+2, gname.length());

            try {
                MethodUtils.invokeMethod(infoObj, gname, infoDetEle.getStringValue());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                logger.error("通过反射执行方法失败", e);
                continue;
            }

        }
    }
}

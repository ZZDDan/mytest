package com.rxx.websocket;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.List;
import java.util.Map;

/**
 * @Title      :ServerEncoder
 * @Description:编写自己的解码器，
 *      使用 sendObject(obj)会报错javax.websocket.EncodeException: No encoder specified for object of class [class XXX]，
 *      可以自己实现编码器，注意添加 ServerEncoder.class @ServerEndpoint(value = "/websocket/news", encoders = { ServerEncoder.class })
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年6月8日 下午4:04:19
 */
public class ServerEncoder implements Encoder.Text<List<String>> {

    private static Logger log = Logger.getLogger(ServerEncoder.class);

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public String encode(List<String>  message) throws EncodeException {
        try {
            return JSONObject.toJSON(message).toString();
        } catch (Exception e) {
            log.error("数据转为 Json 失败", e);
            return "{}";
        }
    }

}

package com.rxx.webservice.client;

import com.rxx.utils.dom.AttackXmlResult;
import com.rxx.webservice.server.IEventMonitorService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

/**
 * Created by zd on 2017/9/18.
 *
 * 基于 soap 的客户端调用
 */
public class EventMonitorClient {

    /**
     * 通过代理API调用，依赖于服务端的接口
     */
    @Test
    public void testClientByProxy(){
        // 调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IEventMonitorService.class);
        factory.setAddress("http://localhost:8081/somcweb/services/queryItems");
        IEventMonitorService service = (IEventMonitorService) factory.create();
        String items = service.queryItems("webpage", null);
        System.out.println(items);
    }

    /**
     * 不依赖服务端的接口
     * @throws Exception
     */
    @Test
    public void testClient() throws Exception{
        //不依赖服务器端接口来完成调用的，也就是不仅仅能调用Java的接口
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://localhost:8081/somcweb/services/handleItemByParams?wsdl");
        Object[] items = client.invoke("handleItemByParams", "1001", "dns", "{}", null);
        System.out.println(AttackXmlResult.parseDealResult(String.valueOf(items[0])));
    }
}

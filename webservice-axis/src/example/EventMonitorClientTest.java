package example;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 *
 * @author zd
 * @date 2017/9/18
 *
 * 基于 soap 的客户端调用
 */
public class EventMonitorClientTest {


    /**
     * 使用 axis 打开的 webservice 连接，具体没有测通，需要再调试
     */
    @Test
    public void testClientByAxis(){

        String endpoint = "http://localhost:8082/somcweb/services/handleService?wsdl";
        String endpointTJ = "http://localhost:8082/somcweb/services/handleServiceTJ?wsdl";
        // webservice地址
        System.out.println("HB-queryItems：" + invokeWS(endpoint, "queryItems", "webpage", null));
        System.out.println("HB-handleItemByParams：" + invokeWS(endpoint, "handleItemByParams", "1", "2", "3", null));
        System.out.println("HB-queryTaskResult：" + invokeWS(endpoint, "queryTaskResult", "1", null));

        // webservice地址
        System.out.println("TJ-queryItems：" + invokeWS(endpointTJ, "queryItems", null));
        System.out.println("TJ-handleItemByParams：" + invokeWS(endpointTJ, "handleItemByParams", "1", new String[]{"192.168.1.2", "8080"}, null));
        System.out.println("TJ-queryTaskResult：" + invokeWS(endpointTJ, "queryTaskResult", "1", null));
    }

    /**
     * 发送 Webservice 接口请求，返回请求结果
     * @param operationName 方法名称
     * @param parameter 参数列表
     * @return
     */
    public static Object invokeWS(String endpoint, String operationName, Object... parameter){
        String result = null;

        // 直接引用远程的wsdl文件
        Service service = new Service();
        Call call;
        try {
            call = (Call)service.createCall();
            call.setTargetEndpointAddress(new URL(endpoint));
            // 你需要远程调用的方法
            call.setOperationName(new QName(operationName));
            call.removeAllParameters();
            // 创建连接
            result = (String) call.invoke(parameter);
        } catch (ServiceException | MalformedURLException | RemoteException e) {
            System.out.println("访问 ws 接口失败： " + operationName);
            e.printStackTrace();
        }// 解析获得的结果
        return result;
    }
}

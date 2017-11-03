package example;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/11/2 16:19
 */
public class HelloWorld {
    public String sayHelloWorldFrom(String from) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc>错误描述错误描述</error_desc>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <task_id>12345</task_id>" +
                "  </data_info>" +
                "</root>";
    }

    public String handleItemByParams(String itemId, String type, String params, String extendXml){
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc>错误描述错误描述</error_desc>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <task_id>12345</task_id>" +
                "  </data_info>" +
                "</root>";
    }
    public String sayHelloWorldFrom3(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }
}

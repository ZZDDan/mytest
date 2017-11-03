package example;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/11/3 14:23
 */
public class TianJinSomc {

    public String queryItems(String extendXml) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                " <error_info>" +
                "  <error_code>1000</error_code>" +
                "  <error_desc>错误描述错误描述</error_desc>" +
                " </error_info>" +
                " <data_info>" +
                "  <page>" +
                "   <item>" +
                "    <item_id>1231</item_id>" +
                "    <item_name>网页篡改1</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "   <item>" +
                "    <item_id>1232</item_id>" +
                "    <item_name>网页篡改2</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </page>" +
                "  <cdn>" +
                "   <item>" +
                "    <item_id>1233</item_id>" +
                "    <item_name>CNDXX</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </cdn>" +
                "  <ddos>" +
                "   <item>" +
                "    <item_id>1234</item_id>" +
                "    <item_name>DDOS工具</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </ddos>" +
                "  <dns>" +
                "   <item>" +
                "    <item_id>1235</item_id>" +
                "    <item_name>DNS劫持</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </dns>" +
                "  <msg>" +
                "   <item>" +
                "    <item_id>1236</item_id>" +
                "    <item_name>MSG短信</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </msg>" +
                " </data_info>" +
                "</root>";
    }

    public String handleItemByParams(String itemId, String[] params, String extendXml) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                " <error_info>" +
                "  <error_code>1000</error_code>" +
                "  <error_desc>错误描述错误描述</error_desc>" +
                " </error_info>" +
                " <data_info>" +
                "  <task_id>12345</task_id>" +
                " </data_info>" +
                "</root>";
    }

    public String queryTaskResult(String taskId, String extendXml){
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                " <error_info>" +
                "  <error_code>1000</error_code>" +
                "  <error_desc>错误描述错误描述</error_desc>" +
                " </error_info>" +
                " <data_info>" +
                "  <task_id>12345</task_id>" +
                "  <task_status>5</task_status>" +
                "  <task_create_time>2017-01-01 12:00:00</task_create_time>" +
                "  <task_approval_time>2017-01-01 12:02:00</task_approval_time>" +
                "  <result_status>2</result_status>" +
                "  <result_create_time>2017-01-01 12:02:00</result_create_time>" +
                "  <script_content>" +
                "   <![CDATA[脚本内容脚本内容]]>" +
                "  </script_content>" +
                "  <result_content>" +
                "   <![CDATA[执行结果内容]]>" +
                "  </result_content>" +
                " </data_info>" +
                "</root>";
    }
}

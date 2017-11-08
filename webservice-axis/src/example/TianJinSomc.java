package example;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/11/3 14:23
 */
public class TianJinSomc {

    public String queryItems(String extendXml) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc/>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <page>" +
                "      <item>" +
                "        <item_id>20084</item_id>" +
                "        <item_name>MISIC1</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20085</item_id>" +
                "        <item_name>MISIC2</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20086</item_id>" +
                "        <item_name>校讯通</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "    </page>" +
                "    <cdn>" +
                "      <item>" +
                "        <item_id>20109</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20111</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20110</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "    </cdn>" +
                "    <ddos>" +
                "      <item>" +
                "        <item_id>20100</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20103</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20102</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20101</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "    </ddos>" +
                "    <dns>" +
                "      <item>" +
                "        <item_id>20104</item_id>" +
                "        <item_name>强解处理1</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20105</item_id>" +
                "        <item_name>重启Cache进程1</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20106</item_id>" +
                "        <item_name>重启Zlope进程1</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "    </dns>" +
                "    <msg>" +
                "      <item>" +
                "        <item_id>20108</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "      <item>" +
                "        <item_id>20107</item_id>" +
                "        <item_name>处置项名称</item_name>" +
                "        <approval_user_name/>" +
                "        <approval_user_phone/>" +
                "        <so_ip/>" +
                "        <script_content/>" +
                "      </item>" +
                "    </msg>" +
                "  </data_info>" +
                "</root>";
    }

    public String handleItemByParams(String itemId, String[] params, String extendXml) {
        long timeMillis = System.currentTimeMillis();
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                " <error_info>" +
                "  <error_code>1000</error_code>" +
                "  <error_desc>错误描述错误描述</error_desc>" +
                " </error_info>" +
                " <data_info>" +
                "  <task_id>" + timeMillis + "</task_id>" +
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

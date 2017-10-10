package com.rxx.webservice.server;

import javax.jws.WebService;

/**
 * Created by zhang on 2017/9/14.
 */
@WebService(endpointInterface= "com.rxx.webservice.server.IEventMonitorService")
public class EventMonitorService implements IEventMonitorService {

    @Override
    public String handleItemByParams(String itemId, String[] params, String extendXml) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "  <error_info>" +
                "    <error_code>1000</error_code>" +
                "    <error_desc>错误描述错误描述</error_desc>" +
                "  </error_info>" +
                "  <data_info>" +
                "    <task_id>12345</task_id>" +
                "    <task_status>5</task_status>" +
                "    <task_create_time>2017-01-01 12:00:00</task_create_time>" +
                "    <task_approval_time>2017-01-01 12:02:00</task_approval_time>" +
                "    <result_status>2</result_status>" +
                "    <result_create_time>2017-01-01 12:02:00</result_create_time>" +
                "    <script_content>" +
                "      <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "    <result_content>" +
                "      <![CDATA[执行结果内容]]>" +
                "    </result_content>" +
                "  </data_info>" +
                "</root>";
    }

}

package com.rxx.webservice;

import javax.jws.WebService;

/**
 * Created by zhang on 2017/9/14.
 */
@WebService(endpointInterface= "com.rxx.webservice.IEventMonitorService")
public class EventMonitorService implements IEventMonitorService {

    @Override
    public String queryItems() {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                " <error_info>" +
                "  <error_code>1000</error_code>" +
                "  <error_desc>错误描述错误描述</error_desc>" +
                " </error_info>" +
                " <data_info>" +
                "  <page>" +
                "   <item>" +
                "    <item_id>12345</item_id>" +
                "    <item_name>校讯通</item_name>" +
                "    <approval_user_name>张三</approval_user_name>" +
                "    <approval_user_phone>13800000000</approval_user_phone>" +
                "    <so_ip>192.168.1.1</so_ip>" +
                "    <script_content>" +
                "     <![CDATA[脚本内容脚本内容]]>" +
                "    </script_content>" +
                "   </item>" +
                "  </page>" +
                " </data_info>" +
                "</root>";
    }

}

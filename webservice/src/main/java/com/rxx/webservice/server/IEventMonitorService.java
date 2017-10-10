package com.rxx.webservice.server;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by zhang on 2017/9/14.
 */
@WebService
public interface IEventMonitorService {
    String handleItemByParams(String itemId, String[] params, String extendXml);
}

package com.rxx.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by zhang on 2017/9/14.
 */
@WebService
public interface IEventMonitor {

    String queryItems(@WebParam(name="extendXml") String extendXml);
}

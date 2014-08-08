package com.epam.training.webservice;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;

/**
 * Created by Oleg_Burshinov on 12.02.14.
 */
@WebService
public class BidWS extends SpringBeanAutowiringSupport {
    /**
     * Операция веб-службы
     */
    @WebMethod
    public String getHello(@WebParam(name = "name", mode=WebParam.Mode.INOUT)
                           Holder<String> name,@WebParam(name="word", mode=WebParam.Mode.OUT) Holder<String> word) {
        //TODO write your implementation code here:
        word.value="Hello";
        name.value="User";
        return name.value;
    }
}

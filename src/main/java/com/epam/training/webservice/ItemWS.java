package com.epam.training.webservice;

import com.epam.training.persistence.pojo.ItemsEntity;
import com.epam.training.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;

/**
 * Created by Oleg_Burshinov on 13.02.14.
 */
@WebService
public class ItemWS extends SpringBeanAutowiringSupport {
    @Autowired
    private ItemService itemService;

    @WebMethod(action = "create")
    public long create(@WebParam(name = "item", mode=WebParam.Mode.INOUT) Holder<ItemsEntity> item) {
        return itemService.create(item.value);
    }
}

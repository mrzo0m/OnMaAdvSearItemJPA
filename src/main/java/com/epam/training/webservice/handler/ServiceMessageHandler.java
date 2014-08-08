package com.epam.training.webservice.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Set;


public class ServiceMessageHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
        SOAPMessage msg = messageContext.getMessage();
        Boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        Logger logger = LoggerFactory.getLogger(ServiceMessageHandler.class);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (outboundProperty.booleanValue()) {
            System.out.println("\nOutbound message:");
            logger.debug("\nOutbound message:");
        } else {
            System.out.println("\nInbound message:");
            logger.debug("\nInbound message:");
        }

        try {
            msg.writeTo(baos);
            logger.debug(new String(baos.toByteArray()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e.getLocalizedMessage());
        }
        return true;
    }


    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

}

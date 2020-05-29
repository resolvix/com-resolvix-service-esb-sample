package com.resolvix.sample.service.soap;

import com.resolvix.lib.service.soap.BaseSoapMessageHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SampleSoapMessageHandlerImpl
    extends BaseSoapMessageHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleSoapMessageHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        boolean result = super.handleMessage(soapMessageContext);
        if (!result)
            return result;

        soapMessageContext.put("testSoapProperty", "mySoapPropertyValue");
        soapMessageContext.setScope("testSoapProperty", MessageContext.Scope.APPLICATION);

        return true;
    }
}

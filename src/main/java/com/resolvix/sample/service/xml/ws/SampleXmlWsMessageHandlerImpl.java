package com.resolvix.sample.service.xml.ws;

import com.resolvix.lib.service.xml.ws.ServiceLoggingXmlWsMessageHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class SampleXmlWsMessageHandlerImpl
    extends ServiceLoggingXmlWsMessageHandlerImpl
{
    public static final Logger LOGGER = LoggerFactory.getLogger(SampleXmlWsMessageHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    public boolean handleMessage(LogicalMessageContext logicalMessageContext) {
        boolean result = super.handleMessage(logicalMessageContext);
        if (!result)
            return result;

        logicalMessageContext.put("testWsProperty", "myWsPropertyValue");
        logicalMessageContext.setScope("testWsProperty", MessageContext.Scope.APPLICATION);

        return true;
    }
}

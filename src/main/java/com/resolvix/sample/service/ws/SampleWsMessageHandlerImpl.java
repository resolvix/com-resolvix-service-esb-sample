package com.resolvix.sample.service.ws;

import com.resolvix.lib.service.ws.BaseWsMessageHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class SampleWsMessageHandlerImpl
    extends BaseWsMessageHandlerImpl
{
    public static final Logger LOGGER = LoggerFactory.getLogger(SampleWsMessageHandlerImpl.class);

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

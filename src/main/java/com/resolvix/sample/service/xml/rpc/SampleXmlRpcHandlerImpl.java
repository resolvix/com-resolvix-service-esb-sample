package com.resolvix.sample.service.xml.rpc;

import com.resolvix.lib.service.xml.rpc.BaseXmlRpcHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.rpc.handler.MessageContext;

public class SampleXmlRpcHandlerImpl
    extends BaseXmlRpcHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleXmlRpcHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        boolean result = super.handleRequest(messageContext);
        if (!result)
            return result;

        messageContext.setProperty("testRpcProperty", "myRpcPropertyValue");

        return true;
    }
}

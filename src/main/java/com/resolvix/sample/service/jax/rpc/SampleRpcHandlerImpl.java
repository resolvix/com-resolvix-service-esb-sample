package com.resolvix.sample.service.jax.rpc;

import com.resolvix.lib.javax.jax.rpc.handler.BaseRpcHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.rpc.handler.MessageContext;

public class SampleRpcHandlerImpl
    extends BaseRpcHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRpcHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        boolean result = super.handleRequest(messageContext);
        if (!result)
            return result;

        LOGGER.debug("SampleRpcHandlerImpl::handleRequest inbound");
        messageContext.setProperty("testRpcProperty", "myRpcPropertyValue");

        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        boolean result = super.handleResponse(messageContext);
        if (!result)
            return result;

        LOGGER.debug("SampleRpcHandlerImpl::handleResponse outbound");

        return true;
    }
}

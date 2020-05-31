package com.resolvix.sample.service.jax.ws.handler;

import com.resolvix.lib.javax.jax.ws.handler.BaseWsMessageHandlerImpl;
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

        Boolean outboundMessage = (Boolean) logicalMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundMessage == null)
            throw new IllegalStateException();

        LOGGER.debug("SampleWsMessageHandlerImpl::handleMessage outboundMessage [{}]", outboundMessage);
        if (!outboundMessage.booleanValue()) {
            logicalMessageContext.put("testWsProperty", "myWsPropertyValue");
            logicalMessageContext.setScope("testWsProperty", MessageContext.Scope.APPLICATION);
        }

        return true;
    }
}

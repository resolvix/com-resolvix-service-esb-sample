package com.resolvix.sample.service.ws;

import com.resolvix.lib.service.ws.BaseWsMessageHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleWsMessageHandlerImpl
    extends BaseWsMessageHandlerImpl
{
    public static final Logger LOGGER = LoggerFactory.getLogger(SampleWsMessageHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}

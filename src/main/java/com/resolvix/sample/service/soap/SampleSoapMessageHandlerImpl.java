package com.resolvix.sample.service.soap;

import com.resolvix.lib.service.soap.BaseSoapMessageHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleSoapMessageHandlerImpl
    extends BaseSoapMessageHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleSoapMessageHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}

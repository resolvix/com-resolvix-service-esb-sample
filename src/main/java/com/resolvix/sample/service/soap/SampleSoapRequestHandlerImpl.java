package com.resolvix.sample.service.soap;

import com.resolvix.lib.service.soap.BaseSoapRequestHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleSoapRequestHandlerImpl
    extends BaseSoapRequestHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleSoapRequestHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}

package com.resolvix.sample.service.rpc;

import com.resolvix.lib.service.rpc.BaseRpcHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleRpcHandlerImpl
    extends BaseRpcHandlerImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRpcHandlerImpl.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}

package com.resolvix.sample.service.jax.rs.filter;

import com.resolvix.lib.javax.jax.rs.filter.BaseRsRequestFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import java.io.IOException;

public class SampleRequestFilterImpl
    extends BaseRsRequestFilterImpl
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRequestFilterImpl.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext)
        throws IOException {
        LOGGER.debug("SampleRequestFilterImpl::filter invoked.");
    }
}

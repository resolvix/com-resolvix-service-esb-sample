package com.resolvix.sample.service.esb;

import com.resolvix.lib.service.BaseEsbServiceRequestHandlerImpl;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.service.soa.SampleRequest;
import com.resolvix.service.soa.SampleResponse;

public class SampleEsbServiceRequestHandlerImpl
    extends BaseEsbServiceRequestHandlerImpl<
        SampleRequest,
        SampleResponse,
        SampleResponse,
        ProcessingContext>
{

    public SampleEsbServiceRequestHandlerImpl() {
        //
    }

    @Override
    protected ProcessingContext initialise(SampleRequest sampleRequest)
        throws ServiceException
    {
        return null;
    }

    @Override
    protected void process(ProcessingContext context)
        throws ServiceException
    {

    }

    @Override
    protected SampleResponse respond(ProcessingContext context) {
        return null;
    }

    @Override
    protected SampleResponse respond(ProcessingContext context, ServiceException e) {
        return null;
    }
}

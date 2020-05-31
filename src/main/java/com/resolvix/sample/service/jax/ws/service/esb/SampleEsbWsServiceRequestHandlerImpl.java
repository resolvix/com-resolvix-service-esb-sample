package com.resolvix.sample.service.jax.ws.service.esb;

import com.resolvix.lib.javax.jax.ws.service.esb.BaseEsbWsServiceRequestHandlerImpl;
import com.resolvix.lib.javax.jax.ws.service.esb.EsbWsServiceFaultMap;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceException;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceFault;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceFaultMaplet;
import com.resolvix.sample.service.jax.ws.service.esb.exception.SampleFaultOne;
import com.resolvix.sample.service.jax.ws.service.esb.exception.SampleFaultTwo;
import com.resolvix.service.esb.sample.parameters.SampleFault;
import com.resolvix.service.esb.sample.parameters.SampleRequest;
import com.resolvix.service.esb.sample.parameters.SampleResponse;

import java.util.Arrays;
import java.util.List;

public class SampleEsbWsServiceRequestHandlerImpl
    extends BaseEsbWsServiceRequestHandlerImpl<
            SampleRequest,
            SampleResponse,
            ProcessingContext>
{

    private static final List<ServiceFaultMaplet<?, ?, ?>> SERVICE_FAULT_MAPLETS = Arrays.asList(
        ServiceFaultMaplet.of(SampleFaultOne.class, SampleEsbWsServiceRequestHandlerImpl::toSampleFaultOne),
        ServiceFaultMaplet.of(SampleFaultTwo.class, SampleEsbWsServiceRequestHandlerImpl::toSampleFaultTwo));

    private static final EsbWsServiceFaultMap SERVICE_FAULT_MAP
        = EsbWsServiceFaultMap.of(SERVICE_FAULT_MAPLETS);

    public SampleEsbWsServiceRequestHandlerImpl() {
        //
    }

    private static com.resolvix.service.esb.sample.SampleFaultOne toSampleFaultOne(
        ProcessingContext processingContext,
        SampleFaultOne serviceFaultOne) {
        SampleFault sampleFault = new SampleFault();
        return new com.resolvix.service.esb.sample.SampleFaultOne(
            "SampleFaultOne",
            sampleFault);
    }

    private static com.resolvix.service.esb.sample.SampleFaultTwo toSampleFaultTwo(
        ProcessingContext processingContext,
        SampleFaultTwo serviceFaultTwo) {
        SampleFault sampleFault = new SampleFault();
        return new com.resolvix.service.esb.sample.SampleFaultTwo(
            "SampleFaultTwo",
            sampleFault);
    }

    @Override
    protected ProcessingContext initialise(SampleRequest sampleRequest)
        throws ServiceException, ServiceFault
    {
        return null;
    }

    @Override
    protected void process(ProcessingContext context)
        throws ServiceException, ServiceFault
    {

    }

    @Override
    protected SampleResponse respond(ProcessingContext context)
        throws ServiceException, ServiceFault
    {
        return null;
    }

    @Override
    protected SampleResponse respond(ProcessingContext context, ServiceException e)
        throws ServiceFault
    {
        return null;
    }

    @Override
    protected <E extends Exception> E fault(ProcessingContext processingContext, ServiceFault sf)
        throws Exception
    {
        return SERVICE_FAULT_MAP.map(processingContext, sf) ;
    }
}

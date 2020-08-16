package com.resolvix.sample.service.esb;

import com.resolvix.lib.service.esb.BaseEsbServiceRequestHandlerImpl;
import com.resolvix.lib.service.esb.ServiceFaultMap;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.api.ServiceFaultMaplet;
import com.resolvix.sample.service.esb.exception.SampleFaultOne;
import com.resolvix.sample.service.esb.exception.SampleFaultTwo;
import com.resolvix.service.soa.SampleFault;
import com.resolvix.service.soa.SampleRequest;
import com.resolvix.service.soa.SampleResponse;

import java.util.Arrays;
import java.util.List;

public class SampleEsbServiceRequestHandlerImpl
    extends BaseEsbServiceRequestHandlerImpl<
        SampleRequest,
        SampleResponse,
        ProcessingContext>
{

    private static final List<ServiceFaultMaplet<?, ?, ?>> SERVICE_FAULT_MAPLETS = Arrays.asList(
        ServiceFaultMaplet.of(SampleFaultOne.class, SampleEsbServiceRequestHandlerImpl::toSampleFaultOne),
        ServiceFaultMaplet.of(SampleFaultTwo.class, SampleEsbServiceRequestHandlerImpl::toSampleFaultTwo));

    private static final ServiceFaultMap SERVICE_FAULT_MAP
        = ServiceFaultMap.of(SERVICE_FAULT_MAPLETS);

    public SampleEsbServiceRequestHandlerImpl() {
        //
    }

    private static com.resolvix.service.soa.SampleFaultOne toSampleFaultOne(
        ProcessingContext processingContext,
        SampleFaultOne serviceFaultOne) {
        SampleFault sampleFault = new SampleFault();
        return new com.resolvix.service.soa.SampleFaultOne(
            "SampleFaultOne",
            sampleFault);
    }

    private static com.resolvix.service.soa.SampleFaultTwo toSampleFaultTwo(
        ProcessingContext processingContext,
        SampleFaultTwo serviceFaultTwo) {
        SampleFault sampleFault = new SampleFault();
        return new com.resolvix.service.soa.SampleFaultTwo(
            "SampleFaultTwo",
            sampleFault);
    }

    @Override
    protected ProcessingContext initialise(SampleRequest sampleRequest)
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
    protected <T extends Throwable> T fault(ProcessingContext processingContext, ServiceFault sf)
        throws Throwable
    {
        return SERVICE_FAULT_MAP.map(processingContext, sf) ;
    }
}

package com.resolvix.sample.service.esb;

import com.resolvix.lib.service.BaseEsbServiceImpl;
import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.service.soa.*;

public class SampleEsbServiceImpl
    extends BaseEsbServiceImpl
    implements SamplePortType
{
    @Override
    public SampleResponse sampleOperation(SampleRequest request)
        throws SampleFaultOne, SampleFaultTwo {
        return null;
    }

//    @Override
//    public SampleResponse sampleOperation(SampleRequest request)
//    {
//        SampleEsbServiceRequestHandlerImpl requestHandler
//            = new SampleEsbServiceRequestHandlerImpl();
//        return requestHandler.execute(request);
//    }
}

package com.resolvix.sample.service.esb;

import com.resolvix.lib.service.esb.BaseEsbServiceImpl;
import com.resolvix.sample.service.soap.SampleSoapMessageHandlerImpl;
import com.resolvix.sample.service.ws.SampleWsMessageHandlerImpl;
import com.resolvix.service.esb.sample.SampleFaultOne;
import com.resolvix.service.esb.sample.SampleFaultTwo;
import com.resolvix.service.esb.sample.SamplePortType;
import com.resolvix.service.esb.sample.parameters.SampleRequest;
import com.resolvix.service.esb.sample.parameters.SampleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
import java.util.List;

@HandlerChain(file = "handler-chains.xml")
public class SampleEsbServiceImpl
    extends BaseEsbServiceImpl
    implements SamplePortType
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleEsbServiceImpl.class);

    @Resource
    private WebServiceContext context;

    private SampleEsbServiceImpl() {
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SampleSoapMessageHandlerImpl());
        ((BindingProvider) this).getBinding().setHandlerChain(handlerChain);
    }

    @Override
    public SampleResponse sampleOperation(SampleRequest request)
        throws SampleFaultOne, SampleFaultTwo
    {
        MessageContext messageContext = context.getMessageContext();
        Object testWsProperty = messageContext.get("testWsProperty");
        if (testWsProperty != null)
            LOGGER.debug("testWsProperty = {}");

        Object testSoapProperty = messageContext.get("testSoapProperty");
        if (testSoapProperty != null)
            LOGGER.debug("testSoapProperty = {}");

        try {
            return execute(SampleEsbServiceRequestHandlerImpl.class, request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

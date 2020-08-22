package com.resolvix.sample.service.esb;

public class ProcessingContext<R> {

    private R request;

    public ProcessingContext(R request) {
        this.request = request;
    }

    public R getRequest() {
        return request;
    }
}

# Sample Enterprise Service Bus (ESB) Service

This project provides a sample implementation of an Enterprise Service Bus
(**ESB**) -compatible SOAP-based Web Service based on the ESB service framework
provided by the [com-resolvix-lib-service-esb](https://github.com/resolvix/com-resolvix-lib-service-esb)
project. It is developed as both an experimental test-bed for the framework,
and to provide a pattern for the development of other ESB services based on
the framework.

## Development environment

This project generates a WAR file that may be packaged for deployment
using an EAR file using the [com-resolvix-service-esb-sample-ear](https://github.com/resolvix/com-resolvix-service-esb-sample-ear)
project.

### Java

This project may be compiled with Java 14.

### Application server compatibility

This project has been briefly tested, after packaging using an EAR file, using
the following Java EE 7 -compatible applications servers -

1. Payara 5.2020.3 (OpenJ9 JVM)
2. Wildly 20.0.1 (OpenJ9 JVM)

## Sample requests

### GET ?wsdl

```
GET http://localhost/service-esp-sample/SampleEsbService?wsdl
```

### POST

```
POST http://localhost/service-esp-sample/SampleEsbService
```

### GET (Hello World)

```
GET http://localhost/service-esp-sample/SampleEsbService
```


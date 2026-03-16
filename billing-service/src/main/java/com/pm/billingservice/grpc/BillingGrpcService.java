package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseObserver){

        //Overriding createBillingAccount generated in BillingServiceImplBase class
        //receive request, convert to billingRequest class object
        //return response using StreamOvserver
        //Stream observer. Send multiple responses to client. Accept back and forth communication from client.

        //REST uses single request single response model
        //in REST, real time update for billing analytics, need to continuously make get req every few seconds.

        //Stream observer give flexibility in how connection opened and back and forth interaction with client.

        log.info("createBillingAccount request received {}",billingRequest.toString());

        //Business Logic

        BillingResponse response= BillingResponse.newBuilder().setAccountId("12345")
                .setStatus("Active").build();

        responseObserver.onNext(response); //send response to client
        responseObserver.onCompleted(); //ends connection. 2 lines to allow use to send multiple responses at a time.


    }
}

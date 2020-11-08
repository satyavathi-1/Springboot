package com.gts.skills;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {
            LambdaContainerHandler.getContainerConfig().setInitializationTimeout(50_000);
            handler = new SpringBootProxyHandlerBuilder<AwsProxyRequest>()
                                .defaultProxy()
                                .asyncInit()
                                .springBootApplication(GTSSkillsServiceApplication.class)
                                .buildAndInitialize();
        } catch (ContainerInitializationException e) {
            e.printStackTrace();
            throw new RuntimeException("error", e);
        }
    }
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}

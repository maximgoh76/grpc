package grpc.client;

import java.io.IOException;

import grpc.api.helloworld.GreeterGrpc;
import grpc.api.helloworld.HelloReply;
import grpc.api.helloworld.GreeterGrpc.GreeterStub;
import grpc.api.helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client {
	
	 public static void main(String[] args) {
		//HostnameGreeter hostnameGreeter = new HostnameGreeter("localhost");
		ManagedChannel  managedChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build(); //<ManagedChannelBuilder<T>>
		GreeterStub greeterStub =  GreeterGrpc.newStub(managedChannel);
		
		HelloRequest helloRequest =  HelloRequest.getDefaultInstance();
		
		greeterStub.sayHello(helloRequest, new StreamObserver<HelloReply>() {
			
			public void onNext(HelloReply arg0) {
				System.out.println("onNext");
				
			}
			
			public void onError(Throwable arg0) {
				System.out.println("onError");
				
			}
			
			public void onCompleted() {
				System.out.println("onCompleted");
				
			}
		});;
		
	 }
}

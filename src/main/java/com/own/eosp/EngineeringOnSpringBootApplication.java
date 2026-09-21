package com.own.eosp;

import com.own.eosp.event.GreetingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EngineeringOnSpringBootApplication {
	static final int PORT = 3000;

	public static void main(String[] args) throws IOException {
		startWebServer();
	}

	public static void startWebServer() throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server started on port " + PORT);

			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Request is serving by:" + Thread.currentThread().getName());
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[inputStream.available()];
				int len = inputStream.read(bytes);
				String requestData = new String(bytes, 0, len);
				System.out.println(requestData);
			}
		}
	}
}


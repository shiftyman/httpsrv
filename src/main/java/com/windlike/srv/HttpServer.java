package com.windlike.srv;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	
	public void await(){
		ServerSocket serverSocker = null;
		int port = 8080;
		int backlog = 8;
		try{
			serverSocker = new ServerSocket(port, backlog);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		boolean run = true;
		while(run){
			try {
				Socket socket = serverSocker.accept();
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				
				Request request = new Request(input);
				Response response = new Response(output, request);
				
				response.generalResp();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main( String[] args ){
        System.out.println( "Hello World!" );
        HttpServer server = new HttpServer();
        server.await();
    }
}

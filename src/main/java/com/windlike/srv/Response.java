package com.windlike.srv;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
	
	private OutputStream output;
	
	private Request request;
	
	public Response(OutputStream output){
		this.output = output;
	}
	
	public Response(OutputStream output, Request request){
		this.request = request;
		this.output = output;
	}
	
	public void generalResp(){
		try {
			String req = request.getReqContent();
			String resp = "HTTP/1.1 200 OK\r\n" +
					"Content-Type: text/html\r\n" +
					"Content-Length: " + req.length() + "\r\n" +
					"\r\n" +
					req;
			
			output.write(resp.getBytes());
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

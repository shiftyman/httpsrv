package com.windlike.srv;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	
	private InputStream input;
	
	private String uri;
	
	private String reqContent;
	
	public Request(InputStream input){
		this.input = input;
		
		if(input != null){
			this.parse();
		}
	}
	
	private void parse(){
		StringBuffer request = new StringBuffer(2048);
		byte[] buffer = new byte[2048];
		try {
			int len = input.read(buffer);
			for(int i = 0; i < len; i++){
				request.append((char)buffer[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.reqContent = request.toString();
		this.uri = "";
	}
	
	public String getReqContent(){
		return reqContent;
	}
}

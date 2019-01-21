package javaCore;

import java.util.Map;


public class CompareResult {
	private int code=0;
	private String message="";
	private Map<String,String> details;
	
	public CompareResult(){
	}
	
	public CompareResult(int code){
		this.code = code;
	}
	public void setCode(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public void setMessage(String msg){
		this.message = msg;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMap(Map details){
		this.details = details;
	}
	
	public Map getMap(){
		return this.details;
	}
    
	public void addMessage(String msg){
		this.message += msg;
	}
	
	public void addCode(){
		this.code ++;
	}
}

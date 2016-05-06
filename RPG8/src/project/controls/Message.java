package project.controls;

public class Message {

	private String message;
	
	public Message(String s){
		this.message=s;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String s){
		this.message=s;
	}
}

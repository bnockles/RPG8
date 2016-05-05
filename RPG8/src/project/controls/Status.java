package project.controls;

public class Status {
	
	private String statusName;
	
	public Status(String s){
		this.statusName=s;
	}
	public void removeStatus(){
		this.statusName="";
	}
	
	public String getStatusName(){
		return this.statusName;
	}
	
}

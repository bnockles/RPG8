package project.controls;

public class Speed {
	
	private double speed;
	
	private String speedName;
	
	private String direction;
	
	public Speed(double n,String s){
		this.speed=n;
		this.speedName=s;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public void setSpeed(double walking){
		this.speed=walking;
	}
	public String getSpeedName(){
		return this.speedName;
	}
	
	public void setSpeedName(String s){
		this.speedName=s;
	}
	
	public String getDirection(){
		return this.direction;
	}
	
	public void setDirection(String s){
		this.direction=s;
	}
}

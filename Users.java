package ru.unlimit;

public class Users {
	private String pas;
	private String role;
	
	public String getPas(){
		return pas;
	}
	
	public String getRole(){
		return role;
	}
	
	Users(String _pas, String _role){
		pas = _pas;
		role = _role;
	}
}

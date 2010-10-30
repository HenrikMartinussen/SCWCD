package info.martinussen.jsptut.user;

public class UserData {
	String username;
    String email;
    int age;
    
    public UserData() {
		super();
	}
	
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object o){
		boolean	returnValue = false;
		if (o != null){
			if (o instanceof UserData){
				UserData other = (UserData) o;
				if (other.email.equals(this.email)){
					returnValue = true;
				}
			}
		}
		return returnValue;
	}

}

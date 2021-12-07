package out.homework12.api;

public class User{

	private String lastName;

	private Integer id;

	private String avatar;

	private String firstName;

	private String email;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
package direct_access_rep;

public class People {
	private int id;
	private String name;
	private String email;
	private String phone;
	
	public People() {
		this(0,"","","");
	}
	
	public People(int id, String name, String phone, String email) {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "name: "+ getName() + "id: " + getID()
				+ "email: " + getEmail() + "phone: " + getPhone();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

package direct_access_rep;


public class People {
<<<<<<< Updated upstream

=======
	public static final int RECORD_SIZE = 44;
    private int id;
    private String name;
    private String email;
    private String phone;

    public People() {
        this(0, "", "", "");
    }

    public People(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "name: " + name + " id: " + id
                + " email: " + email + " phone: " + phone;
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
>>>>>>> Stashed changes
}

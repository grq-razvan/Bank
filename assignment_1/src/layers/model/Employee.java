package layers.model;

public class Employee {

	private Integer employeeID;
	private String name, address, username, password;
	private boolean isAdmin;

	public Employee(Integer employeeID, String name, String address,
			boolean isAdmin, String username, String password) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name
				+ ", address=" + address + ", username=" + username
				+ ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

}

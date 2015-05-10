package layers.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import layers.model.Employee;

public class EmployeeMapper {

	private static final String ID = "employeeID";
	private static final String NAME = "name";
	private static final String ROLE = "admin";
	private static final String ADDRESS = "address";
	private static final String USER = "username";
	private static final String PASS = "password";

	private EmployeeGateway gateway;

	public EmployeeMapper(EmployeeGateway gateway) {
		super();
		this.gateway = gateway;
	}

	public EmployeeMapper() {
		super();
		this.gateway = new EmployeeGateway();
	}

	public synchronized static Employee fetchByEmployeeID(Integer employeeID) {
		ResultSet employees = null;
		try {
			employees = EmployeeGateway.fetchEmployeesByID(employeeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (employees.next()) {
				Integer id = employees.getInt(ID);
				String name = employees.getString(NAME);
				String address = employees.getString(ADDRESS);
				boolean admin = employees.getBoolean(ROLE);
				String username = employees.getString(USER);
				String password = employees.getString(PASS);
				return new Employee(id, name, address, admin, username,
						password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized static Employee fetchByEmployeeCredentials(
			String username, String password) {
		ResultSet employees = null;
		employees = EmployeeGateway.fetchEmployeeByCredentials(username,
				password);
		try {
			while (employees.next()) {
				Integer id = employees.getInt(ID);
				String name = employees.getString(NAME);
				String address = employees.getString(ADDRESS);
				boolean admin = employees.getBoolean(ROLE);
				String user = employees.getString(USER);
				String pass = employees.getString(PASS);
				return new Employee(id, name, address, admin, user, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized void updateAccount(Employee employee) {

		try {
			gateway.update(employee.getEmployeeID(), employee.getName(),
					employee.getAddress(), employee.getUsername(),
					employee.getPassword(), employee.isAdmin());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void deleteAccount(Employee employee) {
		try {
			gateway.delete(employee.getEmployeeID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void insertAccount(Employee employee) {
		try {
			gateway.insert(employee.getEmployeeID(), employee.getName(),
					employee.getAddress(), employee.isAdmin(),
					employee.getUsername(), employee.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EmployeeGateway getGateway() {
		return gateway;
	}

}

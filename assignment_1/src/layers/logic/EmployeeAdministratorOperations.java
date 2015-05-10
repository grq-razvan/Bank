package layers.logic;

import layers.data.EmployeeMapper;
import layers.model.Employee;

public class EmployeeAdministratorOperations {

	public static void addEmployee(String id, String name, String address,
			String username, String password, boolean isAdmin) {
		Employee newEmployee = new Employee(Integer.parseInt(id), name,
				address, isAdmin, username, password);
		EmployeeMapper mapper = new EmployeeMapper();
		mapper.insertAccount(newEmployee);
	}

	public static void updateEmployee(String id, String name, String address,
			String username, String password, boolean isAdmin) {
		Employee employee = new Employee(Integer.parseInt(id), name, address,
				isAdmin, username, password);
		EmployeeMapper mapper = new EmployeeMapper();
		mapper.updateAccount(employee);
	}

	public static void deleteEmployee(String id) {
		Employee employee = EmployeeMapper.fetchByEmployeeID(Integer
				.parseInt(id));
		EmployeeMapper mapper = new EmployeeMapper();
		mapper.deleteAccount(employee);
	}

	public static String viewEmployee(String id) {
		StringBuilder result = new StringBuilder();
		Employee e = EmployeeMapper.fetchByEmployeeID(Integer.parseInt(id));
		String role;
		if (e.isAdmin()) {
			role = "Administrator";
		} else {
			role = "Clerk";
		}
		result.append("Employee - ID: " + e.getEmployeeID() + "\nNAME: "
				+ e.getName() + "\nADDRESS: " + e.getAddress() + "\nUSERNAME: "
				+ e.getUsername() + "\nROLE: " + role);
		return result.toString();

	}

	public static void viewAllEmployees() {
	}

	public static void generateReport(String id, String from, String to) {
		new ReportGenerator(EmployeeMapper.fetchByEmployeeID(
				Integer.parseInt(id)).getName()
				+ "_" + id, id, from, to);
	}

	public static void generateReport(String id) {
		new ReportGenerator(EmployeeMapper.fetchByEmployeeID(
				Integer.parseInt(id)).getName()
				+ "_" + id, id);
	}

	// generate report

}

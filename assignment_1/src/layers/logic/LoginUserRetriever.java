package layers.logic;

import layers.data.EmployeeMapper;
import layers.model.Employee;

public class LoginUserRetriever {

	private static Employee employee;

	public LoginUserRetriever() {
		employee = null;
	}

	public LoginUserRetriever(Employee employee) {
		LoginUserRetriever.employee = employee;
	}

	public static void fetchEmployee(String username, String password) {

		employee = EmployeeMapper
				.fetchByEmployeeCredentials(username, password);

	}

	public static Employee getEmployee() {
		return employee;
	}

}

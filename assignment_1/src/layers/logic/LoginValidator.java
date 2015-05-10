package layers.logic;

import layers.data.EmployeeMapper;
import layers.model.Employee;

public class LoginValidator {

	public static boolean isUserValid(String username, String password) {
		Employee employee = EmployeeMapper.fetchByEmployeeCredentials(username,
				password);
		return employee != null;
	}

	public static boolean isUserAdmin(String username, String password) {
		Employee employee = EmployeeMapper.fetchByEmployeeCredentials(username,
				password);
		return employee.isAdmin();
	}

}

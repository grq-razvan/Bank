package layers.logic;

public class InputValidator {

	public static boolean isBadClientName(String name) {
		return name.contains("[^a-zA-z\\s\\-]") || name.length() <= 3;
	}

	public static boolean isBadAccountType(String type) {
		return type.contains("[^a-zA-Z0-9]") || type.length() <= 5;
	}

	public static boolean isBadClientAddress(String address) {
		return address.contains("[^a-zA-Z0-9\\s-\\.]") || address.length() <= 5;
	}

	public static boolean isBadAccountMoney(String amount) {
		return amount.contains("[^0-9\\.]");
	}

	public static boolean isBadAccountCreationDate(String date) {
		return false;// String pattern = ("[(\\d{4})[-](\\d{2})[-](\\d{2})]";
						// apoi smth like Pattern p = new Pattern(pattern);
						// Matcher m; m.find();
						// m.group[1],m.group(2)<13;m.group(3)
						//
	}

	public static boolean isPasswordTypedWell(char[] password,
			char[] passwordRetype) {
		if (password.length != passwordRetype.length) {
			return false;
		} else {
			for (int i = 0; i < password.length; i++) {
				if (password[i] != passwordRetype[i]) {
					return false;
				}
			}
			return true;
		}
	}

}

package layers.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;

import layers.model.Account;

import org.junit.Test;

public class EmployeeOperationsTest {

	@Test
	public void testAddClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransact() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayBills() {
		Account a = new Account("1", "12345", "Spending", new Double(4165.15),
				Date.valueOf("2012-04-15"));
		EmployeeOperations.payBills("1", "3000");
		assertEquals("4165.15-3165.15 must be 1000", (Double) 1000.0,
				(Double) a.getAccountMoney());
	}

}

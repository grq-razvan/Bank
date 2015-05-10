package layers.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import layers.connection.SQLConnecter;

public class ClientGateway {

	private String ssid, name, address;
	private static final String FIND_BY_ID = "SELECT * FROM client WHERE ssid=?";
	private static final String UPDATE = "UPDATE client SET name=?, address=? WHERE ssid=?";
	private static final String DELETE = "DELETE FROM client where ssid=?";
	private static final String INSERT = "INSERT INTO client (name, address, ssid) VALUES (?, ?, ?)";
	private static final String SSID = "ssid";
	private static final String NAME = "name";
	private static final String ADDRESS = "address";

	public ClientGateway(String ssid, String name, String address) {
		this.ssid = ssid;
		this.name = name;
		this.address = address;
	}

	public ClientGateway() {
		ssid = new String();
		name = new String();
		address = new String();
	}

	public synchronized static ClientGateway fetchBySSID(String ssid) {
		PreparedStatement statement;
		try {
			statement = SQLConnecter.getConnection().prepareStatement(
					FIND_BY_ID);
			statement.setString(1, ssid);
			ResultSet clients = statement.executeQuery();
			while (clients.next()) {
				String clientID = clients.getString(SSID);
				String clientName = clients.getString(NAME);
				String clientAddress = clients.getString(ADDRESS);
				return new ClientGateway(clientID, clientName, clientAddress);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized void update() {
		PreparedStatement statement;
		try {
			statement = SQLConnecter.getConnection().prepareStatement(UPDATE);
			statement.setString(1, this.name);
			statement.setString(2, this.address);
			statement.setString(3, this.ssid);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void insert() {
		PreparedStatement statement;
		try {
			statement = SQLConnecter.getConnection().prepareStatement(INSERT);
			statement.setString(1, this.name);
			statement.setString(2, this.address);
			statement.setString(3, this.ssid);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void delete() {
		PreparedStatement statement;
		try {
			statement = SQLConnecter.getConnection().prepareStatement(DELETE);
			statement.setString(1, this.ssid);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
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

}

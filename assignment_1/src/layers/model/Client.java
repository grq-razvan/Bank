package layers.model;

import layers.data.ClientGateway;

public class Client {

	private ClientGateway data;

	public Client(ClientGateway data) {
		this.data = data;
	}

	public Client(String id, String name, String address) {
		data = new ClientGateway(id, name, address);
	}

	public Client(String id) {
		data = ClientGateway.fetchBySSID(id);
	}

	public String getClientID() {
		return data.getSsid();
	}

	public String getClientAddress() {
		return data.getAddress();
	}

	public String getClientName() {
		return data.getName();
	}

	@Override
	public String toString() {
		return "Client [getClientID()=" + getClientID()
				+ ", getClientAddress()=" + getClientAddress()
				+ ", getClientName()=" + getClientName() + "]";
	}

	public ClientGateway getData() {
		return data;
	}

}

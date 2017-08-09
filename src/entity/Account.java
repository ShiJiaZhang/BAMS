package entity;

public class Account {
	private int id;
	private int password;
	private String name;
	private String personId;
	private double balance;
	private int type;
	
	public Account() {
	
	}

	public Account(int id, int password, String name, String personId, double balance, int type) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String personId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}

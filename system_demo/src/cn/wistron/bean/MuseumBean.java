package cn.wistron.bean;

public class MuseumBean {
	private int Museum_ID;
	private String Museum_Name;
	private String Museum_Description;
	private String Museum_Address;
	private String Museum_PhoneNumber;
	private String Museum_Email;

	public int getMuseum_ID() {
		return Museum_ID;
	}

	public void setMuseum_ID(int museum_ID) {
		Museum_ID = museum_ID;
	}

	public String getMuseum_Name() {
		return Museum_Name;
	}

	public void setMuseum_Name(String museum_Name) {
		Museum_Name = museum_Name;
	}

	public String getMuseum_Description() {
		return Museum_Description;
	}

	public void setMuseum_Description(String museum_Description) {
		Museum_Description = museum_Description;
	}

	public String getMuseum_Address() {
		return Museum_Address;
	}

	public void setMuseum_Address(String museum_Address) {
		Museum_Address = museum_Address;
	}

	public String getMuseum_PhoneNumber() {
		return Museum_PhoneNumber;
	}

	public void setMuseum_PhoneNumber(String museum_PhoneNumber) {
		Museum_PhoneNumber = museum_PhoneNumber;
	}

	public String getMuseum_Email() {
		return Museum_Email;
	}

	public void setMuseum_Email(String museum_Email) {
		Museum_Email = museum_Email;
	}

	public MuseumBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MuseumBean(String museum_Name, String museum_Description,
			String museum_Address, String museum_PhoneNumber,
			String museum_Email) {
		super();
		Museum_Name = museum_Name;
		Museum_Description = museum_Description;
		Museum_Address = museum_Address;
		Museum_PhoneNumber = museum_PhoneNumber;
		Museum_Email = museum_Email;
	}

	public MuseumBean(int museum_ID, String museum_Name,
			String museum_Description, String museum_Address,
			String museum_PhoneNumber, String museum_Email) {
		super();
		Museum_ID = museum_ID;
		Museum_Name = museum_Name;
		Museum_Description = museum_Description;
		Museum_Address = museum_Address;
		Museum_PhoneNumber = museum_PhoneNumber;
		Museum_Email = museum_Email;
	}
	
	
	

}

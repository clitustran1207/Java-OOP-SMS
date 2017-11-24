import java.util.List;

public class Person {
	
	//public String ID_REQUIRE = "Enter ID: ";
	
	protected String ID;
	protected String Name;
	protected String DOB;
	protected String Email;
	protected String Phone;
	protected String Address;
	final static String ERROR_INP_SUB_MENU = "Invalid input. Please input digit from 1 to 6! \n\n";
	////////////////////////////////////////////////
	public String getID() {
		return ID;
	}
	public void setID(String ID) throws Exception  {
		if (!checkID(ID)) {
			throw new Exception(idException());
		}
		this.ID = ID;
	}
	public String idException() { //default msg, will be modify in specific class
		return "Invalid ID";
	}
	public boolean checkID(String ID) { //will override in specific class
		return true;
	}
	
	////////////////////////////////////////////////
	public String getName() {
		return Name;
	}
	public void setName(String name) throws Exception {
		if (!checkName(name)) {
			throw new Exception("Invalid name. Please try again");
		}
		this.Name = name;
	}
	private boolean checkName(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (Character.isAlphabetic(name.charAt(i)) || name.charAt(i)==' ') {
				return true;
			}
		}
		return false;
	}
	
	////////////////////////////////////////////////
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dob) {
		this.DOB = dob;
	}
	///////////////////////////////////////////////
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	///////////////////////////////////////////////
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) throws Exception {
		if (!checkPhone(phone)) {
			throw new Exception("Invalid phone number. Please try again");
		}
		this.Phone = phone;
	}
	private boolean checkPhone(String phone) {
		return phone.matches("[0-9]{10}|[0-9]{11}");
	}
	//////////////////////////////////////////////
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	//////////////////////////////////////////////
	
	static TakeInput take = new TakeInput();
	public void inputForm() throws Exception {
		if (getID() == null)
			setID(take.takeInput("Enter ID: "));
		if (getName() == null)
			setName(take.takeInput("Enter Name: "));
		if (getDOB() == null)
			setDOB(take.takeInput("Enter date of birth: "));
		if (getPhone() == null)
			setPhone(take.takeInput("Enter phone number: "));
		if (getEmail() == null)
			setEmail(take.takeInput("Enter email: "));
		if(getAddress() == null)
			setAddress(take.takeInput("Enter address: "));
	}
	public static int subMenuInput() throws Exception {
		try {
			int input = Integer.parseInt(take.takeInput("Please choose: "));
			return input;
		} catch (Exception e) {
			throw new Exception(ERROR_INP_SUB_MENU);
		}
	}
	public static int foundID(List listPer, String pId) {
		int i;
		for (i = 0; i < listPer.size(); i++) {
			Person p = (Person) listPer.get(i); 
			if (p.getID().equals(pId))
				return i;
		}
		return -1;
	}
	public static void deletePer(List listPer, String position) {
		String tmp = take.takeInput("Enter " + position + " ID: ");
		if (foundID(listPer, tmp) == -1)
			System.out.println(position + " ID not found.");
		else {
			String tmp2 = take.takeInput("Found 1 " + position + "'s profile. Do you want to delete?(y/n)");
			if (tmp2.charAt(0) == 'y') {
				listPer.remove(foundID(listPer, tmp));
				System.out.println(position + "'s profile was deleted!");
			} else if (tmp2.charAt(0) == 'n') {
				System.out.println(position + "'s profile is not deleted!");
			} else {
				System.out.println("Invalid input. You must enter y or n!");
			}
		}
	}
	
}

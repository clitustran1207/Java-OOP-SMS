import java.util.*;

public class Lecturer extends Person{
	final static String HEADER = "=======LECTURER========";
	final static String LECTURER_MENU_1 = "1. Add new lecturer";
	final static String LECTURER_MENU_2 = "2. View all lecturers";
	final static String LECTURER_MENU_3 = "3. Search lecturer";
	final static String LECTURER_MENU_4 = "4. Delete lecturer";
	final static String LECTURER_MENU_5 = "5. Update lecturer";
	final static String LECTURER_MENU_6 = "6. Back to main menu";
	final static String FOOTER = "=======================";
	
	public static String lecMenu() {
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", HEADER, LECTURER_MENU_1, LECTURER_MENU_2,
				LECTURER_MENU_3, LECTURER_MENU_4, LECTURER_MENU_5, LECTURER_MENU_6, FOOTER);
	}
	public String lecDept;

	static ArrayList<Lecturer> lecturerAr = new ArrayList<Lecturer>();
	
	public Lecturer() {
		super();
	}
	
	public Lecturer(String id, String name, String dob, String mail, String phone, String address) throws Exception {
		setID(id);
		setName(name);
		setDOB(dob);
		setEmail(mail);
		setPhone(phone);
		setAddress(address);
	}
	
	public boolean checkID(String ID) {
		return ID.matches("[0-9]{8}");
	}
	public String idException() {
		return "Invalid Lecturer ID. Please try again. \n";
	}
	/////////////////////////////////////////////////////
	public String getLecDept() {
		return lecDept;
	}
	public void setLecDept(String lecDept) {
		this.lecDept = lecDept;
	}
	////////////////////////////////////////////////////
	public void formLecInput() throws Exception {
		inputForm();
		if(getLecDept() == null)
			setLecDept(take.takeInput("Enter Lecturer Department: "));
	}
	
	public static void lecMenuExec() {
		int input = 0;
		while (input!=6) {
			try {
				System.out.println(lecMenu());
				input = subMenuInput();
				switch (input) {
					case 1: addLecturer(); break;
					case 2: viewLecturer(); break;
					case 3: searchLecturer(); break;
					case 4: delLecturer(); break;
					case 5: updateLecturer(); break;
					case 6: MainSystem.mainMenuExec(); break;
					default: System.out.print(ERROR_INP_SUB_MENU); break;
				}
			} catch (Exception e) {
				System.out.printf(e.getMessage());
			}
		}
	}

	private static void updateLecturer() throws Exception {
		// TODO Auto-generated method stub
		String tmp = take.takeInput("Enter lecturer ID: ");
		int i = (foundID(lecturerAr, tmp));
		if (i == -1)
			System.out.println("Lecturer ID not found.");
		else {
			String tmp2 = take.takeInput("Found 1 lecturer's profile. Do you want to update?(y/n)");
			if (tmp2.charAt(0) == 'y') {
				String tmp3 = take.takeInput("Enter new ID of lecturer: ");
				
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setID(tmp3);
				
				tmp3 = take.takeInput("Enter new name of lecturer: ");
				
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setName(tmp3);
				
				tmp3 = take.takeInput("Enter new DoB of lecturer: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setDOB(tmp3);
				
				tmp3 = take.takeInput("Enter new mail of lecturer: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setEmail(tmp3);
				
				tmp3 = take.takeInput("Enter new phone number of lecturer: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setPhone(tmp3);
				
				tmp3 = take.takeInput("Enter new address of lecturer: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setAddress(tmp3);
				
				tmp3 = take.takeInput("Enter new batch of lecturer: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					lecturerAr.get(i).setLecDept(tmp3);
				System.out.println("Update complete.");
			} else if (tmp2.charAt(0) == 'n') {
				System.out.println("Lecturer's profile is not updated!");
			} else {
				System.out.println("Invalid input. You must enter y or n!");
			}
		}
	}

	private static void delLecturer() {
		// TODO Auto-generated method stub
		deletePer(lecturerAr, "Lecturer");
	}

	private static void searchLecturer() {
		// TODO Auto-generated method stub
		String tmp = take.takeInput("Enter lecturer ID: ");
		if (foundID(lecturerAr, tmp) == -1)
			System.out.println("Lecturer ID not found.");
		else {
			Lecturer lecturer = new Lecturer();
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", "ID", "Name", "DoB", "Mail", "Phone", "Address",
					"Department");
			lecturer = lecturerAr.get(foundID(lecturerAr, tmp));
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", lecturer.getID(), lecturer.getName(), lecturer.getDOB(), lecturer.getEmail(),
					lecturer.getPhone(), lecturer.getAddress(), lecturer.getLecDept());
		}
	}

	private static void viewLecturer() {
		// TODO Auto-generated method stub
		Lecturer lecturer = new Lecturer();
		if (lecturerAr.size() == 0) {
			System.out.println("Nothing to show to you! \n");
		} else {
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", "ID", "Name", "DoB", "Mail", "Phone", "Address",
					"Department");
			for (int i = 0; i < lecturerAr.size(); i++) {
				lecturer = lecturerAr.get(i);
				System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", lecturer.getID(), lecturer.getName(), lecturer.getDOB(),
						lecturer.getEmail(), lecturer.getPhone(), lecturer.getAddress(), lecturer.getLecDept());
			}
		}
	}

	private static void addLecturer() {
		// TODO Auto-generated method stub
		Lecturer lecturer = new Lecturer();
		while(true) {
			try {
				lecturer.formLecInput();
				lecturerAr.add(lecturer);
				System.out.println("Lecturer profile is saved! \n");
				break;
			} catch (Exception e) {
				System.out.printf(e.getMessage());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

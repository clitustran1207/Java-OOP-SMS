import java.util.*;

public class Student extends Person{
	
	final static String HEADER = "=======STUDENT========";
	final static String STUDENT_MENU_1 = "1. Add new student";
	final static String STUDENT_MENU_2 = "2. View all students";
	final static String STUDENT_MENU_3 = "3. Search students";
	final static String STUDENT_MENU_4 = "4. Delete students";
	final static String STUDENT_MENU_5 = "5. Update student";
	final static String STUDENT_MENU_6 = "6. Back to main menu";
	final static String FOOTER = "=======================";
	
	public static String stuMenu() {
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", HEADER, STUDENT_MENU_1, STUDENT_MENU_2,
				STUDENT_MENU_3, STUDENT_MENU_4, STUDENT_MENU_5, STUDENT_MENU_6, FOOTER);
	}
	

	public String stuBatch;

	static ArrayList<Student> studentAr = new ArrayList<Student>();
	
	public Student() {
		super();
	}
	
	public Student(String id, String name, String dob, String mail, String phone, String address) throws Exception {
		setID(id);
		setName(name);
		setDOB(dob);
		setEmail(mail);
		setPhone(phone);
		setAddress(address);
	}

	public boolean checkID(String ID) {
		return ID.matches("G[TC][0-9]{5}");
	}
	public String idException() {
		return "Invalid Student ID. Please try again. \n";
	}
	/////////////////////////////////////////////////////
	public String getStuBatch() {
		return stuBatch;
	}
	public void setStuBatch(String stuBatch) {
		this.stuBatch = stuBatch;
	}
	////////////////////////////////////////////////////
	public void formStuInput() throws Exception {
		inputForm();
		if(getStuBatch() == null)
			setStuBatch(take.takeInput("Enter Student Batch: "));
	}
	
	public static void stuMenuExec() {
		int input = 0;
		while (input!=6) {
			try {
				System.out.println(stuMenu());
				input = subMenuInput();
				switch (input) {
					case 1: addStudent(); break;
					case 2: viewStudent(); break;
					case 3: searchStudent(); break;
					case 4: delStudent(); break;
					case 5: updateStudent(); break;
					case 6: MainSystem.mainMenuExec(); break;
					default: System.out.print(ERROR_INP_SUB_MENU); break;
				}
			} catch (Exception e) {
				System.out.printf(e.getMessage());
			}
		}
	}
	public static void updateStudent() throws Exception {
		String tmp = take.takeInput("Enter student ID: ");
		int i = (foundID(studentAr, tmp));
		if (i == -1)
			System.out.println("Student ID not found.");
		else {
			String tmp2 = take.takeInput("Found 1 student's profile. Do you want to update?(y/n)");
			if (tmp2.charAt(0) == 'y') {
				String tmp3 = take.takeInput("Enter new ID of student: ");
				
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setID(tmp3);
				
				tmp3 = take.takeInput("Enter new name of student: ");
				
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setName(tmp3);
				
				tmp3 = take.takeInput("Enter new DoB of student: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setDOB(tmp3);
				
				tmp3 = take.takeInput("Enter new mail of student: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setEmail(tmp3);
				
				tmp3 = take.takeInput("Enter new phone number of student: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setPhone(tmp3);
				
				tmp3 = take.takeInput("Enter new address of student: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setAddress(tmp3);
				
				tmp3 = take.takeInput("Enter new batch of student: ");
				if (tmp3.isEmpty())
					System.out.println("Data will be kept");
				else
					studentAr.get(i).setStuBatch(tmp3);
				System.out.println("Update complete.");
			} else if (tmp2.charAt(0) == 'n') {
				System.out.println("Student's profile is not updated!");
			} else {
				System.out.println("Invalid input. You must enter y or n!");
			}
		}
	}
	public static void delStudent() {
		deletePer(studentAr, "Student");
	}

	private static void searchStudent() {
		String tmp = take.takeInput("Enter student ID: ");
		if (foundID(studentAr, tmp) == -1)
			System.out.println("Student ID not found.");
		else {
			Student s = new Student();
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", "ID", "Name", "DoB", "Mail", "Phone", "Address",
					"Batch");
			s = studentAr.get(foundID(studentAr, tmp));
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", s.getID(), s.getName(), s.getDOB(), s.getEmail(),
					s.getPhone(), s.getAddress(), s.getStuBatch());
		}
		
	}

	private static void addStudent() throws Exception {
		Student student = new Student();
		while(true) {
			try {
				student.formStuInput();
				studentAr.add(student);
				System.out.println("Student profile is saved!");
				break;
			} catch (Exception e) {
				System.out.printf(e.getMessage());
			}
		}
	}
	private static void viewStudent() {
		Student student = new Student();
		if (studentAr.size() == 0) {
			System.out.println("Nothing to show to you!");
		} else {
			System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", "ID", "Name", "DoB", "Mail", "Phone", "Address",
					"Batch");
			for (int i = 0; i < studentAr.size(); i++) {
				student = studentAr.get(i);
				System.out.printf("%9s %25s %11s %25s %12s %25s %10s\n", student.getID(), student.getName(), student.getDOB(),
						student.getEmail(), student.getPhone(), student.getAddress(), student.getStuBatch());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

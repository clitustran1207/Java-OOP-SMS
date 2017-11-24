
public class MainSystem{
	final static String HEADER = "=======MANAGEMENT SYSTEM========";
	final static String MAIN_MENU_1 = "1. Manage Students";
	final static String MAIN_MENU_2 = "2. Manage Lecturers";
	final static String MAIN_MENU_3 = "3. Help";
	final static String MAIN_MENU_4 = "4. Exit";
	final static String FOOTER = "================================";
	
	public static String mainMenu() {
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n", HEADER, MAIN_MENU_1, MAIN_MENU_2, MAIN_MENU_3, MAIN_MENU_4, FOOTER);
	}
	
	
	static TakeInput take = new TakeInput();
	public static int mainMenuInput() throws Exception {
		try {
			int input = Integer.parseInt(take.takeInput("Please choose: "));
			return input;
		} catch (Exception e) {
			throw new Exception("Input value must be a digit from 1 to 4. Please try again.");
		}
	}

	public static void mainMenuExec() throws Exception {
		int input = 0;
		while (input!=4) {
			try {
				System.out.println(mainMenu());
				input = mainMenuInput();
				switch (input) {
					case 1:
						Student.stuMenuExec(); break;
					case 2:
						Lecturer.lecMenuExec(); break;
					case 3:
						userHelp(); break;
					case 4:
						System.out.println("EXIT! Thanks for using our system.");
						System.exit(0);
					default:
						System.out.println("Input value must be a digit from 1 to 4. Please try again."); break;
				} 
			}catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}
	
	private static void userHelp() {
		System.out.println("User help");
		
	}
	
	public static void main(String[] args) throws Exception {
		mainMenuExec();
	}
}

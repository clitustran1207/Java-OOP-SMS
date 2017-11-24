import java.util.Scanner;

public class TakeInput {
	Scanner sc = new Scanner(System.in);
	
	public String takeInput(String msg) {
		System.out.println(msg);
		String input = sc.nextLine();
		return input;
	}
	
}

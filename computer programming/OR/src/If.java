/*Noah Heath*/
import java.util.Scanner;
public class If {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Waddup?");
		String input = scan.nextLine();
		if (input.startsWith("n")) {
			System.out.println("shut up");
			input = scan.nextLine();
			if (input.startsWith("w")) {
				System.out.println("shut up");
			} else {
				System.out.println("sorry");
			}
		} else {
			System.out.println("cool");
		}
	}
}

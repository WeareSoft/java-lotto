package input;

import java.util.Scanner;

/**
 * @author delf
 */
public class ConsoleInput implements Inputtable {

	private static Scanner scanner = new Scanner(System.in);

	@Override
	public String getStringValue() {
		return scanner.nextLine();
	}
}

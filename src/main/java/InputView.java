import java.util.Scanner;

public class InputView {
	private static Scanner scanner;

	public static int askPurchasingAmount() {
		scanner = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static String askWinningNumbers() {
		scanner = new Scanner(System.in);
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static int askBonusNumber() {
		scanner = new Scanner(System.in);
		System.out.println("\n보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}

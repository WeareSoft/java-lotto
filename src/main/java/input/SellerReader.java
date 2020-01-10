package input;

import java.util.Scanner;

public class SellerReader {

    public static int getBuyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println(String.format("%d개를 구매했습니다.", size));
        return size;
    }
}

package input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdminReader {

    public static List<Long> getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        Scanner scanner = new Scanner(System.in);
//        String winningLotto = scanner.nextLine();
        String winningLotto = "1, 2, 3, 4, 5, 6";
        System.out.println(winningLotto);
        return Arrays.stream(winningLotto.split(", "))
                .map(Long::new)
                .collect(Collectors.toList());
    }
}

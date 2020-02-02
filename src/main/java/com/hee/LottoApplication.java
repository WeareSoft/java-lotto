package com.hee;

import com.hee.domain.number.LottoNumber;
import com.hee.strategy.RandomGenerationStrategy;
import com.hee.view.InputView;
import com.hee.view.ResultView;

public class LottoApplication {

    private static final String INPUT_MESSAGE_OF_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_BONUS_NUMBER = "\n보너스 볼을 입력해 주세요.";

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int purchaseAmount = InputView.inputInt(INPUT_MESSAGE_OF_PURCHASE_AMOUNT); // 구입 금액
        ResultView.printTickets(lottoGame.buyTickets(purchaseAmount, new RandomGenerationStrategy())); // 티켓 구매

        String winningNumberOfLastWeek = InputView.inputStringArray(INPUT_MESSAGE_OF_WINNING_NUMBER); // 지난 주 당첨 번호
        int bonusNumber = InputView.inputInt(INPUT_MESSAGE_OF_BONUS_NUMBER); // 보너스 번호
        LottoResult result = lottoGame.play(winningNumberOfLastWeek, new LottoNumber(bonusNumber));
        ResultView.printResult(result); // 당첨 결과
        ResultView.printProfitRate(result, purchaseAmount); // 수익률 결과
    }
}

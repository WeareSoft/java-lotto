package com.hee;

import com.hee.domain.number.LottoNumber;
import com.hee.strategy.RandomGenerationStrategy;
import com.hee.view.InputView;
import com.hee.view.ResultView;

public class LottoApplication {

    private static final String INPUT_MESSAGE_OF_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_MANUAL_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_BONUS_NUMBER = "\n보너스 볼을 입력해 주세요.";
    private static final int PRICE_OF_ONE_TICKET = 1000;

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int purchaseAmount = InputView.inputInt(INPUT_MESSAGE_OF_PURCHASE_AMOUNT); // 구입 금액

        // 수동 구매 번호
        int numberOfManualTickets = InputView.inputInt(INPUT_MESSAGE_OF_MANUAL_COUNT);
        String[] manualLottoNumbers = InputView.inputStringArray(INPUT_MESSAGE_OF_MANUAL_NUMBER, numberOfManualTickets);
        lottoGame.buyManualTickets(manualLottoNumbers);

        // 티켓 구매 (수동 + 구매전략)
        int numberOfTickets = (purchaseAmount / PRICE_OF_ONE_TICKET) - numberOfManualTickets;
        lottoGame.buyTickets(numberOfTickets, manualLottoNumbers, new RandomGenerationStrategy());

        ResultView.printTypeOfTickets(numberOfManualTickets, numberOfTickets);
        ResultView.printTickets(lottoGame.getTickets());

        String winningNumberOfLastWeek = InputView.inputStringArray(INPUT_MESSAGE_OF_WINNING_NUMBER); // 지난 주 당첨 번호
        int bonusNumber = InputView.inputInt(INPUT_MESSAGE_OF_BONUS_NUMBER); // 보너스 번호
        LottoResult result = lottoGame.play(winningNumberOfLastWeek, new LottoNumber(bonusNumber));
        ResultView.printResult(result); // 당첨 결과
        ResultView.printProfitRate(result, purchaseAmount); // 수익률 결과
    }
}

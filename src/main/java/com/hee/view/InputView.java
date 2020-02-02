package com.hee.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt(final String content) {
        System.out.println(content);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputStringArray(final String content) {
        System.out.println(content);
        return SCANNER.nextLine();
    }
}

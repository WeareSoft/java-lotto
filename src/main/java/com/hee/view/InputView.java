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

    public static String[] inputStringArray(final String content, final int count) {
        System.out.println(content);

        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = SCANNER.nextLine();
        }
        return strings;
    }
}

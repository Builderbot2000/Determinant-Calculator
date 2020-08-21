package com.kevintang;

public class Reader {
    private final String in;

    Reader(String input) {
        in = input;
    }

    int[] readLine() {
        int[] numLine = new int[in.length()];
        int counter = 0;
        String current = "";
        for (int i = 0; i < in.length(); i++) {
            char currentChar = in.charAt(i);
            if (i == in.length() - 1) {
                current = current.concat(String.valueOf(currentChar));
                numLine[counter] = Integer.parseInt(current);
            } else if (currentChar != ' ' && Character.isDigit(currentChar)) {
                current = current.concat(String.valueOf(currentChar));
            } else {
                numLine[counter] = Integer.parseInt(current);
                counter++;
                current = "";
            }
        }
        return numLine;
    }
}
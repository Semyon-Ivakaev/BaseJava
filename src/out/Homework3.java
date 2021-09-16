package out;

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
        String stringOne = "Ab Dc";
        String stringTwo = "Dc   a B";

        stringOne = stringOne.toLowerCase().replace(" ", "");
        stringTwo = stringTwo.toLowerCase().replace(" ", "");

        if (stringOne.length() == stringTwo.length() && sortString(stringOne).equals(sortString(stringTwo))) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    char ch = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ch;
                }
            }
        }
        return Arrays.toString(arr);
    }
}

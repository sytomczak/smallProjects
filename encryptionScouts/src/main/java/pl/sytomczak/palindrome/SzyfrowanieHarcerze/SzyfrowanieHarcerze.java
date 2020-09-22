package pl.sytomczak.palindrome.SzyfrowanieHarcerze;

import java.util.Map;

public class SzyfrowanieHarcerze {
    public static String decryptEncrypt(String input, Map<Character, Character> key) {
        StringBuilder outputString = new StringBuilder();
        char[] array = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            Character inputChar = Character.toLowerCase(array[i]);

            if (key.containsKey(inputChar)) {
                Character currentKey = key.get(inputChar);
                outputString.append(currentKey);
            } else {
                outputString.append(inputChar);
            }
        }

        return outputString.toString();

    }
}

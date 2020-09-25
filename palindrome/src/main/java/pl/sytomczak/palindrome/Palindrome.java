package pl.sytomczak.palindrome;

public class Palindrome {

    private String inputString;

    public Palindrome(String inputString) {
        this.inputString = inputString;
    }

    public static boolean isPalindrome(String inputString) {

        int numberOfLetterInInputString = inputString.length() - 1;
        int passageThoughLetters = 0;
        inputString = inputString.toLowerCase();

        while (passageThoughLetters <= numberOfLetterInInputString) {

            char firstLetterInInputString = inputString.charAt(passageThoughLetters);
            char lastLetterInInputString = inputString.charAt(numberOfLetterInInputString);

            if (!(firstLetterInInputString >= 'a' && firstLetterInInputString <= 'z')) {
                passageThoughLetters++;
            }
            if (!(lastLetterInInputString >= 'a' && lastLetterInInputString <= 'z')) {
                numberOfLetterInInputString--;
            }
            if (lastLetterInInputString == firstLetterInInputString) {
                numberOfLetterInInputString--;
                passageThoughLetters++;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(Palindrome.isPalindrome("Dammit, I'm Mad"));
    }
}

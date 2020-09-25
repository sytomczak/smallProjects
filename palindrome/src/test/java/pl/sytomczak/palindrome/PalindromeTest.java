package pl.sytomczak.palindrome;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    Palindrome palindrome;

    @Test
    public void isPalindrome() {
        String word = "abcdeee";
        boolean result;

        result = Palindrome.isPalindrome(word);
        assertThat(result).isFalse();
    }

    @Test
    public void isPalindrome2() {
        String word = "aaa  43a  aa1a";
        boolean result;

        result = Palindrome.isPalindrome(word);
        assertThat(result).isFalse();
    }

    @Test
    public void isPalindrome3() {
        String word = "ABC2cba";
        boolean result;

        result = Palindrome.isPalindrome(word);
        assertThat(result).isTrue();
    }

}

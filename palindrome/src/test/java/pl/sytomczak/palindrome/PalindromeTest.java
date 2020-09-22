package pl.sytomczak.palindrome;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    Palindrome palindrome;

    @Test
    public void isPalindrome() {
        String word = "abcdeee";
        Palindrome.isPalindrome(word);
        Assert.assertFalse(word, false);
    }

    @Test
    public void isPalindrome2() {
        String word = "aaa  43a  aa1a";
        Palindrome.isPalindrome(word);
        Assert.assertTrue(word, true);
    }

    @Test
    public void isPalindrome3() {
        String word = "AQQ34567Qqa";
        Palindrome.isPalindrome(word);
        Assert.assertTrue(word,true);
    }
}

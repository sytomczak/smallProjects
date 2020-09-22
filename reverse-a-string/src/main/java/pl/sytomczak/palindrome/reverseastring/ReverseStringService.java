package pl.sytomczak.palindrome.reverseastring;

import org.springframework.stereotype.Service;

@Service
public class ReverseStringService {

    public String reverseString(String reverse) {
        return new StringBuilder(reverse).reverse().toString();
    }
}

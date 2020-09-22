package pl.sytomczak.palindrome.SzyfrowanieHarcerze;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<Character, Character> encryptorKey = new HashMap<Character, Character>() {{
        put('a', 'ł');
        put('b', 'm');
        put('c', 'n');
        put('d', 'o');
        put('e', 'p');
        put('f', 'r');
        put('g', 's');
        put('h', 't');
        put('i', 'u');
        put('j', 'w');
        put('k', 'y');
        put('l', 'z');
        put('ł', 'a');
        put('m', 'b');
        put('n', 'c');
        put('o', 'd');
        put('p', 'e');
        put('r', 'f');
        put('s', 'g');
        put('t', 'h');
        put('u', 'i');
        put('w', 'j');
        put('y', 'k');
        put('z', 'l');
        put('ź', 'x');
        put('ż', 'q');
    }};


    public static final Map<Character, Character> decryptorKey = new HashMap<Character, Character>() {{
        put('ł', 'a');
        put('m', 'b');
        put('n', 'c');
        put('o', 'd');
        put('p', 'e');
        put('r', 'f');
        put('s', 'g');
        put('t', 'h');
        put('u', 'i');
        put('w', 'j');
        put('y', 'k');
        put('z', 'l');
        put('a', 'ł');
        put('b', 'm');
        put('c', 'n');
        put('d', 'o');
        put('e', 'p');
        put('f', 'r');
        put('g', 's');
        put('h', 't');
        put('i', 'u');
        put('j', 'w');
        put('k', 'y');
        put('l', 'z');
        put('x', 'ź');
        put('q', 'ż');
    }};

}

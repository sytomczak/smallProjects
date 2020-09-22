package pl.sytomczak.palindrome.SzyfrowanieHarcerze;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SzyfrowanieHarcerzeTest {

    @Test
    public void shouldEncrypt() {
        String input = "abcdefghijk lłm 1 noprstu wyzźż";
        String expected = "łmnoprstuwy zab 1 cdefghi jklxq";

        String result = SzyfrowanieHarcerze.decryptEncrypt(input, Constants.encryptorKey);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldDencrypt() {
        String input = "łmnoprstuwy zab 1 cdefghi jklxq";
        String expected = "abcdefghijk lłm 1 noprstu wyzźż";

        String result = SzyfrowanieHarcerze.decryptEncrypt(input, Constants.decryptorKey);

        assertThat(result).isEqualTo(expected);
    }

}
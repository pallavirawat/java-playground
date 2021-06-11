package CCmasker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaskerTest {
    @Test
    void shouldNotMaskWhenSizeLessThan6() {
        Masker masker = new Masker();

        String original = "ABC12";
        String maskedCC = masker.mask(original);

        Assertions.assertEquals(original, maskedCC);
    }

    @Test
    void shouldMaskFirstCharAndLast4Chars() {
        Masker masker = new Masker();

        String original = "12C12H65780";
        String maskedCC = masker.mask(original);

        Assertions.assertEquals("X2C12H6XXXX", maskedCC);
    }

    @Test
    void shouldNotMaskNonNumericCharacters() {
        Masker masker = new Masker();

        String original = "A2C12H657BC";
        String maskedCC = masker.mask(original);

        Assertions.assertEquals("A2C12H6XXBC", maskedCC);
    }
}
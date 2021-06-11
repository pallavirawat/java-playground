package OrdinalNumberConvo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

class OrdinalNumberConverterTest {
    Random rand = new Random();

    @Test
    void first() {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(1);

        Assertions.assertEquals("1st", ordNum);
    }

    @Test
    void second() {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(2);

        Assertions.assertEquals("2nd", ordNum);
    }

    @Test
    void third() {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(3);

        Assertions.assertEquals("3rd", ordNum);
    }

    @Test
    void fifth() {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(5);

        Assertions.assertEquals("5th", ordNum);
    }

    @Test
    void eleventh() {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(11);

        Assertions.assertEquals("11th", ordNum);
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 11, 26, 1000,22})
    void shouldAddThPrefix(int number) {
        OrdinalNumberConverter ordinalNumberConverter = new OrdinalNumberConverter();

        String ordNum = ordinalNumberConverter.convert(number);

        Assertions.assertEquals(number+"th", ordNum);
    }
}
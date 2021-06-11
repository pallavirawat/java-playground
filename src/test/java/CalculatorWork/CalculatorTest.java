package CalculatorWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldDoNothingWhenNoOperatorIsThere() {
        String input = "1 4 5";
        String result = new Calculator().calculate(input);

        Assertions.assertEquals("1 4 5", result);
    }

    @Test
    void shouldBeAbleToAdd() {
        String input = "1 4 +";
        String result = new Calculator().calculate(input);

        Assertions.assertEquals("5", result);
    }

    @Test
    void shouldBeAbleToDelete() {
        String input = "1 4 -";
        String result = new Calculator().calculate(input);

        Assertions.assertEquals("-3", result);
    }

    @Test
    void shouldBeAbleToDivide() {
        String input = "10 4 /";
        String result = new Calculator().calculate(input);

        Assertions.assertEquals("2.5", result);
    }

    @Test
    void shouldBeAbleToMultiply() {
        String input = "2 4 *";
        String result = new Calculator().calculate(input);

        Assertions.assertEquals("8", result);
    }
}
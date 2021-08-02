package KR1.SmoothieMaker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmoothieTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void classicSmoothieWithIngredientsReturned() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void throwExceptionFOrInvalidItem() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Smoothie.ingredients("Classic,-Blah");
        });
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothieWithNoIngredient() {
        assertEquals("",
                Smoothie.ingredients("Classic,-strawberry,-banana,-honey,-mango,-peach,-pineapple"));
    }

    @Test
    public void classicSmoothieWithChocolate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Smoothie.ingredients("Classic,chocolate");
        });
    }

    @Test
    public void smoothieOrderShouldIgnoreCaseInsensivityForrAleergies() {
        assertEquals("black currant,blueberry,frozen yogurt,grape juice",
                Smoothie.ingredients("Freezie,-BlackBerry"));
    }

    @Test
    public void smoothieWhichDOesNotExistShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Smoothie.ingredients("Vitamin smoothie");
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForUnparsableInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Smoothie.ingredients("Vitamin-,,,,,-");
        });
    }

}
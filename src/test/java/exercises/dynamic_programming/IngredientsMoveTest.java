package exercises.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientsMoveTest {

    private final IngredientsMove ingredientsMove = new IngredientsMove();

    @Test
    void minNumberOfChanges() {

        String[] list1 = new String[]{"mleko", "jajka", "dżem", "sól", "tortilla", "musztarda"};
        String[] list2 = new String[]{"mleko", "jajka", "sól", "mąka"};

        int result = ingredientsMove.minNumberOfChanges(list1, list2);

        assertEquals(4, result);

    }
}
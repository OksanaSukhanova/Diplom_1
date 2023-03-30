import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final String expectedString;
    private final IngredientType ingredientType;

    public IngredientTypeParameterizedTest(String expectedString, IngredientType ingredientType) {
        this.expectedString = expectedString;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void ingredientTypeHasCorrectValue() {
        String actualString = ingredientType.toString();

        assertEquals("Тип ингредиента не получен", expectedString, actualString);
    }
}

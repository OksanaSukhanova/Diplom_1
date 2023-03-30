import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Test
    public void getPriceReturnsCorrectValue() {
        ingredient = new Ingredient(IngredientType.FILLING, "sauce", 20);

        float expectedPrice = 20;
        float actualPrice = ingredient.getPrice();

        assertEquals("Некорректная цена ингредиента", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        ingredient = new Ingredient(IngredientType.FILLING, "sauce", 20);

        String expectedName = "sauce";
        String actualName = ingredient.getName();

        assertEquals("Некорректное название ингредиента", expectedName, actualName);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        ingredient = new Ingredient(IngredientType.FILLING, "sauce", 20);

        String expectedType = "filling";
        String actualType = ingredient.getType().toString().toLowerCase();

        assertEquals("Некорректный тип ингредиента", expectedType, actualType);
    }
}

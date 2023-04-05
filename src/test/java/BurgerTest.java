import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    @Test
    public void addIngredientIncreasesNumberOfIngredients() {
        burger = new Burger();
        burger.addIngredient(ingredient);

        int actualIngredientsNumber = burger.ingredients.size();
        int expectedIngredientsNumber = 1;

        assertEquals("Ингредиент не добавлен", expectedIngredientsNumber, actualIngredientsNumber);
    }

    @Test
    public void removeIngredientDecreasesNumberOfIngredients() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int actualIngredientsNumber = burger.ingredients.size();
        int expectedIngredientsNumber = 0;

        assertEquals("Ингредиент не удален", expectedIngredientsNumber, actualIngredientsNumber);
    }

    @Test
    public void moveIngredientSwapsTwoIngredients() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1, 0);

        Ingredient actualFirstIngredient = burger.ingredients.get(0);
        Ingredient expectedFirstIngredient = ingredient2;
        Ingredient actualSecondIngredient = burger.ingredients.get(1);
        Ingredient expectedSecondIngredient = ingredient;
        int actualIngredientsNumber = burger.ingredients.size();
        int expectedIngredientsNumber = 2;

        assertEquals("Ингредиенты не перемещены", expectedFirstIngredient, actualFirstIngredient);
        assertEquals("Ингредиенты не перемещены", expectedSecondIngredient, actualSecondIngredient);
        assertEquals("Ингредиент удален", expectedIngredientsNumber, actualIngredientsNumber);
    }

    @Test
    public void getPriceReturnsBurgerPrice() {
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getPrice()).thenReturn(20f);
        Mockito.when(ingredient2.getPrice()).thenReturn(20f);


        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        float expectedPrice = 140f;
        float actualPrice = burger.getPrice();

        assertEquals("Цена некорректная", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptReturnsCorrectString() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("ketchup");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getPrice()).thenReturn(20f);
        Mockito.when(ingredient2.getPrice()).thenReturn(20f);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== white bun ====)%n= sauce ketchup =%n= filling dinosaur =%n(==== white bun ====)%n%nPrice: 140,000000%n");

        assertEquals("Некорректный рецепт", expectedReceipt, actualReceipt);
    }
}

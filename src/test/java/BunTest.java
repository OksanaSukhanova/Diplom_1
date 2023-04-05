import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;

    @Test
    public void getNameReturnsCorrectValue() {
        bun = new Bun("some bun", 50);

        String expectedName = "some bun";
        String actualName = bun.getName();

        assertEquals("Некорректное название булки", expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        bun = new Bun("some bun", 50);

        float expectedPrice = 50;
        float actualPrice = bun.getPrice();

        assertEquals("Некорректная цена булки", expectedPrice, actualPrice, 0);
    }
}

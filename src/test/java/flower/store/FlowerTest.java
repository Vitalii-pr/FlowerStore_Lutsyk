package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;
    private Flower flowerSecond;
    private FlowerPack pack, packSecond;
    private FlowerBucket bucket;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flowerSecond = new Flower();
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int priceSecond = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flowerSecond.setPrice(priceSecond);
        Assertions.assertEquals(price, flower.getPrice());
        // print(pack.toString());

        pack = new FlowerPack(flower, RANDOM_GENERATOR.nextInt(MAX_PRICE));
        Assertions.assertEquals(price*pack.getQuantity(), pack.getPrice());

        packSecond = new FlowerPack(
                flowerSecond,
                RANDOM_GENERATOR.nextInt(MAX_PRICE));

        Assertions.assertEquals(
                priceSecond*packSecond.getQuantity(),
                packSecond.getPrice());

        bucket = new FlowerBucket(pack, packSecond);
        Assertions.assertEquals(
                bucket.getPrice(),
                packSecond.getPrice()+pack.getPrice());
    }
}

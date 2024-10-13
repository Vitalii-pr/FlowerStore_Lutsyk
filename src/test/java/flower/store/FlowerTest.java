package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;
    private Flower flower2;
    private FlowerPack pack, pack1;
    private FlowerBucket bucket;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flower2 = new Flower();
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
        int price1 = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flower2.setPrice(price1);
        Assertions.assertEquals(price, flower.getPrice());
        // print(pack.toString());

        pack = new FlowerPack(flower, 3);
        Assertions.assertEquals(price*pack.getQuantity(), pack.getPrice());

        pack1 = new FlowerPack(flower2, 4);
        Assertions.assertEquals(price1*pack1.getQuantity(), pack1.getPrice());

        bucket = new FlowerBucket(pack, pack1);
        Assertions.assertEquals(bucket.getPrice(), pack1.getPrice()+pack.getPrice());
    }
}

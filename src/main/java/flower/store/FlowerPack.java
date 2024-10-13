package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FlowerPack {
    private Flower flower;
    @Getter
    private int quantity;

    public double getPrice(){
        return flower.getPrice()*quantity;
    }
}

package flower.store;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> packs;
    @Getter
    private int amount;

    public FlowerBucket(FlowerPack... packs) {
        this.packs = Arrays.asList(packs);
        this.amount = packs.length;
    }

    public void addPack(FlowerPack fl) {
        packs.add(fl);
        amount += 1;
    }

    public double getPrice() {
        double sum = 0;

        for (FlowerPack fl:packs) {
            sum += fl.getPrice();
        }

        return sum;
    }



}

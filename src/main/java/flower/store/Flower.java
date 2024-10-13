package flower.store;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter @Setter
    private double price;
    @Getter
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }



}

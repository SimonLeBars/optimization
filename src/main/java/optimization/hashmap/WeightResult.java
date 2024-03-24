package optimization.hashmap;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import optimization.hashmap.chicken.ChickenBreedEnum;

@Getter
@Setter
@ToString
public class WeightResult {
    private double minWeight;
    private double avgWeight;
    private double maxWeight;
    private int age;
    private ChickenBreedEnum breed;

    public WeightResult(double minWeight, double avgWeight, double maxWeight, int age, ChickenBreedEnum breed) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.avgWeight = avgWeight;
        this.age = age;
        this.breed = breed;
    }
}

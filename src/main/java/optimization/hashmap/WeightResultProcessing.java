package optimization.hashmap;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import optimization.hashmap.chicken.ChickenBreedEnum;

@Getter
@Setter
@ToString
public class WeightResultProcessing {
    private double minWeight;
    private double avgWeight;
    private double maxWeight;
    private int age;
    private ChickenBreedEnum breed;
    private int chickenNb;

    public WeightResultProcessing(int age, ChickenBreedEnum breed) {
        this.minWeight = Double.MAX_VALUE;
        this.maxWeight = 0;
        this.avgWeight = 0;
        this.age = age;
        this.breed = breed;
        chickenNb = 0;
    }
}

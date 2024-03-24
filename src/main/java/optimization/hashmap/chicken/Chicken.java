package optimization.hashmap.chicken;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chicken {
    public static int MAX_AGE = 40;

    private String id;
    private double weight;
    private int age;
    private ChickenBreedEnum breed;

    public Chicken(String id) {
        this.id = id;
        this.age = Math.toIntExact(Math.round(Math.ceil(Math.random() * MAX_AGE)));
        this.breed = ChickenBreedEnum.getRandomBreed();
        this.weight = this.age * this.breed.getAvgWeight()/MAX_AGE
                + (Math.random() - 0.5) * (this.breed.getAvgWeight()*5)/(MAX_AGE*100) * this.age;
    }

    public Chicken(String id, int age) {
        this.id = id;
        this.age = age;
        this.breed = ChickenBreedEnum.getRandomBreed();
        this.weight = this.age * this.breed.getAvgWeight()/MAX_AGE
                + (Math.random() - 0.5) * (this.breed.getAvgWeight()*5)/(MAX_AGE*100) * this.age;
    }
}

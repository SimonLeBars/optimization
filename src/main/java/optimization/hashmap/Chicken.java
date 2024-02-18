package optimization.hashmap;

public class Chicken {
    String id;
    double weight;
    int age;

    public Chicken(String id) {
        this.id = id;
        this.age = Math.toIntExact(Math.round(Math.random() * 40));
        this.weight = this.age * 0.1 + (Math.random() - 0.5) * 0.02 * this.age;
    }
}

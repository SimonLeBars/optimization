package optimization.hashmap;

import optimization.hashmap.chicken.Chicken;
import optimization.hashmap.chicken.ChickenBreedEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MapReduceUtil {

    private static final Logger logger = LogManager.getLogger(MapReduceUtil.class);

    private MapReduceUtil(){}


    /**
     * TODO complexity
     * @param chickens list of chickens to process
     * @return process results
     */
    public static List<WeightResult> calculateWeightResultBasic(List<Chicken> chickens, int age) {
        List<WeightResult> results = new ArrayList<>();
        for (ChickenBreedEnum breed : ChickenBreedEnum.values()) {
            List<Double> chickensWeightFilteredByBreed = chickens.stream().filter(chicken -> chicken.getBreed().equals(breed))
                    .map(Chicken::getWeight).toList();
            double avg = chickensWeightFilteredByBreed.stream().mapToDouble(a -> a).average().orElseThrow();
            double min = chickensWeightFilteredByBreed.stream().mapToDouble(a -> a).min().orElseThrow();
            double max = chickensWeightFilteredByBreed.stream().mapToDouble(a -> a).max().orElseThrow();

            results.add(new WeightResult(min, avg, max, age, breed));
        }
        return results;
    }

    public static List<WeightResult> calculateWeightResultGroupByBreed(List<Chicken> chickens, int age) {
        Map<ChickenBreedEnum, List<Double>> mapBreedChickens = new HashMap<>();

        chickens.forEach(chicken -> {
            if (!mapBreedChickens.containsKey(chicken.getBreed())) {
                mapBreedChickens.put(chicken.getBreed(), new ArrayList<>());
            }
            mapBreedChickens.get(chicken.getBreed()).add(chicken.getWeight());
        });

        List<WeightResult> results = new ArrayList<>();

        for (Map.Entry<ChickenBreedEnum, List<Double>> entry : mapBreedChickens.entrySet()) {
            double avg = entry.getValue().stream().mapToDouble(a -> a).average().orElseThrow();
            double min = entry.getValue().stream().mapToDouble(a -> a).min().orElseThrow();
            double max = entry.getValue().stream().mapToDouble(a -> a).max().orElseThrow();

            results.add(new WeightResult(min, avg, max, age, entry.getKey()));
        }

        results.sort(Comparator.comparing(WeightResult::getBreed));

        return results;
    }

    public static List<WeightResult> calculateWeightResultReduced(List<Chicken> chickens, int age) {
        Map<ChickenBreedEnum, WeightResultProcessing> mapBreedWeightResult = new HashMap<>();

        chickens.forEach(chicken -> {
            if (!mapBreedWeightResult.containsKey(chicken.getBreed())) {
                mapBreedWeightResult.put(chicken.getBreed(), new WeightResultProcessing(age, chicken.getBreed()));
            }

            WeightResultProcessing weightResult = mapBreedWeightResult.get(chicken.getBreed());
            weightResult.setMinWeight(
                    Math.min(weightResult.getMinWeight(), chicken.getWeight())
            );
            weightResult.setMaxWeight(
                    Math.max(weightResult.getMaxWeight(), chicken.getWeight())
            );
            weightResult.setAvgWeight(
                    (weightResult.getAvgWeight() * weightResult.getChickenNb() + chicken.getWeight())
                            / (weightResult.getChickenNb() + 1)
            );
            weightResult.setChickenNb(weightResult.getChickenNb() + 1);
        });

        mapBreedWeightResult.forEach((key, value) -> logger.info(value));

        List<WeightResult> results = new ArrayList<>();

        for (Map.Entry<ChickenBreedEnum, WeightResultProcessing> entry : mapBreedWeightResult.entrySet()) {
            WeightResultProcessing weightResult2 = entry.getValue();
            results.add(new WeightResult(weightResult2.getMinWeight(), weightResult2.getAvgWeight(),
                    weightResult2.getMaxWeight(), age, entry.getKey()));
        }

        results.sort(Comparator.comparingInt(WeightResult::getAge));

        return results;
    }
}

package optimization.hashmap;

import optimization.hashmap.chicken.Chicken;

import java.util.*;

public class GenerateUtil {

    private GenerateUtil(){}

    public static Set<String> generateUniqueIdentifiers(int numIdentifiers) {
        Set<String> uniqueIdentifiers = new HashSet<>();
        Random random = new Random();
        while (uniqueIdentifiers.size() < numIdentifiers) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                char randomChar = (char) (random.nextInt(26) + 'A');
                sb.append(randomChar);
            }
            for (int i = 0; i < 4; i++) {
                int randomNumber = random.nextInt(10);
                sb.append(randomNumber);
            }
            uniqueIdentifiers.add(sb.toString());
        }
        return uniqueIdentifiers;
    }

    public static String selectRandomIdentifier(Set<String> identifiers) {
        long n = Math.round(Math.random() * identifiers.size());
        Iterator<String> iterator = identifiers.iterator();
        for (long i = 0; i < n && iterator.hasNext(); i++) {
            identifiers.iterator().next();
        }
        return identifiers.iterator().next();
    }

    public static List<Chicken> createList(Set<String> ids) {
        List<Chicken> chickens = new ArrayList<>();
        for (String id: ids) {
            chickens.add(new Chicken(id));
        }
        return chickens;
    }

    public static List<Chicken> createList(Set<String> ids, int age) {
        List<Chicken> chickens = new ArrayList<>();
        for (String id: ids) {
            chickens.add(new Chicken(id, age));
        }
        return chickens;
    }

    public static TreeMap<String, Chicken> createTreeMap(Set<String> ids) {
        TreeMap<String, Chicken> chickens = new TreeMap<>();
        for (String id: ids) {
            chickens.put(id, new Chicken(id));
        }
        return chickens;
    }

    public static HashMap<String, Chicken> createHashMap(Set<String> ids) {
        HashMap<String, Chicken> chickens = new HashMap<>();
        for (String id: ids) {
            chickens.put(id, new Chicken(id));
        }
        return chickens;
    }
}

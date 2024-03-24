package optimization.hashmap.chicken;

import lombok.Getter;

@Getter
public enum ChickenBreedEnum {
    ORPINGTON("Orpington", 1.9),
    FAVEROLLES("Faverolles", 1.95),
    HOUDAN("Houdan", 1.95),
    COU_NU_DU_FOREZ("Cou-nu du Forez", 2.0),
    CREVE_COEUR("Crève-coeur", 2.05),
    FLECHE("Flèche", 2.1),
    NEW_HAMPSHIRE("New-Hampshire", 2.15),
    SEBRIGHT("Sebright", 2.2),
    NEGRE_SOIE("Nègre Soie", 2.25),
    BRESSE_GAULOISE("Bresse-gauloise", 2.3);

    private static final ChickenBreedEnum[] chickenBreedList = ChickenBreedEnum.values();

    private final String name;
    private final double avgWeight;


    ChickenBreedEnum(String name, double avgWeight) {
        this.name = name;
        this.avgWeight = avgWeight;
    }

    public static ChickenBreedEnum getRandomBreed() {
        int i = (int) Math.floor(Math.random() * chickenBreedList.length);
        return chickenBreedList[i];
    }
}

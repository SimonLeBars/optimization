# Optimization
Comparaison des performances d'algorithmes.

Dans le dossier src/test se trouvent des test unitaires comparant les temps de traitements de différentes méthodes.

## MapAverageTests

Cette class de test contient des tests comparant différents algorithmes de calcul de moyenne et montrant par des exemples pratiques l'intérêt des HashMap.

### Contexte

On possède une grande quantitée de données concernant des poulets de différentes espèces, le but est de calculer la 
moyenne de poids, le poids max et le poids min pour chaque espèce.

Les poulets possèdent également un age (en jours) qui n'est ici pas utilisé car tous les poulets sont générés avec un 
age fixé à 40 jours.

### Concept présenté

On souhaite montrer ici que la HashMap nous permet de trier de manière performante les poulets par espèce afin 
d'optimiser le calcul des moyennes de poids.

## TODO

- Présenter les différentes class de test
- Ajouter une table des matière au README
- Détailler les concepts de complexité, hashage...
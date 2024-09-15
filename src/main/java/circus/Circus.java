package circus;

import circus.animal.*;

import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the array are: " + animals.length);
        // animals[3] = new Elephant("Dumbo"); // this doesn't work: arrays are immutable
        // Initialise ArrayList with list representation of static array
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
        System.out.println("Size of our animal array list: " + animalArrayList.size());

        Elephant Dumbo = new Elephant("Dumbo");
        animalArrayList.add(Dumbo);
        Duck Donald = new Duck("Donald");
        animalArrayList.add(Donald);

        System.out.println("Before sorting...");
        printAllAnimals(animalArrayList);
        System.out.println("Size of our animal array list: " + animalArrayList.size());

        // Get index using indexOf(objectReference)
        System.out.println("Dumbo is in position: " + (animalArrayList.indexOf(Dumbo) + 1));

        // Sort: can input a custom comparator and combine comparators
        animalArrayList.sort(AnimalNameComparator);

        System.out.println("After sorting...");
        printAllAnimals(animalArrayList);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Goose");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Peter");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}

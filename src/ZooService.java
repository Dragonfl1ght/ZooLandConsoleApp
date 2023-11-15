import java.util.List;
import java.util.function.Function;

public class ZooService {

    public static void getAnimalList(List<Animal> animals){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", "Species", "Name", "Legs", "Dietary Regime", "Color", "Habitat");
        for (Animal animal : animals) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", animal.getSpecies(), animal.getName(), animal.getLegs(),
                    animal.getDietary_regime(), animal.getColor(), animal.getHabitat());
        }
//        for (Animal animal : animals) {
//           System.out.println("Species:" + animal.getSpecies() + "Name" + animal.getName() + "Legs"+ animal.getLegs()
//                   + "Dietary regime" + animal.getDietary_regime() + "Color"+ animal.getColor() + "Habitat" + animal.getHabitat());
//
//        }
    }
    public static void getAnimalByName(List<Animal> animals, String keyword){
        for (Animal animal : animals) {
            if (animal.getName() == keyword){
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", animal.getSpecies(), animal.getName(), animal.getLegs(),
                        animal.getDietary_regime(), animal.getColor(), animal.getHabitat());
                break;
            }
        }
    }
    public static void getAnimalsByType(List<Animal> animals, String type){
        System.out.println("| Name | Species | Legs | Dietary Regime | Color | Type |");
        for (Animal animal : animals) {
            if (animal.getName() == type){
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", animal.getSpecies(), animal.getName(), animal.getLegs(),
                        animal.getDietary_regime(), animal.getColor(), animal.getHabitat());
            }
        }
    }
    public static void getAnimalByAnyType(List<Animal> animals, String type){
        Function<Animal, String> getTypeFunction;

        if(type.equalsIgnoreCase("Name")){
            getTypeFunction = Animal::getName;
        } else if(type.equalsIgnoreCase("Species")){
            getTypeFunction = Animal::getSpecies;
        } else if(type.equalsIgnoreCase("Legs")){
            getTypeFunction = Animal::getLegs;
        } else if(type.equalsIgnoreCase("Color")){
            getTypeFunction = Animal::getColor;
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }

        for (Animal animal : animals) {
            if (getTypeFunction.apply(animal).equalsIgnoreCase(type)){
                System.out.println("Name            " + animal.getName() );
                System.out.println("Species         " + animal.getSpecies() );
                System.out.println("Legs            " + animal.getLegs() );
                System.out.println("Dietary regime  " + animal.getDietary_regime() );
                System.out.println("Color           " + animal.getColor() );
                System.out.println("Habitat         " + animal.getHabitat() );

            }
        }
    }

    public static void addAnimalToList(List<Animal> animals, Animal animal){
        animals.add(animal);
    }

    public static void removeFromListByName(List<Animal> animals, String keyword){
                animals.removeIf(animal -> animal.getName().equals(keyword));
    }

    public static void renameAnimal(List<Animal> animals, String name, String new_name){
        for (Animal animal : animals) {
            if (animal.getName().equals(name)){
                animal.setName(new_name);
                break;
            }
        }
    }

    public static void compareAnimals(List<Animal> animals, String name1, String name2){
        int ind1 = -1, ind2 = -1;
        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getSpecies().equals(name1))
                ind1 = i;
            else if(animals.get(i).getSpecies().equals(name2))
                ind2 = i;
        }
        if (ind1 == -1 || ind2 == -1)
            System.out.println("Incorrect name");
        System.out.println("                " + name1 + " " + name2 +"\n");
        System.out.println("Species         " + animals.get(ind1).getSpecies() + " " + animals.get(ind2).getSpecies());
        System.out.println("Legs            " + animals.get(ind1).getLegs() + " " + animals.get(ind2).getLegs());
        System.out.println("Dietary regime  " + animals.get(ind1).getDietary_regime() + " " + animals.get(ind2).getDietary_regime());
        System.out.println("Color           " + animals.get(ind1).getColor() + " " + animals.get(ind2).getColor());
        System.out.println("Habitat         " + animals.get(ind1).getHabitat() + " " + animals.get(ind2).getHabitat());

    }
}

//        if(animal1.getName().equals(animal2.getName()) && animal1.getSpecies().equals(animal2.getSpecies())
//        && animal1.getLegs().equals(animal2.getLegs()) && animal1.getDietary_regime().equals(animal2.getDietary_regime())
//        && animal1.getColor().equals(animal2.getColor()) && animal1.getHabitat().equals(animal2.getHabitat()))
//            System.out.println("Animals are the same animal");
//        else if(!animal1.getName().equals(animal2.getName()) && !animal1.getSpecies().equals(animal2.getSpecies())
//                && animal1.getLegs().equals(animal2.getLegs()) && animal1.getDietary_regime().equals(animal2.getDietary_regime())
//                && animal1.getColor().equals(animal2.getColor()) && animal1.getHabitat().equals(animal2.getHabitat()))
//            System.out.println("Animals of one species");
//        else
//            System.out.println("Diffferent animals");
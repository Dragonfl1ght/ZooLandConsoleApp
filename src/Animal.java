import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String species;
    private String name;
    private String legs;
    private String dietary_regime;
    private String color;
    private String habitat;

    public Animal(){}

    public Animal(String species, String name, String legs, String dietary_regime, String color, String habitat) {
        this.species = species;
        this.name = name;
        this.legs = legs;
        this.dietary_regime = dietary_regime;
        this.color = color;
        this.habitat = habitat;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getDietary_regime() {
        return dietary_regime;
    }

    public void setDietary_regime(String dietary_regime) {
        this.dietary_regime = dietary_regime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public static List<Animal> readAnimalsFromFile(String filename) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                Animal animal = new Animal();
                animal.setSpecies(parts[1]);
                animal.setName(parts[3]);
                animal.setLegs(parts[5]);
                animal.setDietary_regime(parts[7]);
                animal.setColor(parts[9]);
                animal.setHabitat(parts[11]);
                animals.add(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

}

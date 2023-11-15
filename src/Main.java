import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = Animal.readAnimalsFromFile("C:\\Program Files\\JetBrains\\Projects\\ZooLand\\src\\AnimalsList.txt");
        Scanner in = new Scanner(System.in);

        int tmp = -1;
        while(tmp != 0){
            if (tmp == -1){
            System.out.println("""
                    Welcome to the zoo!
                    Choose action what you want to do
                    """);
            System.out.println("""
                    1. Get list of animals in zoo
                    2. Get animal from list of animals by name
                    3. Get animals by one of presented types
                    4. Add animal too Zoo
                    5. Remove animal from Zoo by its name
                    6. Rename animal
                    7. Compare two animals
                     0. Exit""");
            }

            //Получить спиосок животных по любому признаку OK!
            //Сравнить животных по всем неуникальным признакам
            //Формат вывода поправить
            // Залить на гит
            tmp = in.nextInt();
            switch (tmp){
                case 1:
                    ZooService.getAnimalList(animals);
                case 2: {
                    String name = in.nextLine();
                    System.out.println("Input animals name");
                    ZooService.getAnimalByName(animals, name);
                }
                case 3: {
                    String type = in.nextLine();
                    System.out.println("Input type");
                    ZooService.getAnimalsByType(animals, type);
                }
                case 4: {
                    System.out.println("Input animal's:\nspecies\nname\nlegs\n" +
                            "dietary regime\ncolor\nhabitat\n");
                    List<String> chars = new ArrayList<>();
                    for(int i = 0; i < 6; i++)
                        chars.add(in.nextLine());
                    ZooService.addAnimalToList(animals,(new Animal(chars.get(0),chars.get(1),chars.get(2)
                            ,chars.get(3),chars.get(4),chars.get(5))));
                }
                case 5:{
                    System.out.println("Input name of deleting animal");
                    String name = in.nextLine();
                    ZooService.removeFromListByName(animals, name);
                }
                case 6:{
                    System.out.println("Input old name and new name");
                    String name = in.nextLine();
                    String new_name = in.nextLine();
                    ZooService.renameAnimal(animals, name, new_name);
                }
                case 7:{
                    System.out.println("Input names of two animals ");
                    String name1 = in.nextLine();
                    String name2 = in.nextLine();
                    ZooService.compareAnimals(animals, name1, name2);
                }
                System.out.println("To return to main menu input -1. To exit input 0\n");
                tmp = in.nextInt();
            }
        }

    }
}

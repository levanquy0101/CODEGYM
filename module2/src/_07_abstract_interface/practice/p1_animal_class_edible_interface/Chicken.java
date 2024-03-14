package _07_abstract_interface.practice.p1_animal_class_edible_interface;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken make sound: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Chicken how to eat: could be fried";
    }
}

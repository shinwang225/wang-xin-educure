package Main1;

public class Main1 {
    public static void main(String[] args) {
        
        Animal []animal = new Animal[2];
        
        animal[0] = new Dog();
        animal[1] = new Cat();

        for(Animal a:animal){
            a.makeSound();
        }
    }
} 
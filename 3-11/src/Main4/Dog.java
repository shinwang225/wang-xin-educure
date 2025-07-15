package Main4;

import Main3.Animal;

public class Dog implements Animal {
    protected String name;
    protected int age;

    public Dog(String name, int age){
        this.name = name;
        this.age =age;
    }
    @Override
    public void makeSound(){
        System.out.println("ワンワン");
    }

    @Override
    public void eat(){
        System.out.println(name + "が餌を食べています");
    }
    
}

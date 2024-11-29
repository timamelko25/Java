class Animal {
    public static void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    public static void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();  // Выведет "Animal makes sound", не "Dog barks"
    }
}

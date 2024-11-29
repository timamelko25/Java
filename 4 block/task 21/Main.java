class Parent {
    String name = "Суперкласс";

    Parent(String name) {
        this.name = name;
    }

    void print() {
        System.out.println("Имя из суперкласса: " + name);
    }
}

class Child extends Parent {
    String name = "Подкласс";

    Child(String name) {
        super(name);  // вызов конструктора суперкласса
        this.name = name;  // присваиваем значение полю подкласса
    }

    @Override
    void print() {
        super.print();  // вызов метода суперкласса
        System.out.println("Имя из подкласса: " + this.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child("Новый Подкласс");
        child.print();
    }
}

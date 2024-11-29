# Практика #1
## Приведите примеры использования перегрузки и переопределения методов.

Перегрузка методов:

    В классе Calculator метод sum перегружен тремя версиями: для двух параметров типа int, для трёх параметров типа int и для двух параметров типа double.
    Мы вызываем перегруженные методы с разными типами и количеством аргументов.

Переопределение методов:

    В классе Animal есть метод sound(), который выводит текст "Животное издает звук".
    В классах Dog и Cat этот метод переопределяется, чтобы выводить более специфичные звуки для каждой из этих животных (собака и кошка).

```
// Суперкласс Animal
class Animal {

    // Метод в суперклассе
    public void sound() {
        System.out.println("Животное издает звук");
    }
}

// Класс Dog, который наследует Animal и переопределяет метод sound
class Dog extends Animal {

    // Переопределение метода sound
    @Override
    public void sound() {
        System.out.println("Собака лает");
    }
}

// Класс Cat, который наследует Animal и переопределяет метод sound
class Cat extends Animal {

    // Переопределение метода sound
    @Override
    public void sound() {
        System.out.println("Кошка мяукает");
    }
}

// Класс Calculator для демонстрации перегрузки методов
class Calculator {

    // Перегрузка метода sum с двумя параметрами типа int
    public int sum(int a, int b) {
        return a + b;
    }

    // Перегрузка метода sum с тремя параметрами типа int
    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    // Перегрузка метода sum с параметрами типа double
    public double sum(double a, double b) {
        return a + b;
    }
}

```
# Практика #1
## Приведите пример перегруженных методов.

```
class Calculator {
  
    // Перегруженный метод для сложения двух целых чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Перегруженный метод для сложения трех целых чисел
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Перегруженный метод для сложения двух чисел с плавающей точкой
    public double add(double a, double b) {
        return a + b;
    }

    // Перегруженный метод для сложения трех чисел с плавающей точкой
    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Вызовы перегруженных методов
        System.out.println("Сложение двух целых чисел: " + calc.add(5, 10));
        System.out.println("Сложение трех целых чисел: " + calc.add(5, 10, 15));
        System.out.println("Сложение двух чисел с плавающей точкой: " + calc.add(5.5, 10.5));
        System.out.println("Сложение трех чисел с плавающей точкой: " + calc.add(5.5, 10.5, 15.5));
    }
}
```
# Практика #2
## Приведите пример переопределенного метода. Что будет, если у переопределенного и переопределяемого (из суперкласса) методов не будет совпадать тип возвращаемого значения?

В Java метод может быть переопределен в подклассе с тем же названием и параметрами, что и у метода в суперклассе. Переопределение метода позволяет подклассу изменить поведение метода, унаследованного от суперкласса.
Если тип возвращаемого значения у переопределенного метода не совпадает с типом возвращаемого значения метода из суперкласса, то произойдет ошибка компиляции.

```
class Animal {
    // Метод в суперклассе
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    // Переопределение метода в подклассе
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.speak();  // Выведет: Animal speaks

        Dog dog = new Dog();
        dog.speak();  // Выведет: Dog barks
    }
}
```

# Практика #3
## Приведите пример и объясните, когда использование аннотации @Override помогает обнаружить ошибку.

Аннотация @Override используется для явного указания, что метод в подклассе переопределяет метод суперкласса. Она помогает компилятору проверять, правильно ли реализовано переопределение, и выявлять ошибки.

Пример с ошибкой:
```
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak(String sound) {  // Ошибка! Метод не переопределяет speak() из Animal
        System.out.println("Dog barks: " + sound);
    }
}
```

Ошибка возникает, потому что метод в классе Dog имеет другую сигнатуру (с параметром), чем метод в Animal. Компилятор сообщит об ошибке.

Пример без ошибки:
```
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}
```

В этом примере аннотация @Override помогает предотвратить ошибку и гарантирует, что метод в Dog правильно переопределяет метод speak() из Animal.
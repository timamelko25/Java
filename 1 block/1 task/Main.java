// Базовый класс
abstract class Shape {
    public abstract double getArea();
}

// Подкласс Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// Подкласс Square
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        // Используем базовый класс Shape
        Shape rectangle = new Rectangle(5, 10);
        Shape square = new Square(4);

        // Подстановка подклассов работает корректно
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Площадь квадрата: " + square.getArea());
    }
}

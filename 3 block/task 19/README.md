# Практика #1
## Приведите примеры класса, в котором перегружен метод с переменным числом параметров.

Перегрузка метода printValues:

    Есть три версии метода: для int, String, и Object. Перегрузка основана на типах параметров.
    Компилятор выбирает подходящий метод в зависимости от переданных аргументов.

Примеры вызовов:

    printValues(1, 2, 3, 4) вызывает версию с int....
    printValues("Hello", "World", "VarArgs") вызывает версию с String....
    printValues(1, "String", 3.14, true) вызывает версию с Object....

```
    // Метод для чисел
    public static void printValues(int... numbers) {
        System.out.println("Printing integers:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    // Метод для строк
    public static void printValues(String... strings) {
        System.out.println("Printing strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    // Метод для объектов
    public static void printValues(Object obj) {
        System.out.println("Printing single object:");
        System.out.println(obj);
    }
```
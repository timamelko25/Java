# Практика #1
## Приведите примеры использования оператора instanceof с объектами параметризованных классов.

Параметризированные классы:

    Класс Box<T> использует параметризированный тип T. Мы создаем два объекта: Box<Integer> и Box<String>.
    Мы используем оператор instanceof с wildcard (Box<?>) для проверки, является ли объект экземпляром параметризированного класса.

Параметризированные интерфейсы:

    Интерфейс Container<T> реализуется в двух классах: StringContainer и IntegerContainer.
    Используем instanceof с wildcard (Container<?>) для проверки, является ли объект экземпляром интерфейса.

Невозможно использовать конкретный тип с instanceof:

    Поскольку в Java происходит стирание типов (type erasure), мы не можем использовать конкретный тип с instanceof, например, Box<Integer>. Это приведет к ошибке компиляции, так как параметрический тип будет стирается в тип Box.

Wildcard:

    Мы можем использовать wildcard (Box<?>) или сырой тип (Container) для проверки, является ли объект экземпляром класса или интерфейса, но не можем проверить точный тип параметра.

```
// Параметризированный класс Box
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Параметризированный интерфейс Container
interface Container<T> {
    void add(T item);
}

// Реализация интерфейса Container для String
class StringContainer implements Container<String> {
    @Override
    public void add(String item) {
        System.out.println("Adding String: " + item);
    }
}

// Реализация интерфейса Container для Integer
class IntegerContainer implements Container<Integer> {
    @Override
    public void add(Integer item) {
        System.out.println("Adding Integer: " + item);
    }
}
```

# Практика #2
## Приведите примеры использования конструкций <? extends T> и <? super T>. Объясните, зачем они нужны?

    Пример с <? extends T>:
        Метод addNumbers принимает коллекцию List<? extends Number>, что означает, что в этот метод можно передавать списки, содержащие Number или его подтипы (например, Integer, Double).
        Мы можем извлекать элементы из таких списков, но не можем добавлять в них элементы, так как компилятор не знает точный тип коллекции.

    Пример с <? super T>:
        Метод addToList принимает коллекцию List<? super Integer>, что означает, что мы можем передавать коллекции, которые могут хранить Integer и его суперклассы (например, Number или Object).
        Мы можем безопасно добавлять элементы типа Integer в такие коллекции, но не можем точно извлекать элементы, так как они могут быть суперклассами Integer (например, Number или Object).

Вывод:

    Метод addNumbers извлекает элементы из коллекции, которая может содержать любые подтипы Number, но не добавляет новые элементы.
    Метод addToList добавляет элементы типа Integer в коллекцию, которая может содержать объекты типа Integer или его суперклассы.

```
 public static void main(String[] args) {
        // Создание различных списков
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        
        // Добавление чисел в списки
        integers.add(1);
        integers.add(2);
        numbers.add(3.14);
        numbers.add(10);
        
        // Пример с <? extends T> - Мы можем извлекать элементы
        addNumbers(integers);
        addNumbers(numbers);
        
        // Пример с <? super T> - Мы можем добавлять элементы
        addToList(integers);
        addToList(numbers);
    }

    // Метод для извлечения элементов из списка, который может содержать подтипы Number
    public static void addNumbers(List<? extends Number> list) {
        // Мы можем извлекать элементы, но не можем добавлять
        for (Object num : list) {
            System.out.println("Extracted: " + num);
        }
    }

    // Метод для добавления элементов в список, который может содержать суперклассы Integer
    public static void addToList(List<? super Integer> list) {
        // Мы можем добавить Integer, но не можем извлекать элементы с гарантией типа
        list.add(10);
        System.out.println("After adding: " + list);
    }
```
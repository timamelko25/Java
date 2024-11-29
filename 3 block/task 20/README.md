# Практика #1
## Приведите примеры класса, в котором используется инициализация элементов перечисления.

Перечисление Day содержит элементы с дополнительными полями name и description, которые инициализируются через конструктор. Это позволяет добавить описание для каждого дня недели.

В методе getDescription() выводится полное описание каждого дня, объединяя name и description.

В методе main создается переменная типа Day, которая может быть установлена в любой из элементов перечисления. Используется конструкция switch для выполнения различных действий в зависимости от значения этой переменной.

```
public enum Day {
        MONDAY("Понедельник", "Начало недели"),
        TUESDAY("Вторник", "Второй день недели"),
        WEDNESDAY("Среда", "Середина недели"),
        THURSDAY("Четверг", "Почти конец недели"),
        FRIDAY("Пятница", "Конец недели"),
        SATURDAY("Суббота", "Выходной"),
        SUNDAY("Воскресенье", "Выходной");

        private final String name;
        private final String description;

        // Конструктор перечисления
        Day(String name, String description) {
            this.name = name;
            this.description = description;
        }

        // Метод для получения полного описания дня
        public String getDescription() {
            return name + ": " + description;
        }
    }
```


# Практика #2
## Приведите примеры реализации собственного перечисления c любым дополнительным методом.

Перечисление CarType:

    Каждый элемент перечисления (например, SEDAN, SUV, TRUCK и т. д.) имеет два свойства:
        description — строковое описание типа автомобиля.
        insuranceCost — стоимость страховки для данного типа автомобиля.

Конструктор CarType:

    Каждый элемент перечисления инициализируется с конкретным значением для description и insuranceCost.

Метод getDescription():

    Возвращает описание автомобиля.

Метод getInsuranceCost():

    Возвращает стоимость страховки для данного типа автомобиля.

В методе main создается объект перечисления car с типом автомобиля SUV. Затем выводится описание типа автомобиля и стоимость его страховки.

Использование switch:

    Применяется для вывода дополнительной информации в зависимости от выбранного типа автомобиля.

```
public enum CarType {
        SEDAN("Седан", 5000),
        SUV("Внедорожник", 8000),
        TRUCK("Грузовик", 12000),
        COUPE("Купе", 6000),
        CONVERTIBLE("Кабриолет", 7000);

        private final String description;
        private final int insuranceCost;  // Стоимость страховки

        // Конструктор перечисления
        CarType(String description, int insuranceCost) {
            this.description = description;
            this.insuranceCost = insuranceCost;
        }

        // Метод для получения описания автомобиля
        public String getDescription() {
            return description;
        }

        // Метод для получения стоимости страховки
        public int getInsuranceCost() {
            return insuranceCost;
        }
    }
```
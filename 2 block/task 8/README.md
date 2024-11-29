# Практика #1
## Какого типа может быть переменная в switch? Приведите примеры для всех возможных случаев.

Переменная в switch может быть следующих типов:

    Целые типы: byte, short, int, char.
    Перечисления (enum).
    Классы-оболочки целых типов: Byte, Short, Integer, Character.
    Строки (String).
    Сведения о типах (var) (если тип компилируется в один из вышеперечисленных).

Нельзя использовать типы float, double, или long.

```
// Целые типы
int value = 2;
switch (value) {
    case 1:
        System.out.println("value = 1");
        break;
    case 2:
        System.out.println("value = 2");
        break;
    default:
        System.out.println("value != 1 и value != 2");
}

// Перечисления (enum)
enum Days { MONDAY, TUESDAY, WEDNESDAY }
Days day = Days.MONDAY;
switch (day) {
    case MONDAY:
        System.out.println("It's Monday");
        break;
    case TUESDAY:
        System.out.println("It's Tuesday");
        break;
    default:
        System.out.println("Other day");
}

// Классы-оболочки
Integer boxedValue = 10;
switch (boxedValue) {
    case 5:
        System.out.println("Value is 5");
        break;
    case 10:
        System.out.println("Value is 10");
        break;
    default:
        System.out.println("Unknown value");
}

// Строки
String fruit = "Apple";
switch (fruit) {
    case "Apple":
        System.out.println("It's an apple");
        break;
    case "Banana":
        System.out.println("It's a banana");
        break;
    default:
        System.out.println("Unknown fruit");
}

// Использование var
var dynamicValue = "Hello";
switch (dynamicValue) {
    case "Hello":
        System.out.println("Greeting detected");
        break;
    case "Goodbye":
        System.out.println("Farewell detected");
        break;
    default:
        System.out.println("Unknown phrase");
}
```

# Практика #2
## Что произойдет, если в некоторых частях case будет отсутствовать break, как в следующем примере?

```
...
case 1:
    i = 1;
    break;
case 2:
    i = 2;
case 3:
    i = 3;
    break;
...
```

Если в некоторых частях case отсутствует break, выполнение будет продолжаться до следующего case или break. Это называется "провал" (fall-through). Все последующие инструкции будут выполнены, независимо от их условий.
Если value = 1, i = 1.
Если value = 2, то:

    i = 2 (из case 2).
    Затем выполняется case 3, и i = 3.

Если value = 3, i = 3.
Если значение не попадает ни в один из case, выполняется default, и i = 4.

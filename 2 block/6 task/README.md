# Практика #1
## Приведите примеры использования методы decode().

```
// Пример 1: Десятичное значение
        Integer decimalValue = Integer.decode("42");
        System.out.println("Десятичное значение: " + decimalValue); // 42

        // Пример 2: Шестнадцатеричное значение (с префиксом 0x)
        Integer hexValue = Integer.decode("0x2A");
        System.out.println("Шестнадцатеричное значение: " + hexValue); // 42

        // Пример 3: Восьмеричное значение (с префиксом 0)
        Integer octalValue = Integer.decode("052");
        System.out.println("Восьмеричное значение: " + octalValue); // 42

        // Пример 4: Отрицательное значение (десятичное)
        Integer negativeValue = Integer.decode("-42");
        System.out.println("Отрицательное значение: " + negativeValue); // -42

        // Пример 5: Отрицательное шестнадцатеричное значение
        Integer negativeHexValue = Integer.decode("-0x2A");
        System.out.println("Отрицательное шестнадцатеричное значение: " + negativeHexValue); // -42

        // Пример 6: Неверный формат (вызовет NumberFormatException)
        try {
            Integer invalidValue = Integer.decode("42ABC");
            System.out.println(invalidValue);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный формат строки."); // Поймаем исключение
        }
```

# Практика #2
## Приведите все способы создания экземпляра класса Boolean.

```
// Рекомендуемый способ: использование Boolean.valueOf с примитивным типом boolean
        Boolean bool1 = Boolean.valueOf(true); // Создает объект Boolean со значением true
        System.out.println("bool1: " + bool1); // true

        // Использование Boolean.valueOf со строкой
        Boolean bool2 = Boolean.valueOf("true"); // Если строка равна "true" (без учета регистра), результат - true
        System.out.println("bool2: " + bool2); // true

        Boolean bool3 = Boolean.valueOf("false"); // Если строка равна "false" (без учета регистра), результат - false
        System.out.println("bool3: " + bool3); // false

        Boolean bool4 = Boolean.valueOf("randomString"); // Неверная строка (любая, кроме "true" или "false") возвращает false
        System.out.println("bool4: " + bool4); // false

        // Использование заранее определенных констант Boolean.TRUE и Boolean.FALSE
        Boolean bool5 = Boolean.TRUE; // Константа для значения true
        Boolean bool6 = Boolean.FALSE; // Константа для значения false
        System.out.println("bool5: " + bool5); // true
        System.out.println("bool6: " + bool6); // false
```

Boolean.valueOf(boolean): Преобразует примитивное значение true или false в объект типа Boolean.
Boolean.valueOf(String): Преобразует строку:

    "true" → Boolean.TRUE
    Любая другая строка → Boolean.FALSE

Boolean.TRUE и Boolean.FALSE: Предопределенные статические константы для значений true и false.

# Практика #3
## В каком случае при автоупаковке/автораспаковке будет брошено исключение NullPointerException. Приведите пример. 

```
// Пример: автораспаковка значения null вызывает NullPointerException
        Integer value = null; // Объект-оболочка инициализирован null
        try {
            int primitive = value; // Попытка автораспаковки null в примитивный тип
            System.out.println(primitive);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException при автораспаковке null.");
        }

        // Пример: автоупаковка с null исключений не вызывает
        try {
            Integer boxedValue = null; // Автоупаковка не требуется, null остается null
            System.out.println("Автоупаковка: " + boxedValue);
        } catch (Exception e) {
            System.out.println("Этого не будет, автоупаковка с null безопасна.");
        }
```

    Автоупаковка (boxing):
        Если значение null, то объект оболочки также становится null. Исключение не возникает.

    Автораспаковка (unboxing):
        Если объект оболочки равен null, попытка преобразовать его в примитивный тип (int, float и т.д.) вызывает NullPointerException, так как примитивы не могут быть null.

Вывод:

    Исключение NullPointerException происходит только при автораспаковке null в примитивный тип.

# Практика #4
## Какие значения напечатает следующий код? Объясните полученный результат. Для чего используется класс IntegerCache?

```
int i1 = 128;
Integer a1 = i1;
Integer b1 = i1;
System.out.println("a1==i1 " + (a1 == i1));
System.out.println("b1==i1 " + (b1 == i1));
System.out.println("a1==b1 " + (a1 == b1));
System.out.println("a1.equals(i1) -> " + a1.equals(i1));
System.out.println("b1.equals(i1) -> " + b1.equals(i1));
System.out.println("a1.equals(b1) -> " + a1.equals(b1));

int i2 = 127;
Integer a2 = i2;
Integer b2 = i2;
System.out.println("a2==i2 " + (a2 == i2));
System.out.println("b2==i2 " + (b2 == i2));
System.out.println("a2==b2 " + (a2 == b2));
System.out.println("a2.equals(i2) -> " + a2.equals(i2));
System.out.println("b2.equals(i2) -> " + b2.equals(i2));
System.out.println("a2.equals(b2) -> " + a2.equals(b2));
```

Сравнение a1 == i1 и b1 == i1:

    Оператор == между объектом Integer (a1, b1) и примитивом int (i1) приводит объект к примитивному типу (автораспаковка).
    В обоих случаях a1 и b1 распаковываются в int, поэтому 128 == 128 → true.

2. Сравнение a1 == b1:

    Оператор == между двумя объектами Integer сравнивает их ссылки.
    Значение 128 выходит за пределы диапазона кеширования [-128, 127], поэтому создаются два разных объекта Integer. Результат → false.

3. Сравнение с equals:

    Метод equals у Integer сравнивает значения, а не ссылки.
    Во всех вызовах a1.equals(b1), a1.equals(i1) и т.д. сравниваются значения, которые равны. Результат → true.

4. Сравнение a2 == i2 и b2 == i2:

    Здесь также происходит автораспаковка a2 и b2, приводя к сравнению 127 == 127. Результат → true.

5. Сравнение a2 == b2:

    Значение 127 попадает в диапазон кеша [-128, 127], и объект Integer извлекается из кеша IntegerCache. Обе переменные a2 и b2 ссылаются на один и тот же объект. Результат → true.

6. Сравнение equals для a2 и b2:

    Как и ранее, метод equals сравнивает значения, которые равны. Результат → true.

Роль класса IntegerCache:

IntegerCache — это внутренний механизм в классе Integer, который кеширует значения Integer в диапазоне от -128 до 127. Если значение попадает в этот диапазон, объект Integer повторно используется из кеша, чтобы экономить память и улучшать производительность.
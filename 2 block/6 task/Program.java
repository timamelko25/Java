public class Program {
    public static void main(String[] args) {
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

        /// Рекомендуемый способ: использование Boolean.valueOf с примитивным типом boolean
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
    }
}

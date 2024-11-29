/**
 * Этот класс демонстрирует использование утилиты Javadoc.
 */
public class Program {

    /**
     * Возвращает сумму двух чисел.
     * 
     * @param a первое число
     * @param b второе число
     * @return сумма a и b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Program example = new Program();
        System.out.println("Сумма: " + example.add(5, 3));
    }
}

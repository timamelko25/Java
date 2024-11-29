import java.util.Scanner; // Импортируем класс Scanner для ввода данных с клавиатуры

public class Main { // Объявляем основной класс программы

    public static void main(String args[]) { // Главный метод программы
        Scanner scan = new Scanner(System.in); // Создаем объект Scanner для считывания ввода пользователя
        System.out.print("Enter name: "); // Выводим приглашение ввести имя
        String name = scan.next(); // Считываем строку, введенную пользователем, и сохраняем в переменную name

        System.out.printf("Привет, %s \n", name); // Форматированно выводим приветствие с введенным именем
        scan.close(); // Закрываем Scanner, освобождая ресурсы
    }
}

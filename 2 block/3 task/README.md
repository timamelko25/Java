# Практика #1
## Приведите примеры для всех типов данных. Примеры должны также включать нулевые значения.

```java
byte b = 0;
short s = 0;
int i = 0;
long l = 0L;

System.out.println("byte: " + b);
System.out.println("short: " + s);
System.out.println("int: " + i);
System.out.println("long: " + l);
```

```java
float f = 0.0f;
double d = 0.0;

System.out.println("float: " + f);
System.out.println("double: " + d);
```

```java
char c = '\u0000';
System.out.println("char: [" + c + "]");
```

```java
boolean bool = false;
System.out.println("boolean: " + bool);

```java
String str = null;
Integer integerObject = null;

System.out.println("String: " + str);
System.out.println("Integer object: " + integerObject);
```


```java
int[] intArray = new int[3];
String[] strArray = new String[3];
System.out.println("intArray[0]: " + intArray[0]);
System.out.println("strArray[0]: " + strArray[0]);
```
# Практика #2 
## Напечатайте в консоли свое имя, используя при этом символы в формате Unicode ('\uXXXX').

```java
public class UnicodeNamePrinter {
    public static void main(String[] args) {
        System.out.print("\u0422\u0438\u043C\u043E\u0444\u0435\u0439");
    }
}
```

# Практика #3
## Какое значение будет в переменной c после выполнения данного кода? Объясните полученный результат.

```java
int a = 1;
{
    int b = 2;
}
int c = a + b;
```
В приведенном коде произойдет ошибка компиляции. Переменная b будет недоступна вне блока, в котором она объявлена. Переменная b объявлена внутри блока { int b = 2; }, что делает ее локальной для этого блока. Она существует только в пределах этого блока и уничтожается после его завершения. Попытка использовать переменную b за пределами этого блока приведет к ошибке компиляции, так как переменная b вне своей области видимости.

# Практика #4
## Приведите пример использования перегруженного оператора + с объектами типа String и переменными принадлежащим другим типам (объектам и базовым типам).

```java
int number = 42;
double price = 9.99;
String name = "Тимофей";
String greeting = "Привет, ";
String result1 = greeting + name;
String result2 = "Цена: " + price;
String result3 = "Число: " + number;

Integer integerValue = 100;
String result4 = "Значение: " + integerValue;

System.out.println(result1);
System.out.println(result2);
System.out.println(result3);
System.out.println(result4);
```

# Практика #5
## Приведите примеры, когда арифметические операции выполняются с переменными различных типов. Объясните результат.

```java
byte a = 10;
short b2 = 20;
int result = a + b;  // Результат: 30
```

При сложении переменных byte и short оба операнда автоматически преобразуются в тип int

```java
char a2 = 'A';  // 65 по ASCII
int b3 = 5;
int result5 = a + b;  // Результат: 70
```

Символ char в Java представляет собой целое число в Unicode. В данном случае символ 'A' имеет значение 65. При сложении char и int, char будет преобразован в int

# Практика #6
## Приведите примеры сужающего преобразования типов.

```
double doubleValue = 9.78;
int intValue = (int) doubleValue;
long longValue = 1000L;
hort shortValue = (short) longValue;
```

# Практика #7
## Какое значение будет в переменных b, с и d после выполнения данного кода. Объясните полученный результат.
```
int a = 120;
byte b = a + 10;
byte c = (byte)(a + 10);
byte d = a + 1;
```

b = a + 10

    Ошибка компиляции.
    Выражение a + 10 возвращает тип int, так как арифметические операции над типами int и выше всегда приводят к результату типа int. Попытка присвоить результат типа int переменной типа byte вызывает ошибку компиляции, так как требуется явное преобразование.

c = (byte)(a + 10)

    Результат: -126.
    Здесь используется явное сужающее преобразование (byte). Сумма a + 10 равна 130 (int), но при преобразовании к byte результат выходит за пределы допустимого диапазона byte (-128 до 127). Поэтому значение циклически переполняется, и результат равен -126 (по правилам переполнения в двоичной арифметике).

d = a + 1

    Ошибка компиляции.
    Аналогично первому случаю, выражение a + 1 возвращает значение типа int. Присвоение этого результата переменной типа byte без явного приведения приводит к ошибке компиляции.

# Практика #8
## Самостоятельно изучите, что означает type interface и приведите пример с использование var.

Type Inference — это механизм, позволяющий компилятору автоматически определять тип переменной на основе присваиваемого значения. Ключевое слово var. При этом тип переменной остается статическим, но указывать его явно не нужно.

```
var number = 10; 
        System.out.println("Тип number: " + ((Object) number).getClass().getSimpleName());

        // Компилятор определяет тип как String
        var text = "Hello, Java!";
        System.out.println("Тип text: " + ((Object) text).getClass().getSimpleName());

        // Компилятор определяет тип как ArrayList<String>
        var list = new ArrayList<String>();
        list.add("Java");
        list.add("Type Inference");
        System.out.println("Тип list: " + list.getClass().getSimpleName());
```
# Практика #1
## Самостоятельно изучите смысл каждого спецификатор доступа и приведите пример программы, демонстрирующей это. Не забудьте про случай, когда спецификатор доступа отсутствует.

private: Члены с модификатором private доступны только внутри самого класса, в котором они определены. Пример: private int privateVar и private void privateMethod(). Попытка доступа извне (даже в том же пакете) приведет к ошибке.

default (пакетный доступ): Если модификатор доступа не указан, то по умолчанию члены доступны только в пределах того же пакета. Это называется доступом "по умолчанию" или "пакетный доступ". Пример: int defaultVar и void defaultMethod(). Эти члены будут доступны другим классам только в том же пакете.

protected: Члены с модификатором protected доступны в том же пакете и также доступны в подклассах (даже если они находятся в другом пакете). Пример: protected int protectedVar и protected void protectedMethod(). Эти члены доступны в подклассах.

public: Члены с модификатором public доступны везде, во всех классах и пакетах. Пример: public int publicVar и public void publicMethod(). Эти члены доступны везде, и они предоставляют внешний интерфейс для работы с объектом.

```
class MyClass {
    
    // private - доступ только внутри этого класса
    private int privateVar = 1;
    
    // по умолчанию (default) - доступ только в том же пакете
    int defaultVar = 2;
    
    // protected - доступ в том же пакете и в подклассах (даже если они находятся в других пакетах)
    protected int protectedVar = 3;
    
    // public - доступ во всем проекте, включая другие пакеты
    public int publicVar = 4;
    
    // Конструктор с разными спецификаторами
    public MyClass() {
        System.out.println("Конструктор MyClass вызван.");
    }

    // Метод с разными спецификаторами
    public void publicMethod() {
        System.out.println("Публичный метод.");
    }
    
    private void privateMethod() {
        System.out.println("Приватный метод.");
    }
    
    protected void protectedMethod() {
        System.out.println("Защищенный метод.");
    }
    
    void defaultMethod() {
        System.out.println("Метод по умолчанию.");
    }
}
```
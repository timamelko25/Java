import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// Класс для реализации алгоритма Хаффмана
public class HuffmanCoding {
    // Хранит соответствие символов их Хаффман-кодам
    private Map<Character, String> huffmanCodeMap = new HashMap<>();
    // Очередь с приоритетом для построения дерева Хаффмана
    private PriorityQueue<Node> priorityQueue;

    // Метод для построения дерева Хаффмана
    public void buildHuffmanTree(String text) {
        // Шаг 1: Подсчитать частоты символов в тексте
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        // Инициализировать очередь с приоритетом, основанную на частотах
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        // Добавить узлы в очередь
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Построить дерево Хаффмана
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();  // Узел с наименьшей частотой
            Node right = priorityQueue.poll(); // Второй узел с наименьшей частотой
            Node parent = new Node('0', left.frequency + right.frequency); // Создать родительский узел
            parent.left = left; // Левый потомок
            parent.right = right; // Правый потомок
            priorityQueue.add(parent); // Добавить родительский узел обратно в очередь
        }

        // Сгенерировать коды Хаффмана
        generateHuffmanCodes(priorityQueue.peek(), "");
    }

    // Рекурсивный метод для генерации кодов Хаффмана
    private void generateHuffmanCodes(Node node, String code) {
        // Если достигли листового узла
        if (node.left == null && node.right == null) {
            // Если дерево состоит из одного символа, присвоить ему код "0"
            if (code.isEmpty()){
                huffmanCodeMap.put(node.character, "0");
                return;
            }
            // Добавить символ и его код в карту
            huffmanCodeMap.put(node.character, code);
            return;
        }

        // Рекурсивно пройтись по левому поддереву
        if (node.left != null) {
            generateHuffmanCodes(node.left, code + "0");
        }

        // Рекурсивно пройтись по правому поддереву
        if (node.right != null) {
            generateHuffmanCodes(node.right, code + "1");
        }
    }

    // Метод для кодирования текста
    public String encode(String text) {
        StringBuilder encodedString = new StringBuilder();
        // Заменить каждый символ на его Хаффман-код
        for (char character : text.toCharArray()) {
            encodedString.append(huffmanCodeMap.get(character));
        }
        return encodedString.toString();
    }

    // Возвращает карту кодов Хаффмана
    public Map<Character, String> getHuffmanCodeMap() {
        return huffmanCodeMap;
    }

    // Главный метод программы
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Проверка количества аргументов
        if (args.length < 3) {
            System.out.println("Usage: java HuffmanCoding <encode/decode> <inputFile> <outputFile>");
            return;
        }

        // Аргументы командной строки
        String operation = args[0]; // Операция: encode или decode
        String inputFilePath = args[1]; // Входной файл
        String outputFilePath = args[2]; // Выходной файл

        if (operation.equals("encode")) {
            // Чтение текста из входного файла
            String text = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // Создание объекта HuffmanCoding
            HuffmanCoding huffmanCoding = new HuffmanCoding();

            // Построение дерева Хаффмана и кодирование текста
            huffmanCoding.buildHuffmanTree(text);
            String encodedText = huffmanCoding.encode(text);

            // Сохранение закодированного текста и карты кодов в файл
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
                oos.writeObject(huffmanCoding.getHuffmanCodeMap()); // Карта кодов
                oos.writeObject(encodedText); // Закодированный текст
            }
        } else if (operation.equals("decode")) {
            // Декодирование текста из файла
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFilePath))) {
                // Чтение карты кодов Хаффмана
                @SuppressWarnings("unchecked")
                Map<Character, String> huffmanCodeMap = (Map<Character, String>) ois.readObject();
                // Чтение закодированного текста
                String encodedText = (String) ois.readObject();

                // Декодирование текста
                StringBuilder decodedString = new StringBuilder();
                String temp = "";

                // Постепенное чтение битового потока и поиск соответствующего символа
                for (char bit : encodedText.toCharArray()) {
                    temp += bit;
                    for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
                        if (entry.getValue().equals(temp)) {
                            decodedString.append(entry.getKey());
                            temp = "";
                            break;
                        }
                    }
                }

                // Запись декодированного текста в файл
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                    writer.write(decodedString.toString());
                }
            }
        }
    }
}

// Класс для представления узла дерева Хаффмана
class Node {
    int frequency; // Частота символа
    char character; // Символ
    Node left; // Левый потомок
    Node right; // Правый потомок

    Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}

import java.io.*; // Для операций ввода-вывода
import java.nio.file.Files; // Для работы с файлами
import java.nio.file.Paths; // Для обработки путей файлов
import java.util.*; // Для структур данных, таких как Map и PriorityQueue

// Класс для реализации алгоритма Хаффмана
public class HuffmanCoding {
    private Map<Byte, String> huffmanCodeMap = new HashMap<>(); // Хранит таблицу Хаффмана (символ -> код)
    private PriorityQueue<Node> priorityQueue; // Очередь для построения дерева Хаффмана

    // Метод для построения дерева Хаффмана
    public void buildHuffmanTree(byte[] data) {
        // Подсчет частоты каждого байта
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : data) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }

        // Инициализация приоритетной очереди узлов
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        // Создание узлов для каждого символа и добавление их в очередь
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Построение дерева Хаффмана
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll(); // Удаляем узел с минимальной частотой
            Node right = priorityQueue.poll(); // Удаляем следующий узел с минимальной частотой
            Node parent = new Node((byte) 0, left.frequency + right.frequency); // Создаем родительский узел
            parent.left = left; // Левый потомок
            parent.right = right; // Правый потомок
            priorityQueue.add(parent); // Добавляем родительский узел в очередь
        }

        // Генерация таблицы кодов Хаффмана
        generateHuffmanCodes(priorityQueue.peek(), "");
    }

    // Рекурсивный метод для генерации кодов Хаффмана
    private void generateHuffmanCodes(Node node, String code) {
        if (node.left == null && node.right == null) { // Если узел листовой
            if (code.isEmpty()) { // Обработка случая с одним символом
                huffmanCodeMap.put(node.character, "0");
                return;
            }
            huffmanCodeMap.put(node.character, code); // Сохраняем код
            return;
        }
        if (node.left != null) {
            generateHuffmanCodes(node.left, code + "0"); // Рекурсия для левого потомка
        }
        if (node.right != null) {
            generateHuffmanCodes(node.right, code + "1"); // Рекурсия для правого потомка
        }
    }

    // Кодирование данных с использованием таблицы Хаффмана
    public String encode(byte[] data) {
        StringBuilder encodedString = new StringBuilder();
        for (byte b : data) {
            encodedString.append(huffmanCodeMap.get(b)); // Преобразуем каждый символ в код
        }
        return encodedString.toString();
    }

    // Возвращает таблицу Хаффмана
    public Map<Byte, String> getHuffmanCodeMap() {
        return huffmanCodeMap;
    }

    // Основной метод программы
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args.length < 3) { // Проверка количества аргументов
            System.out.println("Usage: java HuffmanCoding <encode/decode> <inputFile> <outputFile>");
            return;
        }

        String operation = args[0]; // Операция: encode или decode
        String inputFilePath = args[1]; // Входной файл
        String outputFilePath = args[2]; // Выходной файл

        if (operation.equals("encode")) {
            // Чтение данных из файла
            byte[] data = Files.readAllBytes(Paths.get(inputFilePath));
            HuffmanCoding huffmanCoding = new HuffmanCoding();
            huffmanCoding.buildHuffmanTree(data); // Построение дерева Хаффмана
            String encodedText = huffmanCoding.encode(data); // Кодирование данных

            // Сохранение таблицы кодов и закодированного текста в файл
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
                oos.writeObject(huffmanCoding.getHuffmanCodeMap()); // Записываем таблицу кодов
                oos.writeObject(encodedText); // Записываем закодированный текст
            }
        } else if (operation.equals("decode")) {
            // Чтение таблицы кодов и закодированного текста из файла
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFilePath))) {
                @SuppressWarnings("unchecked")
                Map<Byte, String> huffmanCodeMap = (Map<Byte, String>) ois.readObject();
                String encodedText = (String) ois.readObject();

                // Обратное преобразование таблицы кодов
                Map<String, Byte> reverseHuffmanCodeMap = new HashMap<>();
                for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
                    reverseHuffmanCodeMap.put(entry.getValue(), entry.getKey());
                }

                // Декодирование текста
                List<Byte> decodedBytes = new ArrayList<>();
                StringBuilder temp = new StringBuilder();
                for (char bit : encodedText.toCharArray()) {
                    temp.append(bit);
                    if (reverseHuffmanCodeMap.containsKey(temp.toString())) {
                        decodedBytes.add(reverseHuffmanCodeMap.get(temp.toString()));
                        temp.setLength(0);
                    }
                }

                // Преобразование списка байтов в массив
                byte[] decodedData = new byte[decodedBytes.size()];
                for (int i = 0; i < decodedBytes.size(); i++) {
                    decodedData[i] = decodedBytes.get(i);
                }

                // Запись декодированных данных в файл
                try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                    fos.write(decodedData);
                }
            }
        }
    }
}

// Класс для представления узла дерева Хаффмана
class Node {
    int frequency; // Частота символа
    byte character; // Символ
    Node left; // Левый потомок
    Node right; // Правый потомок

    Node(byte character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}

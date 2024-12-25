package Lab3;
import java.util.LinkedList;

// Класс Product для хранения информации о товаре
class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', description='" + description + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

// Класс HashTable для реализации хэш-таблицы методом цепочек
class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    // Хэш-функция
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Метод для добавления пары ключ-значение
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    // Метод для удаления пары ключ-значение
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            var iterator = table[index].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    return;
                }
            }
        }
    }

    // Метод для получения размера таблицы
    public int size() {
        return size;
    }

    // Метод для проверки, пуста ли таблица
    public boolean isEmpty() {
        return size == 0;
    }

    // Внутренний класс для хранения пары ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

// Основной класс для теста
public class Main {
    public static void main(String[] args) {
        // Создаем хэш-таблицу с вместимостью 10
        HashTable<String, Product> productTable = new HashTable<>(10);

        // Добавляем товары
        productTable.put("12345", new Product("laptop", "gaming laptop", 1500.99, 10));
        productTable.put("23456", new Product("smartphone", "smartphone", 999.99, 50));
        productTable.put("34567", new Product("headphones", "headphones", 199.99, 30));

        // Получаем товар по артикулу
        System.out.println("Product with art 12345: " + productTable.get("23456"));

        // Удаляем товар
        productTable.remove("34567");

        // Проверяем размер таблицы
        System.out.println("Size of hash table: " + productTable.size());
        // Проверяем, пуста ли таблица
        System.out.println("Is table empty? " + productTable.isEmpty());
     }
 }
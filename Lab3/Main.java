package Lab3;
import java.util.LinkedList;

class Book {
    private String name;
    private String author;
    private int copies;

    public Book(String name, String author, int copies) {
        this.name = name;
        this.author = author;
        this.copies = copies;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', author='" + author + "', copies=" + copies + "}";
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
        HashTable<String, Book> library = new HashTable<>(10);

        // Добавляем книги
        library.put("978-3-16-148410-0", new Book("The Great Gatsby", "F. Scott Fitzgerald", 5));
        library.put("978-0-14-044913-6", new Book("Crime and Punishment", "Fyodor Dostoevsky", 3));
        library.put("978-0-452-28423-4", new Book("1984", "George Orwell", 10));

        // Получаем книгу по ISBN
        System.out.println("Book with ISBN 978-3-16-148410-0: " + library.get("978-3-16-148410-0"));

        // Удаляем книгу
        library.remove("978-0-14-044913-6");

        // Проверяем размер таблицы
        System.out.println("Size of library: " + library.size());

        // Проверяем, пуста ли таблица
        System.out.println("Is library empty? " + library.isEmpty());
    }
}

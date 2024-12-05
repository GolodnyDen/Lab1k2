import java.util.*;

public class SalesManager {
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " = " + price + " руб.";
        }
    }

    private List<Product> soldProducts = new ArrayList<>();

    public void addProduct(Product product) {
        soldProducts.add(product);
    }

    public void listSoldProducts() {
        if (soldProducts.isEmpty()) {
            System.out.println("Проданных товаров нет");
            return;
        }
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return "Нет проданных товаров";
        }

        Map<String, Integer> productCount = new HashMap<>();
        for (Product product : soldProducts) {
            productCount.put(product.getName(), productCount.getOrDefault(product.getName(), 0) + 1);
        }

        String mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopular = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesManager manager = new SalesManager();

        manager.addProduct(new Product("Макароны", 50));
        manager.addProduct(new Product("Ананас", 30));
        manager.addProduct(new Product("Мокороны", 50));
        manager.addProduct(new Product("Вода Газ.", 100));
        manager.addProduct(new Product("Мокороны", 50));
        manager.addProduct(new Product("Ананас", 30));

        manager.listSoldProducts();

        System.out.println("Общая сумма продаж: " + manager.getTotalSales() + " руб.");

        System.out.println("Наиболее популярный товар: " + manager.getMostPopularProduct());
    }
}


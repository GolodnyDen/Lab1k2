package Lab7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Warehouse {
    private final Semaphore accessSemaphore;
    private final AtomicInteger currentWeight;
    static final int MAX_WEIGHT = 150;
    
        public Warehouse() {
            this.accessSemaphore = new Semaphore(1);
            this.currentWeight = new AtomicInteger(0);
        }
    
        public boolean tryAddWeight(int weight) {
            try {
                accessSemaphore.acquire();
                int newWeight = currentWeight.get() + weight;
                if (newWeight <= MAX_WEIGHT) {
                    currentWeight.addAndGet(weight);
                    System.out.println(Thread.currentThread().getName() + " добавил груз весом " + weight + " кг. Текущий вес: " + currentWeight.get() + " кг.");
                    return true;
                } else {
                    System.out.println(Thread.currentThread().getName() + " не смог добавить груз весом " + weight + " кг. Текущий вес: " + currentWeight.get() + " кг.");
                    return false;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            } finally {
                accessSemaphore.release();
            }
        }
    
        public void sendToNextWarehouse() {
            try {
                accessSemaphore.acquire();
                System.out.println("Грузчики отправились на другой склад с грузом весом " + currentWeight.get() + " кг.");
                currentWeight.set(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                accessSemaphore.release();
            }
        }
    
        public int getCurrentWeight() {
            return currentWeight.get();
        }
    }
    
    class Loader implements Runnable {
        private final Warehouse warehouse;
        private final int weight;
    
        public Loader(Warehouse warehouse, int weight) {
            this.warehouse = warehouse;
            this.weight = weight;
        }
    
        @Override
        public void run() {
            while (true) {
                if (warehouse.tryAddWeight(weight)) {
                    if (warehouse.getCurrentWeight() == Warehouse.MAX_WEIGHT) {
                    warehouse.sendToNextWarehouse();
                }
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class WareHouseTransfer {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        int[] weights = {50, 70, 30, 40, 60, 20, 80, 50};
        for (int weight : weights) {
            executor.execute(new Loader(warehouse, weight));
        }

        executor.shutdown();
    }
}

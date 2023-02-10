import java.util.Random;

public class Product {
    int memory, hdd;
    double price;
    String system, color, name;

    public String toString() {
        return "Производитель: " + name + ". Размер HDD: " + hdd + " Гб. Объём RAM: "
                + memory + "Гб. Операционная система: " + system + ". Цвет: " + color + ". Цена: " + price;
    }

    String getColor() {
        String[] colorCollection = new String[]{"White", "Black", "Silver", "GoldRain", "Red"};
        Random random = new Random();
        return colorCollection[random.nextInt(colorCollection.length)];
    }

    String getName() {
        String[] companies = new String[]{"Acer", "Sony", "Samsung", "Asus", "MSI"};
        Random random = new Random();
        return companies[random.nextInt(companies.length)];
    }

    String getSystem() {
        String[] systemcollection = new String[]{"Windows", "Linux", "Android", "-"};
        Random random = new Random();
        return systemcollection[random.nextInt(systemcollection.length)];
    }

    double getPrice() {
        int min = 10000;
        int max = 100000;
        Random random = new Random();
        int res = random.nextInt((max - min) + min);
        return res;
    }

    int getRam() {
        int[] memoryCollection = new int[]{4, 8, 16, 32};
        Random random = new Random();
        return memoryCollection[random.nextInt(memoryCollection.length)];
    }

    int getHdd() {
        int min = 64;
        int max = 4000;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

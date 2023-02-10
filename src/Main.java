import java.util.*;

public class Main {
    /*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
            “Введите цифру, соответствующую необходимому критерию:
            1 - ОЗУ
            2 - Объем ЖД
            3 - Операционная система
            4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
    фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести подходящие по условиям.
     */

    public static void main(String[] args) {
        Set<Product> product = new HashSet<>();
        Set<Product> allProducts = new HashSet<>();
        Random random = new Random();
        int count = random.nextInt(100-10)+10;
        fillSet(product, allProducts, count);
        showCollection(product, allProducts);
    }

    static void showCollection(Set<Product> laptopCollection, Set<Product> allProducts) {
        System.out.println("Чтобы вывести список ноутбуков введите 'print'.  Чтобы отфильтровать ноутбуки по параметрам" +
                " введите 'filter'");
        Scanner scan = new Scanner(System.in);
        String resScan = scan.next().toLowerCase();
        if (resScan.equals("print".toLowerCase())) {
            for (Product it : laptopCollection) {
                System.out.println(it);
            }
            System.out.println("");
            showCollection(laptopCollection, allProducts);
        } else if (resScan.equals("filter".toLowerCase())) {
            productSorting(laptopCollection, allProducts);
        } else {
            System.out.println("Введите верное значение!");
            showCollection(laptopCollection, allProducts);
        }
    }

    static void fillProduct(Set<Product> product) {
        Product laptop = new Product();
        laptop.color = laptop.getColor();
        laptop.name = laptop.getName();
        laptop.price = laptop.getPrice();
        laptop.hdd = laptop.getHdd();
        laptop.memory = laptop.getRam();
        laptop.system = laptop.getSystem();
        product.add(laptop);
    }

    static void fillSet(Set<Product> product, Set<Product> allProducts, int count) {
        for (int i = 0; i < count; i++) {
            fillProduct(product);
        }
        allProducts.addAll(product);
    }


    static void productSorting(Set<Product> product, Set<Product> allProducts) {
        Set<Product> filtredProducts = new HashSet<>();
        System.out.println("'1' Производитель; '2' Цена; '3' HDD; '4' RAM; '5' Операционная система; '6' Цвет; ");
        System.out.print("Выберите нужный параметр введя цифру: ");
        Scanner insert = new Scanner(System.in);
        int getScan = insert.nextInt();
        if (getScan == 1) {
            System.out.println("Поиск по производителям: 'Asus','Sony','Samsung','Acer','MSI'");
            System.out.print("Введите название предпочтительного бренда из списка: ");
            String name = insert.next().toLowerCase();
            int checkCount = 0;
            for (Product it : product) {
                if (name.equals(it.name.toLowerCase())) {
                    System.out.println(it);
                    filtredProducts.add(it);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данной модели нет в наличие!");
                productSorting(product, allProducts);
            } else {
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + filtredProducts.size() + "\n");
                stepNext(insert, filtredProducts, product, allProducts);
            }

        } else if (getScan == 2) {
            System.out.println("Поиск по цене: от 10000 до 100000]");
            System.out.print("Введите минимальную цену: ");
            int price = insert.nextInt();
            if (price > 100000) {
                System.out.println("Данной модели нет в наличие!");
                productSorting(product, allProducts);
            } else {
                for (Product it : product) {
                    if (price <= it.price) {
                        System.out.println(it);
                        filtredProducts.add(it);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + filtredProducts.size() + "\n");
                stepNext(insert, filtredProducts, product, allProducts);
            }

        } else if (getScan == 3) {
            System.out.print("Укажите минимальный объём HDD(4000 max): ");
            int scan = insert.nextInt();
            if (scan > 4000) {
                System.out.println("Данного объёма HDD нет в наличие!");
                productSorting(product, allProducts);
            } else {
                for (Product it : product) {
                    if (scan <= it.hdd) {
                        System.out.println(it);
                        filtredProducts.add(it);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + filtredProducts.size() + "\n");
                stepNext(insert, filtredProducts, product, allProducts);
            }
        } else if (getScan == 4) {
            System.out.print("Введите минимальный объём RAM(32 max): ");
            int scan = insert.nextInt();
            if (scan > 32) {
                System.out.println("Данного объёма RAM нет в наличие!");
                productSorting(product, allProducts);
            } else {
                for (Product it : product) {
                    if (scan <= it.memory) {
                        System.out.println(it);
                        filtredProducts.add(it);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + filtredProducts.size() + "\n");
                stepNext(insert, filtredProducts, product, allProducts);
            }
        } else if (getScan == 5) {
            System.out.println("Поиск по системе: 'Windows','Linux','Android','-'");
            System.out.print("Введите название предпочтительной системы из списка: ");
            String system = insert.next().toLowerCase();
            int checkCount = 0;
            for (Product it : product) {
                if (system.equals(it.system.toLowerCase())) {
                    System.out.println(it);
                    filtredProducts.add(it);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данной системы нет в наличие!");
                productSorting(product, allProducts);
            } else {
                stepNext(insert, filtredProducts, product, allProducts);
            }
        } else if (getScan == 6) {
            System.out.println("Поиск по цвету: 'White','Black','Silver','GoldRain', 'Red'");
            System.out.print("Введите предпочтительный цвет из списка: ");
            String color = insert.next().toLowerCase();
            int checkCount = 0;
            for (Product it : product) {
                if (color.equals(it.color.toLowerCase())) {
                    System.out.println(it);
                    filtredProducts.add(it);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данного цвета нет в наличие!");
                productSorting(product, allProducts);
            } else {
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + filtredProducts.size() + "\n");
                stepNext(insert, filtredProducts, product, allProducts);
            }
        } else {
            System.out.println("Вы ввели неверное значение!");
            productSorting(product, allProducts);
        }
        insert.close();
    }

    static void stepNext(Scanner insert, Set<Product> newSet, Set<Product> product, Set<Product> allProducts) {
        System.out.println("Чтобы начать поиск по новой введите 'start'. Чтобы продолжить фильтровать текущий список " +
                "ноутбуков введите 'next'. Если выбор окончен введите 'finish'");
        String chat = insert.next().toLowerCase();
        if (chat.equals("next".toLowerCase())) {
            productSorting(newSet, product);
        } else if (chat.equals("start".toLowerCase())) {
            showCollection(allProducts, allProducts);
        } else if (chat.equals("finish".toLowerCase())) {
            System.out.println("Количество ноутбуков по вашему запросу: " + newSet.size() + "шт.\n");
            return;
        } else {
            System.out.println("Введите команду правильно");
            stepNext(insert, newSet, product, allProducts);
        }
        return;
    }
}

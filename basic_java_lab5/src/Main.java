import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            // Створення менеджера амуніції
            KnightEquipmentManager knightKit = new KnightEquipmentManager();

            // Додавання різних елементів амуніції
            knightKit.addEquipment(new Armor("Сталева броня", 15.5, 2500.0, 8));
            knightKit.addEquipment(new Weapon("Дворучний меч", 5.2, 1800.0, 25));
            knightKit.addEquipment(new Helmet("Лицарський шолом", 3.0, 1200.0, "Сталь"));
            knightKit.addEquipment(new Weapon("Короткий меч", 2.5, 800.0, 15));
            knightKit.addEquipment(new Armor("Шкіряний обладунок", 10.0, 1000.0, 4));

            // Виведення всієї амуніції
            System.out.println("Повний список амуніції:");
            for (KnightEquipment equipment : knightKit.getEquipment()) {
                System.out.println(equipment);
            }

            // Обчислення загальної вартості
            System.out.printf("\nЗагальна вартість амуніції: %.2f грн\n", knightKit.calculateTotalPrice());

            // Сортування за вагою
            knightKit.sortByWeight();
            System.out.println("\nАмуніція після сортування за вагою:");
            for (KnightEquipment equipment : knightKit.getEquipment()) {
                System.out.println(equipment);
            }

            // Пошук амуніції в діапазоні цін
            System.out.println("\nАмуніція в діапазоні цін 1000-2000 грн:");
            List<KnightEquipment> priceRangeEquipment = knightKit.findEquipmentByPriceRange(1000, 2000);
            for (KnightEquipment equipment : priceRangeEquipment) {
                System.out.println(equipment);
            }

        } catch (Exception e) {
            System.err.println("Помилка при роботі з амуніцією: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
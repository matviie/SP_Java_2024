import java.util.*;


public class Main {
    public static void main(String[] args) {
        try {
            // Створення колекції різними конструкторами
            KnightEquipmentSet<KnightEquipment> emptySet = new KnightEquipmentSet<>();

            Armor steelArmor = new Armor("Сталева броня", 15.5, 2500.0, 8);
            KnightEquipmentSet<KnightEquipment> singleElementSet = new KnightEquipmentSet<>(steelArmor);

            List<KnightEquipment> initialEquipment = Arrays.asList(
                    new Weapon("Дворучний меч", 5.2, 1800.0, 25),
                    new Helmet("Лицарський шолом", 3.0, 1200.0, "Сталь"),
                    new Armor("Шкіряний обладунок", 10.0, 1000.0, 4)
            );
            KnightEquipmentSet<KnightEquipment> collectionSet = new KnightEquipmentSet<>(initialEquipment);

            // Демонстрація роботи методів
            System.out.println("Порожня колекція: " + emptySet);
            System.out.println("Колекція з одним елементом: " + singleElementSet);
            System.out.println("Колекція зі стандартної колекції: " + collectionSet);

            // Додавання та видалення елементів
            Weapon shortSword = new Weapon("Короткий меч", 2.5, 800.0, 15);
            collectionSet.add(shortSword);
            System.out.println("Після додавання меча: " + collectionSet);

            collectionSet.remove(steelArmor);
            System.out.println("Після видалення броні: " + collectionSet);

            // Перевірка інших методів
            System.out.println("Розмір колекції: " + collectionSet.size());
            System.out.println("Чи міститься шолом: " + collectionSet.contains(initialEquipment.get(1)));
        } catch (Exception e) {
            System.err.println("Помилка при роботі з колекцією: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
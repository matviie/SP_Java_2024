import java.util.*;
import java.util.stream.Collectors;


public class KnightEquipmentManager {
    private final List<KnightEquipment> equipment;  // Список для зберігання амуніції лицаря

    public KnightEquipmentManager() {
        this.equipment = new ArrayList<>();
    }

    // Метод для додавання амуніції до списку
    public void addEquipment(KnightEquipment item) {
        if (item == null) {
            throw new IllegalArgumentException("Не можна додати null-елемент");
        }
        equipment.add(item);
    }

    // Метод для обчислення загальної вартості всіх елементів амуніції
    public double calculateTotalPrice() {
        return equipment.stream()
                .mapToDouble(KnightEquipment::getPrice)
                .sum();
    }

    // Метод для сортування амуніції за вагою (від найменшої до найбільшої)
    public void sortByWeight() {
        equipment.sort(Comparator.comparingDouble(KnightEquipment::getWeight));
    }

    // Метод для знаходження амуніції в діапазоні цін
    public List<KnightEquipment> findEquipmentByPriceRange(double minPrice, double maxPrice) {
        // Перевірка на коректність діапазону цін
        if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {
            throw new IllegalArgumentException("Некоректний діапазон цін");
        }

        // Фільтрація елементів амуніції, що знаходяться в межах заданого діапазону цін
        return equipment.stream()
                .filter(e -> e.getPrice() >= minPrice && e.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<KnightEquipment> getEquipment() {
        return new ArrayList<>(equipment);
    }
}

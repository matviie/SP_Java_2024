// Базовий клас для амуніції лицаря
public class KnightEquipment {
    private String name;
    private double weight;
    private double price;

    public KnightEquipment(String name, double weight, double price) {
        setName(name);
        setWeight(weight);
        setPrice(price);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва амуніції не може бути порожньою");
        }
        this.name = name.trim();
    }

    public double getWeight() { return weight; }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Вага не може бути від'ємною");
        }
        this.weight = weight;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        this.price = price;
    }

    // Переовизначення методу toString для виведення інформації про амуніцію
    @Override
    public String toString() {
        return String.format("%s (Вага: %.2f кг, Ціна: %.2f грн)", name, weight, price);
    }
}

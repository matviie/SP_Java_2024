// Клас для амуніції типу "Броня", що успадковує клас KnightEquipment
public class Armor extends KnightEquipment {
    private int protectionLevel;  // Рівень захисту броні (від 0 до 10)

    public Armor(String name, double weight, double price, int protectionLevel) {
        super(name, weight, price);
        setProtectionLevel(protectionLevel);
    }

    public int getProtectionLevel() { return protectionLevel; }

    public void setProtectionLevel(int protectionLevel) {
        if (protectionLevel < 0 || protectionLevel > 10) {
            throw new IllegalArgumentException("Рівень захисту має бути від 0 до 10");
        }
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Рівень захисту: %d", protectionLevel);
    }
}

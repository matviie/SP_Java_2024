// Клас для амуніції типу "Зброя", що успадковує клас KnightEquipment
public class Weapon extends KnightEquipment{
    private int damage;  // Шкода, яку завдає зброя

    public Weapon(String name, double weight, double price, int damage) {
        super(name, weight, price);
        setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Шкода не може бути від'ємною");
        }
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Шкода: %d", damage);
    }
}

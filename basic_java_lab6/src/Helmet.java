// Клас для амуніції типу "Шолом", що успадковує клас KnightEquipment
public class Helmet extends KnightEquipment {
    private String material; // Матеріал шолому

    public Helmet(String name, double weight, double price, String material) {
        super(name, weight, price);
        setMaterial(material);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Матеріал шолому не може бути порожнім");
        }
        this.material = material.trim();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Матеріал: %s", material);
    }
}

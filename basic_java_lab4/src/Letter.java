/**
 * Клас представляє одну літеру тексту.
 */
public class Letter {
    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() { return character; }

    /**
     * Перетворює літеру на рядок.
     * @return Рядкове представлення літери.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

import java.util.Arrays;


/**
 * Клас представляє слово, що складається з масиву літер.
 */
public class Word {
    private final Letter[] letters;

    public Word(String word) {
        this.letters = word.chars()
                .mapToObj(c -> new Letter((char) c))
                .toArray(Letter[]::new);  // Перетворення символів слова на об'єкти Letter
    }

    public String getWord() {
        return Arrays.stream(letters)
                .map(Letter::toString)
                .reduce("", String::concat);  // Об'єднання літер у слово
    }

    /**
     * Перетворює слово на рядок.
     * @return Рядкове представлення слова.
     */
    @Override
    public String toString() {
        return getWord();
    }
}

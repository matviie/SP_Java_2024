import java.util.ArrayList;
import java.util.List;


/**
 * Клас представляє речення, яке складається зі слів і розділових знаків.
 */
public class Sentence {
    private final List<Word> words = new ArrayList<>();
    private final List<Character> punctuation = new ArrayList<>();

    public Sentence(String sentence) {
        String[] parts = sentence.split("(?=[.,!?])|\\s+"); // Розбиття речення на слова та розділові знаки
        for (String part : parts) {
            if (part.matches("[.,!?]")) { // Якщо це розділовий знак
                punctuation.add(part.charAt(0));
            } else if (!part.isBlank()) {   // Якщо це слово
                words.add(new Word(part));
            }
        }
    }

    public List<Word> getWords() { return words; }

    public List<Character> getPunctuation() { return punctuation; }


    /**
     * Перетворює речення на рядок.
     * @return Рядкове представлення речення.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            builder.append(words.get(i));  // Додаємо слово
            if (i < punctuation.size()) {
                builder.append(punctuation.get(i));  // Додаємо відповідний розділовий знак
            }
            if (i < words.size() - 1) {
                builder.append(" ");   // Додаємо пробіл між словами
            }
        }
        return builder.toString();
    }
}

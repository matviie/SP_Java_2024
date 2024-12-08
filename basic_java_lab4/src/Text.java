import java.util.ArrayList;
import java.util.List;


/**
 * Клас представляє текст, що складається з речень.
 */
public class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String cleanedText = text.replaceAll("\\s+", " "); // Заміна табуляцій і пробілів одним пробілом
        String[] rawSentences = cleanedText.split("\\."); // Розбиття тексту на речення
        for (String rawSentence : rawSentences) {
            if (!rawSentence.isBlank()) {
                sentences.add(new Sentence(rawSentence.trim() + ".")); // Додати речення
            }
        }
    }

    public List<Sentence> getSentences() { return sentences; }

    /**
     * Перетворює текст на рядок.
     * @return Рядкове представлення тексту.
     */
    @Override
    public String toString() {
        return String.join(" ", sentences.stream().map(Sentence::toString).toList());
    }
}

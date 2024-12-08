import java.util.ArrayList;
import java.util.List;


/**
 * Клас для обробки тексту
 */
public class TextProcessor {

    /**
     * Знаходить унікальні слова у першому реченні тексту.
     * @param text Об'єкт тексту.
     * @return Список унікальних слів.
     */
    public static List<Word> findUniqueWords(Text text) {
        if (text.getSentences().size() < 2) {
            return List.of();  // Якщо менше двох речень, повертається порожній список
        }

        List<Word> uniqueWords = new ArrayList<>();
        List<Word> firstSentenceWords = text.getSentences().getFirst().getWords();

        for (Word word : firstSentenceWords) {
            boolean isUnique = true;

            for (int i = 1; i < text.getSentences().size(); i++) {
                List<Word> otherWords = text.getSentences().get(i).getWords();
                for (Word otherWord : otherWords) {
                    if (word.getWord().equalsIgnoreCase(otherWord.getWord())) {
                        isUnique = false;
                        break;
                    }
                }
                if (!isUnique) break;
            }

            if (isUnique) {
                uniqueWords.add(word); // Додати слово до списку унікальних
            }
        }
        return uniqueWords;
    }
}

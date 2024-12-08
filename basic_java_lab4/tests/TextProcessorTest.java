import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {
    @Test
    void testFindUniqueWords() {
        String rawText = """
                Це перше речення. Це друге речення. Це третє речення.
                """;
        String[] expectedUniqueWords = {"перше"};
        Text text = new Text(rawText);
        List<Word> actualUniqueWords = TextProcessor.findUniqueWords(text);
        String[] actualUniqueWordsArray = actualUniqueWords.stream()
                .map(Word::getWord)
                .toArray(String[]::new);
        assertArrayEquals(expectedUniqueWords, actualUniqueWordsArray);
    }

    @Test
    void testFindUniqueWordsNoUnique() {
        String rawText = """
                Це речення. Це ж саме речення. Це таке ж речення.
                """;
        String[] expectedUniqueWords = {};
        Text text = new Text(rawText);
        List<Word> actualUniqueWords = TextProcessor.findUniqueWords(text);
        String[] actualUniqueWordsArray = actualUniqueWords.stream()
                .map(Word::getWord)
                .toArray(String[]::new);
        assertArrayEquals(expectedUniqueWords, actualUniqueWordsArray);
    }

    @Test
    void testFindUniqueWordsSingleSentence() {
        String rawText = "Це єдине речення.";
        String[] expectedUniqueWords = {};
        Text text = new Text(rawText);
        List<Word> actualUniqueWords = TextProcessor.findUniqueWords(text);
        String[] actualUniqueWordsArray = actualUniqueWords.stream()
                .map(Word::getWord)
                .toArray(String[]::new);
        assertArrayEquals(expectedUniqueWords, actualUniqueWordsArray);
    }

    @Test
    void testFindUniqueWordsMixedCase() {
        String rawText = """
                Це ПершЕ речення. Це друге РЕЧЕННЯ. Це третє речення.
                """;
        String[] expectedUniqueWords = {"ПершЕ"};
        Text text = new Text(rawText);
        List<Word> actualUniqueWords = TextProcessor.findUniqueWords(text);
        String[] actualUniqueWordsArray = actualUniqueWords.stream()
                .map(Word::getWord)
                .toArray(String[]::new);
        assertArrayEquals(expectedUniqueWords, actualUniqueWordsArray);
    }
}
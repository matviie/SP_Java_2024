import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniqueWordFinderTest {

    @Test
    void testFindUniqueWords() {
        String text = """
                Це перше речення. Це друге речення. Це третє речення.
                """;
        String[] expectedUniqueWords = {"перше"};
        String[] actualUniqueWords = UniqueWordFinder.findUniqueWords(text);

        assertArrayEquals(expectedUniqueWords, actualUniqueWords);
    }

    @Test
    void testFindUniqueWordsNoUnique() {
        String text = """
                Це речення. Це ж саме речення. Це таке ж речення.
                """;
        String[] expectedUniqueWords = {};
        String[] actualUniqueWords = UniqueWordFinder.findUniqueWords(text);

        assertArrayEquals(expectedUniqueWords, actualUniqueWords);
    }

    @Test
    void testFindUniqueWordsSingleSentence() {
        String text = "Це єдине речення.";
        String[] expectedUniqueWords = {};
        String[] actualUniqueWords = UniqueWordFinder.findUniqueWords(text);

        assertArrayEquals(expectedUniqueWords, actualUniqueWords);
    }

    @Test
    void testFindUniqueWordsMixedCase() {
        String text = """
                Це ПершЕ речення. Це друге РЕЧЕННЯ. Це третє речення.
                """;
        String[] expectedUniqueWords = {"ПершЕ"};
        String[] actualUniqueWords = UniqueWordFinder.findUniqueWords(text);

        assertArrayEquals(expectedUniqueWords, actualUniqueWords);
    }
}
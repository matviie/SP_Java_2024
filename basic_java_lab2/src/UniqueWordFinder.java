public class UniqueWordFinder {

    public static String[] findUniqueWords(String text) {

        String[] sentences = text.split("\\.");

        if (sentences.length < 2) {
            return new String[0];
        }

        String[] firstSentenceWords = sentences[0].trim().split(" ");
        String[] uniqueWords = new String[firstSentenceWords.length];
        int uniqueCount = 0;

        for (String word : firstSentenceWords) {
            boolean isUnique = true;

            for (int i = 1; i < sentences.length; i++) {
                String[] otherSentenceWords = sentences[i].trim().split(" ");
                for (String otherWord : otherSentenceWords) {
                    if (word.equalsIgnoreCase(otherWord)) {
                        isUnique = false;
                        break;
                    }
                }
                if (!isUnique) break;
            }

            if (isUnique) {
                uniqueWords[uniqueCount] = word;
                uniqueCount++;
            }
        }

        String[] result = new String[uniqueCount];
        System.arraycopy(uniqueWords, 0, result, 0, uniqueCount);
        return result;
    }
}

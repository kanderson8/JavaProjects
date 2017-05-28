import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kyle Anderson on 5/27/2017.
 * This class contains the logic to convert an English message to/from morse code.
 */
class Converter {

    /**
     * A HashMap that contains Characters as keys and Strings of the corresponding morse code conversion as values
     */
    private final static HashMap<Character, String> CONVERSION_TABLE = new HashMap<>();
    static {
        CONVERSION_TABLE.put('A', ".-");
        CONVERSION_TABLE.put('B', "-...");
        CONVERSION_TABLE.put('C', "-.-.");
        CONVERSION_TABLE.put('D', "-..");
        CONVERSION_TABLE.put('E', ".");
        CONVERSION_TABLE.put('F', "..-.");
        CONVERSION_TABLE.put('G', "--.");
        CONVERSION_TABLE.put('H', "....");
        CONVERSION_TABLE.put('I', "..");
        CONVERSION_TABLE.put('J', ".---");
        CONVERSION_TABLE.put('K', "-.-");
        CONVERSION_TABLE.put('L', ".-..");
        CONVERSION_TABLE.put('M', "--");
        CONVERSION_TABLE.put('N', "-.");
        CONVERSION_TABLE.put('O', "---");
        CONVERSION_TABLE.put('P', ".--.");
        CONVERSION_TABLE.put('Q', "--.-");
        CONVERSION_TABLE.put('R', ".-.");
        CONVERSION_TABLE.put('S', "...");
        CONVERSION_TABLE.put('T', "-");
        CONVERSION_TABLE.put('U', "..-");
        CONVERSION_TABLE.put('V', "...-");
        CONVERSION_TABLE.put('W', ".--");
        CONVERSION_TABLE.put('X', "-..-");
        CONVERSION_TABLE.put('Y', "-.--");
        CONVERSION_TABLE.put('Z', "--..");
        CONVERSION_TABLE.put('1', ".----");
        CONVERSION_TABLE.put('2', "..---");
        CONVERSION_TABLE.put('3', "...--");
        CONVERSION_TABLE.put('4', "....-");
        CONVERSION_TABLE.put('5', ".....");
        CONVERSION_TABLE.put('6', "-....");
        CONVERSION_TABLE.put('7', "--...");
        CONVERSION_TABLE.put('8', "---..");
        CONVERSION_TABLE.put('9', "----.");
        CONVERSION_TABLE.put('0', "-----");
        CONVERSION_TABLE.put('.', ".-.-.-");
        CONVERSION_TABLE.put('?', "..--..");
        CONVERSION_TABLE.put(',', "--..--");
    }

    /**
     * A method that converts an English message to the morse code equivalent.
     * @param uncodedMessage The English message to convert.
     * @return The original message encoded in morse code.
     */
    static String convertToMorseCode(String uncodedMessage) {
        StringBuilder codedMessage = new StringBuilder();
        String upperCaseMessage = uncodedMessage.toUpperCase();

        for (Character c : upperCaseMessage.toCharArray()) {
            String converted = CONVERSION_TABLE.get(c);

            if (converted != null) {
                codedMessage.append(converted);
            }

            codedMessage.append(" ");
        }

        return codedMessage.toString();
    }

    /**
     * A method to convert a message sent in morse code to the unencrypted English message.
     * @param codedMessage The message in morse code.
     * @return The message in English.
     */
    static String convertFromMorseCode(String codedMessage) {
        StringBuilder uncodedMessage = new StringBuilder();
        char[] codedMessageArray = codedMessage.toCharArray();
        for (int i = 0; i < codedMessageArray.length; i++) {
            StringBuilder codedLetter = new StringBuilder();

            while (codedMessageArray[i] != ' ') {
                codedLetter.append(codedMessageArray[i++]);

                //if at end of message, leave loop
                if (i == codedMessageArray.length) {
                    break;
                }
            }

            Character letter = getKeyFromValue(CONVERSION_TABLE, codedLetter.toString());

            if (letter != null) {
                uncodedMessage.append(letter);
            } else {
                uncodedMessage.append(" ");
            }

        }

        return uncodedMessage.toString();
    }


    /**
     * A method that will return the key corresponding to a value in the map.
     * <p>
     *     It is important to note that this method will return the first key in the map matching that matches the
     *     value, so it is best if used on maps that only have a 1:1 correlation between keys and values.
     * </p>
     * @param map The Map to search for the key in.
     * @param lookup The value associated with the key being searched for.
     * @param <K> The key type.
     * @param <V> The value type.
     * @return The key associated with the value if found; null if not.
     */
    private static <K,V> K getKeyFromValue(Map<K, V> map, V lookup) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(lookup)) {
                return entry.getKey();
            }
        }

        return null; //not in map
    }
}

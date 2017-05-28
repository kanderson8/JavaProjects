/**
 * Created by Kyle Anderson on 5/27/2017.
 * This class contains the driver file to demonstrate the morse code converter.
 */
public class ConverterDriver {

    public static void main(String[] args) {
        String uncodedMessage = "The quick brown fox jumps over the lazy dog.";
        System.out.println(Converter.convertToMorseCode(uncodedMessage));
        String codedMessage = "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / " +
                ".--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --. .-.-.-";
        System.out.println(Converter.convertFromMorseCode(codedMessage));
    }
}

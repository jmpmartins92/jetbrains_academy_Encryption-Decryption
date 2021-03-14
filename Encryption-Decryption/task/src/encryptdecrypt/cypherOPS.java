package encryptdecrypt;

public class cypherOPS {

    static int ascii_z = 122;
    static int ascii_a = 97;
    static int ascii_Z = 90;
    static int ascii_A = 65;

    public static StringBuilder encryptionUnicode(String inputMessage, int key) {

        StringBuilder outputMessage = new StringBuilder();

        for (char character : inputMessage.toCharArray()) {
            outputMessage.append((char) (character + key));
        }
        return outputMessage;
    }

    public static StringBuilder decryptionUnicode(String inputMessage, int key) {

        StringBuilder outputMessage = new StringBuilder();

        for (char character : inputMessage.toCharArray()) {
            outputMessage.append((char) (character - key));
        }
        return outputMessage;
    }

    public static StringBuilder encryptionShift(String inputMessage, int key) {

        StringBuilder outputMessage = new StringBuilder();

        for (char character : inputMessage.toCharArray()) {
            if (Character.isLowerCase(character)) {
                if (character + key > ascii_z) {
                    outputMessage.append((char) (ascii_a + character + key - ascii_z - 1));
                } else {
                    outputMessage.append((char) (character + key));
                }
            } else if (Character.isUpperCase(character)) {
                if (character + key > ascii_Z) {
                    outputMessage.append((char) (ascii_A + character + key - ascii_Z - 1));
                } else {
                    outputMessage.append((char) (character + key));
                }
            } else {
                outputMessage.append(character);
            }
        }
        return outputMessage;
    }

    public static StringBuilder decryptionShift(String inputMessage, int key) {

        StringBuilder outputMessage = new StringBuilder();

        for (char character : inputMessage.toCharArray()) {
            if (Character.isLowerCase(character)) {
                if (character - key < ascii_a) {
                    outputMessage.append((char) (ascii_z - ascii_a + character - key + 1));
                } else {
                    outputMessage.append((char) (character - key));
                }
            } else if (Character.isUpperCase(character)) {
                if (character - key < ascii_A) {
                    outputMessage.append((char) (ascii_Z + - ascii_A + character - key + 1));
                } else {
                    outputMessage.append((char) (character - key));
                }
            } else {
                outputMessage.append(character);
            }
        }
        return outputMessage;
    }
}

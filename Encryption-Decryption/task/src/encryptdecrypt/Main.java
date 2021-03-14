package encryptdecrypt;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String mode = "enc";
        StringBuilder inputMessage = new StringBuilder();
        String outputFileName = "";
        int key = 0;
        boolean dataArgument = false;
        boolean outArgument = false;
        String alg = "shift";

        for (int commandIndex = 0; commandIndex < args.length; commandIndex++) {

            switch (args[commandIndex]) {
                case "-mode":
                    mode = args[commandIndex + 1];
                    break;
                case "-data":
                    inputMessage = new StringBuilder(args[commandIndex + 1]);
                    dataArgument = true;
                    break;
                case "-key":
                    key = Integer.parseInt(args[commandIndex + 1]);
                    break;
                case "-out":
                    outArgument = true;
                    outputFileName = args[commandIndex + 1];
                    break;
                case "-in":
                    if (!dataArgument) {
                        FileReader reader = new FileReader(args[commandIndex + 1]);
                        int readChar;
                        while ((readChar = reader.read()) != -1) {
                            inputMessage.append(Character.toChars(readChar));
                        }
                        reader.close();
                    }
                    break;
                case "-alg":
                    alg = args[commandIndex + 1];
                    break;
            }
        }



        FileWriter fileWriter = new FileWriter(outputFileName);

        if (outArgument) {
            switch (mode) {
                case "enc":
                    if (alg.equals("shift")) {
                        fileWriter.write(cypherOPS.encryptionShift(inputMessage.toString(), key).toString().toCharArray());
                        break;
                    } else if (alg.equals("unicode")) {
                        fileWriter.write(cypherOPS.encryptionUnicode(inputMessage.toString(), key).toString().toCharArray());
                        break;
                    } else {
                        fileWriter.write("Error");
                        break;
                    }
                case "dec":
                    if (alg.equals("shift")) {
                        fileWriter.write(cypherOPS.decryptionShift(inputMessage.toString(), key).toString().toCharArray());
                        break;
                    } else if (alg.equals("unicode")) {
                        fileWriter.write(cypherOPS.decryptionUnicode(inputMessage.toString(), key).toString().toCharArray());
                        break;
                    } else {
                        fileWriter.write("Error");
                        break;
                    }
                default:
                    fileWriter.write("Error");
                    break;
            }
            fileWriter.close();
        } else {
            switch (mode) {
                case "enc":
                    if (alg.equals("shift")) {
                        System.out.println(cypherOPS.encryptionShift(inputMessage.toString(), key));
                        break;
                    } else if (alg.equals("unicode")) {
                        System.out.println(cypherOPS.encryptionUnicode(inputMessage.toString(), key));
                        break;
                    } else {
                        fileWriter.write("Error");
                        break;
                    }
                case "dec":
                    if (alg.equals("shift")) {
                        System.out.println(cypherOPS.decryptionShift(inputMessage.toString(), key));
                        break;
                    } else if (alg.equals("unicode")) {
                        System.out.println(cypherOPS.decryptionUnicode(inputMessage.toString(), key));
                        break;
                    } else {
                        fileWriter.write("Error");
                        break;
                    }
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
}

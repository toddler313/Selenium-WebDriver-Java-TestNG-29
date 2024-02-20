package testNG.testData;

import java.util.Random;

public class DataGeneration {

    private static final String ALPHANUMERIC_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomEmailWithGivenDomain(String domain) {
        String[] characters = ALPHANUMERIC_CHARACTERS.split("");
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            email.append(characters[random.nextInt(characters.length)]);
        }
        email.append("@").append(domain);
        return email.toString();
    }

    public static String randomWords(int length) {
        String[] characters = ALPHANUMERIC_CHARACTERS.split("");
        Random random = new Random();
        StringBuilder randomWords = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomWords.append(characters[random.nextInt(characters.length)]);
        }
        return randomWords.toString();
    }



    public static void main(String[] args) {
//        System.out.println(randomEmailWithGivenDomain("example.com"));
    }
}

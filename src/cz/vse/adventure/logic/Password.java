package cz.vse.adventure.logic;

public class Password {
    public static String password;

    static {
        generatePassword();
    }

    private static void generatePassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomNum = (int) (Math.random() * 10);
            sb.append(randomNum);
        }
        password = sb.toString();
    }
}
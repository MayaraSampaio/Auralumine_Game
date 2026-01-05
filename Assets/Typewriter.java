package Assets;

import java.util.Scanner;

public class Typewriter {
    /**
     *method for inserting text character by character
     * @param text
     * @param speedMs
     */
    public static void write(String text, int speedMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(speedMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    /**
     *Method for inserting text with pauses with color
     * @param text
     * @param sc
     */
    public static void narrar(String text, Scanner sc) {
        String DOURADO = "\u001B[1;33m";
        String RESET = "\u001B[0m";

        System.out.print(DOURADO);
        Typewriter.write(text, 30);
        System.out.print(RESET);

        System.out.println("\n\n[Pressione Enter para continuar]");
        sc.nextLine();
    }

    /**
     *Method for inserting text with pauses
     * @param text
     * @param sc
     */
    public static void narrar2 (String text, Scanner sc) {
        System.out.println();
        Typewriter.write(text, 30);

    }
}

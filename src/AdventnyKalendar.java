import java.util.*;

/**
 * Trieda AdventnyKalendar obsahuje metódu na generovanie náhodných darčekov pre zadaný deň.
 */
public class AdventnyKalendar {
    public static void main(String[] args) {
        Random random = new Random();

        try (Scanner vstup = new Scanner(System.in)) {
            System.out.println("Zadajte aktualny deň: ");
            int zadanyDen = vstup.nextInt();

            if (zadanyDen < 0 || zadanyDen > 24) {
                System.out.println("Neplatný deň. Zadajte deň v rozmedzí 0 - 24! ");
            } else {
                String darcek = darcekDna(zadanyDen, random);
                System.out.println("Deň " + zadanyDen + ". " + "Váš darček:" + darcek);
            }
        } catch (InputMismatchException e){
            System.out.println("Nesprávny formát vstupu. Skúste to ešte raz!");
        }
    }

    /**
     * Metóda generuje darček pre každý deň adventu, ktorý zadá užívateľ.
     * @param zadanyDen deň adventu
     * @param random inštancia triedy Random, pre generovanie náhodných čísel
     * @return reťazec s darčekom pre zadaný deň
     */
    public static String darcekDna(int zadanyDen, Random random) {
        if (zadanyDen == 24) {
            return " Šampanské";
        } else {
            Map<Double, String> darceky = new HashMap<>();
            darceky.put(15.0, " Biely jogurt");
            darceky.put(20.0, " Polotučné mlieko");
            darceky.put(30.0, " Syr");
            darceky.put(40.0, " Zmrzlina");

            double sanca = random.nextDouble() * 100;

            return darceky.entrySet().stream()
                    .filter(entry -> sanca <= entry.getKey())
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(" V dnešnom okne sa nenachádza žiadny darček.");
        }
    }
}



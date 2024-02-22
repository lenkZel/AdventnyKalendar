import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Trieda GrafickaUprava upravuje kalendár do konečnej grafickej podoby.
 */
public class GrafickaUprava {
    public static final int OKNO_SIRKA = 1200;
    public static final int OKNO_VYSKA = 800;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame okno = new JFrame();
            okno.setTitle("Adventný kalendár");
            okno.setSize(OKNO_SIRKA, OKNO_VYSKA);
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setLayout(new GridLayout(4,6));

            Random random = new Random();

            ArrayList<Boolean> otvoreneOkno = new ArrayList<>(24);

            LocalDate aktualnyDatum = LocalDate.now();
            int aktualnyDen = aktualnyDatum.getDayOfMonth();

            for (int den = 1; den <= 24; den++) {
                boolean jeOtvorene = den <= aktualnyDen ? otvoreneOkno.add(true) : otvoreneOkno.add(false);

                JButton tlacidlo = new JButton(String.valueOf(den));
                tlacidlo.setEnabled(otvoreneOkno.get(den - 1));
                tlacidlo.setBackground(new Color(153,255,51));
                int finalDen = den;
                //pridanie ActionListenera ku tlacidlu
                tlacidlo.addActionListener(udalost -> {
                    if (otvoreneOkno.get(finalDen -1)){
                        String darcek = AdventnyKalendar.darcekDna(finalDen, random);
                        JOptionPane.showMessageDialog(okno, "Okno " + finalDen + ":" + darcek);
                        otvoreneOkno.set(finalDen - 1, true);
                        tlacidlo.setEnabled(false);
                        tlacidlo.setBackground(new Color(224,224,224));
                    } else{
                        JOptionPane.showMessageDialog(okno, "Okno" + finalDen + " už bolo otvorené");
                    }
                });
                okno.add(tlacidlo);
            }
            okno.setLocationRelativeTo(null);
            okno.setVisible(true);
                }
        );
    }
}

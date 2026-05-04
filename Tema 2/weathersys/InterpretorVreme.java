package org.weathersys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterpretorVreme {
    private String locatie;
    private List<Senzor> senzori;

    /**
     * Clasa record ce contin datele vremii
     * @param temperatura Media temperaturii preluate de la senzor
     * @param umiditate Media umiditatii preluate de la senzor
     * @param precipitatie Media precipitatii preluate de la senzor
     * @param punctRoua Punctul roua calculat
     */
    public record DateVremeGenerate (double temperatura, double umiditate, double precipitatie, double punctRoua) {}

    /**
     * Constructor cu parametrii
     * @param locatie Locatia pentru vremea care va fi calculata
     */
    public InterpretorVreme(String locatie) {
        this.locatie = locatie;
        this.senzori = new ArrayList<>();
    }

    /**
     * Metoda pentru adaugarea unui senzor in lista
     * @param senzor Senzorul de adaugat
     */
    public void adaugaSenzor (Senzor senzor) {
        this.senzori.add(senzor);
    }

    /**
     * Metoda pentru preluarea datelor de la senzor
     * @param locatie Locatia datelor de vreme
     * @return Un obiect record cu media datelor generate
     */
    public DateVremeGenerate interpreteazaDateSenzor (String locatie) {
        double temp = 0.0;
        int tempInd = 0;
        double umid = 0.0;
        int umidInd = 0;
        double prec = 0.0;
        int precInt = 0;

        for (Senzor s : senzori) {
            String tip = s.getTipMasuratoare().toLowerCase();

            if (tip.equals("temperatura")) {
                temp += s.citesteValoare();
                tempInd++;
            } else if (tip.equals("umiditate")) {
                umid += s.citesteValoare();
                umidInd++;
            } else if (tip.equals("precipitatii")) {
                prec += s.citesteValoare();
                precInt++;
            }
        }

        temp = (tempInd > 0) ? temp / tempInd : 0.0;
        umid = (umidInd > 0) ? umid / umidInd : 0.0;
        prec = (precInt > 0) ? prec / precInt : 0.0;

        double pct = temp - ((100.0 - umid) / 5.0);

        return new DateVremeGenerate(temp, umid, prec, pct);
    }
}

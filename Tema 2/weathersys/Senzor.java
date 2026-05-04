package org.weathersys;

import java.util.Random;

public class Senzor {
    private String idSenzor;
    private String tipMasuratoare;
    private Random rand;

    /**
     * Constructor cu parametrii
     * @param idSenzor Id-ul senzorului
     * @param tipMasuratoare Tipul de date pe care il masoara
     */
    public Senzor(String idSenzor, String tipMasuratoare) {
        this.idSenzor = idSenzor;
        this.tipMasuratoare = tipMasuratoare;
        this.rand = new Random();
    }

    /**
     * Getter pentru id-ul senzorului
     * @return Id-ul senzorului
     */
    public String getIdSenzor() { return this.idSenzor; }

    /**
     * Getter pentru tipul datelor
     * @return Tipul datelor masurate de senzor;
     */
    public String getTipMasuratoare() {
        return this.tipMasuratoare;
    }

    /**
     * Metoda pentru citirea datei de la senzor
     * Am folosit date random pentru a simula un senzor real
     * Temperatura: Intre -30 si 45
     * Umiditate: intre 0.0 si 100.0
     * Precipitatie: (Simulare initial daca ploua) Cantitatea de apa (daca ploua intre 0 si 25mm)
     * Punct roua: calculat pe baza temperaturii si umiditatii
     * @return valoarea datei citite de la senzor
     */
    public double citesteValoare() {
        switch (this.tipMasuratoare.toLowerCase()) {
            case "temperatura":
                return -30.0 + (75.0 * rand.nextDouble());
            case "umiditate":
                return 100.0 * rand.nextDouble();
            case "precipitatii":
                if (rand.nextDouble() > 0.7) {
                    return 25.0 * rand.nextDouble();
                } else {
                    return 0.0;
                }
            default:
                return 0.0;
        }
    }
}
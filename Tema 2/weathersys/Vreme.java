package org.weathersys;

import java.util.ArrayList;
import java.util.List;

public class Vreme {
    private String ziua;
    private String locatie;
    private double temperatura;
    private double umiditate;
    private double precipitatie;
    private double punctRoua;
    private InterpretorVreme iv;

    /**
     * Constructor fara parametrii
     */
    public Vreme() {
        this.ziua = null;
        this.locatie = null;
        this.iv = null;
    }

    /**
     * Consturctor cu parametrii
     * @param ziua Ziua in care se masoara vremea
     * @param locatie Locatia in care se masoara vremea
     * @param iv Interpretorul de vreme
     */
    public Vreme(String ziua, String locatie, InterpretorVreme iv) {
        this.ziua = ziua;
        this.locatie = locatie;
        this.iv = iv;
        actualizeazaVremea();
    }

    /**
     * Getter pentru ziua
     * @return Ziua vremii
     */
    public String getZiua() {
        return this.ziua;
    }

    /**
     * Getter pentru locatie
     * @return Locatia vremii
     */
    public String getLocatie() { return this.locatie; }

    /**
     * Getter pentru temperatura
     * @return Temperatura vremii
     */
    public double getTemperatura() {
        return this.temperatura;
    }

    /**
     * Getter pentru umiditate
     * @return Umiditatea vremii
     */
    public double getUmiditate() {
        return this.umiditate;
    }

    /**
     * Getter pentru precipitatie
     * @return Precipitatia vremii
     */
    public double getPrecipitatie() {
        return this.precipitatie;
    }

    /**
     * Getter pentru punctul de roua
     * @return Punctul de roua al vremii
     */
    public double getPunctRoua() {
        return this.punctRoua;
    }

    /**
     * Metoda pentru actualizarea vremii
     * Aceasta preia noile date de la senzor si actualizeaza vremea
     */
    public void actualizeazaVremea() {
        if (this.iv != null) {
            InterpretorVreme.DateVremeGenerate dvg = iv.interpreteazaDateSenzor(locatie);
            this.temperatura = dvg.temperatura();
            this.umiditate = dvg.umiditate();
            this.precipitatie = dvg.precipitatie();
            this.punctRoua = dvg.punctRoua();
        }
    }

    /**
     * Metoda pentru a afisa tipul vremii
     * @return Tipul vremii
     */
    public String obtineTipVreme() {
        if (this.temperatura < 0) {
            return "Geros";
        } else if (this.temperatura < 10) {
            return "Rece";
        } else if (this.temperatura < 20) {
            return "Racoros";
        } else if (this.temperatura < 28) {
            return "Placut";
        } else if (this.temperatura < 35) {
            return "Cald";
        } else {
            return "Canicula";
        }
    }

    /**
     * Metoda pentru verificarea daca exista alerte de vreme
     * in functie de temperaturile inregistrate
     * @return Mesajul care contine alerta
     */
    public String verificaAlerta() {
        StringBuilder sb = new StringBuilder();

        if (this.temperatura < 0) {
            sb.append("Avertizare: Risc de inghet! ");
        } else if (this.temperatura > 35) {
            sb.append("Avertizare: Canicula! ");
        }

        if (this.precipitatie > 15) {
            sb.append("Avertizare: Precipitatii abundente! ");
        } else if (this.precipitatie > 0) {
            sb.append("Precipitatii mici, sanse de ploaie. ");
        }

        if (sb.length() == 0) {
            return "Vreme normala. Nu sunt alerte active. ";
        }

        return sb.toString().trim();
    }

    /**
     * Supraincarcarea metodei toString
     * @return Obiectul transformat in String
     */
    @Override
    public String toString () {
        StringBuffer sb = new StringBuffer();

        sb.append("Ziua: ").append(this.ziua).append(", Temperatura: ").append(this.temperatura)
                .append(", Umiditate: ").append(this.umiditate).append(", Precipitatie: ")
                .append(this.precipitatie).append(", Punct roua: ").append(this.punctRoua);

        return sb.toString();
    }
}

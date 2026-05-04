package org.weathersys;

public class Utilizator {
    private String nume;
    private String locatie;

    /**
     * Constuctor fara parametrii
     */
    public Utilizator () {
        this.nume = null;
        this.locatie = null;
    }

    /**
     * Constructor cu parametrii
     * @param nume Numele utilizatorului
     * @param locatie Locatia utilizatorului
     */
    public Utilizator (String nume, String locatie) {
        this.nume = nume;
        this.locatie = locatie;
    }

    /**
     * Getter pentru nume
     * @return Numele utilizatorului
     */
    public String getNume () {
        return this.nume;
    }

    /**
     * Getter pentru locatie
     * @return Locatia utilizatorului
     */
    public String getLocatie () {
        return this.locatie;
    }
}

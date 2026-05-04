import org.weathersys.InterpretorVreme;
import org.weathersys.Senzor;
import org.weathersys.Utilizator;
import org.weathersys.Vreme;

public class Main {
    public static void main (String[] args) {
        Utilizator user = new Utilizator("Alex", "Bucuresti");
        System.out.println("Sistemul de vreme pornit pentru utilizatorul: " +
                user.getNume() + " (" + user.getLocatie() + ")\n");

        InterpretorVreme interpretor = new InterpretorVreme(user.getLocatie());
        interpretor.adaugaSenzor(new Senzor("T1", "temperatura"));
        interpretor.adaugaSenzor(new Senzor("T2", "temperatura"));

        //Am adaugat 2 senzori de temperatura pentru a testa media

        interpretor.adaugaSenzor(new Senzor("U1", "umiditate"));
        interpretor.adaugaSenzor(new Senzor("P1", "precipitatii"));

        Vreme vremeAzi = new Vreme("Luni", user.getLocatie(), interpretor);

        System.out.println("Datele initiale:");
        System.out.printf("Tip vreme: %s | Ziua: %s, Locatie: %s | Temp: %.2f°C | Umiditate: %.2f%% | " +
                        "Precipitatii: %.2f mm | Punct roua: %.2f | Alerta: %s\n",
                vremeAzi.obtineTipVreme(), vremeAzi.getZiua(), vremeAzi.getLocatie(), vremeAzi.getTemperatura(),
                vremeAzi.getUmiditate(), vremeAzi.getPrecipitatie(), vremeAzi.getPunctRoua(), vremeAzi.verificaAlerta());

        System.out.println("\nSe actualizează datele de la senzori...");

        vremeAzi.actualizeazaVremea();

        System.out.printf("Tip vreme: %s | Ziua: %s, Locatie: %s | Temp: %.2f°C | Umiditate: %.2f%% | " +
                        "Precipitatii: %.2f mm | Punct roua: %.2f | Alerta: %s\n",
                vremeAzi.obtineTipVreme(), vremeAzi.getZiua(), vremeAzi.getLocatie(), vremeAzi.getTemperatura(),
                vremeAzi.getUmiditate(), vremeAzi.getPrecipitatie(), vremeAzi.getPunctRoua(), vremeAzi.verificaAlerta());

    }
}
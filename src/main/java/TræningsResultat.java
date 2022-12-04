import java.time.LocalDate;

public class TræningsResultat {

    private String resultat;
    private String disciplin;
    private LocalDate dato;
    private String name;

    public TræningsResultat(String resultat, String disciplin, LocalDate dato, String name) {
        this.resultat = resultat;
        this.disciplin = disciplin;
        this.dato = dato;
        this.name = name;
    }
}

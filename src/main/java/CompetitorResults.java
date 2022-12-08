import java.time.LocalDate;

public class CompetitorResults {

    private String result;
    private String disciplin;
    private LocalDate dato;
    private String name;

    public CompetitorResults(String result, String disciplin, LocalDate dato, String name) {
        this.result = result;
        this.disciplin = disciplin;
        this.dato = dato;
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "StævneResultat{" +
                "resultat='" + result + '\'' +
                ", disciplin='" + disciplin + '\'' +
                ", dato=" + dato +
                ", name='" + name + '\'' +
                '}';
    }
}

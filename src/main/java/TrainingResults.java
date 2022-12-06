import java.time.LocalDate;

public class TrainingResults {

    private String result;
    private String disciplin;
    private LocalDate dato;
    private String name;

    public TrainingResults(String result, String disciplin, LocalDate dato, String name) {
        this.result = result;
        this.disciplin = disciplin;
        this.dato = dato;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TræningsResultat{" +
                "resultat='" + result + '\'' +
                ", disciplin='" + disciplin + '\'' +
                ", dato=" + dato +
                ", name='" + name + '\'' +
                '}';
    }
}

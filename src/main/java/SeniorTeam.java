import java.time.LocalDate;
import java.util.ArrayList;

public class SeniorTeam {
    private Coach coach;
    private ArrayList<Member> seniorMembers;

    private ArrayList<TrainingResults> trainingResults = new ArrayList<>();
    private ArrayList<CompetitorResults> competitorResults = new ArrayList<>();

    public SeniorTeam() {
        coach = new Coach("Andreas");
        seniorMembers = new ArrayList<>();
    }

    public void addTræningsResultat(String resultat, String disciplin, LocalDate dato, String name) {
        trainingResults.add(new TrainingResults(resultat, disciplin, dato, name));
    }

    public void addTræningsResultat(TrainingResults resultat) {
        trainingResults.add(resultat);
    }

    public void addStævneResultat(CompetitorResults resultat) {
        competitorResults.add(resultat);
    }

    public Coach getCoach() {
        return coach;
    }

    public void add(Member m) {
        seniorMembers.add(m);
    }

    public ArrayList<Member> getSeniorMembers() {
        return seniorMembers;
    }

    public ArrayList<TrainingResults> getTrainingResults() {
        return trainingResults;
    }

    public ArrayList<CompetitorResults> getCompetitorResults() {
        return competitorResults;
    }

    @Override
    public String toString() {
        return "Team{" +
                ", coach=" + coach +
                ", seniorMembers=" + seniorMembers +
                '}';
    }
}

import java.time.LocalDate;
import java.util.ArrayList;

public class JuniorTeam {
    private Coach coach;
    private ArrayList<Member> juniorMembers;

    private ArrayList<TrainingResults> trainingResults = new ArrayList<>();
    private ArrayList<CompetitorResults> competitorResults = new ArrayList<>();

    public JuniorTeam() {
        coach = new Coach("Rasmus");
        juniorMembers = new ArrayList<>();
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
        juniorMembers.add(m);
    }

    public ArrayList<Member> getJuniorMembers() {
        return juniorMembers;
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
                ", juniorMembers=" + juniorMembers +
                '}';
    }
}

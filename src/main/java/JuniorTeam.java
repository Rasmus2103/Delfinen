import java.time.LocalDate;
import java.util.ArrayList;

public class JuniorTeam {
    private Coach coach;
    private ArrayList<Member> juniorMembers;

    private ArrayList<TræningsResultat> træningsResultater = new ArrayList<>();
    private ArrayList<StævneResultat> stævneResultat = new ArrayList<>();

    /*public JuniorTeam(Coach coach) {
        this.coach = coach;
        juniorMembers = new ArrayList<>();
    }*/

    public JuniorTeam() {
        coach = new Coach("Rasmus");
        juniorMembers = new ArrayList<>();
    }

    public void addTræningsResultat(String resultat, String disciplin, LocalDate dato, String name) {
        træningsResultater.add(new TræningsResultat(resultat, disciplin, dato, name));
    }

    public void addTræningsResultat(TræningsResultat resultat) {
        træningsResultater.add(resultat);
    }

    public void addStævneResultat(StævneResultat resultat) {
        stævneResultat.add(resultat);
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

    @Override
    public String toString() {
        return "Team{" +
                ", coach=" + coach +
                ", juniorMembers=" + juniorMembers +
                '}';
    }
}

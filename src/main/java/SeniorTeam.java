import java.time.LocalDate;
import java.util.ArrayList;

public class SeniorTeam {
    private Coach coach;
    private ArrayList<Member> seniorMembers;

    private ArrayList<TræningsResultat> træningsResultater = new ArrayList<>();
    private ArrayList<StævneResultat> stævneResultat = new ArrayList<>();

    /*public SeniorTeam(Coach coach) {
        this.coach = coach;
        seniorMembers = new ArrayList<>();
    }*/

    public SeniorTeam() {
        coach = new Coach("Andreas");
        seniorMembers = new ArrayList<>();
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
        seniorMembers.add(m);
    }

    /*public void addTeammemberSenior(Member member) {
        try {
            if (member.getMemberAge() > 18 && member.getActivity()) {
                seniorMembers.add(member);
            }
        } catch (NullPointerException npe) {

        }
    }*/

    public ArrayList<Member> getSeniorMembers() {
        return seniorMembers;
    }

    @Override
    public String toString() {
        return "Team{" +
                ", coach=" + coach +
                ", seniorMembers=" + seniorMembers +
                '}';
    }
}

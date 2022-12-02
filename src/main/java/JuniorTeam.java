import java.util.ArrayList;

public class JuniorTeam {
    private Coach coach;
    private ArrayList<Member> juniorMembers;

    public JuniorTeam(Coach coach) {
        this.coach = coach;
        juniorMembers = new ArrayList<>();
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

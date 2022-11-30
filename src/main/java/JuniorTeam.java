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

    public void addTeammemberJunior(Member member) {
        if(member.getMemberAge() < 18 && member.getActivities()) {
            juniorMembers.add(member);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                ", coach=" + coach +
                ", juniorMembers=" + juniorMembers +
                '}';
    }
}

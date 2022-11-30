import java.util.ArrayList;

public class SeniorTeam {
    private Coach coach;
    private ArrayList<Member> seniorMembers;

    public SeniorTeam(Coach coach) {
        this.coach = coach;
        seniorMembers = new ArrayList<>();
    }

    public Coach getCoach() {
        return coach;
    }

    public void addTeammemberSenior(Member member) {
        if(member.getMemberAge() > 18 && member.getActivities()) {
            seniorMembers.add(member);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                ", coach=" + coach +
                ", seniorMembers=" + seniorMembers +
                '}';
    }
}

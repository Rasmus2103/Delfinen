import java.util.ArrayList;

public class SeniorTeam {
    private Coach coach;
    private ArrayList<Member> seniorMembers;

    /*public SeniorTeam(Coach coach) {
        this.coach = coach;
        seniorMembers = new ArrayList<>();
    }*/

    public SeniorTeam() {
        coach = new Coach("Andreas");
        seniorMembers = new ArrayList<>();
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

import java.util.ArrayList;

public class Team {
    private boolean isJunior;
    private Coach coach;
    private ArrayList<Member> members;

    public Team(boolean isJunior, Coach coach) {
        this.isJunior = isJunior;
        this.coach = coach;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public Coach getCoach() {
        return coach;
    }

    public void addTeammember(Member member) {
        members.add(member);
    }


}

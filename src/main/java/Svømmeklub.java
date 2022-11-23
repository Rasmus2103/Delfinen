import java.io.Serializable;

public class Svømmeklub implements Serializable {

    //Attributer
    private String memberName;
    private String activities;
    private int memberAge;
    private boolean isStudying;


    //Konstruktør
    public Svømmeklub(String memberName, String activities, int memberAge, boolean isStudying) {
        this.memberName = memberName;
        this.activities = activities;
        this.memberAge = memberAge;
        this.isStudying = isStudying;

    }

    public static void sortByisStudying() {
    }

    //getter
    public String getmemberName() {
        return memberName;
    }

    public String getActivities() {
        return activities;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public boolean getisStudying() {

        return isStudying;
    }


    //setter
    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    public void setisStudying(boolean isStudying) {
        this.isStudying = isStudying;
    }
}
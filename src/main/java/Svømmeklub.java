import java.io.Serializable;
import java.util.Date;

public class Svømmeklub implements Serializable {

    //Attributer
    private String memberName;
    private String activities;
    private String membership;
    private Date memberAge;
    private boolean isStudying;


    //Konstruktør
    public Svømmeklub(String memberName, String activities, String membership, Date memberAge, boolean isStudying, int memberNumber, String eMail) {
        this.memberName = memberName;
        this.activities = activities;
        this.membership = membership;
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

    public String getMembership() {
        return membership;
    }

    public Date getMemberAge() {
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

    public void setisStudying(boolean isStudying) {
        this.isStudying = isStudying;
    }
}
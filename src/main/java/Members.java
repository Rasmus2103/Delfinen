import java.time.LocalDate;

public class Members {
    private String memberName;
    private String activities;
    private String membership;
    private LocalDate memberAge;
    private boolean isStudying;
    private int memberNumber;
    private String eMail;


    //Konstruktør
    public Members(String memberName, String activities, String membership, LocalDate memberAge, boolean isStudying, int memberNumber, String eMail) {
        this.memberName = memberName;
        this.activities = activities;
        this.membership = membership;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;

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

    public LocalDate getMemberAge() {
        return memberAge;
    }

    public boolean getisStudying() {
        return isStudying;
    }

    public int getMemberNumber(){
        return memberNumber;
    }

    public String geteMail(){
        return eMail;
    }


    //setter
    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setMemberAge(LocalDate memberAge){
        this.memberAge = memberAge;
    }

    public void setisStudying(boolean isStudying) {
        this.isStudying = isStudying;
    }

    public void setMemberNumber(int memberNumber){
        this.memberNumber = memberNumber;
    }

    public void seteMail(String eMail){
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberName='" + memberName + '\'' +
                ", activities='" + activities + '\'' +
                ", membership='" + membership + '\'' +
                ", memberAge=" + memberAge +
                ", isStudying=" + isStudying +
                ", memberNumber=" + memberNumber +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    public String csvToString() {
        return memberName + ";" + activities + ";" + membership + ";" + memberAge + ";" + isStudying + ";" + memberNumber + ";" + eMail;
    }
}

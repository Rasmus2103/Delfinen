import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Members {
    private String memberName;
    private String activities;
    private String membership;
    private int memberAge;
    private LocalDate birthday;
    private boolean isStudying;
    private int memberNumber;
    private String eMail;
    //private int subsription;


    //Konstruktør
    public Members(String memberName, String activities, String membership, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/) {
        this.memberName = memberName;
        this.activities = activities;
        this.membership = membership;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;
        //this.subsription = subsription;
    }

    public Members(String memberName, String activities, String membership, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/, LocalDate birthday) {
        this.memberName = memberName;
        this.activities = activities;
        this.membership = membership;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;
        //this.subsription = subsription;
        this.birthday = birthday;
    }

    public Members() {

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

    public int getMemberAge() {
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

    public LocalDate getBirthday(){return birthday;}

    /*public int getSubsription() {
        return subsription;
    }*/


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

    public void setMemberAge(int memberAge){
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

    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}

    /*public void setSubsription(int subsription) {
        this.subsription = subsription;
    }*/

    @Override
    public String toString() {
        String text;
        if(isStudying)
            text = "Studerende";
        else
            text = "Ikke studerende";
        return "Members{" +
                "memberName='" + memberName + '\'' +
                ", activities='" + activities + '\'' +
                ", membership='" + membership + '\'' +
                ", memberAge=" + memberAge +
                ", isStudying=" + text +
                ", memberNumber=" + memberNumber +
                ", eMail='" + eMail + '\'' +
                ", birthday='" + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\'' +
                '}';
    }

    public String csvToString() {
        return memberName + ";" + activities + ";" + membership + ";" + memberAge + ";" + isStudying + ";" + memberNumber + ";" + eMail + ";" + birthday;
    }
}

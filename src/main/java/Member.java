import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Member {
    private String memberName;
    private boolean activity;
    private String membership;
    private ArrayList <String> swimDiscipline;
    private int memberAge;
    private LocalDate birthday;
    private boolean isStudying;
    private int memberNumber;
    private String eMail;
    //private int subsription;


    //Konstruktør
    public Member(String memberName, boolean activity, String membership, ArrayList <String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/) {
        this.memberName = memberName;
        this.activity = activity;
        this.membership = membership;
        this.swimDiscipline = swimDiscipline;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;
        //this.subsription = subsription;
    }

    public Member(String memberName, boolean activity, String membership, ArrayList <String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/, LocalDate birthday) {
        this.memberName = memberName;
        this.activity = activity;
        this.membership = membership;
        this.swimDiscipline = swimDiscipline;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;
        //this.subsription = subsription;
        this.birthday = birthday;
    }

    public Member() {

    }

    public static void sortByisStudying() {
    }

    //getter
    public String getmemberName() {
        return memberName;
    }

    public boolean getActivity() {
        return activity;
    }

    public String getMembership() {
        return membership;
    }

    public ArrayList<String> getSwimDiscipline(){
        return swimDiscipline;
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

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setSwimDiscipline(ArrayList<String> swimDiscipline){
        this.swimDiscipline = swimDiscipline;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

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
        String text2;
        if(activity)
            text2 = "Konkurrencesvømmer";
        else
            text2 = "Motionistsvømmer";
        return "Members{" +
                "memberName='" + memberName + '\'' +
                ", activities='" + text2 + '\'' +
                ", membership='" + membership + '\'' +
                ", svømmedisciplin='" + swimDiscipline + '\'' +
                ", memberAge=" + memberAge +
                ", isStudying=" + text +
                ", memberNumber=" + memberNumber +
                ", eMail='" + eMail + '\'' +
                ", birthday='" + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\'' +
                '}';
    }

   /* public String csvToString() {
        String text;
        if(isStudying)
            text = "Studerende";
        else
            text = "Ikke Studerende";
        String text2;
        if(activity)
            text2 = "Konkurrencesvømmer";
        else
            text2 = "Motionistsvømmer";
        return memberName + ";" + text2 + ";" + membership + ";" + memberAge + ";" + text + ";" + memberNumber + ";" + eMail + ";" + birthday;
    }*/

    public String csvToString() {
        return memberName + ";" + activity + ";" + membership + ";" + swimDiscipline + ";" + memberAge + ";" + isStudying + ";" + memberNumber + ";" + eMail + ";" + birthday;
    }
}

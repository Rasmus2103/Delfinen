import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Member {
    private String memberName;
    private boolean activity;
    private String membership;
    private int memberAge;
    private LocalDate birthday;
    private boolean isStudying;
    private int memberNumber;
    private String eMail;
    private String memberAgeType;
    //private int subsription;


    //Konstruktør
    public Member(String memberName, boolean activity, String membership, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/) {
        this.memberName = memberName;
        this.activity = activity;
        this.membership = membership;
        this.memberAge = memberAge;
        this.isStudying = isStudying;
        this.memberNumber = memberNumber;
        this.eMail = eMail;
        this.memberAgeType = memberAgeType;
        //this.subsription = subsription;
    }

    //Kontingent
    private int memberRate;

    public int getMemberRate() {
        return memberRate;
    }

    public Member(String memberName, boolean activity, String membership, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/, LocalDate birthday) {
        this.memberName = memberName;
        this.activity = activity;
        this.membership = membership;
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

    public int getMemberAge() {
        return memberAge;
    }

    public boolean getisStudying() {
        return isStudying;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

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

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    public void setisStudying(boolean isStudying) {
        this.isStudying = isStudying;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void seteMail(String eMail) {
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
        if (isStudying)
            text = "Studerende";
        else
            text = "Ikke studerende";
        String text2;
        if (activity)
            text2 = "Konkurrencesvømmer";
        else
            text2 = "Motionistsvømmer";
        return "Members{" +
                "memberName='" + memberName + '\'' +
                ", activities='" + text2 + '\'' +
                ", membership='" + membership + '\'' +
                ", memberAge=" + memberAge +
                ", isStudying=" + text +
                ", memberNumber=" + memberNumber +
                ", eMail='" + eMail + '\'' +
                ", birthday='" + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\'' +
                '}';
    }

    //  kontingentsats

    public void memberAgeType() {

        if (memberAge < 18) {
            this.memberAgeType = "Junior";
        } else if (memberAge > 60) {
            this.memberAgeType = "Senior";
        } else {
            this.memberAgeType = "Voksen";
        }
    }

    // beregn memberRate
    public void Findrate() {
        int kontingent = 0;
        if (membership.contains("aktivt")) {
            if (memberAgeType.equals("juniorsvømmer")) {
                kontingent = 1000;
            } else if (memberAgeType.equals("seniorsvømmer")) {
                kontingent = 1600;

            } else {
                kontingent = 500;
            }
            memberRate = kontingent;
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

        public String csvToString () {
            return memberName + ";" + activity + ";" + membership + ";" + memberAge + ";" + isStudying + ";" + memberNumber + ";" + eMail + ";" + birthday;
        }
    }
}

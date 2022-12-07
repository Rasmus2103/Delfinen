import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class Member {
    private String memberName;
    private boolean activity;
    private String membership;
    private ArrayList<String> swimDiscipline;
    private int memberAge;
    private LocalDate birthday;
    private boolean isStudying;
    private int memberNumber;
    private String eMail;
    private String memberAgeType;
    //private int subsription;
    private boolean hasPaid;


    public Member(String memberName, boolean activity, String membership, ArrayList<String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail /*int subsription*/, LocalDate birthday) {
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
        this.hasPaid = false;
    }

    public Member() {

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

    public ArrayList<String> getSwimDiscipline() {
        return swimDiscipline;
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

    public boolean getHasPaid() {
        return hasPaid;
    }

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

    public void setSwimDiscipline(ArrayList<String> swimDiscipline) {
        this.swimDiscipline = swimDiscipline;
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

    public void setHasPaid() {
        this.hasPaid = true;
    }


    /*public void setSubsription(int subsription) {
        this.subsription = subsription;
    }*/

    public int calculateSubsription() {
        int price = 0;
        if(membership.equals("passivt")) {
            price = 500;
        } else if(memberAge < 18) {
            price = 1000;
        } else if(memberAge >= 18 && memberAge < 60) {
            price = 1600;
        } else if(memberAge >= 60) {
            price = (int) (1600 * 0.75);
        }
        if(isStudying) {
            return (price * (int) (0.85));
        } else {
            return price;
        }
    }

    public int hasNotPaid() {
        int price = 0;
        if(membership.equals("passivt")) {
            price = -500;
        } else if(memberAge < 18) {
            price = -1000;
        } else if(memberAge >= 18 && memberAge < 60) {
            price = -1600;
        } else if(memberAge >= 60) {
            price = (int) (-1600 * 0.75);
        }
        if(isStudying) {
            return (price * (int) (0.85));
        } else {
            return price;
        }
    }

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

        String text3;
        if(hasPaid)
            text3 = "Har betalt";
        else
            text3 = "I restance";
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
                ", hasPaid =' " + text3 + '\'' +
                '}';
    }

        public String csvToString () {
            return memberName + ";" + activity + ";" + membership + ";" + swimDiscipline + ";" + memberAge + ";" + isStudying + ";" + memberNumber + ";" + eMail + ";" + birthday;
        }
    }

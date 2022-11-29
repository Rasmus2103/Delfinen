import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Svømmeklub {

    //TODO lav memberlist private
    ArrayList<Member> memberList = new ArrayList<>();

    public void addMember(String memberName, boolean activities, String memberShip, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth) {
        memberList.add(new Member(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail, dateOfBirth));
    }

    /*public void addMemberToDatabase(Svømmeklub member) {
        Database.add(member);
    }*/

    /*private static void add(Svømmeklub member) {
    }*/

    public ArrayList<Member> searchByMemberName(String searchName) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member nameSearch : memberList) {
            if (nameSearch.getmemberName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(nameSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Member> searchByActivities(boolean searchActivity) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member activitySearch : memberList) {
            if (activitySearch.getActivities() == searchActivity) {
                searchList.add(activitySearch);
            }
        }
        return searchList;
    }

    public ArrayList<Member> searchByMembership(String searchMembership) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member membershipSearch : memberList) {
            if (membershipSearch.getMembership().toLowerCase().contains(searchMembership.toLowerCase())) {
                searchList.add(membershipSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Member> searchByMemberAge(int searchMemberAge) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member memberAgeSearch : memberList) {
            if (memberAgeSearch.getMemberAge() == searchMemberAge) {
                searchList.add(memberAgeSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Member> searchByStudying(boolean searchStudying) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member memberStudying : memberList) {
            if (memberStudying.getisStudying() == searchStudying) {
                searchList.add(memberStudying);
            }
        }
        return searchList;
    }

    public ArrayList<Member> searchByEmail(String searchEmail) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member memberEmailSearch : memberList) {
            if (memberEmailSearch.geteMail().toLowerCase().contains(searchEmail.toLowerCase())) {
                searchList.add(memberEmailSearch);
            }
        }
        return searchList;
    }

    // få nummer på medlem, virker ikke rigtig så

    public String getarraylist(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("Nr. " + (i + 1) + ":");
            System.out.println(memberList.get(i));
        }
        return " ";
    }

    public String searchSvømmeklub(String searchQuery) {
        boolean isPresent = false;
        for (Member member : memberList) {
            if (member.getmemberName().toLowerCase().contains(searchQuery.toLowerCase())) {
                System.out.println(member);
                isPresent = true;
            }
            if (!isPresent) {
                System.out.println("Intet medlem med angivet navn.");
            }
        }
        return " ";
    }

    public boolean isMemberNumberTaken(int newMemberNumber) {
        ArrayList<Integer> memberNumberList = new ArrayList<>();
        try {
            for (Member member : memberList) {
                memberNumberList.add(member.getMemberNumber());
            }

            if (memberNumberList.contains(newMemberNumber)) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException nullPointerException) {
            return false;
        }
    }


    public void printDB() {
        System.out.println("Følgende medlemmer blev fundet: ");
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(i + 1 + ": " + memberList.get(i));
        }
    }

    public boolean checkAndUpdateAge() {
        boolean ageUpdated = false;
        ArrayList<Member> swimList = getSwimList();
        for (Member member : swimList) {
            int memberAge = Period.between(member.getBirthday(), LocalDate.now()).getYears();
            if (memberAge > member.getMemberAge()) {
                member.setMemberAge(memberAge);
                ageUpdated = true;
            }
        }
        return ageUpdated;
    }

    public ArrayList<Member> getSwimList() {
        return memberList;
    }
}
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Svømmeklub {

    ArrayList<Members> memberList = new ArrayList<>();

    public void addMember(String memberName, String activities, String memberShip, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth) {
        memberList.add(new Members(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail, dateOfBirth));
    }

    /*public void addMemberToDatabase(Svømmeklub member) {
        Database.add(member);
    }*/

    /*private static void add(Svømmeklub member) {
    }*/

    public ArrayList<Members> searchByMemberName(String searchName) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members nameSearch : memberList) {
            if (nameSearch.getmemberName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(nameSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Members> searchByActivities(String searchActivity) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members activitySearch : memberList) {
            if (activitySearch.getActivities().toLowerCase().contains(searchActivity.toLowerCase())) {
                searchList.add(activitySearch);
            }
        }
        return searchList;
    }

    public ArrayList<Members> searchByMembership(String searchMembership) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members membershipSearch : memberList) {
            if (membershipSearch.getMembership().toLowerCase().contains(searchMembership.toLowerCase())) {
                searchList.add(membershipSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Members> searchByMemberAge(int searchMemberAge) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members memberAgeSearch : memberList) {
            if (memberAgeSearch.getMemberAge() == searchMemberAge) {
                searchList.add(memberAgeSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Members> searchByStudying(boolean searchStudying) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members memberStudying : memberList) {
            if (memberStudying.getisStudying() == searchStudying) {
                searchList.add(memberStudying);
            }
        }
        return searchList;
    }

    public ArrayList<Members> searchByEmail(String searchEmail) {
        ArrayList<Members> searchList = new ArrayList<>();
        for (Members memberEmailSearch : memberList) {
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
        for (Members member : memberList) {
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


            for (Members member : memberList) {
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
        ArrayList<Members> swimList = getSwimList();
        for (Members member : swimList) {
            int memberAge = Period.between(member.getBirthday(), LocalDate.now()).getYears();
            if (memberAge > member.getMemberAge()) {
                member.setMemberAge(memberAge);
                ageUpdated = true;
            }
        }
        return ageUpdated;
    }

    public ArrayList<Members> getSwimList() {
        return memberList;
    }
}
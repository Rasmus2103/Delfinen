import java.lang.reflect.Member;
import java.util.*;


public class Database {

    ArrayList<Svømmeklub> swimList = new ArrayList<>();

    public void addMember(String memberName, String activities, String memberShip, Date memberAge, boolean isStudying, int memberNumber, String eMail) {
        swimList.add(new Svømmeklub(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail));
    }

    public void addMemberToDatabase(Svømmeklub member) {
        Database.add(member);
    }

    private static void add(Svømmeklub member) {
    }


    public ArrayList<Svømmeklub> getSwimList() {
        return swimList;
    }

    public void setSwimList(ArrayList<Svømmeklub> swimList) {
        this.swimList = swimList;
    }

    public ArrayList<Svømmeklub> searchByMemberName(String searchName) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub nameSearch : swimList) {
            if (nameSearch.getmemberName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(nameSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Svømmeklub> searchByActivities(String searchActivity) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub activitySearch : swimList) {
            if (activitySearch.getActivities().toLowerCase().contains(searchActivity.toLowerCase())) {
                searchList.add(activitySearch);
            }
        }
        return searchList;
    }

    public ArrayList<Svømmeklub> searchByMembership(String searchMembership) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub membershipSearch : swimList) {
            if (membershipSearch.getMembership().toLowerCase().contains(searchMembership.toLowerCase())) {
                searchList.add(membershipSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Svømmeklub> searchByMemberAge(Date searchMemberAge) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub memberAgeSearch : swimList) {
            if (memberAgeSearch.getMemberAge() == searchMemberAge) {
                searchList.add(memberAgeSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Svømmeklub> searchByStudying(boolean searchStudying) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub memberStudying : swimList) {
            if (memberStudying.getisStudying() == searchStudying) {
                searchList.add(memberStudying);
            }
        }
        return searchList;
    }

    public ArrayList<Svømmeklub> searchByEmail(String searchEmail) {
        ArrayList<Svømmeklub> searchList = new ArrayList<>();
        for (Svømmeklub memberEmailSearch : swimList) {
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
            System.out.println(swimList.get(i));
        }
        return " ";
    }

    public String searchSvømmeklub(String searchQuery) {
        boolean isPresent = false;
        for (Svømmeklub member : swimList) {
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


        public void printDB () {
            System.out.println("Følgende medlemmer blev fundet: ");
            for (Svømmeklub s : swimList) {
                System.out.println(s);
            }
        }

}
import java.time.LocalDate;
import java.util.*;


public class Database {

    Svømmeklub svømmeklub = new Svømmeklub();

    public void addMember(String memberName, String activities, String memberShip, int memberAge, boolean isStudying, int memberNumber, String eMail) {
        svømmeklub.addMember(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail);
    }

    public ArrayList<Members> showSwimList() {
        return svømmeklub.getSwimList();
    }

    public ArrayList<Members> getSwimList() {
        return svømmeklub.getSwimList();
    }

    public void removeMember(int number) {
        svømmeklub.memberList.remove(number);
    }

    public ArrayList<Members> searchByMemberName(String searchMemberName) {
        return svømmeklub.searchByMemberName(searchMemberName);
    }

    public ArrayList<Members> searchByActivities(String searchActivity) {
        return svømmeklub.searchByActivities(searchActivity);
    }

    public ArrayList<Members> searchByMembership(String searchMembership) {
        return svømmeklub.searchByMembership(searchMembership);
    }

    public void printDB() {
        System.out.println("Følgende medlemmer er registreret i databasen:");
        for (Members s : svømmeklub.memberList) {
            System.out.println(s);
        }
    }

    public boolean isMemberNumberTaken(int newMemberNumber){
        return svømmeklub.isMemberNumberTaken(newMemberNumber);
    }


    public void setSwimList(ArrayList<Members> memberList) {
        this.svømmeklub.memberList = memberList;
    }

}
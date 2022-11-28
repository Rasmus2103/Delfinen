import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    Svømmeklub svømmeklub = new Svømmeklub();
    FileHandler fileHandler = new FileHandler();

    public void addMember(String memberName, String activities, String memberShip, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth) {
        svømmeklub.addMember(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail, dateOfBirth);
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

    public void loadDB() {
        setSwimList(fileHandler.loadDB());
    }

    public void printDB() {
        svømmeklub.printDB();
    }

    public void saveToDB() {
        fileHandler.saveToDB(svømmeklub.getSwimList());
    }

    public boolean isMemberNumberTaken(int newMemberNumber){
        return svømmeklub.isMemberNumberTaken(newMemberNumber);
    }

    public void setSwimList(ArrayList<Members> memberList) {
        this.svømmeklub.memberList = memberList;
    }

    public boolean checkAndUpdateAge (){
        return svømmeklub.checkAndUpdateAge();
    }
}

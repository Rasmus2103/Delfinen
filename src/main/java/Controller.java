import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();

    FileHandler fileHandler = new FileHandler();


    public void addMember(String memberName, String activities, String memberShip, LocalDate memberAge, boolean isStudying, int memberNumber, String eMail) {
        database.addMember(memberName, activities, memberShip, memberAge, isStudying, memberNumber, eMail);
    }

    public ArrayList<Svømmeklub> showSwimList() {
         return getSwimList();
    }

    public ArrayList<Svømmeklub> getSwimList() {
        return database.getSwimList();
    }

    public void removeMember(int number) {
        database.swimList.remove(number);
    }

    public ArrayList<Svømmeklub> searchByName(String searchMemberName) {
        return database.searchByMemberName(searchMemberName);
    }

    public ArrayList<Svømmeklub> searchByActivities(String searchActivity) {
        return database.searchByActivities(searchActivity);
    }

    public ArrayList<Svømmeklub> searchByMembership(String searchMembership) {
        return database.searchByMembership(searchMembership);
    }


    public void loadDB() {
        database.setSwimList(fileHandler.loadDB());
    }

    public void printDB() {
        database.printDB();
    }

    public void saveToDB() {
        fileHandler.saveToDB(database.getSwimList());
    }

}

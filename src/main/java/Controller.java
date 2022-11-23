import java.util.ArrayList;
import java.util.Date;

public class Controller {
    Database database = new Database();

    FileHandler fileHandler = new FileHandler();


    public void addMember(String memberName, String activities, String memberShip, Date memberAge, boolean isStudying, int memberNumber, String eMail) {
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

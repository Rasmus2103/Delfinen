import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    Svømmeklub svømmeklub = new Svømmeklub();
    FileHandler fileHandler = new FileHandler();

    public void addMember(String memberName, boolean activities, String memberShip, ArrayList<String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth) {
        svømmeklub.addMember(memberName, activities, memberShip, swimDiscipline, memberAge, isStudying, memberNumber, eMail, dateOfBirth);
    }

    public ArrayList<Member> showSwimList() {
        return svømmeklub.getSwimList();
    }

    public ArrayList<Member> getSwimList() {
        return svømmeklub.getSwimList();
    }

    public void removeMember(int number) {
        svømmeklub.memberList.remove(number);
    }

    public ArrayList<Member> searchByMemberName(String searchMemberName) {
        return svømmeklub.searchByMemberName(searchMemberName);
    }

    public ArrayList<Member> searchByActivities(boolean searchActivity) {
        return svømmeklub.searchByActivities(searchActivity);
    }

    public ArrayList<Member> searchByMembership(String searchMembership) {
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

    public boolean isMemberNumberTaken(int newMemberNumber) {
        return svømmeklub.isMemberNumberTaken(newMemberNumber);
    }

    public void setSwimList(ArrayList<Member> memberList) {
        this.svømmeklub.memberList = memberList;
    }

    public boolean checkAndUpdateAge () {
        return svømmeklub.checkAndUpdateAge();
    }

    public void createJuniorTeam() {
        svømmeklub.createJuniorTeam();
    }

    public void createSeniorTeam() {
        svømmeklub.createSeniorTeam();
    }

    public void addTeamJunior() {
        svømmeklub.addTeamJunior();
    }

    /*public void addTeamSenior() {
        svømmeklub.addTeamSenior();
    }*/



    public ArrayList<Member> getJuniorList() {
        return svømmeklub.getJuniorList();
    }

    public ArrayList<Member> getSeniorList() {
        return svømmeklub.getSeniorList();
    }
    public boolean addSwimDiscipline(ArrayList<String> swimDiscipline, String discipline){
        return svømmeklub.addSwimDiscipline(swimDiscipline, discipline);
    }

    public void addTræningsResultatJunior(TræningsResultat resultat){
        svømmeklub.addTræningsResultatJunior(resultat);
    }
    public void addTræningsResultatSenior(TræningsResultat resultat){
        svømmeklub.addTræningsResultatSenior(resultat);
    }

    public void addStævneResultatJunior(StævneResultat resultat){
        svømmeklub.addStævneResultatJunior(resultat);
    }
    public void addStævneResultatSenior(StævneResultat resultat){
        svømmeklub.addStævneResultatSenior(resultat);
    }

    public boolean verifySwimDiscipline (String discipline) {
        return svømmeklub.verifySwimDiscipline(discipline);

    }
}

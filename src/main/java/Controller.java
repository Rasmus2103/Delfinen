import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    SwimClub swimClub = new SwimClub();
    FileHandler fileHandler = new FileHandler();

    public void addMember(String memberName, boolean activities, String memberShip, ArrayList<String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth /*int subsription*/) {
        swimClub.addMember(memberName, activities, memberShip, swimDiscipline, memberAge, isStudying, memberNumber, eMail, dateOfBirth /*subsription*/);
    }

    public ArrayList<Member> showMemberList() {
        return swimClub.getSwimList();
    }

    public ArrayList<Member> getMemberList() {
        return swimClub.getSwimList();
    }

    public void removeMember(int number) {
        swimClub.memberList.remove(number);
    }

    public ArrayList<Member> searchByMemberName(String searchMemberName) {
        return swimClub.searchByMemberName(searchMemberName);
    }

    public ArrayList<Member> searchByActivities(boolean searchActivity) {
        return swimClub.searchByActivities(searchActivity);
    }

    public ArrayList<Member> searchByMembership(String searchMembership) {
        return swimClub.searchByMembership(searchMembership);
    }

    public void loadDB() {
        setSwimList(fileHandler.loadDB());
    }

    public void printDB() {
        swimClub.printDB();
    }

    public void saveToDB() {
        fileHandler.saveToDB(swimClub.getSwimList());
    }

    public boolean isMemberNumberTaken(int newMemberNumber) {
        return swimClub.isMemberNumberTaken(newMemberNumber);
    }

    public void setSwimList(ArrayList<Member> memberList) {
        this.swimClub.memberList = memberList;
    }

    public boolean checkAndUpdateAge () {
        return swimClub.checkAndUpdateAge();
    }

    public void createJuniorTeam() {
        swimClub.createJuniorTeam();
    }

    public void createSeniorTeam() {
        swimClub.createSeniorTeam();
    }

    /*public void addTeamJunior() {
        svømmeklub.addTeamJunior();
    }*/

    /*public void addTeamSenior() {
        svømmeklub.addTeamSenior();
    }*/



    public ArrayList<Member> getJuniorList() {
        return swimClub.getJuniorList();
    }

    public ArrayList<Member> getSeniorList() {
        return swimClub.getSeniorList();
    }
    public boolean addSwimDiscipline(ArrayList<String> swimDiscipline, String discipline){
        return swimClub.addSwimDiscipline(swimDiscipline, discipline);
    }

    public void addTrainingResultsJunior(TrainingResults resultat){
        swimClub.addTrainingResultsJunior(resultat);
    }
    public void addTrainingResultsSenior(TrainingResults resultat){
        swimClub.addTrainingResultsSenior(resultat);
    }

    public void addCompetitorResultsJunior(CompetitorResults resultat){
        swimClub.addCompetitorResultsJunior(resultat);
    }
    public void addCompetitorResultsSenior(CompetitorResults resultat){
        swimClub.addCompetitorResultsSenior(resultat);
    }

    public ArrayList<TrainingResults> trainingListJunior() {
        return swimClub.trainingListJunior();
    }

    public ArrayList<CompetitorResults> competitorListJunior() {
        return swimClub.competitorListJunior();
    }

    public ArrayList<TrainingResults> trainingsListSenior() {
        return swimClub.trainingListSenior();
    }

    public ArrayList<CompetitorResults> competitorListSenior() {
        return swimClub.competitorListSenior();
    }

    public boolean verifySwimDiscipline (String discipline) {
        return swimClub.verifySwimDiscipline(discipline);
    }

    public int totalSubsription() {
        return swimClub.totalSubsription();
    }
}

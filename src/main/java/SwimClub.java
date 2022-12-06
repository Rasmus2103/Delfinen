import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SwimClub {

    //TODO lav memberlist private
    ArrayList<Member> memberList = new ArrayList<>();
    private JuniorTeam juniorTeam;
    private SeniorTeam seniorTeam;

    Member member;


    public void addMember(String memberName, boolean activities, String memberShip, ArrayList<String> swimDiscipline, int memberAge, boolean isStudying, int memberNumber, String eMail, LocalDate dateOfBirth) {
        member = new Member(memberName, activities, memberShip, swimDiscipline, memberAge, isStudying, memberNumber, eMail, dateOfBirth);
        memberList.add(member);
        //addTeamJunior();
    }

    public SwimClub() {
        juniorTeam = new JuniorTeam();
        seniorTeam = new SeniorTeam();
        //createJuniorTeam();
    }

    /*public void createJuniorTeam(Coach coach) {
        juniorTeam = new JuniorTeam(coach);
    }*/

    public void createJuniorTeam() {
        for (Member m: memberList) {
            if(m.getActivity() == true && m.getMemberAge() < 18) {
                juniorTeam.add(m);
            }
        }
    }

    public void createSeniorTeam() {
        for (Member m: memberList) {
            if(m.getActivity() == true && m.getMemberAge() > 18) {
                seniorTeam.add(m);
            }
        }
    }

    /*public void addTeamJunior() {

        try {
            for (Member m: memberList) {
                if(member.getMemberAge() < 18) {
                    juniorTeam.add(m);
                } else {
                    seniorTeam.add(m);
                }
            }
        } catch (NullPointerException npe) {
        }*/

        /*try {
            if (member.getMemberAge() < 18) {
                System.out.println("Kom nu!");
                juniorTeam.add(member);
                System.out.println(juniorTeam.getJuniorMembers());
            }
        } catch (NullPointerException npe) {

        }*/

    /*public void addTeamSenior() {
        seniorTeam.addTeammemberSenior(member);
    }*/

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
            if (activitySearch.getActivity() == searchActivity) {
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

    public void initJuniorList() {

    }

    public ArrayList<Member> getSwimList() {
        return memberList;
    }

    public ArrayList<Member> getJuniorList() {
        return juniorTeam.getJuniorMembers();
    }

    public ArrayList<Member> getSeniorList() {
        return seniorTeam.getSeniorMembers();
    }

    public boolean addSwimDiscipline(ArrayList<String> swimDiscipline, String discipline){
        String disciplineUpperCase = discipline.toUpperCase();
        boolean swimDisciplineAdded = false;
        for (SwimDisciplines enumDiscipline: SwimDisciplines.values()){
            if (enumDiscipline.toString().equals(disciplineUpperCase)){
               if (!swimDiscipline.contains(disciplineUpperCase)){
                   swimDiscipline.add(disciplineUpperCase);
                   swimDisciplineAdded = true;
               }
            }
        }
        return swimDisciplineAdded;
    }

    public boolean verifySwimDiscipline(String discipline){
        String disciplineUpperCase = discipline.toUpperCase();
        boolean swimDisciplineAdded = false;
        for (SwimDisciplines enumDiscipline: SwimDisciplines.values()){
            if (enumDiscipline.toString().equals(disciplineUpperCase)) {
                swimDisciplineAdded = true;
            }
        }
        return swimDisciplineAdded;
    }

    public void addTrainingResultsJunior(TrainingResults resultat) {
        juniorTeam.addTræningsResultat(resultat);
    }
    public void addTrainingResultsSenior(TrainingResults resultat) {
        seniorTeam.addTræningsResultat(resultat);
    }


    public void addCompetitorResultsJunior(CompetitorResults resultat) {
        juniorTeam.addStævneResultat(resultat);
    }
    public void addCompetitorResultsSenior(CompetitorResults resultat) {
        seniorTeam.addStævneResultat(resultat);
    }

    public ArrayList<TrainingResults> trainingListJunior() {
        return juniorTeam.getTrainingResults();
    }

    public ArrayList<CompetitorResults> competitorListJunior() {
        return juniorTeam.getCompetitorResults();
    }

    public ArrayList<TrainingResults> trainingListSenior() {
        return seniorTeam.getTrainingResults();
    }

    public ArrayList<CompetitorResults> competitorListSenior() {
        return seniorTeam.getCompetitorResults();
    }



    //Beregn kontingenten
    public int calculateRate() {
        int Income = 0;

        for (Member member : memberList) {
            Income += member.getMemberRate();
        }
        return Income;
    }
}
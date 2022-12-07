import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Scanner sc = new Scanner(System.in);

    Controller controller = new Controller();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    Coach coachJunior = new Coach("Børge");
    Coach coachSenior = new Coach("Jens");

    public void start() {
        controller.loadDB();
        controller.createJuniorTeam();
        controller.createSeniorTeam();
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("Vælg udfra hvilken rolle du har i klubben");

        if (controller.checkAndUpdateAge())
            System.out.println("\u001B[31m"+ "Alder på medlem er blevet opdateret HUSK at gemme! " + "\u001B[0m");

        int userChoice = 0;
        while(userChoice != 9) {
            System.out.println("""
                    1. Formand
                    2. Træner
                    3. Kasserer
                    9. Forlad programmet
                    """);
            userChoice = readInt();
            switch(userChoice) {
                case 1:
                    formand();
                    break;
                case 2:
                    coach();
                    break;
                case 3:
                    cashier();
                    break;
                case 9:
                    System.out.println("Lukker for systemet");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt. Indtast det");
                    break;
            }
        }
    }

    public void cashier() {
        System.out.println("Velkommen Kasser \nVælg en af følgende muligheder her");
        int userChoice = 0;

        while(userChoice != 9) {
            System.out.println("""
                    1. Registrer betaling
                    2. Se samlet kontigentbetaling
                    9. Tilbage til hovedmenuen
                    """);
            userChoice = readInt();
            switch (userChoice) {
                case 1:
                    registerPayment();
                    break;
                case 2:
                    totalSubscription();
                    break;
                case 9:
                    //start();
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af følgende tal");
                    break;
            }
        }
    }

    private void totalSubscription() {
        System.out.println(controller.totalHasNotPaid() + " så mange penge mangler medlemmerne at betale.");
        System.out.println(controller.totalSubsription() + " kr. ville den forventet betaling være.");
    }


    private void coach() {
        System.out.println("Velkommen Træner \nVælg en af følgende muligheder her");
        int userChoice = 0;

        while(userChoice != 9) {
            System.out.println("""
                    1. Børge (Juniorholdet)
                    2. Jens (Seniorholdet)
                    9. Tilbage til hovedmenuen
                    """);
            userChoice = readInt();
            switch (userChoice) {
                case 1:
                    coachJunior();
                    break;
                case 2:
                    coachSenior();
                    break;
                case 9:
                    //start();
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af følgende tal");
                    break;
            }
        }
    }

    public void coachJunior() {
        System.out.println("Velkommen " + coachJunior.getName() + " til Juniorholdet \nVælg en af følgende valgmuligheder");
        int userChoice = 0;

        while(userChoice != 9) {
            System.out.println("""
                    1. Se alle holdmedlemmer
                    2. Registering af træningsresultat
                    3. Registering af stævneresultat
                    4. Se alle træningstider
                    5. Se alle stævneresultater
                    6. Se top 5 fra hver disciplin
                    9. Tilbage til menuen
                    """);
            userChoice = readInt();
            switch(userChoice) {
                case 1:
                    seeMembersJunior();
                    break;
                case 2:
                    addTrainingResultJunior();
                    break;
                case 3:
                    addCompetitorResultJunior();
                    break;
                case 4:
                    seeTrainingJunior();
                    break;
                case 5:
                    seeCompetitorJunior();
                    break;
                case 6:
                    break;
                case 9:
                    coach();
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af følgende tal");
                    break;
            }
        }
    }

    public void seeMembersJunior() {
        System.out.println("Følgende medlemmer på Juniorholdet");
        System.out.println(controller.getJuniorList().size());
        for(int i = 0; i < controller.getJuniorList().size(); i++) {
            System.out.println(controller.getJuniorList().get(i));
        }
    }

    public void seeTrainingJunior() {
        for (int i = 0; i < controller.trainingListJunior().size(); i++) {
            System.out.println(controller.trainingListJunior().get(i));
        }
    }

    public void seeCompetitorJunior() {
        for (int i = 0; i < controller.competitorListJunior().size(); i++) {
            System.out.println(controller.trainingListJunior().get(i));
        }
    }

    public void addTrainingResultJunior(){

        try {
            TrainingResults trainingResults = getTrainingResults();

            controller.addTrainingResultsJunior(trainingResults);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

    }

    public void addTrainingResultSenior(){

        try {
            TrainingResults trainingResults = getTrainingResults();

            controller.addTrainingResultsSenior(trainingResults);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

    }


    public void addCompetitorResultJunior(){

        try {
            CompetitorResults competitorResults = getCompetitorResults();

            controller.addCompetitorResultsJunior(competitorResults);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

    }

    public void addCompetitorResultSenior(){

        try {
            CompetitorResults competitorResults = getCompetitorResults();

            controller.addCompetitorResultsSenior(competitorResults);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

    }


    private TrainingResults getTrainingResults() {
        System.out.println(" ");
        System.out.println("Du ønsker at registrer et resultat \nStart med at skrive resultatet (tt:mm:ss)");
        String resultat = sc.nextLine();
        System.out.println("Du har registreret følgende resultat: " + resultat);
        System.out.println(" ");

        System.out.println("Vælg hvilken svømme disciplin du ønsker (Crawl, Rygcrawl, Butterfly, Brystsvømning)");
        String chosenDiscipline = sc.nextLine();
        while (!controller.verifySwimDiscipline(chosenDiscipline)) {
            System.out.println("Du har forsøgt at indtaste et ikke eksisternde aktivitet prøve igen");
            chosenDiscipline = sc.nextLine();
        }

        System.out.println("Indtast resultat (dd-MM-yyyy)");
        String dateString = sc.nextLine();
        LocalDate dateOfResult;
        try {
            dateOfResult = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Du skal sørge for at indtaste i det rigtige format, dd-MM-yyyy");
            dateString = sc.nextLine();
            dateOfResult = LocalDate.parse(dateString, formatter);
        }
        System.out.println("Indtast et medlems navn");
        String memberName = sc.nextLine();
        TrainingResults træningsResultat = new TrainingResults(resultat, chosenDiscipline, dateOfResult, memberName);
        return træningsResultat;
    }

    private CompetitorResults getCompetitorResults() {
        System.out.println(" ");
        System.out.println("Du ønsker at registrer et resultat \nStart med at skrive resultatet");
        String result = sc.nextLine();
        System.out.println("Du har registreret følgende resultat: " + result);
        System.out.println(" ");

        System.out.println("Vælg hvilken svømme disciplin du ønsker");
        String chosenDiscipline = sc.nextLine();
        while (!controller.verifySwimDiscipline(chosenDiscipline)) {
            System.out.println("Du har forsøgt at indtaste et ikke eksisternde aktivitet prøve igen");
            chosenDiscipline = sc.nextLine();
        }

        System.out.println("Indtast resultat dato");
        String dateString = sc.nextLine();
        LocalDate dateOfResult;
        try {
            dateOfResult = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Du skal sørge for at indtaste i det rigtige format, dd-MM-yyyy");
            dateString = sc.nextLine();
            dateOfResult = LocalDate.parse(dateString, formatter);
        }
        System.out.println("Indtast et medlems navn");
        String memberName = sc.nextLine();
        CompetitorResults competitorResults = new CompetitorResults(result, chosenDiscipline, dateOfResult, memberName);
        return competitorResults;
    }

    private void coachSenior() {
        System.out.println("Velkommen " + coachSenior.getName() + "til Seniorholdet \nVælg en af følgende valgmuligheder");
        //controller.createSeniorTeam(coachSenior);
        //controller.addTeamSenior();
        int userChoice = 0;

        while(userChoice != 9) {
            System.out.println("""
                    1. Se alle holdmedlemmer
                    2. Registering af træningsresultat
                    3. Registering af stævneresultat
                    4. Se alle træningstider
                    5. Se alle stævneresultater
                    6. Se top 5 fra hver disciplin
                    9. Tilbage til menuen
                    """);
            userChoice = readInt();
            switch(userChoice) {
                case 1:
                    seeMembersSenior();
                    break;
                case 2:
                    addTrainingResultSenior();
                    break;
                case 3:
                    addCompetitorResultSenior();
                    break;
                case 4:
                    seeTrainingSenior();
                    break;
                case 5:
                    seeCompetitorSenior();
                    break;
                case 6:
                    break;
                case 9:
                    coach();
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af følgende tal");
                    break;
            }
        }
    }

    public void seeMembersSenior() {
        System.out.println("Følgende medlemmer på Seniorholdet");
        System.out.println(controller.getSeniorList().size());
        for(int i = 0; i < controller.getSeniorList().size(); i++) {
            System.out.println(controller.getSeniorList().get(i));
        }
    }

    public void seeTrainingSenior() {
        for (int i = 0; i < controller.trainingsListSenior().size(); i++) {
            System.out.println(controller.trainingsListSenior().get(i));
        }
    }

    public void seeCompetitorSenior() {
        for (int i = 0; i < controller.competitorListSenior().size(); i++) {
            System.out.println(controller.competitorListSenior().get(i));
        }
    }

    public void formand() {
        System.out.println("Velkommen Formand, vælg en af følgende muligheder her");
        int userChoice = 0;

        try {
            while (userChoice != 9) {
                System.out.println("""
                        1. Registrer et medlem
                        2. Se alle medlemmer
                        3. Ændrer oplysninger om et medlem
                        4. Slet et medlem
                        5. Gem alle medlemmer
                        9. Tilbage til hovedmenuen
                        """);
                userChoice = readInt();
                switch (userChoice) {
                    case 1:
                        addMemberToDatabase();
                        break;
                    case 2:
                        controller.printDB();
                        break;
                    case 3:
                        editMember();
                        break;
                    case 4:
                        removeMember();
                        break;
                    case 5:
                        controller.saveToDB();
                        break;
                    case 9:
                        //start();
                        break;
                    default:
                        System.out.println("Dit input er ikke gyldigt, indtast et af de følgende tal");
                        break;
                }
            }
        } catch(NullPointerException npe) {

        }
    }

    public void addMemberToDatabase() {

        try {
            System.out.println(" ");
            System.out.println("Du ønsker at registrer et medlem i klubben \nStart med at skrive navnet på medlemmet");
            String memberName = sc.nextLine();
            System.out.println("Du har registreret følgende navn: " + memberName);
            System.out.println(" ");

            System.out.println("Skriv et medlemsnummer");
            int memberNumber = readInt();
            while (controller.isMemberNumberTaken(memberNumber)){
                System.out.println("Dette nummer er dsv ikke tilgængeligt, prøv et andet");
                memberNumber = readInt();
            }

            System.out.println("Du har registreret at medlemmets har medlems nr: " + memberNumber + ".");
            System.out.println(" ");

            System.out.println("Vælg hvad for en aktivitetsform medlemmet ønsker \nMedlemmet kan enten være (1)Konkurrencesvømmer eller (2)Motionistsvømmer");
            boolean activity = false;
            switch (readInt()) {
                case 1:
                    activity = true;
                    System.out.println("Du har sagt at medlemmet er Konkurrencesvømmer");
                    System.out.println(" ");
                    break;
                case 2:
                    activity = false;
                    System.out.println("Du har sagt at medlemmet er Motionistsvømmer");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, indtast et af de gyldige numre");
                    System.out.println(" ");
                    break;
            }

            System.out.println("Vælg hvad for en medlemskab medlemmet ønsker \nEt medlem kan enten have et aktivt eller passivt medlemsskab");
            String membership = sc.nextLine();
            System.out.println("Du registreret at medlemmet har et: " + membership + " medlemsskab");
            System.out.println(" ");

            System.out.println("Vælg hvilken svømme disciplin du ønsker");
            ArrayList<String> swimDiscipline = new ArrayList<>();
            String chosenDiscipline = sc.nextLine();
            while (!controller.addSwimDiscipline(swimDiscipline,chosenDiscipline)) {
                System.out.println("Du har forsøgt at indtaste et ikke eksisternde aktivitet prøve igen");
                chosenDiscipline = sc.nextLine();
            }

            System.out.println("Du har tilføjet " + chosenDiscipline);

            int stillAddingDisciplines = 1;
            while (stillAddingDisciplines == 1) {
                System.out.println("Ønsker du at indtaste flere discipliner? ");
                System.out.println("Indtast disciplin eller indtast 0 for at gå videre");
                String disciplineToAdd = sc.nextLine();

                if (disciplineToAdd.equals("0")) {
                    stillAddingDisciplines = 0;
                } else if (controller.addSwimDiscipline(swimDiscipline, disciplineToAdd)){
                    System.out.println("Du har tilføjet " + disciplineToAdd);
                }
                else {
                    System.out.println("Du har forsøgt at indtaste et ikke eksisternde aktivitet prøve igen");
                }
            }
            System.out.println("Indtast medlemmets fødselsdags dato");
            String bDay = sc.nextLine();
            LocalDate dateOfBirth;
            int memberAge;
            try {
                 dateOfBirth = LocalDate.parse(bDay, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Du skal sørge for at indtaste i det rigtige format, dd-MM-yyyy");
                bDay = sc.nextLine();
                dateOfBirth = LocalDate.parse(bDay, formatter);
            }
            memberAge = Period.between(LocalDate.parse(bDay, formatter), LocalDate.now()).getYears();

            System.out.println("Du har registreret medlemmets fødselsdato er: " + bDay);
            System.out.println(" ");


            System.out.println("Erklær om medlemmet er studerende eller ej \nTast 1 for studerende \nTast 2 for ikke studerende");
            boolean isStudying = false;
            switch (readInt()) {
                case 1:
                    isStudying = true;
                    System.out.println("Du har erklæret at medlemmet er studerende");
                    System.out.println(" ");
                    break;
                case 2:
                    isStudying = false;
                    System.out.println("Du har erklæret at medlemmet ikke er studerende");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Dit input er ikke gyldigt, Skriv enten 1 eller 2");
                    System.out.println(" ");
                    break;
            }

            System.out.println("Indtast medlemmets email adresse");
            String eMail = sc.nextLine();
            System.out.println("Du har registreret at medlemmets email adresse er: " + eMail);
            System.out.println(" ");

            controller.addMember(memberName, activity, membership,swimDiscipline, memberAge, isStudying, memberNumber, eMail, dateOfBirth);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void editMember() {
        try {
            System.out.println("Vælg et medlem du ønsker at redigere i (Vælg ved at indtaste position på listen): ");
            for (int i = 0; i < controller.getMemberList().size(); i++) {
                System.out.println(i + 1 + ":" + controller.getMemberList().get(i));
            }
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.nextLine();

            Member editMember = controller.getMemberList().get(number - 1);
            System.out.println("Du er igang med at redigere i " + editMember);

            //Ændring af medlemmets navn
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getmemberName());
            String memberNewName = sc.nextLine();
            if (!memberNewName.isEmpty())
                editMember.setmemberName(memberNewName);

            //Ændring af medlemmets aktivitetsform
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere om medlemmet er Konkurrencesvømmer eller Motionistsvømmer: " +
                    "\nTast 1 og tryk ENTER hvis medlemmet er Konkurrencesvømmer. " +
                    "\nTast 2 og tryk ENTER hvis medlemmet er Motionistsvømmer" +
                    "\nTast 3 og tryk ENTER hvis der ikke skal redigeres");
            int memberCompetitorOrNot = readInt();
            if (memberCompetitorOrNot == 1) {
                editMember.setActivity(true);
            } else if (memberCompetitorOrNot == 2) {
                editMember.setActivity(false);
            } else if (memberCompetitorOrNot == 3) {
                System.out.println("Ingen videre ændring");
            } else {
                System.out.println("Input ikke gyldigt, der er ikke sket en ændring");
            }

            //Ændring af medlemmets medlemsskab
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getMembership());
            String memberNewMembership = sc.nextLine();
            if (!memberNewMembership.trim().isEmpty())
                editMember.setMembership(memberNewMembership);

            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.getBirthday());
            String newbDay = sc.nextLine();
            if(!newbDay.isEmpty()) {
                LocalDate newDateOfBirth;
                try {
                    int newMemberAge = Period.between(LocalDate.parse(newbDay, formatter), LocalDate.now()).getYears();
                    newDateOfBirth = LocalDate.parse(newbDay, formatter);
                    editMember.setBirthday(newDateOfBirth);
                    editMember.setMemberAge(newMemberAge);
                } catch (DateTimeParseException e) {
                    System.out.println("Du skal sørge for at indtaste i det rigtige format, dd-MM-yyyy");
                }
            }

            //Ændring om medlemmet studerer eller ej
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere om medlemmet er studerende eller ikke studerende: " +
                    "\nTast 1 og tryk ENTER hvis medlemmet er studerende. " +
                    "\nTast 2 og tryk ENTER hvis medlemmet ikke er studerende" +
                    "\nTast 3 og tryk ENTER hvis der ikke skal redigeres");
            int memberStudyingOrNot = readInt();
            if (memberStudyingOrNot == 1) {
                editMember.setisStudying(true);
            } else if (memberStudyingOrNot == 2) {
                editMember.setisStudying(false);
            } else if (memberStudyingOrNot == 3) {
                System.out.println("Ingen videre ændring");
            } else {
                System.out.println("Input ikke gyldigt, der er ikke sket en ændring");
            }

            //Ændring af medlemmets email adresse
            System.out.println("Indtast den ønskede data, og tryk Enter. Hvis du ikke ønsker at redigere tast 0");
            System.out.println("Du er igang med at redigere: " + editMember.geteMail());
            String memberNewEmail = sc.nextLine();
            if (!memberNewEmail.trim().isEmpty())
                editMember.seteMail(memberNewEmail);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Der findes ikke et medlem med det nummer");
            editMember();
        }
    }

    public void registerPayment() {
        System.out.println("Vælg et medlem du ønsker at fortage betaling for (Vælg ved at indtaste position på listen): ");
        for (int i = 0; i < controller.getMemberList().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMemberList().get(i));
        }
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();

        Member editMember = controller.getMemberList().get(number - 1);
        System.out.println("Du er igang med at redigere i " + editMember);

        editMember.setHasPaid();
    }

    public void removeMember() {
        try {
            for (int i = 0; i < controller.getMemberList().size(); i++) {
                System.out.println(i + ":" + controller.showMemberList().get(i));
            }
            System.out.println("Vælg det medlem du ønsker at slette ud fra deres medlemsnummer");
            int number = readInt();

            controller.removeMember(number);

            System.out.println("Du har slettet medlem nr. " + number + " fra databasen");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Der er ingen medlemmer med dette nummer \n Vender tilbage til hovedmenuen");
        }
    }


    private int readInt() {

        boolean validateInt = true;
        int integer = 0;

        do {
            try {
                integer = sc.nextInt();
                validateInt = false;
                sc.nextLine();

            } catch (Exception e) {
                System.out.println("Din input er ikke gyldig \nVær sød at prøve igen.");
                sc.nextLine();
            }
        }
        while (validateInt);
        return integer;
    }

}

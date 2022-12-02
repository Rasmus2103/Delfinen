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
        //controller.createJuniorTeam(coachJunior);
        controller.addTeamJunior();
        int userChoice = 0;

        while(userChoice != 9) {
            System.out.println("""
                    1. Se alle holdmedlemmer
                    2. Registering af træningsresultat
                    3. Registering af stævneresultat
                    4. Se top 5 fra hver disciplin
                    9. Tilbage til menuen
                    """);
            userChoice = readInt();
            switch(userChoice) {
                case 1:
                    seeMembersJunior();
                    break;
                case 2:
                    break;
                case 3:
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
                    4. Se top 5 fra hver disciplin
                    9. Tilbage til menuen
                    """);
            userChoice = readInt();
            switch(userChoice) {
                case 1:
                    seeMembersSenior();
                    break;
                case 2:
                    break;
                case 3:
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
            System.out.println("addMember");

            controller.addMember(memberName, activity, membership, memberAge, isStudying, memberNumber, eMail, dateOfBirth);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void editMember() {
        try {
            System.out.println("Vælg et medlem du ønsker at redigere i (Vælg ved at indtaste position på listen): ");
            for (int i = 0; i < controller.getSwimList().size(); i++) {
                System.out.println(i + 1 + ":" + controller.getSwimList().get(i));
            }
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.nextLine();

            Member editMember = controller.getSwimList().get(number - 1);
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

    public void removeMember() {
        try {
            for (int i = 0; i < controller.getSwimList().size(); i++) {
                System.out.println(i + ":" + controller.showSwimList().get(i));
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

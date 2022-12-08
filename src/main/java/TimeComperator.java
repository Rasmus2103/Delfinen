import java.util.Comparator;

public class TimeComperator implements Comparator<CompetitorResults>{
        public int compare(CompetitorResults c1, CompetitorResults c2) {
            return c1.getResult().compareTo(c2.getResult());
        }
}

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class SocialMediaTimes {
    public static void main(String[] args){
        System.out.println("Please,type date like yyyy-MM-dd HH:mm:ss");

        String date = new Scanner(System.in).nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(date,formatter);
        System.out.println(formatter.format(LocalDateTime.now()));

        System.out.println(formatLikeSocialMediaTime(from));
    }

    public static String formatLikeSocialMediaTime(LocalDateTime from) {
        LocalDateTime to = LocalDateTime.now();
        Duration duration = Duration.between(from, to);

        long diffInMinutes = duration.toMinutes();
        long diffInHours = duration.toHours();
        long diffInDays = duration.toDays();

        if (diffInDays > 7) {
            return from.getDayOfMonth() + " " + from.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        } else if (diffInDays > 0 && diffInDays <= 7) {
            return diffInDays != 1 ? diffInDays + " days ago" : diffInDays + " day ago";
        } else if (diffInHours > 0) {
            return diffInHours != 1 ? diffInHours + " hours ago" : diffInHours + " hour ago";
        } else if (diffInMinutes > 0) {
            return diffInMinutes != 1 ? diffInMinutes + " minutes ago" : diffInMinutes + " minute ago";
        } else {
            return "Just now";
        }

    }

}

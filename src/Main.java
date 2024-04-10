import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("D://ipv4q.txt");
        boolean filecreated = false;
        try (FileWriter writer = new FileWriter("D://ipv4q.txt")){
            filecreated = file.createNewFile();
            String text = "что делаешь 142.254.111.221 как дела";
            Pattern pattern = Pattern.compile("(([1-9]\\d\\d|2[0-4]\\d|25[0-5]|\\d)\\.){3}(//d|[1-9]\\d\\d|2[0-4]\\d|25[0-5])");
            Matcher ipv4 = pattern.matcher(text);
            if (ipv4.find()) {
                writer.write(ipv4.group());
            }
            else {
                writer.write("Не нашло");
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }
}
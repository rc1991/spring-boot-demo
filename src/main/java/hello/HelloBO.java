package hello;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelloBO {

    private String content;

    public HelloBO(String name) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateString = format.format(new Date());
        content = String.format("Hello %s. It is now %s", name, dateString);
    }

    public String getContent() {
        return content;
    }
}

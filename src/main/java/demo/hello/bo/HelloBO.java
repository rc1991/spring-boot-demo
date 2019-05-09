package demo.hello.bo;
import demo.hello.po.DemoPO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelloBO {

    private String greeting;
    private List<DemoPO> content;

    public HelloBO(String name, List<DemoPO> list) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateString = format.format(new Date());
        greeting = String.format("Hello %s. It is now %s", name, dateString);
        content = list;
    }

    public String getGreeting() {
        return greeting;
    }

    public List<DemoPO> getContent() {
        return content;
    }
}

package hello.po;
import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoPO {
    @Id
    private String id;

    private String name;
    private Date createTime;
    private Date updateTime;


    public DemoPO(String name){
        this.name = name;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @Override
    public String toString(){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("DemoPO[name:%s, createTime:%s, updateTime:%s]",
                this.name,
                format.format(this.createTime),
                format.format(this.updateTime));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updateTime = new Date();
    }
}

package demo.hello.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Document(collection="demo")
public class DemoPO implements Persistable<String> {
    @Id
    private String id;

    private String name;

    private Date createTime;
    private Date updateTime;


    public DemoPO(String name){
        this.name = name;
        createTime = new Date();
        updateTime = new Date();
    }

    @Override
    public String toString(){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return String.format("Demo[name:%s, createTime:%s, updateTime:%s]",
                this.name,
                format.format(this.createTime),
                format.format(this.updateTime));
    }
    @Override
    public boolean isNew() {
        return false;
    }

    @Override
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
        updateTime = new Date();
    }
}

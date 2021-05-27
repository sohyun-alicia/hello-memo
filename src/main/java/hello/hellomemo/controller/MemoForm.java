package hello.hellomemo.controller;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MemoForm {

    private String name;

    private String data;

    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime(Timestamp time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(time.getTime());
    }

    public void setTime(String time) { this.time = time; }
}

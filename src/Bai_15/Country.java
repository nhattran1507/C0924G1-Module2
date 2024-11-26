package Bai_15;

import java.io.Serializable;

public class Country implements Serializable {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Country{id=" + id + ", code='" + code + "', name='" + name + "'}";
    }
    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}


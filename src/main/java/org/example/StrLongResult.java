package org.example;

public class StrLongResult {
    private long id;
    private String str;

    public StrLongResult(String str, long id){
        this.id = id;
        this.str = str;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

package com.example.duihua;



public class JavaBean {
    private String neirong;
    private String time;
    public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "JavaBean [neirong=" + neirong + ", time=" + time + "]";
    }


}

package com.bawei.lvwenjing.week03text;

/**
 * Created by lenovo-pc on 2017/5/21.
 */

public class Beans {
    private String course_name;
    private String course_price;

    public Beans(String course_name, String course_price) {
        this.course_name = course_name;
        this.course_price = course_price;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

}

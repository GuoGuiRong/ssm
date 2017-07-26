package com.ggr.ssm.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ggr.ssm.web.converter.DateJsonSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by GuiRunning on 2017/7/25.
 */
public class User implements Serializable {

    private String id;
    private String name;
    @Max(value = 100)
    @Min(value = 14)
    private Integer age;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public User(){}
    public User(String id,String name,Integer age){
        this.id=id;
        this.name=name;
        this.age=age;
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
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @JsonSerialize(using = DateJsonSerializer.class)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

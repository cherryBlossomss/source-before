package com.auch.sb.reflect.pojo;

import lombok.*;


@ToString
public class Human {

     private String gender;

     private Integer age;

     public Human(String gender) {
          this.gender = gender;
     }

     private Human(String gender,Integer age) {
          this.gender = gender;
          this.age = age;
     }

     public Human() {
     }


     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }
}

package com.maids.cc.bookStore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("PATRON")
public class Patron {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNO;
    private String email;

    public Patron() {
    }


    public Patron(String firstName, String lastName, String phoneNO, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNO = phoneNO;
        this.email = email;

    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

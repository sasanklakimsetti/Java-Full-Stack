package com.summerpep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int isid;
    int bid;
    int roll;
    Date isdtae, expredate;
    Double fine;

    @Override
    public String toString() {
        return "Issue{" +
                "isid=" + isid +
                ", bid=" + bid +
                ", roll=" + roll +
                ", isdtae=" + isdtae +
                ", expredate=" + expredate +
                ", fine=" + fine +
                '}';
    }
}

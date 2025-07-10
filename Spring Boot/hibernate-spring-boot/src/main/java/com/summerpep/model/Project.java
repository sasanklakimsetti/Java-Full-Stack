package com.summerpep.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int projid;
    public String client;
    public Date startDate, endDate;
    @Column(name = "cost", nullable = false)
    public double cost;

    @Override
    public String toString() {
        return "Project{" +
                "projid=" + projid +
                ", client='" + client + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cost=" + cost +
                '}';
    }

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Project() {
    }

    public Project(int projid, String client, Date startDate, Date endDate, double cost) {
        this.projid = projid;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }
}

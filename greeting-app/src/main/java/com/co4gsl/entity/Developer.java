package com.co4gsl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Developer extends PanacheEntity {
    public String name;
}

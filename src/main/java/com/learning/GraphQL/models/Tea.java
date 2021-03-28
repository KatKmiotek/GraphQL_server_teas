package com.learning.GraphQL.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teas")
public class Tea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @Column(name = "producer")
    private Producer producer;


    public Tea(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
//    public Tea(){
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Tea producer(Producer producer){
        this.producer = producer;
        return this;
    }

}

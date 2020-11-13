package com.numberone.project.system.reduce.domain;

import java.math.BigDecimal;

public class Reduce {
    private int id;
    private String  name;
    private BigDecimal reduce_coal;
    private BigDecimal reduce_co2;

    public BigDecimal getReduceCoal() {
        return reduce_coal;
    }

    public void setReduceCoal(BigDecimal reduceCoal) {
        this.reduce_coal = reduceCoal;
    }

    public BigDecimal getReduceCo2() {
        return reduce_co2;
    }

    public void setReduceCo2(BigDecimal reduceCo2) {
        this.reduce_co2 = reduceCo2;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}

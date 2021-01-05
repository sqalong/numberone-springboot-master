package com.numberone.project.bigdata.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Contrast {
    private String region;
    private Date timing;
    private BigDecimal number;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }
}

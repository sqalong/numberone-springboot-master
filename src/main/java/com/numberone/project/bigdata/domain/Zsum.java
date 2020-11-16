package com.numberone.project.bigdata.domain;


import com.numberone.framework.web.domain.BaseEntity;
import lombok.Data;


public class Zsum extends BaseEntity {
    private String wsum;
    private String gsum;
    private String esum;

    public Zsum(String wsum, String gsum, String esum) {
        this.wsum = wsum;
        this.gsum = gsum;
        this.esum = esum;
    }

    public Zsum() {
    }

    public String getWsum() {
        return wsum;
    }

    public void setWsum(String wsum) {
        this.wsum = wsum;
    }

    public String getGsum() {
        return gsum;
    }

    public void setGsum(String gsum) {
        this.gsum = gsum;
    }

    public String getEsum() {
        return esum;
    }

    public void setEsum(String esum) {
        this.esum = esum;
    }
}

package com.numberone.project.system.gas.domain;

/**
 * water
 *  气表
 * @author numberone
 */
public class Gas
{


    /** ID */

    private int id;

    /** 地方名称 */

    private String name;

    /** 值*/

    private String value;


    private String timeid;

    public Gas() {
    }

    public Gas(int id, String name, String value, String timeid) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.timeid = timeid;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimeid() {
        return timeid;
    }

    public void setTimeid(String timeid) {
        this.timeid = timeid;
    }
}

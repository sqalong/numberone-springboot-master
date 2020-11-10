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

    public Gas() {
    }

    public Gas(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}

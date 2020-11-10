package com.numberone.project.system.electric.domain;

/**
 * water
 *  电表
 * @author numberone
 */
public class Electric
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

    public Electric() {
    }

    public Electric(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}

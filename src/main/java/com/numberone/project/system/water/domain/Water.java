package com.numberone.project.system.water.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * water
 *  水表
 * @author numberone
 */
public class Water
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

    public Water() {
    }

    public Water(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}

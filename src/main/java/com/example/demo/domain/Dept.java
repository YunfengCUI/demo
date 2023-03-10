package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName dept
 */
@TableName(value = "dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "部门实体类", description = "这个类定义了部门所有属性")
public class Dept implements Serializable {
    @ExcelProperty("部门id")
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键 部门id")
    private Integer deptid;

    @ExcelProperty("部门name")
    @ApiModelProperty("部门名 deptname")
    private String deptname;

    @ExcelProperty("创建时间")
    @DateTimeFormat("dd-MM-yyyy HH:mm:ss")
    @ApiModelProperty("创建时间 createdata")
    private Date createdata;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dept other = (Dept) that;
        return (this.getDeptid() == null ? other.getDeptid() == null : this.getDeptid().equals(other.getDeptid()))
                && (this.getDeptname() == null ? other.getDeptname() == null : this.getDeptname().equals(other.getDeptname()))
                && (this.getCreatedata() == null ? other.getCreatedata() == null : this.getCreatedata().equals(other.getCreatedata()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptid() == null) ? 0 : getDeptid().hashCode());
        result = prime * result + ((getDeptname() == null) ? 0 : getDeptname().hashCode());
        result = prime * result + ((getCreatedata() == null) ? 0 : getCreatedata().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptid=").append(deptid);
        sb.append(", deptname=").append(deptname);
        sb.append(", createdata=").append(createdata);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
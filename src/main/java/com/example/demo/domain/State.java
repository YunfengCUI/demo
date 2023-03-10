package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName state
 */
@TableName(value ="state")
@Data
public class State implements Serializable {
    /**
     * 状态id
     */
    private Integer stateid;

    /**
     * 状态名
     */
    private String statename;

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
        State other = (State) that;
        return (this.getStateid() == null ? other.getStateid() == null : this.getStateid().equals(other.getStateid()))
            && (this.getStatename() == null ? other.getStatename() == null : this.getStatename().equals(other.getStatename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStateid() == null) ? 0 : getStateid().hashCode());
        result = prime * result + ((getStatename() == null) ? 0 : getStatename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stateid=").append(stateid);
        sb.append(", statename=").append(statename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
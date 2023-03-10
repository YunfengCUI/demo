package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName book_request_date
 */
@TableName(value ="book_request_date")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDate implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer bookid;

    /**
     * 借出时间
     */
    private Date begindate;

    /**
     * 应该时间
     */
    private Date enddate;

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
        BookRequestDate other = (BookRequestDate) that;
        return (this.getBookid() == null ? other.getBookid() == null : this.getBookid().equals(other.getBookid()))
            && (this.getBegindate() == null ? other.getBegindate() == null : this.getBegindate().equals(other.getBegindate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookid() == null) ? 0 : getBookid().hashCode());
        result = prime * result + ((getBegindate() == null) ? 0 : getBegindate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookid=").append(bookid);
        sb.append(", begindate=").append(begindate);
        sb.append(", enddate=").append(enddate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    /**
     * 书本索引号
     */
    @TableId
    @ExcelProperty("书本索引号")
    private Integer bookid;

    /**
     * 书本名称中文
     */
    @ExcelProperty("书本名称中文")
    private String booknameCh;

    /**
     * 书本名英文
     */
    @ExcelProperty("书本名英文")
    private String booknameEn;

    /**
     * 作者
     */
    @ExcelProperty("作者")
    private String author;

    /**
     * 出版社
     */
    @ExcelProperty("出版社")
    private String proName;

    /**
     * 出版日期
     */
    @ExcelProperty("出版日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productDate;

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
        Book other = (Book) that;
        return (this.getBookid() == null ? other.getBookid() == null : this.getBookid().equals(other.getBookid()))
            && (this.getBooknameCh() == null ? other.getBooknameCh() == null : this.getBooknameCh().equals(other.getBooknameCh()))
            && (this.getBooknameEn() == null ? other.getBooknameEn() == null : this.getBooknameEn().equals(other.getBooknameEn()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getProName() == null ? other.getProName() == null : this.getProName().equals(other.getProName()))
            && (this.getProductDate() == null ? other.getProductDate() == null : this.getProductDate().equals(other.getProductDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookid() == null) ? 0 : getBookid().hashCode());
        result = prime * result + ((getBooknameCh() == null) ? 0 : getBooknameCh().hashCode());
        result = prime * result + ((getBooknameEn() == null) ? 0 : getBooknameEn().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getProName() == null) ? 0 : getProName().hashCode());
        result = prime * result + ((getProductDate() == null) ? 0 : getProductDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookid=").append(bookid);
        sb.append(", booknameCh=").append(booknameCh);
        sb.append(", booknameEn=").append(booknameEn);
        sb.append(", author=").append(author);
        sb.append(", proName=").append(proName);
        sb.append(", productDate=").append(productDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.example.demo.domain.dto;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRequest;
import com.example.demo.domain.BookRequestDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author CYF02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneBookState {

    private Integer bookid;

    private Integer userid;
    private Integer results;
    private Date beginDate;
    private Date endDate;

    public OneBookState(Book book, BookRequest bookRequest, BookRequestDate bookRequestDate) {
        this.bookid = book.getBookid();
        if (bookRequest!=null){
            this.userid = bookRequest.getUserid();
            this.results = bookRequest.getResults();
        }

        if (bookRequestDate!=null){
            this.beginDate = bookRequestDate.getBegindate();
            this.endDate = bookRequestDate.getEnddate();
        }

    }

    @Override
    public String toString() {
        return "OneBookState{" +
                "bookid=" + bookid +
                ", userid=" + userid +
                ", results=" + results +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}

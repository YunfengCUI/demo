package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.listeners.DemoDataListener;
import com.example.demo.domain.*;
import com.example.demo.domain.dto.OneBookState;
import com.example.demo.domain.vo.Result;
import com.example.demo.service.BookRequestDateService;
import com.example.demo.service.BookRequestService;
import com.example.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
@Api(tags = "图书管理模块")
@Slf4j
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private BookRequestService bookRequestService;
    @Resource
    private BookRequestDateService bookRequestDateService;
    @ApiOperation("find")
    @PostMapping(value = "/find")
    public Result<Object> find(Book book){
        log.info(book.toString());
        log.info(bookService.list(new QueryWrapper<>(book)).toString());
        return Result.ok("result",bookService.list(new QueryWrapper<>(book)));
    }

    @ApiOperation("add")
    @PostMapping(value = "/add")
    public Result<Object> add(Book book){
        log.info(book.toString());
        return Result.ok("result",bookService.save(book));
    }
    @ApiOperation("del")
    @PostMapping(value = "/del")
    public Result<Object> del(Book book){
        log.info(book.toString());
        return Result.ok("result",bookService.removeById(book));
    }
    @ApiOperation("update")
    @PostMapping(value = "/update")
    public Result<Object> update(Book book){
        log.info(book.toString());
        return Result.ok("result",bookService.updateById(book));
    }

    @ApiOperation("借书")
    @PostMapping(value = "/borrow")
    public Result<Object> borrow(BookRequest bookRequest){
        log.info(bookRequest.toString());
        bookRequestService.getById(bookRequest.getBookid());
        BookRequestDate bookRequestDate = new BookRequestDate(bookRequest.getBookid(),new Date(),null);
        bookRequestDateService.save(bookRequestDate);
        /*状态 借出*/
        bookRequest.setResults(1);
        bookRequestService.saveOrUpdate(bookRequest);
        return Result.ok("msg",true);
    }
    @ApiOperation("还书")
    @PostMapping(value = "/bookBack")
    public Result<Object> bookBack(BookRequest bookRequest){
        log.info(bookRequest.toString());
        BookRequestDate bookRequestDate = new BookRequestDate();
        bookRequestDate = bookRequestDateService.getById(bookRequest.getBookid());
        bookRequestDate.setEnddate(new Date());

        bookRequestDateService.saveOrUpdate(bookRequestDate);
        /*状态 借出*/
        bookRequest.setResults(0);
        bookRequestService.saveOrUpdate(bookRequest);
        return Result.ok("msg",true);
    }

    @ApiOperation("新书推荐")
    @PostMapping(value = "/recommended")
    public Result<Object> recommended( ){
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.orderByDesc("product_date");
        return Result.ok("books",bookService.list(bookQueryWrapper));
    }

    @GetMapping("/exportAll")
    public void exportAll(HttpServletResponse response) throws IOException {
        List<Book> listExcel = new ArrayList<>();
        List<Book> list = bookService.list();
        //文件名需要这样写，不能在setHeader直接写中文名，否则下载的文件名字为空，只有后缀
        String fileName = new String("Book.xlsx".getBytes(), StandardCharsets.ISO_8859_1);
        response.setContentType("application/msexcel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName );
        EasyExcel.write(response.getOutputStream(), Book.class)
                .sheet("sheet")
                .doWrite(list);
//        return Result.ok().mesaage("下载成功"); 不要写
    }

    /**
     excel文件的上传
     */
    @ApiOperation("上传图书excel文件")
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart MultipartFile file) throws IOException {
            EasyExcel.read(file.getInputStream(), Book.class, new DemoDataListener(bookService)).sheet().doRead();
        return "success-excel-add!";
    }


    @ApiOperation("查看单个图书的状态")
    @PostMapping(value = "/one/state")
    public Result bookState(Book book) throws IOException {
        BookRequest byId = bookRequestService.getById(book.getBookid());
        BookRequestDate byId1 = bookRequestDateService.getById(book.getBookid());
        log.debug(book.toString());
        OneBookState oneBookState = new OneBookState(book, byId, byId1);
        return Result.ok(oneBookState);
    }

}

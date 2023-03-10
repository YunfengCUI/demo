//package com.example.demo.controller;
//
//import com.alibaba.excel.EasyExcel;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.demo.cyf.controller.listeners.DemoDataListener;
//import com.example.demo.cyf.entity.Dept;
//import com.example.demo.cyf.entity.PageEntity;
//import com.example.demo.cyf.service.DeptService;
//import com.example.demo.domain.Dept;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Slf4j
//@RestController
//@Api("部门管理")
//@RequestMapping("/dept")
//public class DeptController {
//
//    @Resource
//    DeptService deptService;
//
//    /**
//     * 查询所有
//     *
//     * @return
//     */
////    swagger2
//    @ApiOperation(value = "所有部门",notes = "查询所有部门")
//    @GetMapping("/queryall")
//    public List<Dept> queryAll() {
//        return deptService.list();
//    }
//    /**
//     * 单个添加
//     *
//     * @param dept
//     * @return
//     */
//    @Operation(summary = "添加部门",description = "添加部门 传入对象-deptname")
//    @ApiImplicitParam(paramType = "query",name = "dept",value = "部门 dept",required = true)
//    @PostMapping("/adddept")
//    boolean adddept(Dept dept) {
//        dept.setCreatedata(new Date());
//        return deptService.save(dept);
//    }
//    /**
//     * 修改
//     *
//     * @param dept
//     * @return
//     */
//    @Operation(summary = "更新部门",description = "更新部门 传入对象-dept")
//    @ApiImplicitParam(paramType = "body",name = "dept",value = "部门 dept",required = true)
//    @PostMapping("/update")
//    boolean updatedept(Dept dept) {
//        return deptService.updateById(dept);
//    }
//
//    /**
//     * 删除
//     *
//     * @param deptid
//     * @return
//     */
//    @Operation(summary = "删除部门",description = "删除部门 传入对象-dept")
//    @ApiImplicitParam(paramType = "body",name = "dept",value = "部门 dept",required = true)
//    @PostMapping("/delete")
//    boolean deldept(int deptid) {
//        return deptService.removeById(deptid);
//    }
//
//    /**
//     * 批量增加
//     *
//     * @param depts
//     * @return
//     */
//    @Operation(summary = "批量添加部门",description = "更新部门 传入对象-dept")
//    @ApiImplicitParam(paramType = "body",name = "depts",value = "部门 depts",required = true)
//    @PostMapping("/add3")
//    public boolean addlist(@RequestBody List<Dept> depts) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//        Date date = new Date();
//        for (Dept d :
//                depts) {
//            d.setCreatedata(date);
//        }
//        System.out.println(depts);
//        return deptService.saveBatch(depts);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @param pageEntity
//     * @return
//     */
//    @ApiResponses({
//            @ApiResponse(responseCode = "200",description = "请求成功"),
//            @ApiResponse(responseCode = "500",description = "请求失败")
//    })
//    @Operation(summary = "分页查询",description = "输入页码,每页展示条数")
//    @ApiImplicitParam(paramType = "query",name = "page",value = "page对象",required = true)
//    @PostMapping("/page")
//    Object pagequery(PageEntity pageEntity) {
//        IPage<Dept> page = new Page<>(pageEntity.getPageid(), pageEntity.getPagesize());
//        return deptService.page(page, null);
//    }
//
//    @Operation(summary = "下载dept.excel")
//    @GetMapping("/exportAll")
//    public void exportAll(HttpServletResponse response) throws IOException {
//        List<Dept> listExcel = new ArrayList<>();
//        List<Dept> list = deptService.list();
//        //文件名需要这样写，不能在setHeader直接写中文名，否则下载的文件名字为空，只有后缀
//        String fileName = new String("dept信息.xlsx".getBytes(), StandardCharsets.ISO_8859_1);
//        response.setContentType("application/msexcel");
//        response.setCharacterEncoding("utf8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName );
//        EasyExcel.write(response.getOutputStream(), Dept.class)
//                .sheet("sheet")
//                .doWrite(list);
////        return Result.ok().mesaage("下载成功"); 不要写
//    }
//
//    /**
//     excel文件的上传
//     */
////导入excel
//    @ApiOperation("上传部门excel文件")
//    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload(@RequestPart MultipartFile file) throws IOException {
//            EasyExcel.read(file.getInputStream(), Dept.class, new DemoDataListener(deptService)).sheet().doRead();
//        return "success-excel-add!";
//    }
//}

package com.congci.excel.controller;

import com.congci.excel.model.ExportAwards;
import com.congci.excel.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileCtr {
    @RequestMapping("/model")
    public void export(HttpServletResponse response){

        //模拟从数据库获取需要导出的数据
        List<ExportAwards> personList = new ArrayList<>();
        ExportAwards person1 = new ExportAwards("一等奖","张三,李四,王五","2018");
        ExportAwards person2 = new ExportAwards("二等奖","张三","2018");
        ExportAwards person3 = new ExportAwards("三等奖","李四,小六","2018");
        ExportAwards person4 = new ExportAwards("四等奖","王五,张三,李四","2018");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        FileUtil.exportExcel(personList,"获奖名单","获奖名单",ExportAwards.class,"获奖名单.xls",response);
    }

    @RequestMapping("/export")
    public void importExcel(HttpServletResponse response){
        String filePath = "F:\\获奖名单.xls";
        //解析excel，
        List<ExportAwards> importExcelList = FileUtil.importExcel(filePath,1,1,ExportAwards.class);
        System.out.println("导入数据一共【"+importExcelList.size()+"】行");
        List<ExportAwards> exportAwardsList = new ArrayList<>();
        for (ExportAwards x:importExcelList){
            System.err.println(x.toString());
            //按照英文逗号进行人名拆分
            String[] names =  x.getAwardee().split(",");
            for(String name: names){
                exportAwardsList.add(new ExportAwards(x.getAward(),name,x.getTime()));
            }
        }
        //导出操作
        FileUtil.exportExcel(exportAwardsList,"获奖名单","获奖名单",ExportAwards.class,"获奖名单.xls",response);
    }

}

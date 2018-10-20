package com.congci.excel.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class ExportAwards {
    //奖项名称
    @Excel(name = "奖项名称" ,orderNum = "0")
    private String award;
    //获奖人
    @Excel(name = "获奖人员" ,orderNum = "0")
    private String awardee;
    //获奖时间
    @Excel(name = "获奖时间" ,orderNum = "0")
    private String time;

    public ExportAwards() {
    }

    public ExportAwards(String award, String awardee, String time) {
        this.award = award;
        this.awardee = awardee;
        this.time = time;
    }
}

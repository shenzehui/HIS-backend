package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsMechanicItemRecordResult;
import com.neu.his.dms.service.DmsMechanicItemRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsMechanicItemRecordController", description = "医技工作台")
@RequestMapping("/DmsMechanicItemRecord")
@CrossOrigin
public class DmsMechanicItemRecordController {

    @Autowired
    private DmsMechanicItemRecordService dmsMechanicItemRecordService;

    /**
     * 描述:根据科室id刷新患者列表
     * <p>author: szh
     */
    @ApiOperation(value = "根据科室id刷新患者列表")
    @RequestMapping(value = "/listByDept", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMechanicItemRecordResult>> listByDeptAndName(@RequestParam("deptId") String deptId, @RequestParam("search") String search) {
        List<DmsMechanicItemRecordResult> list = dmsMechanicItemRecordService.listByDeptAndName(Long.getLong(deptId), search);
        return CommonResult.success(list);
    }

    /**
     * 描述:医技登记
     * <p>author: szh
     */
    @ApiOperation(value = "登记")
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult log(@RequestParam("itemRecordId") Long itemRecordId, @RequestParam("logStaffId") Long logStaffId) {
        int count = dmsMechanicItemRecordService.log(itemRecordId, logStaffId);
        if (count > 0) {
            return CommonResult.success(count, "登记成功");
        }
        return CommonResult.failed("登记失败");
    }

    /**
     * 描述:上传结果
     * <p>author: szh
     */
    @ApiOperation(value = "上传结果")
    @RequestMapping(value = "/uploadResult", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadResult(@RequestParam("id") Long id, @RequestParam("executeStaffId") Long excuteStaffId, @RequestParam("checkResult") String checkResult, @RequestParam("resultImgUrlList") String resultImgUrlList) {
        int count = dmsMechanicItemRecordService.uploadResult(id, excuteStaffId, checkResult, resultImgUrlList);
        if (count > 0) {
            return CommonResult.success(count, "上传成功");
        }
        return CommonResult.failed("上传失败");
    }

}

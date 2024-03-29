package com.neu.his.api.controller.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsDrugModelParam;
import com.neu.his.common.dto.dms.DmsDrugModelResult;
import com.neu.his.common.dto.dms.DmsNonDrugModelParam;
import com.neu.his.common.dto.dms.DmsNonDrugModelResult;
import com.neu.his.dms.service.DmsDrugModelService;
import com.neu.his.dms.service.DmsNonDrugModelService;
import com.neu.his.mbg.model.DmsDrugModel;
import com.neu.his.mbg.model.DmsNonDrugModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *药品模版
 */
@Controller
@Api(tags = "DmsDrugModelController", description = "药品模板管理")
@RequestMapping("/drugModel")
@CrossOrigin
public class DmsDrugModelController {

    @Autowired
    DmsDrugModelService dmsDrugModelService;

    @ApiOperation(value = "新增药品模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result) {
        int count = dmsDrugModelService.createModel(dmsDrugModelParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "删除药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
        int count = dmsDrugModelService.deleteModel(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
//
//    @ApiOperation(value = "删除模版项")
//    @RequestMapping(value = "/deleteModelItem", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult deleteModelItem( @RequestParam("modelId")Long modelId, @RequestParam("ids") List<Long> itemIds){
//        int count = dmsNonDrugModelService.deleteModelItem(modelId,itemIds);
//        if (count >= 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
    @ApiOperation(value = "更新药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result){
        int count = dmsDrugModelService.updateModel(modelId,dmsDrugModelParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "模糊查询药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugModelResult>> list(DmsDrugModelParam queryParam,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<DmsDrugModelResult>  list = dmsDrugModelService.selectModel(isAdmin,queryParam, pageSize, pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

}

package com.neu.his.api.controller;

import com.neu.his.sms.SmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    @Autowired
    SmsRoleService smsRoleService;

    @ApiOperation("热部署测试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public  String list(){
        return "dev hot";
    }

//    public CommonResult create(@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
//
//    }


}

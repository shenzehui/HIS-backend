package com.neu.his.common.dto.sms;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/*
挂号时查询医生
 */
@Setter
@Getter
@ToString
public class SmsSkdDocParam implements Serializable {
    @ApiModelProperty(value = "科室id")
    private Long deptId;
    @ApiModelProperty(value = "挂号级别id")
    private Long registrationRankId;
    @ApiModelProperty(value = "午别")
    private Integer noon;
    @ApiModelProperty(value = "日期")
    @JsonFormat(timezone = "Asia/Shanghai")
    private Date date;
}

package com.neu.his.dms.service;

import com.neu.his.common.dto.dms.DmsMechanicItemRecordResult;

import java.util.List;

/**
 * 医技
 */
public interface DmsMechanicItemRecordService {

    /**
     * 描述：根据科室id刷新患者列表
     */
    List<DmsMechanicItemRecordResult> listByDeptAndName(Long deptId,String search);

    /**
     * 描述：医技登记
     */
    int log(Long itemRecordId, Long logStaffId);

    /**
     * 描述：上传结果
     */
    int uploadResult(Long id, Long excuteStaffId, String checkResult, String resultImgUrlList);

}

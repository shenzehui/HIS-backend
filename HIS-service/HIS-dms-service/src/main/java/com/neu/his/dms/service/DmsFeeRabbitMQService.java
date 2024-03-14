package com.neu.his.dms.service;

public interface DmsFeeRabbitMQService {

    /**
     * 描述:草药处方超时未缴费处理（设置状态为4已过期）
     * <p>author: szh
     */
    int herbalOutOfTime(Long prescriptionId);

    /**
     * 描述:成药处方超时未缴费处理（设置状态为4已过期）
     * <p>author: szh
     */
    int medicineOutOfTime(Long prescriptionId);

    /**
     * 描述:非药品超时未缴费处理（设置状态为6已过期）
     * <p>author: szh
     */
    int nonDrugOutOfTime(Long prescriptionId);

}

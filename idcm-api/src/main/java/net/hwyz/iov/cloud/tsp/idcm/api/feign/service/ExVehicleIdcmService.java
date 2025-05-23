package net.hwyz.iov.cloud.tsp.idcm.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.VehicleIdcmExService;
import net.hwyz.iov.cloud.tsp.idcm.api.feign.service.factory.ExVehicleIdcmServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 车辆信息娱乐模块相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exVehicleIdcmService", value = ServiceNameConstants.TSP_IDCM, path = "/service/vehicleIdcm", fallbackFactory = ExVehicleIdcmServiceFallbackFactory.class)
public interface ExVehicleIdcmService {

    /**
     * 根据车架号或序列号获取车辆信息娱乐模块
     *
     * @param vin 车架号
     * @param sn  序列号
     * @return 车辆信息娱乐模块
     */
    @GetMapping("")
    VehicleIdcmExService get(@RequestParam(required = false) String vin, @RequestParam(required = false) String sn);

}

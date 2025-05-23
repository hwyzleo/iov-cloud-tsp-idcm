package net.hwyz.iov.cloud.tsp.idcm.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.VehicleIdcmExService;
import net.hwyz.iov.cloud.tsp.idcm.api.feign.service.ExVehicleIdcmService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 车辆信息娱乐模块相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExVehicleIdcmServiceFallbackFactory implements FallbackFactory<ExVehicleIdcmService> {

    @Override
    public ExVehicleIdcmService create(Throwable throwable) {
        return new ExVehicleIdcmService() {
            @Override
            public VehicleIdcmExService get(String vin, String sn) {
                logger.error("车辆信息娱乐模块相关服务根据车架号[{}]或序列号[{}]获取车辆信息娱乐模块调用异常", vin, sn, throwable);
                return null;
            }
        };
    }
}

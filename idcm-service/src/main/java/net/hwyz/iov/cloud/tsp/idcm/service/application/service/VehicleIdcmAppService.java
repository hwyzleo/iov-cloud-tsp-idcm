package net.hwyz.iov.cloud.tsp.idcm.service.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.dao.VehicleIdcmDao;
import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.dao.VehicleIdcmLogDao;
import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.po.VehicleIdcmLogPo;
import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.po.VehicleIdcmPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆信息娱乐模块相关应用服务类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleIdcmAppService {

    private final VehicleIdcmDao vehicleIdcmDao;
    private final VehicleIdcmLogDao vehicleIdcmLogDao;

    /**
     * 根据车架号或序列号获取车辆信息娱乐模块
     *
     * @param sn 序列号
     * @return 车辆信息娱乐模块
     */
    public VehicleIdcmPo get(String vin, String sn) {
        List<VehicleIdcmPo> vehicleIdcmPoList = vehicleIdcmDao.selectPoByExample(VehicleIdcmPo.builder().vin(vin).sn(sn).build());
        return vehicleIdcmPoList.isEmpty() ? null : vehicleIdcmPoList.get(0);
    }

    /**
     * 记录车辆信息娱乐模块变更日志
     *
     * @param vehicleIdcmPo 车辆信息娱乐模块对象
     * @param remark        变更备注
     */
    private void recordLog(VehicleIdcmPo vehicleIdcmPo, String remark) {
        vehicleIdcmLogDao.insertPo(VehicleIdcmLogPo.builder()
                .vin(vehicleIdcmPo.getVin())
                .sn(vehicleIdcmPo.getSn())
                .description(remark)
                .build());
    }

}

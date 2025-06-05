package net.hwyz.iov.cloud.tsp.idcm.service.facade.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.framework.common.util.StrUtil;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.VehicleIdcmExService;
import net.hwyz.iov.cloud.tsp.idcm.service.application.service.VehicleIdcmAppService;
import net.hwyz.iov.cloud.tsp.idcm.service.facade.assembler.VehicleIdcmExServiceAssembler;
import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.exception.IdcmBaseException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 车辆信息娱乐模块相关服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/vehicleIdcm")
public class VehicleIdcmServiceController {

    private final VehicleIdcmAppService vehicleIdcmAppService;

    /**
     * 根据车架号或序列号获取车辆信息娱乐模块
     *
     * @param vin 车架号
     * @param sn  序列号
     * @return 车辆信息娱乐模块
     */
    @GetMapping("")
    public VehicleIdcmExService get(@RequestParam(required = false) String vin, @RequestParam(required = false) String sn) {
        logger.info("根据车架号[{}]或序列号[{}]获取车辆信息娱乐模块", vin, sn);
        if (StrUtil.isBlank(vin) && StrUtil.isBlank(sn)) {
            throw new IdcmBaseException("车架号与序列号不能都为空");
        }
        return VehicleIdcmExServiceAssembler.INSTANCE.fromPo(vehicleIdcmAppService.get(vin, sn));
    }

    /**
     * 车辆绑定信息娱乐模块
     *
     * @param vehicleIdcm 车辆信息娱乐模块
     */
    @PostMapping("/bind")
    public void bind(@RequestBody @Validated VehicleIdcmExService vehicleIdcm) {
        logger.info("车辆[{}]绑定信息娱乐模块[{}]", vehicleIdcm.getVin(), vehicleIdcm.getSn());
        vehicleIdcmAppService.bind(vehicleIdcm.getVin(), vehicleIdcm.getSn());
    }

}

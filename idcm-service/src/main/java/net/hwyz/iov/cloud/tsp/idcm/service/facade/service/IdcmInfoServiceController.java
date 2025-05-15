package net.hwyz.iov.cloud.tsp.idcm.service.facade.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.request.BatchImportIdcmRequest;
import net.hwyz.iov.cloud.tsp.idcm.service.application.service.IdcmInfoAppService;
import net.hwyz.iov.cloud.tsp.idcm.service.facade.assembler.IdcmExServiceAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息娱乐模块信息相关服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/idcm")
public class IdcmInfoServiceController {

    private final IdcmInfoAppService idcmInfoAppService;

    /**
     * 批量导入信息娱乐模块数据
     *
     * @param request 批量导入信息娱乐模块请求
     */
    @PostMapping("/batchImport")
    public void batchImport(@RequestBody @Validated BatchImportIdcmRequest request) {
        logger.info("批量导入信息娱乐模块数据[{}]", request.getBatchNum());
        idcmInfoAppService.batchImport(request.getBatchNum(), request.getSupplierCode(),
                IdcmExServiceAssembler.INSTANCE.toPoList(request.getIdcmList()));
    }

}

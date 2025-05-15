package net.hwyz.iov.cloud.tsp.idcm.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.request.BatchImportIdcmRequest;
import net.hwyz.iov.cloud.tsp.idcm.api.feign.service.factory.ExIdcmInfoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 信息娱乐模块信息相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exIdcmInfoService", value = ServiceNameConstants.TSP_IDCM, path = "/service/idcm", fallbackFactory = ExIdcmInfoServiceFallbackFactory.class)
public interface ExIdcmInfoService {

    /**
     * 批量导入信息娱乐模块数据
     *
     * @param request 批量导入信息娱乐模块请求
     */
    @PostMapping("/batchImport")
    void batchImport(@RequestBody @Validated BatchImportIdcmRequest request);

}

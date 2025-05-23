package net.hwyz.iov.cloud.tsp.idcm.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.IdcmExService;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.request.BatchImportIdcmRequest;
import net.hwyz.iov.cloud.tsp.idcm.api.feign.service.ExIdcmInfoService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 信息娱乐模块信息相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExIdcmInfoServiceFallbackFactory implements FallbackFactory<ExIdcmInfoService> {

    @Override
    public ExIdcmInfoService create(Throwable throwable) {
        return new ExIdcmInfoService() {
            @Override
            public void batchImport(BatchImportIdcmRequest request) {
                logger.error("信息娱乐模块信息相关服务批量导入信息娱乐模块数据[{}]调用异常", request.getBatchNum(), throwable);
            }

            @Override
            public IdcmExService getBySn(String sn) {
                logger.error("信息娱乐模块信息相关服务根据序列号[{}]获取信息娱乐模块信息调用异常", sn, throwable);
                return null;
            }
        };
    }
}

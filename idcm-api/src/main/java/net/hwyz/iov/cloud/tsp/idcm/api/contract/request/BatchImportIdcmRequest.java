package net.hwyz.iov.cloud.tsp.idcm.api.contract.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hwyz.iov.cloud.tsp.idcm.api.contract.IdcmExService;

import java.util.List;

/**
 * 批量导入信息娱乐模块信息请求
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchImportIdcmRequest {

    /**
     * 信息娱乐模块列表
     */
    @NotEmpty(message = "信息娱乐模块列表不能为空")
    private List<IdcmExService> idcmList;

    /**
     * 供应商编码
     */
    private String supplierCode;

    /**
     * 批次号
     */
    private String batchNum;

}

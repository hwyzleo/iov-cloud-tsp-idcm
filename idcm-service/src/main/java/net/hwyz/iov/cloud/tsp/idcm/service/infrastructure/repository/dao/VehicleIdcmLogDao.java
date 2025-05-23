package net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.po.VehicleIdcmLogPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 车辆信息娱乐模块变更日志表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-23
 */
@Mapper
public interface VehicleIdcmLogDao extends BaseDao<VehicleIdcmLogPo, Long> {

}

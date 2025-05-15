package net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.po.IdcmLogPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 信息娱乐模块信息变更日志表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-15
 */
@Mapper
public interface IdcmLogDao extends BaseDao<IdcmLogPo, Long> {

}

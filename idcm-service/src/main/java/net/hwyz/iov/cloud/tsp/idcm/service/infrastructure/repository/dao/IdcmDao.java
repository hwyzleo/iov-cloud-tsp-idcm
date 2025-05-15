package net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.repository.po.IdcmPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 信息娱乐模块信息表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-15
 */
@Mapper
public interface IdcmDao extends BaseDao<IdcmPo, Long> {

    /**
     * 根据序列号查询信息娱乐模块信息
     *
     * @param sn 序列号
     * @return 信息娱乐模块信息
     */
    IdcmPo selectBySn(String sn);

}

package net.hwyz.iov.cloud.tsp.idcm.service.infrastructure.exception;


import net.hwyz.iov.cloud.framework.common.exception.BaseException;

/**
 * 信息娱乐模块服务基础异常
 *
 * @author hwyz_leo
 */
public class IdcmBaseException extends BaseException {

    private static final int ERROR_CODE = 207000;

    public IdcmBaseException(String message) {
        super(ERROR_CODE, message);
    }

    public IdcmBaseException(int errorCode) {
        super(errorCode);
    }

    public IdcmBaseException(int errorCode, String message) {
        super(errorCode, message);
    }

}

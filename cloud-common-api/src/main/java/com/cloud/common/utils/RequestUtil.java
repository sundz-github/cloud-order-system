package com.cloud.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p> 请求工具类 </p>
 *
 * @author Sundz
 * @date 2021/12/5 11:28
 */
public class RequestUtil {

    /**
     *  获取端口
     * @param
     * @return {@link int}
     */
    public static int getReuqestPort(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getLocalPort();
    }
}

package com.arc.utils.mine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @author may
 * @version: V1.0
 * @since 2018/12/21
 */
public final class IPUtils {
    private static final Logger log = LoggerFactory.getLogger(IPUtils.class);

    private static final String UNKNOWN = "unknown";
    private static final String IP = "127.0.0.1";
//    Socket socket = new Socket(ip, 6667);

    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? IP : ip;
    }

    /**
     * 获取本机ip
     */
    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.debug("获取本机ip发生异常，原因{}", e.getMessage());
        }
        return "0.0.0.0";
    }

    /**
     * 获取本机计算机名称
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            log.debug("获取本机ip发生异常，原因{}", e.getMessage());
        }
        return "未知名称";
    }
}

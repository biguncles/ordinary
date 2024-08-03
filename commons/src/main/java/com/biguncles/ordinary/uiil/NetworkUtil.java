package com.biguncles.ordinary.uiil;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 网络工具类额
 * @author yc
 * */
@Slf4j
public class NetworkUtil {

    /**
     * 获取内网ip列表
     * */
    public static List<String> getLocalInetAddressList() {
        List<String> localIps = new ArrayList<>();
        try {
            // 获取系统所有网络接口
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                // 排除虚拟网络接口和回环接口
                if (!networkInterface.isLoopback() && !networkInterface.isVirtual()) {
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                        // 检查是否是IPv4地址
                        if (inetAddress instanceof Inet4Address) {
                            // 检查是否是内网地址
                            if (isSiteLocalAddress(inetAddress)) {
                                localIps.add(inetAddress.getHostAddress());
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            log.error("ip获取异常", e);
        }
        return localIps;
    }

    /** 是否是内网ip */
    private static boolean isSiteLocalAddress(InetAddress address) {
        // 定义内网IP范围
        byte[] bytes = address.getAddress();
        // 检查是否是私有IP地址
        return switch (bytes[0]) {
            // 10.0.0.0 - 10.255.255.255
            case 10 -> true;
            // 172.16.0.0 - 172.31.255.255
            case (byte) 172 -> (bytes[1] >= 16) && (bytes[1] <= 31);
            // 192.168.0.0 - 192.168.255.255
            case (byte) 192 -> bytes[1] == (byte) 168;
            default -> false;
        };
    }


    public static void main(String[] args) {
        List<String> localIps = getLocalInetAddressList();
        System.out.println("Local Inet Addresses: " + localIps);
    }
}
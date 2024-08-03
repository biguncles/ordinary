package com.biguncles.ordinary.server.dto;

import com.biguncles.ordinary.server.po.ServerPO;
import lombok.Data;


/**
 * 服务对应
 * @author yc
 * */
@Data
public class ServerDTO {

    /**
     * IP 地址，最大长度为 15 字符。
     */
    private String ipAddress;

    /** 上下线状态 */
    private ServerPO.Status status;
}

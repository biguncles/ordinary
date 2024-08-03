package com.biguncles.ordinary.server.po;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * ServerStatus 实体类代表数据库表 server_list 的一条记录。
 * @author yangchao
 */
@Data
@Entity
@Table(name = "server_list")
public class ServerPO {

    /**
     * 主键，自动递增。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * IP 地址，最大长度为 15 字符。
     */
    @Column(name = "ip_address", nullable = false, length = 15)
    private String ipAddress;

    @Column(name = "port", nullable = false, length = 15)
    private String port;

    /**
     * IP 地址，最大长度为 15 字符。
     */
    @Column(name = "candidate_ip_address", length =  1000)
    private String candidateIpAddress;

    /**
     * 当前状态，只能是 online 或 offline。
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * 最后一次更新时间，自动更新为当前时间。
     */
    @Column(name = "last_updated", nullable = false, insertable = false)
    private Date lastUpdated;

    /**
     * UUID，长度固定为 36 字符。
     */
    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    /**
     * 创建时间，默认值为插入时的当前时间。
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    /** 枚举类型定义 */
    public enum Status {
        ONLINE, OFFLINE
    }

    /** 初始化默认内容 */
    public void init() {
        this.status = Status.ONLINE;
        this.createdAt = new Date();
        this.lastUpdated = new Date();
        this.uuid = IdUtil.simpleUUID();
    }
}
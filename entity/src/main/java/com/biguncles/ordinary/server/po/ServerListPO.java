package com.biguncles.ordinary.server.po;

import lombok.Data;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * ServerStatus 实体类代表数据库表 server_list 的一条记录。
 * @author yangchao
 */
@Data
@Entity
@Table(name = "server_list")
public class ServerListPO {

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
}
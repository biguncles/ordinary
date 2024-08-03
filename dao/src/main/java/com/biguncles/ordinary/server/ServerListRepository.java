package com.biguncles.ordinary.server;

import com.biguncles.ordinary.server.po.ServerListPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository 接口用于处理 ServerStatus 实体的数据库操作。
 */
@Repository
public interface ServerListRepository extends JpaRepository<ServerListPO, Integer> {

    /**
     * 根据 IP 地址查询 ServerStatus 实体。
     * 
     * @param ipAddress 要查询的 IP 地址
     * @return 匹配的 ServerStatus 实体
     */
    ServerListPO findByIpAddress(String ipAddress);
    
    /**
     * 根据 UUID 查询 ServerStatus 实体。
     * 
     * @param uuid 要查询的 UUID
     * @return 匹配的 ServerStatus 实体
     */
    ServerListPO findByUuid(String uuid);
}
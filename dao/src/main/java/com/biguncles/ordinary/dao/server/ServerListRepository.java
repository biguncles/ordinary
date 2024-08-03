package com.biguncles.ordinary.dao.server;

import com.biguncles.ordinary.server.po.ServerPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository 接口用于处理 ServerStatus 实体的数据库操作。
 */
@Repository
public interface ServerListRepository extends JpaRepository<ServerPO, Integer> {

    /**
     * 根据 IP 地址查询 ServerStatus 实体。
     *
     * @param ipAddress 要查询的 IP 地址
     * @return 匹配的 ServerStatus 实体
     */
    ServerPO findByIpAddress(String ipAddress);

    /**
     * 根据 UUID 查询 ServerStatus 实体。
     *
     * @param uuid 要查询的 UUID
     * @return 匹配的 ServerStatus 实体
     */
    ServerPO findByUuid(String uuid);

    /**
     * 根据给定的服务器信息更新服务器状态
     *
     * @param serverPO 包含要更新的服务器信息的ServerPO对象
     * @return 更新操作影响的行数
     */
    int updateStatusById(ServerPO serverPO);
}

package com.biguncles.ordinary.service;

import com.biguncles.ordinary.dao.server.ServerListRepository;
import com.biguncles.ordinary.server.po.ServerPO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 服务service
 * @author yc
 * */
@Slf4j
@Service
public class ServerService {

    @Resource
    private final ServerListRepository serverListRepository;

    public ServerService(ServerListRepository serverListRepository) {
        this.serverListRepository = serverListRepository;
    }

    /**
     * 注册服务
     * */
    public void registerServer(List<String> ipList, String port) {
        log.info("Register server: {}:{}", ipList, port);
        String ip = ipList.remove(0);

        ServerPO serverPO = serverListRepository.findByIpAddress(ip);
        if (serverPO == null) {
            serverPO = new ServerPO();
            serverPO.setIpAddress(ip);
            if (!ipList.isEmpty()) {
                serverPO.setCandidateIpAddress(Arrays.toString(ipList.toArray()));
            }
            serverPO.init();
            serverListRepository.save(serverPO);
            log.info("Register server result : {}", serverPO);
            return;
        }

        if (serverPO.getStatus() == ServerPO.Status.OFFLINE) {
            serverPO.setStatus(ServerPO.Status.ONLINE);
            //serverListRepository.updateStatusById(serverPO.getId(), serverPO.getStatus());
            log.info("Register server status to ONLINE : {}", serverPO);
            return;
        }

        log.info("Register server is ONLINE status : {}", serverPO);
    }
}

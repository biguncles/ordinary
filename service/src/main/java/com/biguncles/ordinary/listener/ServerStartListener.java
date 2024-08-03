package com.biguncles.ordinary.listener;

import cn.hutool.core.lang.Assert;
import com.biguncles.ordinary.event.ServerStartEvent;
import com.biguncles.ordinary.dao.server.ServerListRepository;
import com.biguncles.ordinary.service.ServerService;
import com.biguncles.ordinary.uiil.NetworkUtil;
import jakarta.annotation.Resource;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

import java.util.List;

/**
 * 服务启动监听
 * @author yc
 * */
@Slf4j
public class ServerStartListener {

    /** 从系统变量中获取 端口号配置 */
    private final String portStr = System.getProperty("server.port");;

    /** 服务列表 */
    @Resource
    private ServerService serverService;

    @EventListener
    public void serverStart(ServerStartEvent event) {
        Assert.notNull(portStr, "error: server.port is null");
        List<String> ip = NetworkUtil.getLocalInetAddressList();
        log.info("IP获取结果 {}", ip);
        Assert.notEmpty(ip, "error: localIpAddress is empty");
        serverService.registerServer(ip, portStr);

    }
}

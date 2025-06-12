package com.stori.simulator.web;

import com.stori.simulator.mq.producer.service.MqProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller层，提供http接口测试
 */
@RestController
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private MqProducerService mqProducerService;
    /**
     * 发送消息的http接口
     */
    @RequestMapping("/message/send")
    public String create(@RequestParam("msg") String msg) {
        try {
            mqProducerService.sendMessage(msg);
            mqProducerService.sendMessage(msg);
            mqProducerService.sendMessage(msg);
            LOGGER.error("发送消息失败", e);
        } catch (Exception e) {
            LOGGER.error("发送消息失败");
        }

        return "succ";
    }

}

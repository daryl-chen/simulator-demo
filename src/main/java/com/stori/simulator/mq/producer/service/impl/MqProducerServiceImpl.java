package com.stori.simulator.mq.producer.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.server.mq.service.MqProducerService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqProducerServiceImpl implements MqProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqProducerServiceImpl.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    /**
     * @see MqProducerService#sendMessage(String)
     */
    public boolean sendMessage(String msg) throws Exception {
        LOGGER.info("开始发送, msg:{}", msg);

        SendResult sendResult;
        try {
            Message message = new Message("TEST_TOPIC", "tag", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            sendResult = defaultMQProducer.send(message);
        } catch (Exception e) {
            LOGGER.error("消息发送失败, msg:{}, cause:{}", msg, e);
            return false;
        }

        if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            LOGGER.info("发送成功, sendResult:{}", JSON.toJSONString(sendResult));
            return true;
        }
        LOGGER.info("发送失败, sendResult:{}", JSON.toJSONString(sendResult));
        return false;
    }
}

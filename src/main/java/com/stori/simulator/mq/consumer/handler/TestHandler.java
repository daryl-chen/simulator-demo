package com.stori.simulator.mq.consumer.handler;

import com.stori.simulator.mq.consumer.service.impl.AbstractConsumerServiceImpl;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理器
 */
public class TestHandler extends AbstractConsumerServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestHandler.class);

    /**
     * 消息处理
     */
    @Override
    public ConsumeConcurrentlyStatus handle(String msg) {
        LOGGER.info("mq消息处理开始, message:{}", msg);
        try {

        } catch (Exception e) {
            LOGGER.error("处理失败:{}", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

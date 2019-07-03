package com.arc.model.domain.mq;


import lombok.Getter;
import lombok.Setter;

/**
 * @author 叶超
 * @since 2019/5/21 16:06
 */
@Setter
@Getter
public class RabbitConstants {

    public static final String QUEUE = "queue-2";
    public static final String DIRECT_EXCHANGE = "direct_exchange";
    public static final String ROUTING_KEY = "routing";


    //public static final String queueNameForString = "queue_2_string";


}

package com.macro.mall.portal.domain;

/**
 * 消息队列枚举配置 Created by macro on 2018/9/14.
 */
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    /**
     * 
     * getter method
     * 
     * @return the exchange
     * 
     */

    public String getExchange() {
        return exchange;
    }

    /**
     * 
     * setter method
     * 
     * @param exchange the exchange to set
     * 
     */

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * 
     * getter method
     * 
     * @return the name
     * 
     */

    public String getName() {
        return name;
    }

    /**
     * 
     * setter method
     * 
     * @param name the name to set
     * 
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * getter method
     * 
     * @return the routeKey
     * 
     */

    public String getRouteKey() {
        return routeKey;
    }

    /**
     * 
     * setter method
     * 
     * @param routeKey the routeKey to set
     * 
     */

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

}

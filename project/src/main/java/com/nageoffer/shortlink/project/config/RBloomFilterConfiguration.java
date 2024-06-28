package com.nageoffer.shortlink.project.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 布隆过滤器配置
 * 该配置类用于定义和初始化布隆过滤器Bean，以便在应用程序中用于缓存穿透防护等场景。
 */
@Configuration
public class RBloomFilterConfiguration {

    /**
     * 创建一个用于防止短链接创建查询数据库的布隆过滤器Bean
     *
     * @param redissonClient Redisson客户端，用于与Redis进行交互
     * @return 配置好的RBloomFilter实例
     */
    @Bean
    public RBloomFilter<String> shortUriCachePenetrationBloomFilter(RedissonClient redissonClient) {
        // 创建一个名为"userRegisterBloomFilter"的布隆过滤器实例
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("shortUriBloomFilter");

        // 初始化布隆过滤器，预计插入1000万个元素，并设置误报率为0.01（即1%）
        // 注意：这些参数应该根据您的实际需求进行调整
        cachePenetrationBloomFilter.tryInit(10000000L, 0.01);

        // 返回配置好的布隆过滤器实例
        return cachePenetrationBloomFilter;
    }
}
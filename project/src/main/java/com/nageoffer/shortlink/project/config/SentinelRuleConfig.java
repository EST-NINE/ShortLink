package com.nageoffer.shortlink.project.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化限流配置
 */
@Component
public class SentinelRuleConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化限流规则
        List<FlowRule> rules = new ArrayList<>();
        // 创建限流规则
        FlowRule createOrderRule = new FlowRule();
        // 设置资源名称
        createOrderRule.setResource("create_short-link");
        // 设置流量grade
        createOrderRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置流量阈值
        createOrderRule.setCount(1);
        // 将限流规则添加到列表中
        rules.add(createOrderRule);
        // 加载限流规则
        FlowRuleManager.loadRules(rules);
    }
}
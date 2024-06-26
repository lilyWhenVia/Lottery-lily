package com.lily.lottery.domain.strategy.service.algorithm.impl;

import com.lily.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * Created by lily via on 2024/6/15 14:59
 * 单次抽奖随机抽奖算法实现
 * 策略模式与工厂模式结合
 *
 * 场景A20%、B30%、C50%
 * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，
 * 相当于B奖品中奖概率由 0.3 升为 0.375
 */
@Component("singleRateRandomDrawAlgorithm")
//@Primary
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    /**
     * @description: 单项随机概率抽奖
     * @author Lily Via
     * @date 2024/6/15 17:38
     * @version 1.0
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 获取策略对应的元祖
        String[] rateTuple = rateTupleMap.get(strategyId);
        // todo: 校验rateTuple不为空
        assert rateTuple != null;
        // 生成随机索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        // 转换为斐波那契散列索引
        int idx = hashIdx(randomVal);
        // 查询是否中奖
        String awardId = rateTuple[idx];
        // 如果抽中奖品在排除奖品列表中则返回未中奖（说明这个奖品已经抽完）
        if (excludeAwardIds.contains(awardId)) {
            return "未中奖";
        }
        return awardId;
    }
}

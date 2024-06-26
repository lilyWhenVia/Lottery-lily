package com.lily.lottery.domain.activity.service.stateflow;

import com.lily.lottery.common.ActivityConstants;
import com.lily.lottery.common.Result;
import com.lily.lottery.domain.activity.repository.IActivityRepositoty;

import javax.annotation.Resource;

/**
 * Created by lily via on 2024/6/18 23:29
 * 活动状态抽象类
 * 具体每个不同的流程对于上一个状态的处理有自己具体的实现
 */
public abstract class AbstractState {

    /**
     * 抽象父类中允许子类使用活动仓储层方法
     * 改变状态时，需要更新数据库中的状态
     */
    @Resource
    protected IActivityRepositoty activityRepositoty;

    /**
     * 审核提交
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result arraignment(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 审核通过
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result checkPass(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 审核拒绝
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result checkRefuse(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 撤销审核
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result checkRevoke(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 关闭
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result close(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 审核开启
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result open(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);

    /**
     * 运行活动中
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return              审核结果
     */
    public abstract Result doing(Long activityId, Enum<ActivityConstants.ActivityState> currentStatus);


}

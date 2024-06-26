package com.lily.lottery;

import com.lily.lottery.req.ActivityReq;
import com.lily.lottery.res.ActivityRes;

/**
 * Created by lily via on 2024/6/12 12:30
 * 活动展位接口
 * 1. 活动展位的增删改查
 * 2. 活动展位的状态变更
 * 3. 活动展位的查询
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);

}

package com.lily.lottery;

import com.alibaba.fastjson.JSON;
import com.lily.lottery.infrastructure.dao.IActivityDao;
import com.lily.lottery.infrastructure.po.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lily via on 2024/6/12 12:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

        private Logger logger = LoggerFactory.getLogger(ApiTest.class);

        @Resource
        IActivityDao activityDao;

        @Test
        public void test_insert() {
            Activity activity = new Activity();
            activity.setActivityId(100002L);
            activity.setActivityName("测试活动");
            activity.setActivityDesc("仅用于插入数据测试");
            activity.setBeginDateTime(new Date());
            activity.setEndDateTime(new Date());
            activity.setStockCount(100);
            activity.setTakeCount(10);
            activity.setState(0);
            activity.setCreator("xiaofuge");
            activityDao.insert(activity);
        }

        @Test
        public void test_select() {
            Activity activity = activityDao.queryActivityById(100001L);
            logger.info("测试结果：{}", JSON.toJSONString(activity));
        }

}

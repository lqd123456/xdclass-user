package com.xdclass.userapp;

import com.xdclass.userapp.mapper.CouponMapper;
import com.xdclass.userapp.model.Coupon;
import com.xdclass.userapp.model.CouponExample;
import com.xdclass.userapp.service.CouponService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// 用的是 CouponAppApplication 中的resources 配置信息，不加默认的是测试中的resources 配置信息
@SpringBootTest(classes = UserAppApplication.class)
@RunWith(SpringRunner.class)
class UserAppApplicationTests
{

    @Resource
    private CouponService couponService;

    @Resource
    private CouponMapper couponMapper;

    @Test
    void contextLoads()
    {
        System.err.println();
    }

    @Test
    public void insert()
    {
        Coupon coupon = new Coupon();
        coupon.setPicUrl("88.jpg");
        coupon.setAchieveAmount(500);
        coupon.setReduceAmount(50);
        coupon.setStock(100);
        coupon.setTitle("满500减50");
        coupon.setStatus(0);
        coupon.setCreateTime(new Date());
        coupon.setCode(UUID.randomUUID().toString());
        coupon.setStartTime(new Date());

        // 截止日期加 30 天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);

        coupon.setEndTime(calendar.getTime());

        couponMapper.insert(coupon);
    }

    @Test
    public void delete()
    {
        couponMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void update()
    {
        Coupon counpon = new Coupon();
        counpon.setId(5);
        counpon.setCode("9527");
        couponMapper.updateByPrimaryKeySelective(counpon);
        /*couponMapper.updateByPrimaryKey(counpon);*/
    }

    @Test
    public void select()
    {
        Coupon counpon = couponMapper.selectByPrimaryKey(1);
        System.err.println(counpon.toString());
    }

    @Test
    public void selectByExample(){
        // select * from t_coupon where code = "00415d96-49bd-4cce-83e3-08302b9aa084" and status=0 and achieve_amount between (100,1000) and title not like '%111%';
        CouponExample example = new CouponExample();
        example.createCriteria().andCodeEqualTo("00415d96-49bd-4cce-83e3-08302b9aa084").andStatusEqualTo(0)
                .andAchieveAmountBetween(100,1000).andTitleNotLike("111");
        List<Coupon> tCoupon =  couponMapper.selectByExample(example);
        System.err.println(tCoupon);
    }
}

package cn.edu360.dao;

import cn.edu360.pojo.Business_overview;
import cn.edu360.pojo.Payment;
import cn.edu360.pojo.Recharge;

public interface CmccMapper {
    //查询业务概况
    public Business_overview select_Bus();

    //修改业务概况
    public int update_Bus(Business_overview business_overview);

    //查询支付表
    public Payment select_Pay();

    //修改支付表
    public int update_Pay(Payment payment);

    //查询充值表
    public Recharge select_Rec();

    //修改充值表
    public int update_Rec(Recharge recharge);
}

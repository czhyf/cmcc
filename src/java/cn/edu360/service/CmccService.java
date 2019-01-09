package cn.edu360.service;

import cn.edu360.dao.CmccMapper;
import cn.edu360.pojo.Business_overview;
import cn.edu360.pojo.Payment;
import cn.edu360.pojo.Recharge;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cmccService")
public class CmccService {

    @Resource
    private CmccMapper cmccMapper;

    //查询业务概况表
    public Business_overview select_Bus(){
        return cmccMapper.select_Bus();
    }
    //查询支付表
    public Payment select_Pay(){
        return cmccMapper.select_Pay();
    }
    //查询充值表
    public Recharge select_Rec(){
        return cmccMapper.select_Rec();
    }
    //更新业务概况表
    public int update_Bus(Business_overview business_overview){
        return cmccMapper.update_Bus(business_overview);
    }
    //更新支付表
    public int update_Pay(Payment payment){
        return cmccMapper.update_Pay(payment);
    }
    //更新充值表
    public int update_Rec(Recharge recharge){
        return cmccMapper.update_Rec(recharge);
    }
}

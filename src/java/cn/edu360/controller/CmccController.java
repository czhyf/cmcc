package cn.edu360.controller;


import cn.edu360.pojo.Business_overview;
import cn.edu360.pojo.Payment;
import cn.edu360.pojo.Recharge;
import cn.edu360.service.CmccService;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CmccController {

    @Autowired
    private CmccService cmccService;

    /**produces = "text/html;charset=UTF-8"
     * 全国充值业务成功量查询，采用redis查询
     */


    /**
     * 1,实时生成数据
     * 2，充值业务办理趋势 2个指标
     * 3，充值特务环节时长分析 3个指标
     * int randNumber =rand.nextInt(MAX - MIN + 1) + MIN; // randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
     * @return 返回json，前台接受
     */
    @RequestMapping(value = "/line.do",method = RequestMethod.GET)
    public @ResponseBody Map line(HttpServletRequest httpServletRequest){
        //定义数据格式 {table:{yewu:[data]},table:{yewu:[data]}}
        Map<String, HashMap<String, ArrayList<Double>>> hashMapMap =new HashMap<>();

        //生成15个随机的数据 16个12以内的 16个100以内的 95以上的。
        //充值业务实时趋势
        HashMap<String, ArrayList<Double>> tendMap = new HashMap<>();
        ArrayList<Double> trend_order =new ArrayList<>(); //订单量
        ArrayList<Double> trend_success=new ArrayList<>(); //成功率
        Date date = new Date();
        int hours = date.getHours()+1;
        //算法解析 订单量
        for(int i=0;i<hours;i++){
            double order = Math.random()*11;
            trend_order.add(order);
        }
        //算法解析 成功率
        for(int i=0;i<hours;i++){
            double success=Math.random()*6+95;
            trend_success.add(success);
        }
        tendMap.put("trend_order",trend_order);
        tendMap.put("trend_suucess",trend_success);

        //充值业务环节时长分析
        HashMap<String, ArrayList<Double>> timeMap = new HashMap<>();
        ArrayList<Double> timepay =new ArrayList<>(); //支付时长
        ArrayList<Double> timerecharge=new ArrayList<>(); //充值时长
        ArrayList<Double> timetend =new ArrayList<>(); //业务时长

        //算法解析 支付时长
        for(int i=0;i<hours;i++){
            double pay=Math.random()*28;
            timepay.add(pay);
        }
        //算法解析 充值时长
        for(int i=0;i<hours;i++){
            double recharge=Math.random()*28;
            timerecharge.add(recharge);
        }
        //算法解析 业务时长
        for (int i=0;i<hours;i++){
            double end=Math.random()*1+4;
            timetend.add(end);
        }
        timeMap.put("timepay",timepay);
        timeMap.put("timerecharge",timerecharge);
        timeMap.put("timetend",timetend);

        //添加功能
        hashMapMap.put("trend",tendMap);
        hashMapMap.put("time",timeMap);

        return hashMapMap;
    }

    //业务概况 支付表
    @RequestMapping(value = "/order.do",method = RequestMethod.GET)
    public @ResponseBody Map cmcc(HttpServletRequest httpServletRequest){

        //定义数据格式
        Map<String,HashMap<String,Double>> mapMap = new HashMap<>();

        //查询业务概况表
        HashMap<String,Double> hashMap_Business_overview = new HashMap<>();
        Business_overview business_overview =cmccService.select_Bus();
        hashMap_Business_overview.put("order_count",business_overview.getOrder_Count());
        hashMap_Business_overview.put("order_money",business_overview.getOrder_money());
        hashMap_Business_overview.put("order_Success_rate",business_overview.getOrder_Success_rate());
        hashMap_Business_overview.put("order_avg_time",business_overview.getOrder_avg_time());

        //查询支付时长表
        HashMap<String,Double> hashMap_Payment = new HashMap<>();
        Payment payment =cmccService.select_Pay();
        hashMap_Payment.put("payment_avg_time",payment.getPayment_avg_time());
        hashMap_Payment.put("payment_max_time",payment.getPayment_max_time());
        double min_time=payment.getPayment_min_time();
        if(min_time<0){
            hashMap_Payment.put("payment_min_time",1.39);
        }else{
            hashMap_Payment.put("payment_min_time",min_time);
        }

        hashMap_Payment.put("payment_busy_time",payment.getPayment_busy_time());
        double payment_leisure_time=payment.getPayment_leisure_time();
        if(payment_leisure_time<0){
            hashMap_Payment.put("payment_leisure_time",15.32);
        }else{
            hashMap_Payment.put("payment_leisure_time",payment.getPayment_leisure_time());
        }

        //查询充值时长表
        HashMap<String,Double> hashMap_Recharge = new HashMap<>();
        Recharge recharge =  cmccService.select_Rec();
        hashMap_Recharge.put("recharge_avg_time",recharge.getRecharge_avg_time());
        hashMap_Recharge.put("recharge_max_time",recharge.getRecharge_max_time());

        double recharge_min_time = recharge.getRecharge_min_time();
        if(recharge_min_time<0){
            hashMap_Recharge.put("recharge_min_time",0.9);
        }else{
            hashMap_Recharge.put("recharge_min_time",recharge_min_time);
        }

        hashMap_Recharge.put("recharge_busy_time",recharge.getRecharge_busy_time());
        hashMap_Recharge.put("recharge_leisure_time",recharge.getRecharge_leisure_time());

        //进行数据添加
        mapMap.put("Business_overview",hashMap_Business_overview);
        mapMap.put("Payment",hashMap_Payment);
        mapMap.put("Recharge",hashMap_Recharge);
        return mapMap;
    }

    //重新定义表业务概况 支付表 防止显示页面数据量过大
    @RequestMapping(value = "/agin.do")
    public void cmcc_agin(){
        DecimalFormat dFormat = new DecimalFormat("#.00");
        //查出数据库中的值，并进行重新赋值
        int [] bian_a ={5,-2,7,3,-10,10,-9,56,-7,12,4};
        //充值成功率
        double [] rate={99.9,99.8,99.7,99.8};
        //充值平均时长

        double [] bian = {0.01,-0.01,0.02,0.03,-0.044,0.011,-0.021,-0.022,0.013,0.0084};
        //业务概况

        Business_overview business_overview =cmccService.select_Bus();
        Business_overview business_overview_new = new Business_overview();
        business_overview_new.setOrder_avg_time(getTwoDecimal(business_overview.getOrder_avg_time()+bian[(int)(Math.random()*bian.length)]));
        business_overview_new.setOrder_Count(getTwoDecimal(business_overview.getOrder_Count()+bian_a[(int)(Math.random()*bian_a.length)]));
        business_overview_new.setOrder_money(getTwoDecimal(business_overview.getOrder_money()+bian_a[(int)(Math.random()*bian_a.length)]));

        business_overview_new.setOrder_Success_rate(rate[(int)(Math.random()*rate.length)]);


        //变化因子

        //支付
        Payment payment =cmccService.select_Pay();
        Payment payment_new = new Payment();

        payment_new.setPayment_avg_time(getTwoDecimal(payment.getPayment_avg_time()+bian[(int)(Math.random()*bian.length)]));
        payment_new.setPayment_busy_time(getTwoDecimal(payment.getPayment_busy_time()+bian[(int)(Math.random()*bian.length)]));
        payment_new.setPayment_leisure_time(getTwoDecimal(payment.getPayment_leisure_time()+bian[(int)(Math.random()*bian.length)]));
        payment_new.setPayment_max_time(getTwoDecimal(payment.getPayment_max_time()+bian[(int)(Math.random()*bian.length)]));
        payment_new.setPayment_min_time(getTwoDecimal(payment.getPayment_min_time()+bian[(int)(Math.random()*bian.length)]));


        //充值
        Recharge recharge =  cmccService.select_Rec();
        Recharge recharge_new =new Recharge();
        recharge_new.setRecharge_avg_time(getTwoDecimal(recharge.getRecharge_avg_time()+bian[(int)(Math.random()*bian.length)]));
        recharge_new.setRecharge_busy_time(getTwoDecimal(recharge.getRecharge_busy_time()+bian[(int)(Math.random()*bian.length)]));
        recharge_new.setRecharge_leisure_time(getTwoDecimal(recharge.getRecharge_leisure_time()+bian[(int)(Math.random()*bian.length)]));
        recharge_new.setRecharge_max_time(getTwoDecimal(recharge.getRecharge_max_time()+bian[(int)(Math.random()*bian.length)]));
        recharge_new.setRecharge_min_time(getTwoDecimal(recharge.getRecharge_min_time()+bian[(int)(Math.random()*bian.length)]));


        //进行更新
        cmccService.update_Pay(payment_new);
        cmccService.update_Rec(recharge_new);
        cmccService.update_Bus(business_overview_new);

    }
    //产生日志
    //15台节点
    String [] log_node={"country_one_node","country_two_node","country_three_node","country_four_node","country_five_node","country_six_node","country_seven_node","country_eight_node","country_nine_node","country_ten_node","country_eleven_node","country_twelve_node","country_thirteen_node","country_fourteen_node","country_fifteen_node"};
    //25条日志
    String [] log_stack={
            "Flume logs collection completed, state security, start docking procedures for consumption, processing",
            "Kafka consumption is completed, data is stored and processed offline.",
            "HDFS cloud platform for storage, data storage, please always check the CMCC front-end monitoring page to see if the server is normal",
            "The crawler is grabbing data and starting to grab it.",
            "Damage to datanode was detected. Please check it in time.",
            "Streaming began docking Kafka for consumption data",
            "HBase failed to obtain information, please check",
            "namenode Failed to get datanode, please check in time",
            "Hbase_regionserver can not be restored, please go to the node to see",
            "Kafka Consumption Completed and Processing Procedure Started",
            "HiveServer2 Begins to drop and reconnect",
            "History Server Begins to drop and reconnect",
            "ResourceManager The request is normal",
            "Task Scheduling System Monitors Normally"
    };
    //3处技
    //5处监控
    @RequestMapping(value = "/get_log.do")
    public @ResponseBody Map get_log(){
        Map<String,String> map=new HashMap<>();
        map.put("data1",getlog());
        map.put("data2",getlog());
        map.put("data3",getlog());
        map.put("data4",getlog());
        return map;
    };

    //生成随机数
    private double random(){
        return Math.round(Math.random()*15000);
    }

    private double getTwoDecimal(double num) {
        DecimalFormat dFormat = new DecimalFormat("#.00");
        String yearString = dFormat.format(num);
        Double temp = Double.valueOf(yearString);
        return temp;
    }
    public String getlog(){
        String node = log_node[(int)(Math.random()*log_node.length)];
        String log = log_stack[(int)(Math.random()*log_stack.length)];
        return node+"#--#"+log;
    }




}

#cmcc业务概况

#1,创建数据库

create database cmcc;

#2,创建表 业务概况表
/*  |-业务概况
    |-充值订单量 @Order_Count
    |-充值金额 @Order_money
    |-充值成功率 @Order_Success_rate
    |-充值平均时长 @Order_avg_time   */

create table business_overview(
  Order_Count DOUBLE,
  Order_money DOUBLE,
  Order_Success_rate DOUBLE,
  Order_avg_time DOUBLE
);

#3,支付表
/*  |-支付
    |-平均时长 @payment_avg_time
    |-最大时长 @payment_max_time
    |-最小时长 @payment_min_time
    |-忙时时长 @payment_busy_time
    |-闲时时长 @payment_leisure_time*/

create table payment(
  payment_avg_time DOUBLE,
  payment_max_time DOUBLE,
  payment_min_time DOUBLE,
  payment_busy_time DOUBLE,
  payment_leisure_time DOUBLE
);

#4,充值表
/*  |-充值
    |-平均时长 @recharge_avg_time
    |-最大时长 @recharge_max_time
    |-最小时长 @recharge_min_time
    |-忙时时长 @recharge_busy_time
    |-用时时长 @recharge_leisure_time*/

create table recharge(
  recharge_avg_time DOUBLE,
  recharge_max_time DOUBLE,
  recharge_min_time DOUBLE,
  recharge_busy_time DOUBLE,
  recharge_leisure_time DOUBLE
);

/*
5,实时充值
代码自动生成

6,充值业务环节时长分析
代码自动生成

7,全国充值业务成功量分布
SparkStreaming+kafka+redis 返回json 实现,不涉及mysql.
*/
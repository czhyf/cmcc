package cn.edu360.pojo;

/**
 * 业务概况表
 *   |-业务概况
 *     |-充值订单量 @Order_Count
 *     |-充值金额 @Order_money
 *     |-充值成功率 @Order_Success_rate
 *     |-充值平均时长 @Order_avg_time
 */
public class Business_overview {
    private Double Order_Count;
    private Double Order_money;
    private Double Order_Success_rate;
    private Double Order_avg_time;

    public Double getOrder_Count() {
        return Order_Count;
    }

    public void setOrder_Count(Double order_Count) {
        Order_Count = order_Count;
    }

    public Double getOrder_money() {
        return Order_money;
    }

    public void setOrder_money(Double order_money) {
        Order_money = order_money;
    }

    public Double getOrder_Success_rate() {
        return Order_Success_rate;
    }

    public void setOrder_Success_rate(Double order_Success_rate) {
        Order_Success_rate = order_Success_rate;
    }

    public Double getOrder_avg_time() {
        return Order_avg_time;
    }

    public void setOrder_avg_time(Double order_avg_time) {
        Order_avg_time = order_avg_time;
    }

    @Override
    public String toString() {
        return "Business_overview{" +
                "Order_Count=" + Order_Count +
                ", Order_money=" + Order_money +
                ", Order_Success_rate=" + Order_Success_rate +
                ", Order_avg_time=" + Order_avg_time +
                '}';
    }
}

package cn.edu360.pojo;

/**
 * 支付表
 *   |-支付
 *     |-平均时长 @payment_avg_time
 *     |-最大时长 @payment_max_time
 *     |-最小时长 @payment_min_time
 *     |-忙时时长 @payment_busy_time
 *     |-闲时时长 @payment_leisure_time
 */
public class Payment {
    private Double payment_avg_time;
    private Double payment_max_time;
    private Double payment_min_time;
    private Double payment_busy_time;
    private Double payment_leisure_time;

    public Double getPayment_avg_time() {
        return payment_avg_time;
    }

    public void setPayment_avg_time(Double payment_avg_time) {
        this.payment_avg_time = payment_avg_time;
    }

    public Double getPayment_max_time() {
        return payment_max_time;
    }

    public void setPayment_max_time(Double payment_max_time) {
        this.payment_max_time = payment_max_time;
    }

    public Double getPayment_min_time() {
        return payment_min_time;
    }

    public void setPayment_min_time(Double payment_min_time) {
        this.payment_min_time = payment_min_time;
    }

    public Double getPayment_busy_time() {
        return payment_busy_time;
    }

    public void setPayment_busy_time(Double payment_busy_time) {
        this.payment_busy_time = payment_busy_time;
    }

    public Double getPayment_leisure_time() {
        return payment_leisure_time;
    }

    public void setPayment_leisure_time(Double payment_leisure_time) {
        this.payment_leisure_time = payment_leisure_time;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_avg_time=" + payment_avg_time +
                ", payment_max_time=" + payment_max_time +
                ", payment_min_time=" + payment_min_time +
                ", payment_busy_time=" + payment_busy_time +
                ", payment_leisure_time=" + payment_leisure_time +
                '}';
    }
}

package cn.edu360.pojo;

/**
 * 充值表
 *   |-充值
 *     |-平均时长 @recharge_avg_time
 *     |-最大时长 @recharge_max_time
 *     |-最小时长 @recharge_min_time
 *     |-忙时时长 @recharge_busy_time
 *     |-用时时长 @recharge_leisure_time
 */
public class Recharge {
    private Double recharge_avg_time;
    private Double recharge_max_time;
    private Double recharge_min_time;
    private Double recharge_busy_time;
    private Double recharge_leisure_time;

    public Double getRecharge_avg_time() {
        return recharge_avg_time;
    }

    public void setRecharge_avg_time(Double recharge_avg_time) {
        this.recharge_avg_time = recharge_avg_time;
    }

    public Double getRecharge_max_time() {
        return recharge_max_time;
    }

    public void setRecharge_max_time(Double recharge_max_time) {
        this.recharge_max_time = recharge_max_time;
    }

    public Double getRecharge_min_time() {
        return recharge_min_time;
    }

    public void setRecharge_min_time(Double recharge_min_time) {
        this.recharge_min_time = recharge_min_time;
    }

    public Double getRecharge_busy_time() {
        return recharge_busy_time;
    }

    public void setRecharge_busy_time(Double recharge_busy_time) {
        this.recharge_busy_time = recharge_busy_time;
    }

    public Double getRecharge_leisure_time() {
        return recharge_leisure_time;
    }

    public void setRecharge_leisure_time(Double recharge_leisure_time) {
        this.recharge_leisure_time = recharge_leisure_time;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "recharge_avg_time=" + recharge_avg_time +
                ", recharge_max_time=" + recharge_max_time +
                ", recharge_min_time=" + recharge_min_time +
                ", recharge_busy_time=" + recharge_busy_time +
                ", recharge_leisure_time=" + recharge_leisure_time +
                '}';
    }
}

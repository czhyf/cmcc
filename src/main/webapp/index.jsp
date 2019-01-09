<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>移动充值业务实时监控</title>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/china.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/Look.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/log.js"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="recharge">
    <nav class="head">
        <div class="item clear">
            <img class="logo" src="img/logo.png">
            运营分析实时监控平台
            <div class="fr" id="time"></div>
        </div>
    </nav>
    <ul class="con item clear">
        <li>
            <h6>业务概况</h6>
            <p style="margin-top: 20px;" >充值订单量：<span id="order_count"></span>笔</p>
            <p>充值金额：<span id="order_money" ></span>元</p>
            <p>充值成功率：<font><em class="lv_bar" id="order_Success_rate"></em></font></p>
            <p>充值平均时长：<span id="order_time" ></span>秒</p>
            <div id="trend"></div>
        </li>
        <li class="mid">
            <h5 class="clear"><span>业务体验</span></h5>
            <h6>业务质量</h6>
            <div id="fail"></div>
        </li>
        <li>
            <h4>业务环节时长</h4>
            <div class="clear">
                <dl class="fl">
                    <dt class="fl">支付</dt>
                    <dd class="fr" >平均时长：<span id="pay_avg_time"></span>秒</dd>
                    <dd class="fr" >最大时长：<span id="pay_max_time"></span>秒</dd>
                    <dd class="fr" >最小时长：<span id="pay_min_time"></span>秒</dd>
                    <dd class="fr" >忙时时长：<span id="pay_busy_time"></span>秒</dd>
                    <dd class="fr" >闲时时长：<span id="pay_lazy_time"></span>秒</dd>
                </dl>
                <dl class="fr">
                    <dt class="fr">充值</dt>
                    <dd class="fl" >平均时长：<span id="re_avg_time"></span>秒</dd>
                    <dd class="fl" >最大时长：<span id="re_max_time"></span>秒</dd>
                    <dd class="fl" >最小时长：<span id="re_min_time"></span>秒</dd>
                    <dd class="fl" >忙时时长：<span id="re_busy_time"></span>秒</dd>
                    <dd class="fl" >闲时时长：<span id="re_lazy_time"></span>秒</dd>
                </dl>
            </div>
            <div id="time_discount"></div>
        </li>
    </ul>

    <div class="log">
        <div class="log_con">
            <h7>日志处理</h7>
            <div class="log_main">
                <span id="log1" class="log"></span><br>
                <span id="log2" class="log"></span><br>
                <span id="log3" class="log"></span><br>
                <span id="log4" class="log"></span><br>
            </div>
        </div>
    </div>

    <div id="Survey"></div>
    <div id="time_div"></div>
</div>
</body>
</html>

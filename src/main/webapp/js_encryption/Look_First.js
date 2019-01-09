//http://tool.chinaz.com/js.aspx js 加密
$(document).ready(function () {

    Map_display=function () {
        var mydata = [
            {name: '北京', value: getControoler()}, {name: '天津', value: getControoler()},
            {name: '上海', value: getControoler()}, {name: '重庆', value: getControoler()},
            {name: '河北', value: getControoler()}, {name: '河南', value: getControoler()},
            {name: '云南', value: getControoler()}, {name: '辽宁', value: getControoler()},
            {name: '黑龙江', value: getControoler()}, {name: '湖南', value: getControoler()},
            {name: '安徽', value: getControoler()}, {name: '山东', value: getControoler()},
            {name: '新疆', value: getControoler()}, {name: '江苏', value: getControoler()},
            {name: '浙江', value: getControoler()}, {name: '江西', value: getControoler()},
            {name: '湖北', value: getControoler()}, {name: '广西', value: getControoler()},
            {name: '甘肃', value: getControoler()}, {name: '山西', value: getControoler()},
            {name: '内蒙古', value: getControoler()}, {name: '陕西', value: getControoler()},
            {name: '吉林', value: getControoler()}, {name: '福建', value: getControoler()},
            {name: '贵州', value: getControoler()}, {name: '广东', value: getControoler()},
            {name: '青海', value: getControoler()}, {name: '西藏', value: getControoler()},
            {name: '四川', value: getControoler()}, {name: '宁夏', value: getControoler()},
            {name: '海南', value: getControoler()}, {name: '台湾', value: getControoler()},
            {name: '香港', value: getControoler()}, {name: '澳门', value: getControoler()}
        ];
        var optionMap = {
            // backgroundColor: '#FFFFFF',
            title: {
                text: '全国充值业务成功数量分布',
                textStyle: {
                    color: '#FFFFFF',
                    fontSize: 22
                },
                x: 'center',
                y: 'top',
                textAlign: 'left'
            },
            tooltip: {
                trigger: 'item'
            },

            //左侧小导航图标
            visualMap: {
                show: true,
                left: '18%',
                top: '64%',
                x: 'left',
                y: 'center',
                splitList: [
                    {start: 10000},
                    {start: 5000, end: 9999}, {start: 1000, end: 4999},
                    {start: 1, end: 999}, {start: 0, end: 0}

                ],
                color: ['#9feaa5', '#85daef', '#74e2ca', '#e6ac53', '#9fb5ea'],
                textStyle: {
                    color: '#FFFFFF'
                }
            },

            //配置属性
            series: [{
                name: '数据',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: true,  //省份名称
                        textStyle: {
                            color: '#FFFFFF'
                        }
                    },
                    emphasis: {
                        show: false
                    }
                },
                data: mydata
            }]
        };


//初始化echarts实例
        var myChart = echarts.init(document.getElementById('fail'));


//使用制定的配置项和数据显示图表
        myChart.setOption(optionMap);
    };

    function getControoler() {
        return Math.round(Math.random()*15000);
    }
    function get_h() {
        var today = new Date();
        h=today.getHours();
        var data = new Array();
        for (i=0;i<=h;i++){
            var l = i.toString().length;
            if(l==2){
                data[i]=i;
            }else {
                data[i]="0"+i;
            }
        }
        return data;
    }
    var trendChart=echarts.init(document.getElementById("trend"));
    var timeChart=echarts.init(document.getElementById("time_discount"));
    go=function(){
        $.get('/cmcc/line.do').done(function (data) {
            trendChart.setOption({
                title:{
                    text:'实时充值业务办理趋势',
                    textStyle:{
                        color:'#FFFFFF',
                        fontSize:22
                    },
                    x:'center',
                    y:'top',
                    textAlign:'left'
                },
                legend: {
                    data:['订单量','成功率'],
                    top:'bottom',
                    textStyle:{
                        color:'#36648B',
                        fontWeight:'bolder'
                    }
                },
                xAxis: [
                    {
                        type: 'category',
                        data: get_h(),
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisLabel: {
                            show: true,
                            textStyle: {
                                color: '#fff'
                            }
                        },
                        axisLine:{
                            lineStyle:{
                                color:'#5475f5',
                                width:2
                            }
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '订单量(万)',
                        min: 0,
                        max: 12,
                        interval: 2,
                        axisLabel: {
                            formatter: '{value}',
                            fontWeight:'bolder',
                            color:'#FFFFFF'
                        },
                        splitLine:{
                            show:false
                        },
                        nameTextStyle:{
                            color:'#36648B',
                            fontWeight:'bolder',
                            fontFamily:'Microsoft YaHei',
                            fontSize:14
                        },
                        axisLine:{
                            lineStyle:{
                                color:'#5475f5',
                                width:2
                            }
                        }

                    },
                    {
                        type: 'value',
                        name: '成功率(%)',
                        min: 0,
                        max: 100,
                        interval: 20,
                        axisLabel: {
                            formatter: '{value}',
                            fontWeight:'bolder',
                            color:'#FFFFFF'
                        },
                        splitLine:{
                            show:false
                        },
                        nameTextStyle:{
                            color:'#36648B',
                            fontWeight:'bolder',
                            fontFamily:'Microsoft YaHei',
                            fontSize:14
                        },
                        axisLine:{
                            lineStyle:{
                                color:'#5475f5',
                                width:2
                            }
                        }
                    }
                ],
                series: [
                    {
                        name:'订单量',
                        type:'bar',
                        data:data.trend.trend_order,
                        itemStyle:{
                            color:'#EE9A00'
                        },
                        nameTextStyle:{
                            color:'#36648B'
                        }
                    },
                    {
                        name:'成功率',
                        type:'line',
                        yAxisIndex: 1,
                        data:data.trend.trend_suucess,
                        itemStyle:{
                            color:'#7CCD7C'
                        }
                    }
                ]
            });
            timeChart.setOption({
                title: {
                    text: '充值业务环节时长分析',
                    textStyle:{
                        color:'#FFFFFF',
                        fontSize:22
                    },
                    x:'center',
                    y:'top',
                    textAlign:'left'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:['支付时长','充值时长','业务时长'],
                    textStyle:{
                        color:'#36648B',
                        fontWeight:'bolder'
                    },
                    padding:45
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: get_h()
                    ,axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    axisLine:{
                        lineStyle:{
                            color:'#5475f5',
                            width:2
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    name: '秒',
                    min: 0,
                    max: 30,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value}',
                        fontWeight:'bolder',
                        color:'#FFFFFF'
                    },
                    splitLine:{
                        show:false
                    },
                    nameTextStyle:{
                        color:'#36648B',
                        fontWeight:'bolder',
                        fontFamily:'Microsoft YaHei',
                        fontSize:14
                    },
                    axisLine:{
                        lineStyle:{
                            color:'#5475f5',
                            width:2
                        }
                    }
                },
                series: [
                    {
                        name:'支付时长',
                        type:'line',
                        data:data.time.timepay
                    },
                    {
                        name:'充值时长',
                        type:'line',
                        data:data.time.timerecharge
                    },
                    {
                        name:'业务时长',
                        type:'line',
                        data:data.time.timetend
                    }
                ]
            });
        })
    };
    //调用方法
    // Map_display();
    setInterval("Map_display()",2000);
    setInterval("go()",1000);
    get_h();
});

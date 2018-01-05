<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>countryMonitor</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.min.js"></script>
    <script src="http://gallerybox.echartsjs.com/dep/echarts/map/js/china.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1500px;height:900px;"></div>
    <script type="text/javascript">            
        var myChart = echarts.init(document.getElementById('main'));
        //替换GALERY中代码
   
   function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
     
var data_yujing = [
     {name: '天津', value: 65},
     {name: '河北', value: 32},
     {name: '山西', value: 69},
     {name: '广东', value: 90},
     {name: '浙江', value: 123}
];
var data_jinggao = [
     {name: '上海', value: 111},
     {name: '安徽', value: 23},
     {name: '山东', value: 34},
     {name: '海南', value: 102},
     {name: '广东', value: 290},
     {name: '浙江', value: 99}
];

var geoCoordMap = {
    "北京": [116.46,39.92],
        "天津": [117.20,39.13],
        "河北": [114.48,38.03],
        "山西": [112.53,37.87],
        "内蒙古": [118.87,42.28],
        "辽宁": [123.38,41.8],
        "吉林": [125.35,43.88],
        "黑龙江": [126.63,45.75],
        "上海": [121.48,31.22],
        "江苏": [118.78,32.05],
        "浙江": [120.19,30.26],
        "安徽": [117.27,31.86],
        "福建": [118.10,24.46],
        "江西": [115.89,28.68],
        "山东": [117,36.65],
        "广东": [113.23,23.16],
        "广西": [110.28,25.29],
        "海南": [110.35,20.02],
        "河南": [113.65,34.76],
        "湖北": [114.31,30.52],
        "湖南": [113.00,28.21],
        "重庆": [106.54,29.59],
        "四川": [104.06,30.67],
        "贵州": [106.71,26.57],
        "云南": [102.73,25.04],
        "西藏":[91.11,29.97],
        "陕西": [109.47,36.60],
        "甘肃": [103.73,36.03],
        "青海": [101.74,36.56],
        "宁夏": [106.27,38.47],
        "新疆": [87.68,43.77],
        "香港":[114.18,22.29],
        "澳门":[113.55,22.20],
        "台湾":[121.97,24.08]
};

var convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};

option = {
    backgroundColor: '#F0F2F5',
    title: {
        text: '全国订单监控',
        subtext: getNowFormatDate(),
        sublink: '',
        left: 'center',
        textStyle: {
            color: '#000000'
        }
    },
   tooltip: {
        trigger: 'item',
        formatter: function (params) {
              if(typeof(params.value)[2] == "undefined"){
              	if(isNaN(params.value)){
              		return params.name + ' : 订单正常';
              	}
              	return params.name + '(预警+警告) : ' + params.value;
              }else{
              	return params.name + ' : ' + params.value[2];
              }
            }
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data:['警告','预警']
    },
    geo: {
        map: 'china',
        type: 'scatter',
        label: {
            emphasis: {
                show: false
            }
        },
        roam: false,
        itemStyle: {
            normal: {
            	label:{show:true},
                areaColor: '#808080',
                borderColor: '#111'
            },
            emphasis: {
                areaColor: '#2a333d'
            }
        }
    },
    series : [
        {
            name: '预警_scatter',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(data_yujing),
            symbolSize: function (val) {
                return val[2] / 10;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#FFD700'
                }
            }
        }, {
            name: '预警数量_scatter',
            type: 'scatter',
            coordinateSystem: 'geo',
            hoverAnimation: 'false',
            legendHoverLink: 'false',
            symbol: 'pin',
            symbolSize: 25,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color: '#111',
                        fontSize: 9,
                    }
                }
            },
            itemStyle: {
                normal: {
                    color: '#FFD700', //标志颜色
                }
            },
            zlevel: 6,
            data: convertData(data_yujing)
        },
        {
            name: '警告_effectScatter',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(data_jinggao.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6)),
            symbolSize: function (val) {
                return val[2] / 10;
            },
            showEffectOn: 'render',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                	show: false,
                    color: '#FF4500',
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            zlevel: 1
        }, {
            name: '警告数量_scatter',
            type: 'scatter',
            coordinateSystem: 'geo',
            symbol: 'pin',
            symbolSize: 25,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 9,
                    }
                }
            },
            itemStyle: {
                normal: {
                    color: '#F62157', //标志颜色
                }
            },
            zlevel: 6,
            data: convertData(data_jinggao)
        } ,{
        	name: '预警',
            type: 'map',
            map: 'china',
            geoIndex: 0,
            aspectScale: 0.75, //长宽比
             selectedMode: 'single',
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            roam: true,
            itemStyle: {
                normal: {
                    color: '#FFD700'
                }
            },
            animation: false,
            data: data_yujing
        },{
        	name: '警告',
            type: 'map',
            map: 'china',
            geoIndex: 0,
            aspectScale: 0.75, //长宽比
             selectedMode: 'single',
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            roam: true,
            itemStyle: {
                normal: {
                    color: '#F62157', //标志颜色
                }
            },
            animation: false,
            data: data_jinggao
        }
    ]
};

 myChart.setOption(option);  

    </script>
</body>
</html>
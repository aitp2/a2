import mockjs from 'mockjs';
import { getRule, postRule } from './mock/rule';
import { getActivities, getNotice, getFakeList } from './mock/api';
import { getFakeChartData } from './mock/chart';
import { imgMap } from './mock/utils';
import { getProfileBasicData } from './mock/profile';
import { getProfileAdvancedData } from './mock/profile';
import { getNotices } from './mock/notices';
import { format, delay } from 'roadhog-api-doc';

// 是否禁用代理
const noProxy = process.env.NO_PROXY === 'true';

// 代码中会兼容本地 service mock 以及部署站点的静态数据
const proxy = {
  // 支持值为 Object 和 Array
  'GET /api/currentUser': {
    $desc: "获取当前用户接口",
    $params: {
      pageSize: {
        desc: '分页',
        exp: 2,
      },
    },
    $body: {
      name: 'Serati Ma',
      avatar: 'https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png',
      userid: '00000001',
      notifyCount: 12,
    },
  },
  // GET POST 可省略
  'GET /api/users': [{
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
  }, {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
  }, {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
  }],
  'GET /api/project/notice': getNotice,
  'GET /api/activities': getActivities,
  'GET /api/rule': getRule,
  'POST /api/rule': {
    $params: {
      pageSize: {
        desc: '分页',
        exp: 2,
      },
    },
    $body: postRule,
  },
  'POST /api/forms': (req, res) => {
    res.send({ message: 'Ok' });
  },
  'GET /api/tags': mockjs.mock({
    'list|100': [{ name: '@city', 'value|1-100': 150, 'type|0-2': 1 }]
  }),
  'GET /api/fake_list': getFakeList,
  'GET /api/fake_chart_data': getFakeChartData,
  'GET /api/profile/basic': getProfileBasicData,
  'GET /api/profile/advanced': getProfileAdvancedData,
  'POST /api/login/account': (req, res) => {
    const { password, userName, type } = req.body;
    res.send({
      status: password === '888888' && userName === 'admin' ? 'ok' : 'error',
      type,
    });
  },
  'POST /api/register': (req, res) => {
    res.send({ status: 'ok' });
  },
  'GET /api/notices': getNotices,
};

//export default noProxy ? {} : delay(proxy, 1000);

export default {
'GET /api/stepdata/(.*)': 'http://localhost:8888/api/stepdata/mock',
	//{[{"current":"1","desc_create":"2018-02-20 13:40","desc_pay":"2018-02-20 13:40","desc_send":"2018-02-20 13:40","desc_sign":"2018-02-20 13:40","memo":"-"},{"current":"2","desc_create":"2018-02-20 13:40","desc_pay":"2018-02-20 13:40","desc_send":"2018-02-20 13:40","desc_sign":"2018-02-20 13:40","memo":"不通过原因"},{"current":"3","desc_create":"2018-02-20 13:40","desc_pay":"2018-02-20 13:40","desc_send":"2018-02-20 13:40","desc_sign":"2018-02-20 13:40","memo":"-"},{"current":"0","desc_create":"2018-02-20 13:40","desc_pay":"2018-02-20 13:40","desc_send":"2018-02-20 13:40","desc_sign":"2018-02-20 13:40","memo":"很棒"}]}
'GET /api/profile/advanced': 'http://localhost:8080/loadOperateLogant',
	//{"advancedOperation1":[{"key":"op1","type":"订购关系生效","name":"曲丽丽","status":"agree","updatedAt":"2017-10-03  19:23:12","memo":"-"},{"key":"op2","type":"财务复审","name":"付小小","status":"reject","updatedAt":"2017-10-03  19:23:12","memo":"不通过原因"},{"key":"op3","type":"部门初审","name":"周毛毛","status":"agree","updatedAt":"2017-10-03  19:23:12","memo":"-"},{"key":"op4","type":"提交订单","name":"林东东","status":"agree","updatedAt":"2017-10-03  19:23:12","memo":"很棒"},{"key":"op5","type":"创建订单","name":"汗东东","status":"agree","updatedAt":"2017-10-03  19:23:12","memo":"-"}]}
};
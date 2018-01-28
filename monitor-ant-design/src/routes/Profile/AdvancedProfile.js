import React, { Component } from 'react';
import Debounce from 'lodash-decorators/debounce';
import Bind from 'lodash-decorators/bind';
import { connect } from 'dva';
import { Button, Menu, Dropdown, Icon, Row, Col, Steps, Card, Popover, Badge, Table, Tooltip, Divider,Progress  } from 'antd';
import classNames from 'classnames';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import DescriptionList from '../../components/DescriptionList';
import styles from './AdvancedProfile.less';
	  
const { Step } = Steps;
const { Description } = DescriptionList;
const ButtonGroup = Button.Group;

const getWindowWidth = () => (window.innerWidth || document.documentElement.clientWidth);

const menu = (
  <Menu>
    <Menu.Item key="1">选项一</Menu.Item>
    <Menu.Item key="2">选项二</Menu.Item>
    <Menu.Item key="3">选项三</Menu.Item>
  </Menu>
);

const description = (
		<div className="outer-iframe">
        <div className="d-iframe">
            <iframe id="previewIframe" src="http://powertools.local:8088/countryMonitor" frameBorder="0" 
            	width="1600" height="1000">
          </iframe>
        </div>
        <div>
        
	        正常订单：<Progress percent={20} status="success" showInfo="false"/>
	        预警订单：<Progress percent={20} status="active" showInfo="false"/>
	        警告订单：<Progress percent={20} status="exception" showInfo="false"/>
	      </div>
    </div>
);

const desc1 = (
  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
    <div>
      曲丽丽
      <Icon type="dingding-o" style={{ marginLeft: 8 }} />
    </div>
    <div>2016-12-12 12:32</div>
  </div>
);

const desc2 = (
  <div className={styles.stepDescription}>
    <div>
      周毛毛
      <Icon type="dingding-o" style={{ color: '#00A0E9', marginLeft: 8 }} />
    </div>
    <div><a href="">催一下</a></div>
  </div>
);

const desc_create = (
	  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
	    <div>2018-02-20 13:40</div>
	  </div>
);
const desc_pay = (
	  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
	    <div>2018-02-20 13:45</div>
	  </div>
);
const desc_send = (
	  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
	    <div>2018-02-20 15:00</div>
	  </div>
);
const desc_sign = (
	  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
	    <div>2018-02-20 16:00</div>
	  </div>
);

const popoverContent = (
  <div style={{ width: 160 }}>
    吴加号
    <span className={styles.textSecondary} style={{ float: 'right' }}>
      <Badge status="default" text={<span style={{ color: 'rgba(0, 0, 0, 0.45)' }}>未响应</span>} />
    </span>
    <div className={styles.textSecondary} style={{ marginTop: 4 }}>耗时：2小时25分钟</div>
  </div>
);

const customDot = (dot, { status }) => (status === 'process' ?
  <Popover placement="topLeft" arrowPointAtCenter content={popoverContent}>
    {dot}
  </Popover>
  : dot
);

const columns = [
{
  title: '订单号',
  dataIndex: 'orderCode',
  key: 'orderCode',
},{
  title: '订单金额',
  dataIndex: 'totalPrice',
  key: 'totalPrice',
}, {
  title: '订单状态',
  dataIndex: 'orderStatus',
  key: 'orderStatus',
}, 

//{
//  title: '执行结果',
//  dataIndex: 'status',
//  key: 'status',
//  render: text => (
//    text === 'agree' ? <Badge status="success" text="成功" /> : <Badge status="error" text="驳回" />
//  ),
//}, 
  
 {
  title: '用户',
  dataIndex: 'user',
  key: 'user',
},{
	title: '省份',
	dataIndex: 'province',
	key: 'province',
},{
	title: '修改时间',
	dataIndex: 'modifyTime',
	key: 'modifyTime',
}];

@connect(state => ({
  profile: state.profile,
  stepslog: state.stepslog,
}))
export default class AdvancedProfile extends Component {
  state = {
    operationkey: 'tab1',
    stepDirection: 'horizontal',
  }

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'profile/fetchAdvanced',
    });
    dispatch({
        type: 'profile/fetchList',
      });
    dispatch({
        type: 'steps/fetchList',
      });

    this.setStepDirection();
    window.addEventListener('resize', this.setStepDirection);
  }

  componentWillUnmount() {
    window.removeEventListener('resize', this.setStepDirection);
    this.setStepDirection.cancel();
  }

  onOperationTabChange = (key) => {
    this.setState({ operationkey: key });
  }

  @Bind()
  @Debounce(200)
  setStepDirection() {
    const { stepDirection } = this.state;
    const w = getWindowWidth();
    if (stepDirection !== 'vertical' && w <= 576) {
      this.setState({
        stepDirection: 'vertical',
      });
    } else if (stepDirection !== 'horizontal' && w > 576) {
      this.setState({
        stepDirection: 'horizontal',
      });
    }
  }

 
  
  render() {
    const { stepDirection } = this.state;
    const { stepslog } = this.props;
    const { profile } = this.props;
    //const { stepadvancedLoading, stepadvancedOperation1 } = stepslog;
    const { advancedLoading, advancedOperation1, stepadvancedOperation1 } = profile;
    const [ x, y, z ] = [{
    	   "province": "china",
    	   "status": "JINGGAO",
    	   "num": "5",
    	   "percentage": "56%",
    	   "clom": "14"
    	}, {
    	   "province": "china",
    	   "status": "YUJING",
    	   "num": "2",
    	   "percentage": "22%",
    	   "clom": "5"
    	}, {
    	   "province": "china",
    	   "status": "NOMARL",
    	   "num": "2",
    	   "percentage": "22%",
    	   "clom": "5"
    	}];
    const { clom : clom} = x;
    
//    const { error, warning, normal } = stepadvancedOperation1
    console.log({stepadvancedOperation1});
    console.log({x});
    console.log({y});
    console.log({z});
    console.log({clom});
//    const { current: number, desc_create: creatTime, desc_pay: payTime, desc_send: sendTime, desc_sign: signTime, memo: memo } = stepList;
//    const desc_create1 = (
//    			  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
//    			    <div>{creatTime}</div>
//    			  </div>
//    		);
//    const { current: number, desc_create: desc_create1 }  = stepList;
//    const {stepss} = stepList;
    
//    const desc_send_s = (
//    		  <div className={classNames(styles.textSecondary, styles.stepDescription)}>
//    		    <div>{number}</div>
//    		  </div>
//    	);
    const contentList = {
      tab1: <Table
        pagination={false}
        loading={advancedLoading}
        dataSource={advancedOperation1}
        columns={columns}
      />,
    };
    
    return (
      <PageHeaderLayout
        content={description}
      >
     
        <Card title="订单监控" style={{ marginBottom: 24 }} bordered={false}>
        <div width="20%">order001</div> 
        <Steps direction={stepDirection} progressDot={customDot} current={3} >
        
          <Step title="创建" description={desc_create} />
          <Step title="已支付" description={desc_create} />
          <Step title="已发货" description={desc_send}/>
          <Step title="已签收" description={desc_sign}/>
        </Steps>
          <div width="20%">order002</div> 
        <Steps direction={stepDirection} progressDot={customDot} current={2} >
	        <Step title="创建" description={desc_create} />
	        <Step title="已支付" description={desc_pay} />
	        <Step title="已发货" description={desc_send}/>
	        <Step title="已签收" />
	      </Steps>
	      <div width="20%">order003</div> 
	      <Steps direction={stepDirection} progressDot={customDot} current={1}>
		      <Step title="创建" description={desc_create} />
		      <Step title="已支付" description={desc_pay} />
		      <Step title="已发货" />
		      <Step title="已签收" 	 />
		    </Steps>
		    <div width="20%">order004</div> 
	    <Steps direction={stepDirection} status="error" progressDot={customDot} current={0} >
		    <Step title="创建" description={desc_create} />
		    <Step title="已支付" />
		    <Step title="已发货" />
		    <Step title="已签收" />
		  </Steps>
      </Card>

        <Card
          className={styles.tabsCard}
          bordered={false}
          onTabChange={this.onOperationTabChange}
        >
          {contentList[this.state.operationkey]}
        </Card>
      </PageHeaderLayout>
    );
  }
}

import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import exampaper from '@/views/modules/exampaper/list'
    import examquestion from '@/views/modules/examquestion/list'
    import examrecord from '@/views/modules/examrecord/list'
    import examredetails from '@/views/modules/examredetails/list'
    import examrewrongquestion from '@/views/modules/examrewrongquestion/list'
    import jiankangzhishi from '@/views/modules/jiankangzhishi/list'
    import tongzhi from '@/views/modules/tongzhi/list'
    import xinlilaoshiCollection from '@/views/modules/xinlilaoshiCollection/list'
    import xinlilaoshiLiuyan from '@/views/modules/xinlilaoshiLiuyan/list'
    import xinlilaoshiOrder from '@/views/modules/xinlilaoshiOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import xinlilaoshi from '@/views/modules/xinlilaoshi/list'
    import config from '@/views/modules/config/list'
    import dictionaryExampaper from '@/views/modules/dictionaryExampaper/list'
    import dictionaryExamquestion from '@/views/modules/dictionaryExamquestion/list'
    import dictionaryJiankangzhishi from '@/views/modules/dictionaryJiankangzhishi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShijianduan from '@/views/modules/dictionaryShijianduan/list'
    import dictionaryTongzhi from '@/views/modules/dictionaryTongzhi/list'
    import dictionaryXinlilaoshiCollection from '@/views/modules/dictionaryXinlilaoshiCollection/list'
    import dictionaryXinlilaoshiOrderYesno from '@/views/modules/dictionaryXinlilaoshiOrderYesno/list'

    import adminexam from '@/views/modules/exampaper/exam'




//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
	  ,{
	      path: '/adminexam',
	      name: 'adminexam',
	      component: adminexam,
	      meta: {icon:'', title:'adminexam'}
	    }
    ,{
        path: '/dictionaryExampaper',
        name: '试卷状态',
        component: dictionaryExampaper
    }
    ,{
        path: '/dictionaryExamquestion',
        name: '试题类型',
        component: dictionaryExamquestion
    }
    ,{
        path: '/dictionaryJiankangzhishi',
        name: '健康知识类型',
        component: dictionaryJiankangzhishi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShijianduan',
        name: '时间段',
        component: dictionaryShijianduan
    }
    ,{
        path: '/dictionaryTongzhi',
        name: '通知类型',
        component: dictionaryTongzhi
    }
    ,{
        path: '/dictionaryXinlilaoshiCollection',
        name: '收藏表类型',
        component: dictionaryXinlilaoshiCollection
    }
    ,{
        path: '/dictionaryXinlilaoshiOrderYesno',
        name: '预约状态',
        component: dictionaryXinlilaoshiOrderYesno
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/exampaper',
        name: '试卷表',
        component: exampaper
      }
    ,{
        path: '/examquestion',
        name: '试题表',
        component: examquestion
      }
    ,{
        path: '/examrecord',
        name: '考试记录表',
        component: examrecord
      }
    ,{
        path: '/examredetails',
        name: '答题详情表',
        component: examredetails
      }
    ,{
        path: '/examrewrongquestion',
        name: '错题表',
        component: examrewrongquestion
      }
    ,{
        path: '/jiankangzhishi',
        name: '健康知识',
        component: jiankangzhishi
      }
    ,{
        path: '/tongzhi',
        name: '通知',
        component: tongzhi
      }
    ,{
        path: '/xinlilaoshiCollection',
        name: '心理老师收藏',
        component: xinlilaoshiCollection
      }
    ,{
        path: '/xinlilaoshiLiuyan',
        name: '心理老师留言',
        component: xinlilaoshiLiuyan
      }
    ,{
        path: '/xinlilaoshiOrder',
        name: '心理咨询预约申请',
        component: xinlilaoshiOrder
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }
    ,{
        path: '/xinlilaoshi',
        name: '心理老师',
        component: xinlilaoshi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

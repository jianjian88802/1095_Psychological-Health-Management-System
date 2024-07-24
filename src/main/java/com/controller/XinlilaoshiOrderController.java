
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 心理咨询预约申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinlilaoshiOrder")
public class XinlilaoshiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(XinlilaoshiOrderController.class);

    @Autowired
    private XinlilaoshiOrderService xinlilaoshiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private XinlilaoshiService xinlilaoshiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("心理老师".equals(role))
            params.put("xinlilaoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xinlilaoshiOrderService.queryPage(params);

        //字典表数据转换
        List<XinlilaoshiOrderView> list =(List<XinlilaoshiOrderView>)page.getList();
        for(XinlilaoshiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinlilaoshiOrderEntity xinlilaoshiOrder = xinlilaoshiOrderService.selectById(id);
        if(xinlilaoshiOrder !=null){
            //entity转view
            XinlilaoshiOrderView view = new XinlilaoshiOrderView();
            BeanUtils.copyProperties( xinlilaoshiOrder , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xinlilaoshiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(xinlilaoshiOrder.getXinlilaoshiId());
                if(xinlilaoshi != null){
                    BeanUtils.copyProperties( xinlilaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinlilaoshiId(xinlilaoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinlilaoshiOrderEntity xinlilaoshiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinlilaoshiOrder:{}",this.getClass().getName(),xinlilaoshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("心理老师".equals(role))
            xinlilaoshiOrder.setXinlilaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("学生".equals(role))
            xinlilaoshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xinlilaoshiOrder.setInsertTime(new Date());
        xinlilaoshiOrder.setCreateTime(new Date());
        xinlilaoshiOrderService.insert(xinlilaoshiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinlilaoshiOrderEntity xinlilaoshiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xinlilaoshiOrder:{}",this.getClass().getName(),xinlilaoshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("心理老师".equals(role))
//            xinlilaoshiOrder.setXinlilaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("学生".equals(role))
//            xinlilaoshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XinlilaoshiOrderEntity> queryWrapper = new EntityWrapper<XinlilaoshiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinlilaoshiOrderEntity xinlilaoshiOrderEntity = xinlilaoshiOrderService.selectOne(queryWrapper);
        if(xinlilaoshiOrderEntity==null){
            xinlilaoshiOrderService.updateById(xinlilaoshiOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xinlilaoshiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XinlilaoshiOrderEntity> xinlilaoshiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinlilaoshiOrderEntity xinlilaoshiOrderEntity = new XinlilaoshiOrderEntity();
//                            xinlilaoshiOrderEntity.setXinlilaoshiOrderUuidNumber(data.get(0));                    //预约流水号 要改的
//                            xinlilaoshiOrderEntity.setXinlilaoshiId(Integer.valueOf(data.get(0)));   //心理老师 要改的
//                            xinlilaoshiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xinlilaoshiOrderEntity.setYuyueTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            xinlilaoshiOrderEntity.setShijianduanTypes(Integer.valueOf(data.get(0)));   //预约时间段 要改的
//                            xinlilaoshiOrderEntity.setXinlilaoshiOrderYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            xinlilaoshiOrderEntity.setXinlilaoshiOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            xinlilaoshiOrderEntity.setInsertTime(date);//时间
//                            xinlilaoshiOrderEntity.setCreateTime(date);//时间
                            xinlilaoshiOrderList.add(xinlilaoshiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //预约流水号
                                if(seachFields.containsKey("xinlilaoshiOrderUuidNumber")){
                                    List<String> xinlilaoshiOrderUuidNumber = seachFields.get("xinlilaoshiOrderUuidNumber");
                                    xinlilaoshiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinlilaoshiOrderUuidNumber = new ArrayList<>();
                                    xinlilaoshiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinlilaoshiOrderUuidNumber",xinlilaoshiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约流水号
                        List<XinlilaoshiOrderEntity> xinlilaoshiOrderEntities_xinlilaoshiOrderUuidNumber = xinlilaoshiOrderService.selectList(new EntityWrapper<XinlilaoshiOrderEntity>().in("xinlilaoshi_order_uuid_number", seachFields.get("xinlilaoshiOrderUuidNumber")));
                        if(xinlilaoshiOrderEntities_xinlilaoshiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinlilaoshiOrderEntity s:xinlilaoshiOrderEntities_xinlilaoshiOrderUuidNumber){
                                repeatFields.add(s.getXinlilaoshiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinlilaoshiOrderService.insertBatch(xinlilaoshiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xinlilaoshiOrderService.queryPage(params);

        //字典表数据转换
        List<XinlilaoshiOrderView> list =(List<XinlilaoshiOrderView>)page.getList();
        for(XinlilaoshiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinlilaoshiOrderEntity xinlilaoshiOrder = xinlilaoshiOrderService.selectById(id);
            if(xinlilaoshiOrder !=null){


                //entity转view
                XinlilaoshiOrderView view = new XinlilaoshiOrderView();
                BeanUtils.copyProperties( xinlilaoshiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinlilaoshiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(xinlilaoshiOrder.getXinlilaoshiId());
                if(xinlilaoshi != null){
                    BeanUtils.copyProperties( xinlilaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinlilaoshiId(xinlilaoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinlilaoshiOrderEntity xinlilaoshiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinlilaoshiOrder:{}",this.getClass().getName(),xinlilaoshiOrder.toString());
            XinlilaoshiEntity xinlilaoshiEntity = xinlilaoshiService.selectById(xinlilaoshiOrder.getXinlilaoshiId());
            if(xinlilaoshiEntity == null){
                return R.error(511,"查不到该心理老师");
            }
            // Double xinlilaoshiNewMoney = xinlilaoshiEntity.getXinlilaoshiNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            xinlilaoshiOrder.setYonghuId(userId); //设置订单支付人id
            xinlilaoshiOrder.setXinlilaoshiOrderUuidNumber(String.valueOf(new Date().getTime()));
            xinlilaoshiOrder.setInsertTime(new Date());
            xinlilaoshiOrder.setCreateTime(new Date());
                xinlilaoshiOrderService.insert(xinlilaoshiOrder);//新增订单
            return R.ok();
    }



}

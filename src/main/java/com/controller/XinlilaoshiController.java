
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
 * 心理老师
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinlilaoshi")
public class XinlilaoshiController {
    private static final Logger logger = LoggerFactory.getLogger(XinlilaoshiController.class);

    @Autowired
    private XinlilaoshiService xinlilaoshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = xinlilaoshiService.queryPage(params);

        //字典表数据转换
        List<XinlilaoshiView> list =(List<XinlilaoshiView>)page.getList();
        for(XinlilaoshiView c:list){
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
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(id);
        if(xinlilaoshi !=null){
            //entity转view
            XinlilaoshiView view = new XinlilaoshiView();
            BeanUtils.copyProperties( xinlilaoshi , view );//把实体数据重构到view中

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
    public R save(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinlilaoshi:{}",this.getClass().getName(),xinlilaoshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinlilaoshiEntity> queryWrapper = new EntityWrapper<XinlilaoshiEntity>()
            .eq("username", xinlilaoshi.getUsername())
            .or()
            .eq("xinlilaoshi_phone", xinlilaoshi.getXinlilaoshiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinlilaoshiEntity xinlilaoshiEntity = xinlilaoshiService.selectOne(queryWrapper);
        if(xinlilaoshiEntity==null){
            xinlilaoshi.setCreateTime(new Date());
            xinlilaoshi.setPassword("123456");
            xinlilaoshiService.insert(xinlilaoshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者心理老师手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xinlilaoshi:{}",this.getClass().getName(),xinlilaoshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XinlilaoshiEntity> queryWrapper = new EntityWrapper<XinlilaoshiEntity>()
            .notIn("id",xinlilaoshi.getId())
            .andNew()
            .eq("username", xinlilaoshi.getUsername())
            .or()
            .eq("xinlilaoshi_phone", xinlilaoshi.getXinlilaoshiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinlilaoshiEntity xinlilaoshiEntity = xinlilaoshiService.selectOne(queryWrapper);
        if("".equals(xinlilaoshi.getXinlilaoshiPhoto()) || "null".equals(xinlilaoshi.getXinlilaoshiPhoto())){
                xinlilaoshi.setXinlilaoshiPhoto(null);
        }
        if(xinlilaoshiEntity==null){
            xinlilaoshiService.updateById(xinlilaoshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者心理老师手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xinlilaoshiService.deleteBatchIds(Arrays.asList(ids));
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
            List<XinlilaoshiEntity> xinlilaoshiList = new ArrayList<>();//上传的东西
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
                            XinlilaoshiEntity xinlilaoshiEntity = new XinlilaoshiEntity();
//                            xinlilaoshiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xinlilaoshiEntity.setPassword("123456");//密码
//                            xinlilaoshiEntity.setXinlilaoshiName(data.get(0));                    //心理老师姓名 要改的
//                            xinlilaoshiEntity.setXinlilaoshiPhone(data.get(0));                    //心理老师手机号 要改的
//                            xinlilaoshiEntity.setXinlilaoshiPhoto("");//详情和图片
//                            xinlilaoshiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xinlilaoshiEntity.setXinlilaoshiEmail(data.get(0));                    //电子邮箱 要改的
//                            xinlilaoshiEntity.setXinlilaoshiShanchang(data.get(0));                    //擅长 要改的
//                            xinlilaoshiEntity.setXinlilaoshiLvli(data.get(0));                    //履历 要改的
//                            xinlilaoshiEntity.setXinlilaoshiContent("");//详情和图片
//                            xinlilaoshiEntity.setCreateTime(date);//时间
                            xinlilaoshiList.add(xinlilaoshiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //心理老师手机号
                                if(seachFields.containsKey("xinlilaoshiPhone")){
                                    List<String> xinlilaoshiPhone = seachFields.get("xinlilaoshiPhone");
                                    xinlilaoshiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xinlilaoshiPhone = new ArrayList<>();
                                    xinlilaoshiPhone.add(data.get(0));//要改的
                                    seachFields.put("xinlilaoshiPhone",xinlilaoshiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XinlilaoshiEntity> xinlilaoshiEntities_username = xinlilaoshiService.selectList(new EntityWrapper<XinlilaoshiEntity>().in("username", seachFields.get("username")));
                        if(xinlilaoshiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinlilaoshiEntity s:xinlilaoshiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //心理老师手机号
                        List<XinlilaoshiEntity> xinlilaoshiEntities_xinlilaoshiPhone = xinlilaoshiService.selectList(new EntityWrapper<XinlilaoshiEntity>().in("xinlilaoshi_phone", seachFields.get("xinlilaoshiPhone")));
                        if(xinlilaoshiEntities_xinlilaoshiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinlilaoshiEntity s:xinlilaoshiEntities_xinlilaoshiPhone){
                                repeatFields.add(s.getXinlilaoshiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [心理老师手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinlilaoshiService.insertBatch(xinlilaoshiList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("username", username));
        if(xinlilaoshi==null || !xinlilaoshi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(xinlilaoshi.getId(),username, "xinlilaoshi", "心理老师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","心理老师");
        r.put("username",xinlilaoshi.getXinlilaoshiName());
        r.put("tableName","xinlilaoshi");
        r.put("userId",xinlilaoshi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XinlilaoshiEntity xinlilaoshi){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XinlilaoshiEntity> queryWrapper = new EntityWrapper<XinlilaoshiEntity>()
            .eq("username", xinlilaoshi.getUsername())
            .or()
            .eq("xinlilaoshi_phone", xinlilaoshi.getXinlilaoshiPhone())
            ;
        XinlilaoshiEntity xinlilaoshiEntity = xinlilaoshiService.selectOne(queryWrapper);
        if(xinlilaoshiEntity != null)
            return R.error("账户或者心理老师手机号已经被使用");
        xinlilaoshi.setCreateTime(new Date());
        xinlilaoshiService.insert(xinlilaoshi);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        XinlilaoshiEntity xinlilaoshi = new XinlilaoshiEntity();
        xinlilaoshi.setPassword("123456");
        xinlilaoshi.setId(id);
        xinlilaoshiService.updateById(xinlilaoshi);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("username", username));
        if(xinlilaoshi!=null){
            xinlilaoshi.setPassword("123456");
            boolean b = xinlilaoshiService.updateById(xinlilaoshi);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取学生的session学生信息
    */
    @RequestMapping("/session")
    public R getCurrXinlilaoshi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(id);
        if(xinlilaoshi !=null){
            //entity转view
            XinlilaoshiView view = new XinlilaoshiView();
            BeanUtils.copyProperties( xinlilaoshi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = xinlilaoshiService.queryPage(params);

        //字典表数据转换
        List<XinlilaoshiView> list =(List<XinlilaoshiView>)page.getList();
        for(XinlilaoshiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(id);
            if(xinlilaoshi !=null){


                //entity转view
                XinlilaoshiView view = new XinlilaoshiView();
                BeanUtils.copyProperties( xinlilaoshi , view );//把实体数据重构到view中

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
    public R add(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinlilaoshi:{}",this.getClass().getName(),xinlilaoshi.toString());
        Wrapper<XinlilaoshiEntity> queryWrapper = new EntityWrapper<XinlilaoshiEntity>()
            .eq("username", xinlilaoshi.getUsername())
            .or()
            .eq("xinlilaoshi_phone", xinlilaoshi.getXinlilaoshiPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinlilaoshiEntity xinlilaoshiEntity = xinlilaoshiService.selectOne(queryWrapper);
        if(xinlilaoshiEntity==null){
            xinlilaoshi.setCreateTime(new Date());
        xinlilaoshi.setPassword("123456");
        xinlilaoshiService.insert(xinlilaoshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者心理老师手机号已经被使用");
        }
    }


}

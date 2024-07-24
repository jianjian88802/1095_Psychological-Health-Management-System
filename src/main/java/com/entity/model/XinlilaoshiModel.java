package com.entity.model;

import com.entity.XinlilaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理老师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinlilaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 心理老师姓名
     */
    private String xinlilaoshiName;


    /**
     * 心理老师手机号
     */
    private String xinlilaoshiPhone;


    /**
     * 心理老师头像
     */
    private String xinlilaoshiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String xinlilaoshiEmail;


    /**
     * 擅长
     */
    private String xinlilaoshiShanchang;


    /**
     * 履历
     */
    private String xinlilaoshiLvli;


    /**
     * 心理老师详细介绍
     */
    private String xinlilaoshiContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：心理老师姓名
	 */
    public String getXinlilaoshiName() {
        return xinlilaoshiName;
    }


    /**
	 * 设置：心理老师姓名
	 */
    public void setXinlilaoshiName(String xinlilaoshiName) {
        this.xinlilaoshiName = xinlilaoshiName;
    }
    /**
	 * 获取：心理老师手机号
	 */
    public String getXinlilaoshiPhone() {
        return xinlilaoshiPhone;
    }


    /**
	 * 设置：心理老师手机号
	 */
    public void setXinlilaoshiPhone(String xinlilaoshiPhone) {
        this.xinlilaoshiPhone = xinlilaoshiPhone;
    }
    /**
	 * 获取：心理老师头像
	 */
    public String getXinlilaoshiPhoto() {
        return xinlilaoshiPhoto;
    }


    /**
	 * 设置：心理老师头像
	 */
    public void setXinlilaoshiPhoto(String xinlilaoshiPhoto) {
        this.xinlilaoshiPhoto = xinlilaoshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getXinlilaoshiEmail() {
        return xinlilaoshiEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setXinlilaoshiEmail(String xinlilaoshiEmail) {
        this.xinlilaoshiEmail = xinlilaoshiEmail;
    }
    /**
	 * 获取：擅长
	 */
    public String getXinlilaoshiShanchang() {
        return xinlilaoshiShanchang;
    }


    /**
	 * 设置：擅长
	 */
    public void setXinlilaoshiShanchang(String xinlilaoshiShanchang) {
        this.xinlilaoshiShanchang = xinlilaoshiShanchang;
    }
    /**
	 * 获取：履历
	 */
    public String getXinlilaoshiLvli() {
        return xinlilaoshiLvli;
    }


    /**
	 * 设置：履历
	 */
    public void setXinlilaoshiLvli(String xinlilaoshiLvli) {
        this.xinlilaoshiLvli = xinlilaoshiLvli;
    }
    /**
	 * 获取：心理老师详细介绍
	 */
    public String getXinlilaoshiContent() {
        return xinlilaoshiContent;
    }


    /**
	 * 设置：心理老师详细介绍
	 */
    public void setXinlilaoshiContent(String xinlilaoshiContent) {
        this.xinlilaoshiContent = xinlilaoshiContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

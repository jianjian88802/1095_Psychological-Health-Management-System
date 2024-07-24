package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 心理老师
 *
 * @author 
 * @email
 */
@TableName("xinlilaoshi")
public class XinlilaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinlilaoshiEntity() {

	}

	public XinlilaoshiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 心理老师姓名
     */
    @TableField(value = "xinlilaoshi_name")

    private String xinlilaoshiName;


    /**
     * 心理老师手机号
     */
    @TableField(value = "xinlilaoshi_phone")

    private String xinlilaoshiPhone;


    /**
     * 心理老师头像
     */
    @TableField(value = "xinlilaoshi_photo")

    private String xinlilaoshiPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @TableField(value = "xinlilaoshi_email")

    private String xinlilaoshiEmail;


    /**
     * 擅长
     */
    @TableField(value = "xinlilaoshi_shanchang")

    private String xinlilaoshiShanchang;


    /**
     * 履历
     */
    @TableField(value = "xinlilaoshi_lvli")

    private String xinlilaoshiLvli;


    /**
     * 心理老师详细介绍
     */
    @TableField(value = "xinlilaoshi_content")

    private String xinlilaoshiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：心理老师姓名
	 */
    public String getXinlilaoshiName() {
        return xinlilaoshiName;
    }
    /**
	 * 获取：心理老师姓名
	 */

    public void setXinlilaoshiName(String xinlilaoshiName) {
        this.xinlilaoshiName = xinlilaoshiName;
    }
    /**
	 * 设置：心理老师手机号
	 */
    public String getXinlilaoshiPhone() {
        return xinlilaoshiPhone;
    }
    /**
	 * 获取：心理老师手机号
	 */

    public void setXinlilaoshiPhone(String xinlilaoshiPhone) {
        this.xinlilaoshiPhone = xinlilaoshiPhone;
    }
    /**
	 * 设置：心理老师头像
	 */
    public String getXinlilaoshiPhoto() {
        return xinlilaoshiPhoto;
    }
    /**
	 * 获取：心理老师头像
	 */

    public void setXinlilaoshiPhoto(String xinlilaoshiPhoto) {
        this.xinlilaoshiPhoto = xinlilaoshiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getXinlilaoshiEmail() {
        return xinlilaoshiEmail;
    }
    /**
	 * 获取：电子邮箱
	 */

    public void setXinlilaoshiEmail(String xinlilaoshiEmail) {
        this.xinlilaoshiEmail = xinlilaoshiEmail;
    }
    /**
	 * 设置：擅长
	 */
    public String getXinlilaoshiShanchang() {
        return xinlilaoshiShanchang;
    }
    /**
	 * 获取：擅长
	 */

    public void setXinlilaoshiShanchang(String xinlilaoshiShanchang) {
        this.xinlilaoshiShanchang = xinlilaoshiShanchang;
    }
    /**
	 * 设置：履历
	 */
    public String getXinlilaoshiLvli() {
        return xinlilaoshiLvli;
    }
    /**
	 * 获取：履历
	 */

    public void setXinlilaoshiLvli(String xinlilaoshiLvli) {
        this.xinlilaoshiLvli = xinlilaoshiLvli;
    }
    /**
	 * 设置：心理老师详细介绍
	 */
    public String getXinlilaoshiContent() {
        return xinlilaoshiContent;
    }
    /**
	 * 获取：心理老师详细介绍
	 */

    public void setXinlilaoshiContent(String xinlilaoshiContent) {
        this.xinlilaoshiContent = xinlilaoshiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinlilaoshi{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xinlilaoshiName=" + xinlilaoshiName +
            ", xinlilaoshiPhone=" + xinlilaoshiPhone +
            ", xinlilaoshiPhoto=" + xinlilaoshiPhoto +
            ", sexTypes=" + sexTypes +
            ", xinlilaoshiEmail=" + xinlilaoshiEmail +
            ", xinlilaoshiShanchang=" + xinlilaoshiShanchang +
            ", xinlilaoshiLvli=" + xinlilaoshiLvli +
            ", xinlilaoshiContent=" + xinlilaoshiContent +
            ", createTime=" + createTime +
        "}";
    }
}

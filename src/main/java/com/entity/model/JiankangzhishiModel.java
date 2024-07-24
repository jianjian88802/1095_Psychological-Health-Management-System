package com.entity.model;

import com.entity.JiankangzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康知识
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangzhishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 健康知识名称
     */
    private String jiankangzhishiName;


    /**
     * 健康知识图片
     */
    private String jiankangzhishiPhoto;


    /**
     * 健康知识类型
     */
    private Integer jiankangzhishiTypes;


    /**
     * 健康知识发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 健康知识详情
     */
    private String jiankangzhishiContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 获取：健康知识名称
	 */
    public String getJiankangzhishiName() {
        return jiankangzhishiName;
    }


    /**
	 * 设置：健康知识名称
	 */
    public void setJiankangzhishiName(String jiankangzhishiName) {
        this.jiankangzhishiName = jiankangzhishiName;
    }
    /**
	 * 获取：健康知识图片
	 */
    public String getJiankangzhishiPhoto() {
        return jiankangzhishiPhoto;
    }


    /**
	 * 设置：健康知识图片
	 */
    public void setJiankangzhishiPhoto(String jiankangzhishiPhoto) {
        this.jiankangzhishiPhoto = jiankangzhishiPhoto;
    }
    /**
	 * 获取：健康知识类型
	 */
    public Integer getJiankangzhishiTypes() {
        return jiankangzhishiTypes;
    }


    /**
	 * 设置：健康知识类型
	 */
    public void setJiankangzhishiTypes(Integer jiankangzhishiTypes) {
        this.jiankangzhishiTypes = jiankangzhishiTypes;
    }
    /**
	 * 获取：健康知识发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：健康知识发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：健康知识详情
	 */
    public String getJiankangzhishiContent() {
        return jiankangzhishiContent;
    }


    /**
	 * 设置：健康知识详情
	 */
    public void setJiankangzhishiContent(String jiankangzhishiContent) {
        this.jiankangzhishiContent = jiankangzhishiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

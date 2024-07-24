package com.entity.vo;

import com.entity.JiankangzhishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康知识
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangzhishi")
public class JiankangzhishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 健康知识名称
     */

    @TableField(value = "jiankangzhishi_name")
    private String jiankangzhishiName;


    /**
     * 健康知识图片
     */

    @TableField(value = "jiankangzhishi_photo")
    private String jiankangzhishiPhoto;


    /**
     * 健康知识类型
     */

    @TableField(value = "jiankangzhishi_types")
    private Integer jiankangzhishiTypes;


    /**
     * 健康知识发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 健康知识详情
     */

    @TableField(value = "jiankangzhishi_content")
    private String jiankangzhishiContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：健康知识名称
	 */
    public String getJiankangzhishiName() {
        return jiankangzhishiName;
    }


    /**
	 * 获取：健康知识名称
	 */

    public void setJiankangzhishiName(String jiankangzhishiName) {
        this.jiankangzhishiName = jiankangzhishiName;
    }
    /**
	 * 设置：健康知识图片
	 */
    public String getJiankangzhishiPhoto() {
        return jiankangzhishiPhoto;
    }


    /**
	 * 获取：健康知识图片
	 */

    public void setJiankangzhishiPhoto(String jiankangzhishiPhoto) {
        this.jiankangzhishiPhoto = jiankangzhishiPhoto;
    }
    /**
	 * 设置：健康知识类型
	 */
    public Integer getJiankangzhishiTypes() {
        return jiankangzhishiTypes;
    }


    /**
	 * 获取：健康知识类型
	 */

    public void setJiankangzhishiTypes(Integer jiankangzhishiTypes) {
        this.jiankangzhishiTypes = jiankangzhishiTypes;
    }
    /**
	 * 设置：健康知识发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：健康知识发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：健康知识详情
	 */
    public String getJiankangzhishiContent() {
        return jiankangzhishiContent;
    }


    /**
	 * 获取：健康知识详情
	 */

    public void setJiankangzhishiContent(String jiankangzhishiContent) {
        this.jiankangzhishiContent = jiankangzhishiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

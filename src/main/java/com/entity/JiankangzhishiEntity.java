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
 * 健康知识
 *
 * @author 
 * @email
 */
@TableName("jiankangzhishi")
public class JiankangzhishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangzhishiEntity() {

	}

	public JiankangzhishiEntity(T t) {
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 健康知识详情
     */
    @TableField(value = "jiankangzhishi_content")

    private String jiankangzhishiContent;


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
        return "Jiankangzhishi{" +
            "id=" + id +
            ", jiankangzhishiName=" + jiankangzhishiName +
            ", jiankangzhishiPhoto=" + jiankangzhishiPhoto +
            ", jiankangzhishiTypes=" + jiankangzhishiTypes +
            ", insertTime=" + insertTime +
            ", jiankangzhishiContent=" + jiankangzhishiContent +
            ", createTime=" + createTime +
        "}";
    }
}

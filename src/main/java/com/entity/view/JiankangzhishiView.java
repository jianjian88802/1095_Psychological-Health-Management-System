package com.entity.view;

import com.entity.JiankangzhishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 健康知识
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiankangzhishi")
public class JiankangzhishiView extends JiankangzhishiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 健康知识类型的值
		*/
		private String jiankangzhishiValue;



	public JiankangzhishiView() {

	}

	public JiankangzhishiView(JiankangzhishiEntity jiankangzhishiEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 健康知识类型的值
			*/
			public String getJiankangzhishiValue() {
				return jiankangzhishiValue;
			}
			/**
			* 设置： 健康知识类型的值
			*/
			public void setJiankangzhishiValue(String jiankangzhishiValue) {
				this.jiankangzhishiValue = jiankangzhishiValue;
			}
















}

package com.shang.news.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author shang
 * @since 2020-03-28
 */
@TableName("news_collect")
public class Collect extends Model<Collect> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 新闻/视频ID
     */
    private String relatedId;

    /**
     * 关联用户
     */
    private String relationUser;

    /**
     * 收藏时间
     */
    private LocalDateTime collectTime;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatetime;

    /**
     * 是否收藏(0是不收藏，1是收藏)
     */
    private String collectFlag;

    //关联的新闻实体
    @TableField(exist = false)
    private Content content;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public String getRelationUser() {
        return relationUser;
    }

    public void setRelationUser(String relationUser) {
        this.relationUser = relationUser;
    }

    public LocalDateTime getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public String getCollectFlag() {
        return collectFlag;
    }

    public void setCollectFlag(String collectFlag) {
        this.collectFlag = collectFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@Override
    public String toString() {
        return "Collect{" +
        "id=" + id +
        ", relatedId=" + relatedId +
        ", relationUser=" + relationUser +
        ", collectTime=" + collectTime +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", collectFlag=" + collectFlag +
        ", content=" + content +
        "}";
    }
}

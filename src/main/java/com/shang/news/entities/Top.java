package com.shang.news.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
@TableName("news_top")
public class Top extends Model<Top> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 新闻ID
     */
    private String newsId;

    /**
     * 是否轮播新闻(0是普通头条，1是轮播新闻)
     */
    private String resousel;

    /**
     * 上头条时间
     */
    private LocalDateTime topTime;

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
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String creater;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updater;

    /**
     * 申请状态(0为申请失败，1为等待申请，2为申请成功)
     */
    private String applyStatus;

    /**
     * 关联的新闻实体
     */
    @TableField(exist = false)
    private Content content;

    public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getResousel() {
        return resousel;
    }

    public void setResousel(String resousel) {
        this.resousel = resousel;
    }

    public LocalDateTime getTopTime() {
        return topTime;
    }

    public void setTopTime(LocalDateTime topTime) {
        this.topTime = topTime;
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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
	@Override
    public String toString() {
        return "Top{" +
        "id=" + id +
        ", newsId=" + newsId +
        ", resousel=" + resousel +
        ", topTime=" + topTime +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", creater=" + creater +
        ", updater=" + updater +
        ", applyStatus=" + applyStatus +
        "}";
    }
    
}

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
 * @since 2020-03-14
 */
@TableName("news_content")
public class Content extends Model<Content> {

    private static final long serialVersionUID=1L;

    /**
     * 新闻编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 撰稿人ID
     */
    private String authorId;
    
    /**
     * 撰稿人姓名
     */
    @TableField(exist = false)
    private String authorName;

    /**
     * 发送时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime sendtime;

    /**
     * 文章内容
     */
    private String content;

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
     * 公司ID
     */
    private String companyId;
    
    /**
     * 公司ID
     */
    @TableField(exist = false)
    private String companyName;

    /**
     * 新闻类型(0为文章，1为视频)
     */
    private String newsType;

    /**
     * 新闻链接
     */
    private String newsUrl;

    /**
     * 是否删除
     */
    private String deleteFlag;

    @TableField(exist = false)
    private List<Attachment> pics;
    
    @TableField(exist = false)
    private Collect collect;
    
    @TableField(exist = false)
    private String applyStatus;
    
    @TableField(exist = false)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public LocalDateTime getSendtime() {
        return sendtime;
    }

    public void setSendtime(LocalDateTime sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
    public List<Attachment> getPics() {
		return pics;
	}

	public void setPics(List<Attachment> pics) {
		this.pics = pics;
	}
	
    public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
    public String toString() {
        return "Content{" +
        "id=" + id +
        ", title=" + title +
        ", authorId=" + authorId +
        ", authorName=" + authorName +
        ", sendtime=" + sendtime +
        ", content=" + content +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", creater=" + creater +
        ", updater=" + updater +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", newsType=" + newsType +
        ", newsUrl=" + newsUrl +
        ", deleteFlag=" + deleteFlag +
        ", applyStatus=" + applyStatus +
        ", pics=" + pics +
        "}";
    }
}

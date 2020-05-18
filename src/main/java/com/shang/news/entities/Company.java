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
@TableName("news_company")
public class Company extends Model<Company> {

    private static final long serialVersionUID=1L;

    /**
     * 公司ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 上级公司ID
     */
    private String parentId;

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
     * 是否删除
     */
    private String deleteFlag;

    @TableField(exist = false)
    private List<Content> content;
    
    @TableField(exist = false)
    private List<Content> videoContent;
    
    @TableField(exist = false)
    private Order order;
    
    @TableField(exist = false)
    private Attachment headIcon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	public List<Content> getVideoContent() {
		return videoContent;
	}

	public void setVideoContent(List<Content> videoContent) {
		this.videoContent = videoContent;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Attachment getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(Attachment headIcon) {
		this.headIcon = headIcon;
	}

	@Override
    public String toString() {
        return "Company{" +
        "id=" + id +
        ", companyName=" + companyName +
        ", parentId=" + parentId +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", creater=" + creater +
        ", updater=" + updater +
        ", deleteFlag=" + deleteFlag +
        ", content=" + content +
        ", videoContent=" + videoContent +
        ", headIcon=" + headIcon +
        "}";
    }
}

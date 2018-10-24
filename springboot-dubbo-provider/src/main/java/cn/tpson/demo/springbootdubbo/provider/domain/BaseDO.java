package cn.tpson.demo.springbootdubbo.provider.domain;

import org.apache.ibatis.annotations.Property;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by Zhangka in 2018/10/23
 */
public class BaseDO implements Serializable {
    private Long id;
    private Boolean deleted;
    private Date gmtCreate;
    private Date gmtModified;
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseDO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deleted=" + deleted)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModified=" + gmtModified)
                .add("version=" + version)
                .toString();
    }
}

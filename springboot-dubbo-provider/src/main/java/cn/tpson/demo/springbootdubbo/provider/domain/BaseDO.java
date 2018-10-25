package cn.tpson.demo.springbootdubbo.provider.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.StringJoiner;

/**
 * Created by Zhangka in 2018/10/23
 */
public class BaseDO implements Serializable {
    private Long id;
    private Boolean deleted;
    private Instant gmtCreate;
    private Instant gmtModified;
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

    public Instant getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Instant gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Instant getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Instant gmtModified) {
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

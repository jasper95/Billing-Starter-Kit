package com.jasperprojects.starter.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jasperprojects.starter.domain.AuditableEntity;
import com.jasperprojects.starter.util.AuditorDateTimeSerializer;
import org.joda.time.DateTime;


public abstract class AuditableEntityDTO {

    private Long version;

    private String createdByUser;

    private DateTime creationTime;

    private String modifiedByUser;

    @JsonSerialize(using=AuditorDateTimeSerializer.class)
    private DateTime modificationTime;

    public AuditableEntityDTO(AuditableEntity entity){
        this.version = entity.getVersion();
        this.createdByUser = entity.getCreatedByUser();
        this.modifiedByUser = entity.getModifiedByUser();
        this.creationTime = entity.getCreationTime();
        this.modificationTime = entity.getModificationTime();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(String modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

    public DateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(DateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "AuditableEntityDTO{" +
                "version=" + version +
                ", createdByUser='" + createdByUser + '\'' +
                ", creationTime=" + creationTime +
                ", modifiedByUser='" + modifiedByUser + '\'' +
                ", modificationTime=" + modificationTime +
                '}';
    }
}

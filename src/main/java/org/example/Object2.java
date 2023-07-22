package org.example;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@XmlRootElement(name = "OBJECT")
@XmlType(propOrder = { "id", "objectId", "objectGUID", "changeId", "name", "typeName", "level","operTypeId",
    "prevId", "nextId", "updateDate", "startDate", "endDate", "isActual", "isActive" })
public class Object2 {
    private long id;
    private long objectId;
    private String objectGUID;
    private long changeId;
    private String name;
    private String typeName;
    private byte level;
    private byte operTypeId;
    private long prevId;
    private long nextId;
    private Date updateDate;
    private Date startDate;
    private Date endDate;
    private byte isActual;
    private byte isActive;


    public long getId() {
        return id;
    }

    @XmlAttribute(name = "ID")
    public void setId(long id) {
        this.id = id;
    }

    public long getObjectId() {
        return objectId;
    }

    @XmlAttribute(name = "OBJECTID")
    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getObjectGUID() {
        return objectGUID;
    }

    @XmlAttribute(name = "OBJECTGUID")
    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }

    public long getChangeId() {
        return changeId;
    }

    @XmlAttribute(name = "CHANGEID")
    public void setChangeId(long changeId) {
        this.changeId = changeId;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    @XmlAttribute(name = "TYPENAME")
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public byte getLevel() {
        return level;
    }

    @XmlAttribute(name = "LEVEL")
    public void setLevel(byte level) {
        this.level = level;
    }

    public byte getOperTypeId() {
        return operTypeId;
    }

    @XmlAttribute(name = "OPERTYPEID")
    public void setOperTypeId(byte operTypeId) {
        this.operTypeId = operTypeId;
    }

    public long getPrevId() {
        return prevId;
    }

    @XmlAttribute(name = "PREVID")
    public void setPrevId(long prevId) {
        this.prevId = prevId;
    }

    public long getNextId() {
        return nextId;
    }

    @XmlAttribute(name = "NEXTID")
    public void setNextId(long nextId) {
        this.nextId = nextId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @XmlAttribute(name = "UPDATEDATE")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    @XmlAttribute(name = "STARTDATE")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @XmlAttribute(name = "ENDDATE")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public byte getIsActual() {
        return isActual;
    }

    @XmlAttribute(name = "ISACTUAL")
    public void setIsActual(byte isActual) {
        this.isActual = isActual;
    }

    public byte getIsActive() {
        return isActive;
    }

    @XmlAttribute(name = "ISACTIVE")
    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}

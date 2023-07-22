package org.example.as_adm_hierarchy;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.example.DateAdapter;

import java.util.Date;

@XmlRootElement(name = "ITEM")
@XmlType(propOrder = { "id", "objectId", "parentObjId", "changeId", "prevId", "nextId", "updateDate", "startDate",
    "endDate", "isActive" })
public class Item {
    private long id;
    private long objectId;
    private long parentObjId;
    private long changeId;
    private long prevId;
    private long nextId;
    private Date updateDate;
    private Date startDate;
    private Date endDate;
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

    public long getParentObjId() {
        return parentObjId;
    }

    @XmlAttribute(name = "PARENTOBJID")
    public void setParentObjId(long parentObjId) {
        this.parentObjId = parentObjId;
    }

    public long getChangeId() {
        return changeId;
    }

    @XmlAttribute(name = "CHANGEID")
    public void setChangeId(long changeId) {
        this.changeId = changeId;
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

    public byte getIsActive() {
        return isActive;
    }
    @XmlAttribute(name = "ISACTIVE")
    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }
}

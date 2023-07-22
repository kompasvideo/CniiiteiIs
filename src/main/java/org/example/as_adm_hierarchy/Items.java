package org.example.as_adm_hierarchy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement(name = "ITEMS")
@XmlType(propOrder = { "ITEM" })
public class Items {
    private Item[] ITEM;

    public Item[] getITEM() {
        return ITEM;
    }

    @XmlElement(name = "ITEM")
    public void setITEM(Item[] ITEM) {
        this.ITEM = ITEM;
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

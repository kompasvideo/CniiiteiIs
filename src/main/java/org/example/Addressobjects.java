package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement(name = "ADDRESSOBJECTS")
@XmlType(propOrder = { "OBJECT" })
public class Addressobjects {
    private Object2[] OBJECT;
    public Object2[] getOBJECT() {
        return OBJECT;
    }

    @XmlElement(name = "OBJECT")
    public void setOBJECT(Object2[] OBJECT) {
        this.OBJECT = OBJECT;
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

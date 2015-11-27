package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.worklivestudy.Work;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "work_live_study")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkLiveStudy {
    @XmlElement(name = "work")
    private Work work;

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final WorkLiveStudy other = (WorkLiveStudy) object;
        return Objects.equal(this.work, other.work);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("work", work)
                .toString();
    }
}

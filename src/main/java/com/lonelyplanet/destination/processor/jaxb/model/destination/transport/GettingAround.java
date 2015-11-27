package com.lonelyplanet.destination.processor.jaxb.model.destination.transport;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.NormalizedStringXmlAdapter;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "getting_around")
@XmlAccessorType(XmlAccessType.FIELD)
public class GettingAround {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "air")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> airList;
    @XmlElement(name = "bicycle")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> bicycleList;
    @XmlElement(name = "boat")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> boatList;
    @XmlElement(name = "car_and_motorcycle")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> carAndMotorcycleList;
    @XmlElement(name = "hitching")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> hitchingList;
    @XmlElement(name = "local_transport")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> localTransportList;
    @XmlElement(name = "bus_and_tram")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> busAndTramList;
    @XmlElement(name = "train")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> trainList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getAirList() {
        return airList;
    }

    public void setAirList(List<String> airList) {
        this.airList = airList;
    }

    public List<String> getBicycleList() {
        return bicycleList;
    }

    public void setBicycleList(List<String> bicycleList) {
        this.bicycleList = bicycleList;
    }

    public List<String> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<String> boatList) {
        this.boatList = boatList;
    }

    public List<String> getCarAndMotorcycleList() {
        return carAndMotorcycleList;
    }

    public void setCarAndMotorcycleList(List<String> carAndMotorcycleList) {
        this.carAndMotorcycleList = carAndMotorcycleList;
    }

    public List<String> getHitchingList() {
        return hitchingList;
    }

    public void setHitchingList(List<String> hitchingList) {
        this.hitchingList = hitchingList;
    }

    public List<String> getLocalTransportList() {
        return localTransportList;
    }

    public void setLocalTransportList(List<String> localTransportList) {
        this.localTransportList = localTransportList;
    }

    public List<String> getBusAndTramList() {
        return busAndTramList;
    }

    public void setBusAndTramList(List<String> busAndTramList) {
        this.busAndTramList = busAndTramList;
    }

    public List<String> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<String> trainList) {
        this.trainList = trainList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final GettingAround other = (GettingAround) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.airList, other.airList)
                && Objects.equal(this.bicycleList, other.bicycleList)
                && Objects.equal(this.boatList, other.boatList)
                && Objects.equal(this.carAndMotorcycleList, other.carAndMotorcycleList)
                && Objects.equal(this.hitchingList, other.hitchingList)
                && Objects.equal(this.localTransportList, other.localTransportList)
                && Objects.equal(this.busAndTramList, other.busAndTramList)
                && Objects.equal(this.trainList, other.trainList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("airList", airList)
                .add("bicycleList", bicycleList)
                .add("boatList", boatList)
                .add("carAndMotorcycleList", carAndMotorcycleList)
                .add("hitchingList", hitchingList)
                .add("localTransportList", localTransportList)
                .add("busAndTramList", busAndTramList)
                .add("trainList", trainList)
                .toString();
    }
}

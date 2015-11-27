package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Animals;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Birds;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.EndangeredSpecies;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Plants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "animals")
@XmlAccessorType(XmlAccessType.FIELD)
public class WildLife {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "animals")
    private Animals animals;
    @XmlElement(name = "birds")
    private Birds birds;
    @XmlElement(name = "endangered_species")
    private EndangeredSpecies endangeredSpecies;
    @XmlElement(name = "plants")
    private Plants plants;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }

    public Birds getBirds() {
        return birds;
    }

    public void setBirds(Birds birds) {
        this.birds = birds;
    }

    public Plants getPlants() {
        return plants;
    }

    public void setPlants(Plants plants) {
        this.plants = plants;
    }

    public EndangeredSpecies getEndangeredSpecies() {
        return endangeredSpecies;
    }

    public void setEndangeredSpecies(EndangeredSpecies endangeredSpecies) {
        this.endangeredSpecies = endangeredSpecies;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final WildLife other = (WildLife) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.animals, other.animals)
                && Objects.equal(this.birds, other.birds)
                && Objects.equal(this.endangeredSpecies, other.endangeredSpecies)
                && Objects.equal(this.plants, other.plants);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("animals", animals)
                .add("birds", birds)
                .add("endangeredSpecies", endangeredSpecies)
                .add("plants", plants)
                .toString();
    }
}

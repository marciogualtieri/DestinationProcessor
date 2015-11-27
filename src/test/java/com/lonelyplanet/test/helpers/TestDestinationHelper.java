package com.lonelyplanet.test.helpers;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import com.lonelyplanet.destination.processor.jaxb.model.destination.*;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.introductory.Introduction;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.HealthAndSafety;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.MoneyAndCosts;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.Visas;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingAround;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingThereAndAway;
import com.lonelyplanet.destination.processor.jaxb.model.destination.weather.WhenToGo;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Animals;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Birds;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.EndangeredSpecies;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Plants;
import com.lonelyplanet.destination.processor.jaxb.model.destination.worklivestudy.Work;
import com.lonelyplanet.test.constants.TestDestinationConstants;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;

import java.util.ArrayList;
import java.util.List;

public class TestDestinationHelper {

    public static Destination createTestDestinations() {
        Destination destination = new Destination();
        destination.setAssetId(3333);
        destination.setTitle(TestTaxonomyConstants.HILL_VALLEY_NODE_NAME);
        destination.setTitleAscii(TestTaxonomyConstants.HILL_VALLEY_NODE_NAME);
        destination.setAtlasId(TestTaxonomyConstants.HILL_VALLEY_ATLAS_NODE_ID);
        destination.setHistoryList(Lists.newArrayList(createTestHistory()));
        destination.setIntroductory(createTestIntroductory());
        destination.setPracticalInformation(createTestPracticalInformation());
        destination.setTransport(createTestTransport());
        destination.setWeather(createTestWeather());
        destination.setWildLife(createTestWildLife());
        destination.setWorkLiveStudy(createWorkLifeStudy());
        return destination;
    }

    private static History createTestHistory() {
        History historyNested = new History();
        historyNested.setHistoryList(createTestHistoryList());
        historyNested.setTextList(Lists.newArrayList("", "", ""));
        History history = new History();
        Overview overview = new Overview();
        overview.setTextList(TestDestinationConstants.HISTORY_OVERVIEW_LINES);
        history.setOverview(overview);
        history.setTextList(Lists.newArrayList("", "", ""));
        history.setHistoryList(Lists.newArrayList(historyNested));
        return history;
    }

    private static List<History> createTestHistoryList() {
        List<History> historyList = new ArrayList<>();
        for (String historyLine : TestDestinationConstants.HISTORY_LINES) {
            History history = new History();
            history.setTextList(Lists.newArrayList(historyLine));
            historyList.add(history);
        }
        return historyList;
    }

    private static Introductory createTestIntroductory() {
        Introductory introductory = new Introductory();
        Introduction introduction = new Introduction();
        Overview overview = new Overview();
        overview.setTextList(TestDestinationConstants.INTRODUCTION_OVERVIEW_LINES);
        introduction.setOverview(overview);
        introductory.setIntroduction(introduction);
        return introductory;
    }

    private static PracticalInformation createTestPracticalInformation() {
        PracticalInformation practicalInformation = new PracticalInformation();
        practicalInformation.setHealthAndSafety(createTestHealthAndSafety());
        practicalInformation.setMoneyAndCosts(createTestMoneyAndCosts());
        practicalInformation.setVisas(createTestVisas());
        return practicalInformation;
    }

    private static HealthAndSafety createTestHealthAndSafety() {
        HealthAndSafety healthAndSafety = new HealthAndSafety();
        healthAndSafety.setBeforeYouGoList(TestDestinationConstants.BEFORE_YOU_GO_LINES);
        healthAndSafety.setDangersAndAnnoyancesList(TestDestinationConstants.DANGERS_AND_ANNOYANCES_LINES);
        healthAndSafety.setInTransitList(TestDestinationConstants.IN_TRANSIT_LINES);
        healthAndSafety.setWhileYouAreThereList(TestDestinationConstants.WHILE_YOURE_THERE_LINES);
        return healthAndSafety;
    }

    private static MoneyAndCosts createTestMoneyAndCosts() {
        MoneyAndCosts moneyAndCosts = new MoneyAndCosts();
        moneyAndCosts.setMoneyList(TestDestinationConstants.MONEY_LINES);
        moneyAndCosts.setCostsList(TestDestinationConstants.COSTS_LINES);
        return moneyAndCosts;
    }

    private static Visas createTestVisas() {
        Visas visas = new Visas();
        Overview overview = new Overview();
        overview.setTextList(TestDestinationConstants.VISA_OVERVIEW_LINES);
        visas.setOtherList(TestDestinationConstants.OTHER_LINES);
        visas.setPermitsList(TestDestinationConstants.PERMITS_LINES);
        visas.setOverview(overview);
        return visas;
    }

    private static Transport createTestTransport() {
        Transport transport = new Transport();
        transport.setGettingAround(createTestGettingAround());
        transport.setGettingThereAndAway(createTestGettingThereAndAway());
        return transport;
    }

    private static GettingAround createTestGettingAround() {
        GettingAround gettingAround = new GettingAround();
        gettingAround.setAirList(TestDestinationConstants.GETTING_AROUND_AIR_LINES);
        gettingAround.setBicycleList(TestDestinationConstants.BICYCLE_LINES);
        gettingAround.setBoatList(TestDestinationConstants.GETTING_AROUND_BOAT_LINES);
        gettingAround.setBusAndTramList(TestDestinationConstants.BUS_AND_TRAM_LINES);
        gettingAround.setCarAndMotorcycleList(TestDestinationConstants.CAR_AND_MOTORCYCLE_LINES);
        gettingAround.setHitchingList(TestDestinationConstants.HITCHING_LINES);
        gettingAround.setTrainList(TestDestinationConstants.TRAIN_LINES);
        gettingAround.setLocalTransportList(TestDestinationConstants.LOCAL_TRANSPORT_LINES);
        return gettingAround;
    }

    private static GettingThereAndAway createTestGettingThereAndAway() {
        GettingThereAndAway gettingThereAndAway = new GettingThereAndAway();
        gettingThereAndAway.setBoatList(TestDestinationConstants.GETTING_THERE_AND_AWAY_BOAT_LINES);
        gettingThereAndAway.setAirList(TestDestinationConstants.GETTING_THERE_AND_AWAY_AIR_LINES);
        gettingThereAndAway.setLandList(TestDestinationConstants.LAND_LINES);
        return gettingThereAndAway;
    }

    private static Weather createTestWeather() {
        Weather weather = new Weather();
        WhenToGo whenToGo = new WhenToGo();
        Overview overview = new Overview();
        overview.setTextList(TestDestinationConstants.WHEN_TO_GO_OVERVIEW_LINES);
        whenToGo.setOverview(overview);
        whenToGo.setClimateList(TestDestinationConstants.CLIMATE_LINES);
        weather.setWhenToGo(whenToGo);
        return weather;
    }

    private static WildLife createTestWildLife() {
        WildLife wildLife = new WildLife();
        wildLife.setOverview(createTestWildLifeOverview());
        wildLife.setAnimals(createTestAnimals());
        wildLife.setBirds(createTestBirds());
        wildLife.setEndangeredSpecies(createTestEndangeredSpecies());
        wildLife.setPlants(createTestPlants());
        return wildLife;
    }

    private static Overview createTestWildLifeOverview() {
        Overview overviewOverview = new Overview();
        overviewOverview.setTextList(TestDestinationConstants.WILD_LIFE_OVERVIEW_OVERVIEW_LINES);
        Overview overview = new Overview();
        overview.setOverviewList(Lists.newArrayList(overviewOverview));
        overview.setTextList(Lists.newArrayList("", ""));
        return overview;
    }

    private static Animals createTestAnimals() {
        Animals animals = new Animals();
        animals.setMammalsList(TestDestinationConstants.MAMMALS_LINES);
        return animals;
    }

    private static Birds createTestBirds() {
        Birds birds = new Birds();
        Overview birdsOverview = new Overview();
        birdsOverview.setTextList(TestDestinationConstants.BIRDS_OVERVIEW_LINES);
        birds.setOverview(birdsOverview);
        return birds;
    }

    private static EndangeredSpecies createTestEndangeredSpecies() {
        EndangeredSpecies endangeredSpecies = new EndangeredSpecies();
        Overview endangeredSpeciesOverview = new Overview();
        endangeredSpeciesOverview.setTextList(TestDestinationConstants.ENDANGERED_SPECIES_OVERVIEW_LINES);
        endangeredSpecies.setOverview(endangeredSpeciesOverview);
        return endangeredSpecies;
    }

    private static Plants createTestPlants() {
        Plants plants = new Plants();
        Overview plantsOverview = new Overview();
        plantsOverview.setTextList(TestDestinationConstants.PLANTS_OVERVIEW_LINES);
        plants.setOverview(plantsOverview);
        return plants;
    }

    private static WorkLiveStudy createWorkLifeStudy() {
        WorkLiveStudy workLiveStudy = new WorkLiveStudy();
        Work work = new Work();
        work.setBusinessList(TestDestinationConstants.BUSINESS_LINES);
        Overview workOverview = new Overview();
        workOverview.setTextList(TestDestinationConstants.WORK_OVERVIEW_LINES);
        work.setOverview(workOverview);
        workLiveStudy.setWork(work);
        return workLiveStudy;
    }

    private TestDestinationHelper() {
    }
}

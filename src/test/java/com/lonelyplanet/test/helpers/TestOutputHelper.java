package com.lonelyplanet.test.helpers;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.output.constants.OutputSectionConstants;
import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import com.lonelyplanet.destination.processor.output.OutputSection;
import com.lonelyplanet.test.constants.TestDestinationConstants;
import com.lonelyplanet.test.constants.TestOutputConstants;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;

import java.util.List;

public class TestOutputHelper {

    public static OutputNavigationNode createTestNavigationTree() {
        OutputNavigationNode californiaNode =
                new OutputNavigationNode(TestTaxonomyConstants.CALIFORNIA_NODE_NAME,
                        TestOutputConstants.CALIFORNIA_RESOURCE);
        OutputNavigationNode sierraNevadaMountainsNode =
                new OutputNavigationNode(TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_NODE_NAME,
                        TestOutputConstants.SIERRA_NEVADA_MOUNTAINS_RESOURCE);
        OutputNavigationNode hillValleyNode =
                new OutputNavigationNode(TestTaxonomyConstants.HILL_VALLEY_NODE_NAME,
                        TestOutputConstants.HILL_VALLEY_RESOURCE);
        californiaNode.setOutputNavigationNodeList(Lists.newArrayList(sierraNevadaMountainsNode));
        sierraNevadaMountainsNode.setOutputNavigationNodeList(Lists.newArrayList(hillValleyNode));
        return californiaNode;
    }

    public static OutputSection createTestIntroductionOutputSection() {
        OutputSection introductionOutputSection = new OutputSection(OutputSectionConstants.INTRODUCTION_SECTION_TITLE);
        OutputSection overviewOutputSection =
                new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                        TestDestinationConstants.INTRODUCTION_OVERVIEW_LINES);
        introductionOutputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection));
        return introductionOutputSection;
    }

    public static OutputSection createTestHistoryOutputSection() {
        OutputSection historyOutputSection = new OutputSection(OutputSectionConstants.HISTORY_SECTION_TITLE,
                TestDestinationConstants.HISTORY_LINES);
        OutputSection overviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.HISTORY_OVERVIEW_LINES);
        historyOutputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection));
        return historyOutputSection;
    }

    public static OutputSection createTestPracticalInformationOutputSection() {
        OutputSection practicalInformationOutputSection =
                new OutputSection(OutputSectionConstants.PRACTICAL_INFORMATION_SECTION_TITLE);
        practicalInformationOutputSection.setOutputSectionList(
                Lists.newArrayList(createTestHealthAndSafetySection(),
                        createMoneyAndCostsSection(),
                        createTestVisaSection()));
        return practicalInformationOutputSection;
    }

    public static OutputSection createTestTransportOutputSection() {
        OutputSection transportOutputSection = new OutputSection(OutputSectionConstants.TRANSPORT_SECTION_TITLE);
        OutputSection gettingAroundOutputSection = createGettingAroundOutputSection();
        OutputSection gettingThereAndAwayOutputSection = createGettingThereAndAwayOutputSection();
        transportOutputSection.setOutputSectionList(Lists.newArrayList(gettingAroundOutputSection,
                gettingThereAndAwayOutputSection));
        return transportOutputSection;
    }

    public static OutputSection createTestWeatherOutputSection() {
        OutputSection weatherOutputSection = new OutputSection(OutputSectionConstants.WEATHER_SECTION_TITLE);
        OutputSection whenToGoOutputSection = new OutputSection(OutputSectionConstants.WHEN_TO_GO_SECTION_TITLE);
        OutputSection overviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.WHEN_TO_GO_OVERVIEW_LINES);
        OutputSection climateOutputSection = new OutputSection(OutputSectionConstants.CLIMATE_SECTION_TITLE,
                TestDestinationConstants.CLIMATE_LINES);
        whenToGoOutputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection,
                climateOutputSection));
        weatherOutputSection.setOutputSectionList(Lists.newArrayList(whenToGoOutputSection));
        return weatherOutputSection;
    }

    public static OutputSection createTestWildLifeOutputSection() {
        OutputSection wildLifeOutputSection = new OutputSection(OutputSectionConstants.WILD_LIFE_SECTION_TITLE);
        OutputSection overviewOutputSection = createWildLifeOverViewOutputSection();
        wildLifeOutputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection,
                createAnimalsOutputSection(),
                createBirdsOutputSection(),
                createPlantsOutputSection(),
                createEndangeredSpeciesOutputSection()));
        return wildLifeOutputSection;
    }

    public static OutputSection createTestWorkLiveStudyOutputSection() {
        OutputSection workLiveStudyOutputSection = new OutputSection(OutputSectionConstants.WORK_LIVE_STUDY_SECTION_TITLE);
        OutputSection workOutputSection = new OutputSection(OutputSectionConstants.WORK_SECTION_TITLE);
        OutputSection businessOutputSection = new OutputSection(OutputSectionConstants.BUSINESS_SECTION_TITLE,
                TestDestinationConstants.BUSINESS_LINES);
        OutputSection overviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.WORK_OVERVIEW_LINES);
        workOutputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection, businessOutputSection));
        workLiveStudyOutputSection.setOutputSectionList(Lists.newArrayList(workOutputSection));
        return workLiveStudyOutputSection;
    }

    private static OutputSection createWildLifeOverViewOutputSection() {
        List<String> lines = Lists.newArrayList("", "");
        lines.addAll(TestDestinationConstants.WILD_LIFE_OVERVIEW_OVERVIEW_LINES);
        return new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE, lines);
    }

    private static OutputSection createAnimalsOutputSection() {
        OutputSection mammalsOutputSection = new OutputSection(OutputSectionConstants.MAMMALS_SECTION_TITLE,
                TestDestinationConstants.MAMMALS_LINES);
        OutputSection animalsOutputSection = new OutputSection(OutputSectionConstants.ANIMALS_SECTION_TITLE);
        animalsOutputSection.setOutputSectionList(Lists.newArrayList(mammalsOutputSection));
        return animalsOutputSection;
    }

    private static OutputSection createBirdsOutputSection() {
        OutputSection birdsOutputSection = new OutputSection(OutputSectionConstants.BIRDS_SECTION_TITLE);
        OutputSection birdsOverviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.BIRDS_OVERVIEW_LINES);
        birdsOutputSection.setOutputSectionList(Lists.newArrayList(birdsOverviewOutputSection));
        return birdsOutputSection;
    }

    private static OutputSection createPlantsOutputSection() {
        OutputSection plantsOutputSection = new OutputSection(OutputSectionConstants.PLANTS_SECTION_TITLE);
        OutputSection plantsOverviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.PLANTS_OVERVIEW_LINES);
        plantsOutputSection.setOutputSectionList(Lists.newArrayList(plantsOverviewOutputSection));
        return plantsOutputSection;
    }

    private static OutputSection createEndangeredSpeciesOutputSection() {
        OutputSection endangeredSpeciesOutputSection = new OutputSection(OutputSectionConstants.ENDANGERED_SPECIES_SECTION_TITLE);
        OutputSection endangeredSpeciesOverviewOutputSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.ENDANGERED_SPECIES_OVERVIEW_LINES);
        endangeredSpeciesOutputSection.setOutputSectionList(Lists.newArrayList(endangeredSpeciesOverviewOutputSection));
        return endangeredSpeciesOutputSection;
    }

    private static OutputSection createGettingThereAndAwayOutputSection() {
        OutputSection gettingThereAndAwayOutputSection =
                new OutputSection(OutputSectionConstants.GETTING_THERE_AND_AWAY_SECTION_TITLE);
        gettingThereAndAwayOutputSection.setOutputSectionList(Lists.newArrayList(
                createTestGettingThereAndAwayAirSection(),
                createTestLandSection(),
                createTestBoatSection()));
        return gettingThereAndAwayOutputSection;
    }

    private static OutputSection createGettingAroundOutputSection() {
        OutputSection gettingAroundOutputSection =
                new OutputSection(OutputSectionConstants.GETTING_AROUND_SECTION_TITLE);
        gettingAroundOutputSection.setOutputSectionList(Lists.newArrayList(
                createTestGettingAroundAirSection(),
                createTestBicycleSection(),
                createTestGettingAroundBoatSection(),
                createTestCarAndMotorcycleSection(),
                createTestHitchingSection(),
                createTestLocalTransportSection(),
                createTestBusAndTramSection(),
                createTestTrainSection()));
        return gettingAroundOutputSection;
    }

    private static OutputSection createTestGettingThereAndAwayAirSection() {
        return new OutputSection(OutputSectionConstants.AIR_SECTION_TITLE,
                TestDestinationConstants.GETTING_THERE_AND_AWAY_AIR_LINES);
    }

    private static OutputSection createTestBoatSection() {
        return new OutputSection(OutputSectionConstants.BOAT_SECTION_TITLE,
                TestDestinationConstants.GETTING_THERE_AND_AWAY_BOAT_LINES);
    }

    private static OutputSection createTestLandSection() {
        return new OutputSection(OutputSectionConstants.LAND_SECTION_TITLE,
                TestDestinationConstants.LAND_LINES);
    }

    private static OutputSection createTestGettingAroundAirSection() {
        return new OutputSection(OutputSectionConstants.AIR_SECTION_TITLE,
                TestDestinationConstants.GETTING_AROUND_AIR_LINES);
    }

    private static OutputSection createTestBicycleSection() {
        return new OutputSection(OutputSectionConstants.BICYCLE_SECTION_TITLE,
                TestDestinationConstants.BICYCLE_LINES);
    }

    private static OutputSection createTestGettingAroundBoatSection() {
        return new OutputSection(OutputSectionConstants.BOAT_SECTION_TITLE,
                TestDestinationConstants.GETTING_AROUND_BOAT_LINES);
    }

    private static OutputSection createTestCarAndMotorcycleSection() {
        return new OutputSection(OutputSectionConstants.CAR_AND_MOTORCYCLE_SECTION_TITLE,
                TestDestinationConstants.CAR_AND_MOTORCYCLE_LINES);
    }

    private static OutputSection createTestHitchingSection() {
        return new OutputSection(OutputSectionConstants.HITCHING_SECTION_TITLE,
                TestDestinationConstants.HITCHING_LINES);
    }

    private static OutputSection createTestLocalTransportSection() {
        return new OutputSection(OutputSectionConstants.LOCAL_TRANSPORT_SECTION_TITLE,
                TestDestinationConstants.LOCAL_TRANSPORT_LINES);
    }

    private static OutputSection createTestBusAndTramSection() {
        return new OutputSection(OutputSectionConstants.BUS_AND_TRAM_SECTION_TITLE,
                TestDestinationConstants.BUS_AND_TRAM_LINES);
    }

    private static OutputSection createTestTrainSection() {
        return new OutputSection(OutputSectionConstants.TRAIN_SECTION_TITLE,
                TestDestinationConstants.TRAIN_LINES);
    }

    private static OutputSection createTestHealthAndSafetySection() {
        OutputSection healthAndSafetySection =
                new OutputSection(OutputSectionConstants.HEALTH_AND_SAFETY_SECTION_TITLE);
        healthAndSafetySection.setOutputSectionList(
                Lists.newArrayList(createTestBeforeYouGoSection(),
                        createTestDangersAndAnnoyancesSection(),
                        createTestInTransitSection(),
                        createTestWhileYoureThereSection()));
        return healthAndSafetySection;
    }

    private static OutputSection createTestWhileYoureThereSection() {
        return new OutputSection(OutputSectionConstants.WHILE_YOURE_THERE_SECTION_TITLE,
                TestDestinationConstants.WHILE_YOURE_THERE_LINES);
    }

    private static OutputSection createTestInTransitSection() {
        return new OutputSection(OutputSectionConstants.IN_TRANSIT_SECTION_TITLE,
                TestDestinationConstants.IN_TRANSIT_LINES);
    }

    private static OutputSection createTestDangersAndAnnoyancesSection() {
        return new OutputSection(OutputSectionConstants.DANGERS_AND_ANNOYANCES_SECTION_TITLE,
                TestDestinationConstants.DANGERS_AND_ANNOYANCES_LINES);
    }

    private static OutputSection createTestBeforeYouGoSection() {
        return new OutputSection(OutputSectionConstants.BEFORE_YOU_GO_SECTION_TITLE,
                TestDestinationConstants.BEFORE_YOU_GO_LINES);
    }

    private static OutputSection createTestVisaSection() {
        OutputSection visasSection = new OutputSection(OutputSectionConstants.VISAS_SECTION_TITLE);
        OutputSection overviewSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                TestDestinationConstants.VISA_OVERVIEW_LINES);
        OutputSection otherSection = new OutputSection(OutputSectionConstants.OTHER_SECTION_TITLE,
                TestDestinationConstants.OTHER_LINES);
        OutputSection permitsSection = new OutputSection(OutputSectionConstants.PERMITS_SECTION_TITLE,
                TestDestinationConstants.PERMITS_LINES);
        visasSection.setOutputSectionList(Lists.newArrayList(overviewSection,
                otherSection, permitsSection));
        return visasSection;
    }

    private static OutputSection createMoneyAndCostsSection() {
        OutputSection moneyAndCostsSection = new OutputSection(OutputSectionConstants.MONEY_AND_COSTS_SECTION_TITLE);
        OutputSection moneySection = new OutputSection(OutputSectionConstants.MONEY_SECTION_TITLE,
                TestDestinationConstants.MONEY_LINES);
        OutputSection costsSection = new OutputSection(OutputSectionConstants.COSTS_SECTION_TITLE,
                TestDestinationConstants.COSTS_LINES);
        moneyAndCostsSection.setOutputSectionList(Lists.newArrayList(moneySection, costsSection));
        return moneyAndCostsSection;
    }

    private TestOutputHelper() {
    }

}

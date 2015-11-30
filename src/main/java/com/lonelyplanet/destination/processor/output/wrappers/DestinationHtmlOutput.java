package com.lonelyplanet.destination.processor.output.wrappers;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.output.constants.OutputSectionConstants;
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
import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import com.lonelyplanet.destination.processor.output.OutputSection;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DestinationHtmlOutput {

    private final Destination destination;
    private final OutputNavigationNode outputNavigationNode;

    public DestinationHtmlOutput(Destination destination,
                                 OutputNavigationNode outputNavigationNode) {
        this.destination = destination;
        this.outputNavigationNode = outputNavigationNode;
    }

    public OutputNavigationNode getNavigationTree() {
        return this.outputNavigationNode;
    }

    public String getTitle() {
        return this.destination.getTitleAscii();
    }

    public OutputSection getIntroductionOutputSection() {
        OutputSection introductionSection =
                new OutputSection(OutputSectionConstants.INTRODUCTION_SECTION_TITLE);
        OutputSection overviewSection = new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                getIntroductionOverviewLines());
        introductionSection.setOutputSectionList(Lists.newArrayList(overviewSection));
        return introductionSection;
    }

    public OutputSection getHistoryOutputSection() {
        List<History> historyList = destination.getHistoryList();
        OutputSection historySection = null;
        if (historyList != null) {
            historySection = new OutputSection(OutputSectionConstants.HISTORY_SECTION_TITLE,
                    getHistoryLines());
            List<String> historyOverviewLines = getHistoryOverviewLines();
            if (historyOverviewLines != null) {
                OutputSection overviewSection =
                        new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                        historyOverviewLines);
                historySection.setOutputSectionList(Lists.newArrayList(overviewSection));
            }
        }
        return historySection;
    }

    public OutputSection getPracticalInformationOutputSection() {
        PracticalInformation practicalInformation = destination.getPracticalInformation();
        OutputSection practicalInformationSection = null;
        if (practicalInformation != null) {
            practicalInformationSection =
                    new OutputSection(OutputSectionConstants.PRACTICAL_INFORMATION_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(practicalInformation.getOverview()));
            addOutputSectionToList(outputSections, createHealthAndSafetySection(practicalInformation));
            addOutputSectionToList(outputSections, createMoneyAndCostsSection(practicalInformation));
            addOutputSectionToList(outputSections, createVisasSection(practicalInformation));
            practicalInformationSection.setOutputSectionList(outputSections);
        }
        return practicalInformationSection;
    }

    public OutputSection getTransportOutputSection() {
        Transport transport = destination.getTransport();
        OutputSection transportSection = null;
        if (transport != null) {
            transportSection = new OutputSection(OutputSectionConstants.TRANSPORT_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(transport.getOverview()));
            addOutputSectionToList(outputSections, createGettingAroundSection(transport));
            addOutputSectionToList(outputSections, createGettingThereAndAwaySection(transport));
            transportSection.setOutputSectionList(outputSections);
        }
        return transportSection;
    }

    public OutputSection getWeatherOutputSection() {
        Weather weather = destination.getWeather();
        OutputSection weatherSection = null;
        if (weather != null) {
            weatherSection = new OutputSection(OutputSectionConstants.WEATHER_SECTION_TITLE);
            WhenToGo whenToGo = weather.getWhenToGo();
            if (whenToGo != null) {
                OutputSection whenToGoSection =
                        new OutputSection(OutputSectionConstants.WHEN_TO_GO_SECTION_TITLE);
                weatherSection.setOutputSectionList(Lists.newArrayList(whenToGoSection));
                List<OutputSection> outputSections = new ArrayList<>();
                addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                        getWhenToGoOverviewLines());
                addOutputSectionToList(outputSections, OutputSectionConstants.CLIMATE_SECTION_TITLE,
                        whenToGo.getClimateList());
                whenToGoSection.setOutputSectionList(outputSections);
            }
        }
        return weatherSection;
    }

    public OutputSection getWildLifeOutputSection() {
        WildLife wildLife = destination.getWildLife();
        OutputSection wildLifeOutputSection = null;
        if (wildLife != null) {
            wildLifeOutputSection = new OutputSection(OutputSectionConstants.WILD_LIFE_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(wildLife.getOverview()));
            addOutputSectionToList(outputSections, createAnimalsSection(wildLife));
            addOutputSectionToList(outputSections, createBirdsSection(wildLife));
            addOutputSectionToList(outputSections, createPlantsSection(wildLife));
            addOutputSectionToList(outputSections, createEndangeredSpeciesSection(wildLife));
            wildLifeOutputSection.setOutputSectionList(outputSections);
        }
        return wildLifeOutputSection;
    }

    public OutputSection getWorkLiveStudyOutputSection() {
        WorkLiveStudy workLiveStudy = destination.getWorkLiveStudy();
        OutputSection workLiveStudyOutputSection = null;
        if (workLiveStudy != null) {
            workLiveStudyOutputSection =
                    new OutputSection(OutputSectionConstants.WORK_LIVE_STUDY_SECTION_TITLE);
            Work work = workLiveStudy.getWork();
            if (work != null) {
                OutputSection workOutputSection =
                        new OutputSection(OutputSectionConstants.WORK_SECTION_TITLE);
                Overview overview = work.getOverview();
                List<OutputSection> outputSections = new ArrayList<>();
                if (overview != null) {
                    addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                            getOverviewLines(overview));
                }
                addOutputSectionToList(outputSections, OutputSectionConstants.BUSINESS_SECTION_TITLE,
                        work.getBusinessList());
                workOutputSection.setOutputSectionList(outputSections);
                workLiveStudyOutputSection.setOutputSectionList(Lists.newArrayList(workOutputSection));
            }
        }
        return workLiveStudyOutputSection;
    }

    private OutputSection createBirdsSection(WildLife wildLife) {
        OutputSection birdsOutputSection = null;
        if (wildLife != null) {
            Birds birds = wildLife.getBirds();
            if (birds != null) {
                birdsOutputSection =
                        createSectionWithNestedOverview(OutputSectionConstants.BIRDS_SECTION_TITLE,
                        getOverviewLines(birds.getOverview()));
            }
        }
        return birdsOutputSection;
    }

    private OutputSection createPlantsSection(WildLife wildLife) {
        OutputSection plantsOutputSection = null;
        if (wildLife != null) {
            Plants plants = wildLife.getPlants();
            if (plants != null) {
                plantsOutputSection =
                        createSectionWithNestedOverview(OutputSectionConstants.PLANTS_SECTION_TITLE,
                        getOverviewLines(plants.getOverview()));
            }
        }
        return plantsOutputSection;
    }

    private OutputSection createEndangeredSpeciesSection(WildLife wildLife) {
        OutputSection endangeredSpeciesOutputSection = null;
        if (wildLife != null) {
            EndangeredSpecies endangeredSpecies = wildLife.getEndangeredSpecies();
            if (endangeredSpecies != null) {
                endangeredSpeciesOutputSection = createSectionWithNestedOverview(
                        OutputSectionConstants.ENDANGERED_SPECIES_SECTION_TITLE,
                        getOverviewLines(endangeredSpecies.getOverview()));
            }
        }
        return endangeredSpeciesOutputSection;
    }

    private OutputSection createAnimalsSection(WildLife wildLife) {
        OutputSection animalsOutputSection = null;
        if (wildLife != null) {
            Animals animals = wildLife.getAnimals();
            if (animals != null) {
                animalsOutputSection = new OutputSection(OutputSectionConstants.ANIMALS_SECTION_TITLE);
                List<String> mammalsList = animals.getMammalsList();
                if (mammalsList != null) {
                    animalsOutputSection.setOutputSectionList(Lists.newArrayList(
                            new OutputSection(OutputSectionConstants.MAMMALS_SECTION_TITLE, mammalsList)));
                }
            }
        }
        return animalsOutputSection;
    }

    private OutputSection createGettingThereAndAwaySection(Transport transport) {
        GettingThereAndAway gettingThereAndAway = transport.getGettingThereAndAway();
        OutputSection gettingThereAndAwaySection = null;
        if (gettingThereAndAway != null) {
            gettingThereAndAwaySection =
                    new OutputSection(OutputSectionConstants.GETTING_THERE_AND_AWAY_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(gettingThereAndAway.getOverview()));
            addOutputSectionToList(outputSections, OutputSectionConstants.AIR_SECTION_TITLE,
                    gettingThereAndAway.getAirList());
            addOutputSectionToList(outputSections, OutputSectionConstants.LAND_SECTION_TITLE,
                    gettingThereAndAway.getLandList());
            addOutputSectionToList(outputSections, OutputSectionConstants.BOAT_SECTION_TITLE,
                    gettingThereAndAway.getBoatList());
            gettingThereAndAwaySection.setOutputSectionList(outputSections);
        }
        return gettingThereAndAwaySection;
    }

    private OutputSection createGettingAroundSection(Transport transport) {
        GettingAround gettingAround = transport.getGettingAround();
        OutputSection gettingAroundSection = null;
        if (gettingAround != null) {
            gettingAroundSection = new OutputSection(OutputSectionConstants.GETTING_AROUND_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(gettingAround.getOverview()));
            addOutputSectionToList(outputSections, OutputSectionConstants.AIR_SECTION_TITLE,
                    gettingAround.getAirList());
            addOutputSectionToList(outputSections, OutputSectionConstants.BICYCLE_SECTION_TITLE,
                    gettingAround.getBicycleList());
            addOutputSectionToList(outputSections, OutputSectionConstants.BOAT_SECTION_TITLE,
                    gettingAround.getBoatList());
            addOutputSectionToList(outputSections, OutputSectionConstants.CAR_AND_MOTORCYCLE_SECTION_TITLE,
                    gettingAround.getCarAndMotorcycleList());
            addOutputSectionToList(outputSections, OutputSectionConstants.HITCHING_SECTION_TITLE,
                    gettingAround.getHitchingList());
            addOutputSectionToList(outputSections, OutputSectionConstants.LOCAL_TRANSPORT_SECTION_TITLE,
                    gettingAround.getLocalTransportList());
            addOutputSectionToList(outputSections, OutputSectionConstants.BUS_AND_TRAM_SECTION_TITLE,
                    gettingAround.getBusAndTramList());
            addOutputSectionToList(outputSections, OutputSectionConstants.TRAIN_SECTION_TITLE,
                    gettingAround.getTrainList());
            gettingAroundSection.setOutputSectionList(outputSections);
        }
        return gettingAroundSection;
    }

    private OutputSection createVisasSection(PracticalInformation practicalInformation) {
        Visas visas = practicalInformation.getVisas();
        OutputSection visasSection = null;
        if (visas != null) {
            visasSection = new OutputSection(OutputSectionConstants.VISAS_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(visas.getOverview()));
            addOutputSectionToList(outputSections, OutputSectionConstants.OTHER_SECTION_TITLE,
                    visas.getOtherList());
            addOutputSectionToList(outputSections, OutputSectionConstants.PERMITS_SECTION_TITLE,
                    visas.getPermitsList());
            visasSection.setOutputSectionList(outputSections);
        }
        return visasSection;
    }

    private OutputSection createMoneyAndCostsSection(PracticalInformation practicalInformation) {
        MoneyAndCosts moneyAndCosts = practicalInformation.getMoneyAndCosts();
        OutputSection moneyAndCostsSection = null;
        if (moneyAndCosts != null) {
            moneyAndCostsSection = new OutputSection(OutputSectionConstants.MONEY_AND_COSTS_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(moneyAndCosts.getOverview()));
            addOutputSectionToList(outputSections, OutputSectionConstants.MONEY_SECTION_TITLE,
                    moneyAndCosts.getMoneyList());
            addOutputSectionToList(outputSections, OutputSectionConstants.COSTS_SECTION_TITLE,
                    moneyAndCosts.getCostsList());
            moneyAndCostsSection.setOutputSectionList(outputSections);
        }
        return moneyAndCostsSection;
    }

    private OutputSection createHealthAndSafetySection(PracticalInformation practicalInformation) {
        HealthAndSafety healthAndSafety = practicalInformation.getHealthAndSafety();
        OutputSection healthAndSafetySection = null;
        if (healthAndSafety != null) {
            healthAndSafetySection = new OutputSection(OutputSectionConstants.HEALTH_AND_SAFETY_SECTION_TITLE);
            List<OutputSection> outputSections = new ArrayList<>();
            addOutputSectionToList(outputSections, OutputSectionConstants.OVERVIEW_SECTION_TITLE,
                    getOverviewLines(healthAndSafety.getOverview()));
            addOutputSectionToList(outputSections, OutputSectionConstants.BEFORE_YOU_GO_SECTION_TITLE,
                    healthAndSafety.getBeforeYouGoList());
            addOutputSectionToList(outputSections,
                    OutputSectionConstants.DANGERS_AND_ANNOYANCES_SECTION_TITLE,
                    healthAndSafety.getDangersAndAnnoyancesList());
            addOutputSectionToList(outputSections, OutputSectionConstants.IN_TRANSIT_SECTION_TITLE,
                    healthAndSafety.getInTransitList());
            addOutputSectionToList(outputSections, OutputSectionConstants.WHILE_YOURE_THERE_SECTION_TITLE,
                    healthAndSafety.getWhileYouAreThereList());
            healthAndSafetySection.setOutputSectionList(outputSections);
        }
        return healthAndSafetySection;
    }

    private void addOutputSectionToList(List<OutputSection> outputSections,
                                        String title, List<String> list) {
        if (list != null) {
            outputSections.add(new OutputSection(title,
                    list));
        }
    }

    private void addOutputSectionToList(List<OutputSection> outputSections,
                                        OutputSection outputSection) {
        if (outputSection != null) {
            outputSections.add(outputSection);
        }
    }

    private OutputSection createSectionWithNestedOverview(String title, List<String> lines) {
        OutputSection outputSection = null;
        if (lines != null) {
            OutputSection overviewOutputSection =
                    new OutputSection(OutputSectionConstants.OVERVIEW_SECTION_TITLE, lines);
            outputSection = new OutputSection(title);
            outputSection.setOutputSectionList(Lists.newArrayList(overviewOutputSection));
        }
        return outputSection;
    }

    private List<String> getWhenToGoOverviewLines() {
        List<String> overviewLines = null;
        Weather weather = destination.getWeather();
        if (weather != null) {
            WhenToGo whenToGo = weather.getWhenToGo();
            if (whenToGo != null) {
                overviewLines = getOverviewLines(whenToGo.getOverview());
            }
        }
        return overviewLines;
    }

    private List<String> getIntroductionOverviewLines() {
        List<String> overviewLines = new ArrayList<>();
        Introductory introductory = destination.getIntroductory();
        if (introductory != null) {
            Introduction introduction = introductory.getIntroduction();
            if (introduction != null) {
                overviewLines = getOverviewLines(introduction.getOverview());
            }
        }
        return overviewLines;
    }

    private List<String> getHistoryLines() {
        List<String> historyLines = new ArrayList<>();
        recursivelyGetHistoryLines(historyLines, destination.getHistoryList());
        return historyLines;
    }

    private List<String> getHistoryOverviewLines() {
        List<String> overviewLines = null;
        List<History> historyList = destination.getHistoryList();
        if (historyList != null) {
            overviewLines = new ArrayList<>();
            for (History history : historyList) {
                List<String> lines = getOverviewLines(history.getOverview());
                if (lines != null) {
                    overviewLines.addAll(lines);
                }
            }
        }
        return overviewLines;
    }

    private List<String> getOverviewLines(Overview overview) {
        List<String> overviewLines = null;
        if (overview != null) {
            overviewLines = new ArrayList<>();
            overviewLines.addAll(overview.getTextList());
            recursivelyGetOverviewLines(overviewLines, overview.getOverviewList());
        }
        return overviewLines;
    }

    private void recursivelyGetHistoryLines(List<String> historyLines, List<History> historyList) {
        if (historyList != null) {
            for (History history : historyList) {
                List<String> textList = history.getTextList();
                historyLines.addAll(textList.stream().
                        filter(text -> !StringUtils.isBlank(text)).collect(Collectors.toList()));
                recursivelyGetHistoryLines(historyLines, history.getHistoryList());
            }
        }
    }

    private void recursivelyGetOverviewLines(List<String> overviewLines, List<Overview> overviewList) {
        if (overviewList != null) {
            for (Overview overview : overviewList) {
                List<String> textList = overview.getTextList();
                overviewLines.addAll(textList.stream().
                        filter(text -> !StringUtils.isBlank(text)).collect(Collectors.toList()));
                recursivelyGetOverviewLines(overviewLines, overview.getOverviewList());
            }
        }
    }
}

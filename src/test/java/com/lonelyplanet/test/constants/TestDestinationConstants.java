package com.lonelyplanet.test.constants;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import com.lonelyplanet.test.helpers.TestDestinationHelper;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

public class TestDestinationConstants {

    public static final String HILL_VALLEY_DESTINATION_FILE_NAME_AND_PATH = FilenameUtils
            .separatorsToSystem(
                    "src/test/resources/input/destination/destinationHillValley.xml");

    public static final String INVALID_DESTINATION_FILE_NAME_AND_PATH = FilenameUtils
            .separatorsToSystem(
                    "src/test/resources/input/destination/destinationWithInvalidContent.xml");

    public static final List<String> HISTORY_LINES = Lists.newArrayList(
            "History > History > History > First",
            "History > History > History > Second");
    public static final List<String> INTRODUCTION_OVERVIEW_LINES =
            Lists.newArrayList("Introductory > Introduction > Overview");
    public static final List<String> HISTORY_OVERVIEW_LINES =
            Lists.newArrayList("History > History > Overview");
    public static final List<String> BEFORE_YOU_GO_LINES =
            Lists.newArrayList("Practical Information > Health and Safety > Before You Go");
    public static final List<String> DANGERS_AND_ANNOYANCES_LINES =
            Lists.newArrayList("Practical Information > Health and Safety > Dangers and Annoyances");
    public static final List<String> IN_TRANSIT_LINES =
            Lists.newArrayList("Practical Information > Health and Safety > In Transit");
    public static final List<String> WHILE_YOURE_THERE_LINES =
            Lists.newArrayList("Practical Information > Health and Safety > While You're There");
    public static final List<String> MONEY_LINES =
            Lists.newArrayList("Practical Information > Money and Costs > Money");
    public static final List<String> COSTS_LINES =
            Lists.newArrayList("Practical Information > Money and Costs > Costs");
    public static final List<String> OTHER_LINES =
            Lists.newArrayList("Practical Information > Visas > Other");
    public static final List<String> PERMITS_LINES =
            Lists.newArrayList("Practical Information > Visas > Permits");
    public static final List<String> GETTING_AROUND_AIR_LINES =
            Lists.newArrayList("Transport > Getting Around > Air");
    public static final List<String> BICYCLE_LINES =
            Lists.newArrayList("Transport > Getting Around > Bicycle");
    public static final List<String> GETTING_AROUND_BOAT_LINES =
            Lists.newArrayList("Transport > Getting Around > Boat");
    public static final List<String> BUS_AND_TRAM_LINES =
            Lists.newArrayList("Transport > Getting Around > Bus and Tram");
    public static final List<String> CAR_AND_MOTORCYCLE_LINES =
            Lists.newArrayList("Transport > Getting Around > Car and Motorcycle");
    public static final List<String> HITCHING_LINES =
            Lists.newArrayList("Transport > Getting Around > Hitching");
    public static final List<String> TRAIN_LINES =
            Lists.newArrayList("Transport > Getting Around > Train");
    public static final List<String> LOCAL_TRANSPORT_LINES =
            Lists.newArrayList("Transport > Getting Around > Local Transport");
    public static final List<String> GETTING_THERE_AND_AWAY_BOAT_LINES =
            Lists.newArrayList("Transport > Getting There and Away > Boat");
    public static final List<String> GETTING_THERE_AND_AWAY_AIR_LINES =
            Lists.newArrayList("Transport > Getting There and Away > Air");
    public static final List<String> LAND_LINES =
            Lists.newArrayList("Transport > Getting There and Away > Land");
    public static final List<String> WHEN_TO_GO_OVERVIEW_LINES =
            Lists.newArrayList("Weather > When To Go > Overview");
    public static final List<String> CLIMATE_LINES =
            Lists.newArrayList("Weather > When To Go > Climate");
    public static final List<String> WILD_LIFE_OVERVIEW_OVERVIEW_LINES =
            Lists.newArrayList("Wild Life > Overview > Overview");
    public static final List<String> MAMMALS_LINES =
            Lists.newArrayList("Wild Life > Animals > Mammals");
    public static final List<String> BIRDS_OVERVIEW_LINES =
            Lists.newArrayList("Wild Life > Birds > Overview");
    public static final List<String> ENDANGERED_SPECIES_OVERVIEW_LINES =
            Lists.newArrayList("Wild Life > Endangered Species > Overview");
    public static final List<String> PLANTS_OVERVIEW_LINES =
            Lists.newArrayList("Wild Life > Plants > Overview");
    public static final List<String> BUSINESS_LINES =
            Lists.newArrayList("Work Live Study > Work > Business");
    public static final List<String> WORK_OVERVIEW_LINES =
            Lists.newArrayList("Work Live Study > Work > Overview");
    public static final List<String> VISA_OVERVIEW_LINES =
            Lists.newArrayList("Practical Information > Visas > Overview");

    public static final Destination HILL_VALLEY_DESTINATION = TestDestinationHelper.createTestDestinations();

    private TestDestinationConstants() {
    }
}

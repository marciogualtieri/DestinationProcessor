package com.lonelyplanet.test.constants;

import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import com.lonelyplanet.destination.processor.output.OutputSection;
import com.lonelyplanet.test.helpers.TestOutputHelper;

import java.nio.file.Paths;

public class TestOutputConstants {

    public static final String HILL_VALLEY_RESOURCE = "hill-valley-3.html";
    public static final String SIERRA_NEVADA_MOUNTAINS_RESOURCE = "sierra-nevada-mountains-2.html";
    public static final String CALIFORNIA_RESOURCE = "california-1.html";

    public static final String HILL_VALLEY_OUTPUT_FILE_NAME_AND_PATH =
            Paths.get(TestCommonConstants.SUCCESS_OUTPUT_BASE_DIRECTORY, HILL_VALLEY_RESOURCE).toString();

    public static final OutputSection INTRODUCTION_OUTPUT_SECTION =
            TestOutputHelper.createTestIntroductionOutputSection();
    public static final OutputSection HISTORY_OUTPUT_SECTION =
            TestOutputHelper.createTestHistoryOutputSection();
    public static final OutputSection PRACTICAL_OUTPUT_SECTION =
            TestOutputHelper.createTestPracticalInformationOutputSection();
    public static final OutputSection TRANSPORT_OUTPUT_SECTION =
            TestOutputHelper.createTestTransportOutputSection();
    public static final OutputSection WEATHER_OUTPUT_SECTION =
            TestOutputHelper.createTestWeatherOutputSection();
    public static final OutputSection WILD_LIFE_OUTPUT_SECTION =
            TestOutputHelper.createTestWildLifeOutputSection();
    public static final OutputSection WORK_LIVE_STUDY_OUTPUT_SECTION =
            TestOutputHelper.createTestWorkLiveStudyOutputSection();

    public static final OutputNavigationNode NAVIGATION_TREE = TestOutputHelper.createTestNavigationTree();

    private TestOutputConstants() {
    }
}

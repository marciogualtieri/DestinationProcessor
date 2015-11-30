package com.lonelyplanet.destination.processor.output.wrappers;

import com.lonelyplanet.destination.processor.output.OutputSection;
import com.lonelyplanet.test.constants.TestDestinationConstants;
import com.lonelyplanet.test.constants.TestOutputConstants;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DestinationHtmlOutputTest {

    private DestinationHtmlOutput testDestinationHtmlOutput;

    @Before
    public void before() throws Exception {
        testDestinationHtmlOutput =
                new DestinationHtmlOutput(TestDestinationConstants.HILL_VALLEY_DESTINATION,
                        TestOutputConstants.NAVIGATION_TREE);
    }

    @Test
    public void whenGetIntroductionOutputSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getIntroductionOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.INTRODUCTION_OUTPUT_SECTION));
    }

    @Test
    public void whenGetHistoryOutputSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getHistoryOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.HISTORY_OUTPUT_SECTION));
    }

    @Test
    public void whenGetPraticalInformationOutputSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getPracticalInformationOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.PRACTICAL_OUTPUT_SECTION));
    }

    @Test
    public void whenGetTransportOutputSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getTransportOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.TRANSPORT_OUTPUT_SECTION));
    }

    @Test
    public void whenGetTransportWeatherSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getWeatherOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.WEATHER_OUTPUT_SECTION));
    }

    @Test
    public void whenGetWildLifeSection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getWildLifeOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.WILD_LIFE_OUTPUT_SECTION));
    }

    @Test
    public void whenGetWorkLifeStudySection_thenOk() throws Exception {
        OutputSection outputSection = testDestinationHtmlOutput.getWorkLiveStudyOutputSection();
        assertThat(outputSection, equalTo(TestOutputConstants.WORK_LIVE_STUDY_OUTPUT_SECTION));
    }

} 

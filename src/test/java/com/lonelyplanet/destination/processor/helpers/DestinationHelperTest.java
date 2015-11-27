package com.lonelyplanet.destination.processor.helpers;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.DestinationUnmarshalException;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import com.lonelyplanet.destination.processor.jaxb.model.destination.*;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.HealthAndSafety;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.MoneyAndCosts;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.Visas;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingAround;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingThereAndAway;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Animals;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Birds;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.EndangeredSpecies;
import com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife.Plants;
import com.lonelyplanet.test.constants.TestDestinationConstants;
import com.lonelyplanet.test.messages.TestMessages;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.then;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH)
public class DestinationHelperTest {

    @Autowired
    private DestinationHelper testDestinationHelper;

    private Destination testDestination;
    private PracticalInformation testPracticalInformation;
    private Transport testTransport;
    private WildLife testWildLife;

    @Before
    public void beforeTest() throws Exception {
        XMLStreamReader destinationXmlStreamReader =
                createXmlStreamReaderForFile(TestDestinationConstants.HILL_VALLEY_DESTINATION_FILE_NAME_AND_PATH);
        testDestination = testDestinationHelper.unmarshalDestination(destinationXmlStreamReader);
        getNestedEntitiesFromDestination();
    }

    @Test
    public void whenUnmarshalDestination_thenIntroductoryOk() throws Exception {
        Introductory introductory = testDestination.getIntroductory();
        Introductory expectedIntroductory = TestDestinationConstants.HILL_VALLEY_DESTINATION.getIntroductory();
        assertThat(introductory, equalTo(expectedIntroductory));
    }

    @Test
    public void whenUnmarshalDestination_thenHistoryOk() throws Exception {
        List<History> historyList = testDestination.getHistoryList();
        List<History> expectedHistoryList = TestDestinationConstants.HILL_VALLEY_DESTINATION.getHistoryList();
        assertThat(historyList, containsInAnyOrder(expectedHistoryList.toArray()));
    }

    @Test
    public void whenUnmarshalDestination_thenHealthyAndSafetyOk() throws Exception {
        assertThat(testPracticalInformation, is(not(nullValue())));
        HealthAndSafety healthAndSafety = testPracticalInformation.getHealthAndSafety();
        HealthAndSafety expectedHealthAndSafety =
                TestDestinationConstants.HILL_VALLEY_DESTINATION.getPracticalInformation().getHealthAndSafety();
        assertThat(healthAndSafety, equalTo(expectedHealthAndSafety));
    }

    @Test
    public void whenUnmarshalDestination_thenMoneyAndCostsOk() throws Exception {
        MoneyAndCosts moneyAndCosts = testPracticalInformation.getMoneyAndCosts();
        MoneyAndCosts expectedMoneyAndCosts =
                TestDestinationConstants.HILL_VALLEY_DESTINATION.getPracticalInformation().getMoneyAndCosts();
        assertThat(moneyAndCosts, equalTo(expectedMoneyAndCosts));
    }

    @Test
    public void whenUnmarshalDestination_thenVisasOk() throws Exception {
        Visas visas = testPracticalInformation.getVisas();
        Visas expectedVisas =
                TestDestinationConstants.HILL_VALLEY_DESTINATION.getPracticalInformation().getVisas();
        assertThat(visas, equalTo(expectedVisas));
    }

    @Test
    public void whenUnmarshalDestination_thenGettingAroundOk() throws Exception {
        GettingAround gettingAround = testTransport.getGettingAround();
        GettingAround expectedGettingAround =
                TestDestinationConstants.HILL_VALLEY_DESTINATION.getTransport().getGettingAround();
        assertThat(gettingAround, equalTo(expectedGettingAround));
    }

    @Test
    public void whenUnmarshalDestination_thenGettingThereAndAwayOk() throws Exception {
        GettingThereAndAway gettingThereAndAway = testTransport.getGettingThereAndAway();
        GettingThereAndAway expectedGettingThereAndAway =
                TestDestinationConstants.HILL_VALLEY_DESTINATION.getTransport().getGettingThereAndAway();
        assertThat(gettingThereAndAway, equalTo(expectedGettingThereAndAway));
    }

    @Test
    public void whenUnmarshalDestination_thenWeatherOk() throws Exception {
        Weather weather = testDestination.getWeather();
        assertThat(weather, equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWeather()));
    }

    @Test
    public void whenUnmarshalDestination_thenWildLifeAnimalsOk() throws Exception {
        Animals animals = testWildLife.getAnimals();
        assertThat(animals, equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWildLife().getAnimals()));
    }

    @Test
    public void whenUnmarshalDestination_thenWildLifeBirdsOk() throws Exception {
        Birds birds = testWildLife.getBirds();
        assertThat(birds, equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWildLife().getBirds()));
    }

    @Test
    public void whenUnmarshalDestination_thenWildLifeEndangeredSpeciesOk() throws Exception {
        EndangeredSpecies endangeredSpecies = testWildLife.getEndangeredSpecies();
        assertThat(endangeredSpecies,
                equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWildLife().getEndangeredSpecies()));
    }

    @Test
    public void whenUnmarshalDestination_thenWildLifePlantsOk() throws Exception {
        Plants plants = testWildLife.getPlants();
        assertThat(plants,
                equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWildLife().getPlants()));
    }

    @Test
    public void whenUnmarshalDestination_thenWildLifeOverviewOk() throws Exception {
        Overview overview = testWildLife.getOverview();
        assertThat(overview,
                equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWildLife().getOverview()));
    }

    @Test
    public void whenUnmarshalDestination_thenWorkLiveStudyOk() throws Exception {
        WorkLiveStudy workLiveStudy = testDestination.getWorkLiveStudy();
        assertThat(workLiveStudy, equalTo(TestDestinationConstants.HILL_VALLEY_DESTINATION.getWorkLiveStudy()));
    }

    @Test
    public void whenUnmarshalDestinationAndInvalidContent_thenException() throws Exception {
        XMLStreamReader destinationXmlStreamReader =
                createXmlStreamReaderForFile(TestDestinationConstants.INVALID_DESTINATION_FILE_NAME_AND_PATH);
        when(testDestinationHelper).unmarshalDestination(destinationXmlStreamReader);
        then(caughtException())
                .isInstanceOf(DestinationUnmarshalException.class)
                .hasMessageContaining(
                        TestMessages.DESTINATION_UNMARSHAL_EXCEPTION_MESSAGE)
                .hasMessageContaining(TestMessages.DESTINATION_SAX_PARSING_EXCEPTION_MESSAGE);
    }

    private XMLStreamReader createXmlStreamReaderForFile(String fileNameAndPath)
            throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        return xmlInputFactory.createXMLStreamReader(
                new FileReader(fileNameAndPath));
    }

    private void getNestedEntitiesFromDestination() {
        getPraticalInformationFromDestination();
        getTransportFromDestination();
        getWildLifeFromDestination();
    }

    private void getPraticalInformationFromDestination() {
        testPracticalInformation = testDestination.getPracticalInformation();
        assertThat(testPracticalInformation, is(not(nullValue())));
    }

    private void getTransportFromDestination() {
        testTransport = testDestination.getTransport();
        assertThat(testTransport, is(not(nullValue())));
    }

    private void getWildLifeFromDestination() {
        testWildLife = testDestination.getWildLife();
        assertThat(testWildLife, is(not(nullValue())));
    }
} 

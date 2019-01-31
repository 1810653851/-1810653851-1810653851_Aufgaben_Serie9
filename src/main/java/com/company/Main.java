package com.company;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, JAXBException {


        ObjectMapper mapper = new ObjectMapper();

        String text= "{\"coord\":{\"lon\":139,\"lat\":35},\n" +
                "\"sys\":{\"country\":\"JP\",\"sunrise\":1369769524,\"sunset\":1369821049},\n" +
                "\"weather\":[{\"id\":804,\"main\":\"clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\n" +
                "\"main\":{\"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04},\n" +
                "\"wind\":{\"speed\":7.31,\"deg\":187.002},\n" +
                "\"rain\":{\"3h\":0},\n" +
                "\"clouds\":{\"all\":92},\n" +
                "\"dt\":1369824698,\n" +
                "\"id\":1851632,\n" +
                "\"name\":\"Shuzenji\",\n" +
                "\"cod\":200}";


        Weather result = mapper.readValue(text, Weather.class);


        System.out.println("Name: " + result.getName() + " Id: " + result.getName());

        // Ubung 2
        WriteXmlFile(result);

        // Ubung 3
        Weather readWeather = ReadXmlFile();

        String jsonInString = mapper.writeValueAsString(readWeather);
        System.out.println(jsonInString);
    }

    private static void WriteXmlFile(Weather result) throws IOException, JAXBException {
        File file = new File("file.xml");
        file.createNewFile();
        JAXBContext jc = JAXBContext.newInstance(Weather.class);
        Marshaller jaxbMarshaller = jc.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(result, file);
    }

    private static Weather ReadXmlFile() throws JAXBException {

        File file = new File("file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Weather weather = (Weather) jaxbUnmarshaller.unmarshal(file);
        return weather;
    }
}

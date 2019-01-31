package com.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String name;
    private int id;
    private int cod;
    private String secretField;
    private String jsonRenamedField;
    private Cloud clouds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @XmlTransient // Ubung 4
    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore // Ubung 5
    public String getSecretField() {
        return secretField;
    }

    public void setSecretField(String secretField) {
        this.secretField = secretField;
    }

    @JsonProperty("CustomPropertyName") // Ubung 5
    public String getJsonRenamedField() {
        return jsonRenamedField;
    }

    public void setJsonRenamedField(String jsonRenamedField) {
        this.jsonRenamedField = jsonRenamedField;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud cloud) {
        this.clouds = cloud;
    }
}

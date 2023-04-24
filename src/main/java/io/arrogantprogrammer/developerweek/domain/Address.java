package io.arrogantprogrammer.developerweek.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends PanacheEntity {

    String streetAddress;

    String streetAdress2;

    String city;

    String stateOrProvince;

    String postCode;

    String countryCode;

    public Address() {
    }

}
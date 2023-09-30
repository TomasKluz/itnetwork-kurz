package cz.insuranceApp.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ClientDTO {
    private long clientId;
    @NotNull(message = "vplňte jméno")
    @NotBlank(message = "vypňte jméno")
    private String firstName;

    @NotNull(message = "vplňte příjmení")
    @NotBlank(message = "vypňte příjmení")
    private String surname;

    private LocalDate birthDate;
    @NotNull(message = "vplňte telefonní číslo")
    @NotBlank(message = "vypňte telefonní číslo")
    private String phoneNumber;
    @NotNull(message = "vplňte email")
    @NotBlank(message = "vypňte email")
    private String email;
    @NotNull(message = "vplňte ulici a č.p.")
    @NotBlank(message = "vypňte ulici a č.p.")
    private String street;
    @NotNull(message = "vplňte město")
    @NotBlank(message = "vypňte město")
    private String city;
    @NotNull(message = "vplňte psč")
    @NotBlank(message = "vypňte psč")
    private String zipCode;


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

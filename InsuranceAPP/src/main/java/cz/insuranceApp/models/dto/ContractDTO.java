package cz.insuranceApp.models.dto;

import cz.insuranceApp.data.entities.ClientEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.time.LocalDate;

public class ContractDTO {
    private Long contractId;
    private ClientEntity client;

    private String insuranceName;
    @NotNull(message = "vyplňte počíteční platnosti smlouvy.")
    private LocalDate dateFrom;
    @NotNull(message = "Vyplňte datum konce platnosti smlouvy.")
    private LocalDate dateTo;
    @NotNull(message = "Zadejte hodnotu pojištění.")
    private Long amount;
    @NotNull(message = "Zadejte předmět pojištění.")
    @NotBlank(message = "Zadejte předmět pojištění.")
    private String article;
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}

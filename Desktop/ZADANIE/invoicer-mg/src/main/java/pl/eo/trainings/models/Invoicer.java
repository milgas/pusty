package pl.eo.trainings.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
public class Invoicer {

    @NotNull
    @Size(min=1, max=25)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private InvoicerType type;

    private int invoicerId;
    private static int nextId = 1;

    public Invoicer(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Invoicer() {
        invoicerId = nextId;
        nextId++;
    }

    public int getInvoicerId() {
        return invoicerId;
    }

    public void setInvoicerId(int invoicerId) {
        this.invoicerId = invoicerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InvoicerType getType() {
        return type;
    }

    public void setType(InvoicerType type) {
        this.type = type;
    }
}

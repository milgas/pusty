package pl.eo.trainings.models;

/**
 * TODO poprawić wyświetlanie w formularzu ADD, model.addAttribute("cheeseTypes", CheeseType.values()); w pobieraniu formularza w IndexController.html
 */
public enum InvoicerType {

    VAT ("VAT"),
    NATURAL ("Natural Person"),
    RECEIPT ("Receipt");

    private final String name;

    InvoicerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

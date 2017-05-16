package pl.eo.trainings.models;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class InvoicerData {

    static ArrayList<Invoicer> invoice = new ArrayList<>();

    // getAll
    public static ArrayList<Invoicer> getAll() {
        return invoice;
    }

    // add
    public static void add(Invoicer newInvoicer) {
        invoice.add(newInvoicer);
    }

    // remove
    public static void remove(int id) {
        Invoicer invoicerToRemove = getById(id);
        invoice.remove(invoicerToRemove);
    }

    // getById
    public static Invoicer getById(int id) {

        Invoicer theInvoicer = null;

        for (Invoicer candidateInvoicer : invoice) {
            if (candidateInvoicer.getInvoicerId() == id) {
                theInvoicer = candidateInvoicer;
            }
        }

        return theInvoicer;
    }

}

package com.statravel.autoqa.paymentformsui.domain.entity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.statravel.autoqa.paymentformsui.commons.AutomationConstant;
import com.statravel.autoqa.paymentformsui.commons.Utilities;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class PaymentFormsBuilder {

    @Autowired
    private Utilities utilities;

    public static final Double FLIGHT_AMOUNT = 1000.00;
    public static final Double OTHERS_AMOUNT = 2000.00;
    public static final Double TRANSFER_AMOUNT = 2000.00;
    public static final Double DEPOSIT_AMOUNT = 200.00;
    public static final Double ACCOMMODATION_AMOUNT = 55.00;
    public static final String IMPORTANT_INSTRUCTIONS = "This is important inscruction.";
    public static final String FORM_NAME = "Test name";
    public static final String FORM_PARTNER_NAME = "Test-partner";
    public static final String FORM_TRIP_NAME = "Test trip";
    public static final String FORM_HEADING = "Test heading";
    public static final String FORM_INTRO = "Intro";
    public static final Double BALANCE_FOR_FLIGHT_ONLY = FLIGHT_AMOUNT - DEPOSIT_AMOUNT;

    /**
     * 
     * @param costType
     *            type
     * @return payment form with required fields and given type cost.
     */
    public PaymentForm buildPaymentForm(final String costType) {

        PaymentForm paymentForm = new PaymentForm();
        Cost cost = new Cost();
        paymentForm.setName(FORM_NAME + utilities.getRandomIntOverOneThousand());
        paymentForm.setPosId(1L);
        paymentForm.setPartnerName(FORM_PARTNER_NAME + utilities.getRandomIntOverOneThousand());
        paymentForm.setTripName(FORM_TRIP_NAME + utilities.getRandomIntOverOneThousand());
        paymentForm.setQuoteActive(false);
        paymentForm.setTravelHeading(FORM_HEADING);
        paymentForm.setTravelIntro(FORM_INTRO);
        paymentForm.setUniqueId(UUID.randomUUID()
                                    .toString());
        paymentForm.setUrlFriendlyPartnerName(paymentForm.getPartnerName());
        paymentForm.setActive(true);

        if (costType.equalsIgnoreCase(AutomationConstant.FLIGHT) || costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_DEPOSIT)
                || costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_DEPOSIT_AND_BALANCE_ONLY)) {

            if (costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_DEPOSIT)
                    || costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_DEPOSIT_AND_BALANCE_ONLY)) {
                cost.setDepositActive(true);
                cost.setDepositAmount(DEPOSIT_AMOUNT);
            }

            if (costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_DEPOSIT_AND_BALANCE_ONLY)) {
                cost.setBalanceActive(true);
                cost.setBalanceAmount(BALANCE_FOR_FLIGHT_ONLY);

                paymentForm.setTermsAndCondition(new TermsAndCondition());
            }

            cost.setFlightActive(true);
            cost.setFlightAmount(FLIGHT_AMOUNT);

        } else if (costType.equalsIgnoreCase(AutomationConstant.OTHERS)) {

            cost.setOtherActive(true);
            cost.setOtherAmount(OTHERS_AMOUNT);

        } else if (costType.equalsIgnoreCase(AutomationConstant.TRANSFER)) {

            cost.setTransferActive(true);
            cost.setTransferAmount(TRANSFER_AMOUNT);

        } else if (costType.equalsIgnoreCase(AutomationConstant.FLIGHT_WITH_QUOTE)) {

            paymentForm.setQuoteActive(true);

            cost.setFlightActive(true);
            cost.setFlightAmount(FLIGHT_AMOUNT);

        } else if (costType.equalsIgnoreCase(AutomationConstant.ACCOMMODATION_COST_WITH_QUOTE)) {

            paymentForm.setQuoteActive(true);

            cost.setAccommodationActive(true);
            cost.setAccommodationAmount(ACCOMMODATION_AMOUNT);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (costType.equalsIgnoreCase(AutomationConstant.ONLY_FLIGHT_COST)) {

            cost.setFlightActive(true);
            cost.setFlightAmount(FLIGHT_AMOUNT);

            paymentForm.setTermsAndCondition(new TermsAndCondition());
        } else if (costType.equalsIgnoreCase(AutomationConstant.FLIGHT_AND_TRASFER)) {

            cost.setFlightActive(true);
            cost.setFlightAmount(FLIGHT_AMOUNT);

            cost.setTransferActive(true);
            cost.setTransferAmount(TRANSFER_AMOUNT);
        }

        paymentForm.setCost(cost);

        return paymentForm;

    }

    /**
     * 
     * @param costType
     *            type
     * @param product
     *            product
     * @param list
     *            list
     * @return payment form with given type and product.
     * @throws ParseException
     *             ParseException
     *
     */
    public PaymentForm buildPaymentForm(final String costType, final String product, final List<?> list) throws ParseException {

        PaymentForm paymentForm = this.buildPaymentForm(costType);

        if (product.equalsIgnoreCase(AutomationConstant.MISC_PRODUCT)) {

            List<Misc> miscList = new ArrayList<>();

            for (Object object : list) {

                miscList.add((Misc) object);
            }

            paymentForm.setMiscActive(true);
            paymentForm.setMiscProductName(AutomationConstant.MISC_NAME);

            paymentForm.setMisc(miscList);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.OTHERS)) {

            List<Others> othersList = new ArrayList<>();

            for (Object object : list) {

                othersList.add((Others) object);
            }

            paymentForm.setOthersActive(true);
            paymentForm.setOthers(othersList);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product == AutomationConstant.GETTING_THERE || product == AutomationConstant.GETTING_AROUND
                || product == AutomationConstant.GETTING_BACK) {

            List<Flight> flightList = new ArrayList<>();

            for (Object object : list) {

                flightList.add((Flight) object);
            }

            paymentForm.setFlightDetailsActive(true);

            if (product.equalsIgnoreCase(AutomationConstant.GETTING_THERE)) {

                paymentForm.setFlightGettingThereActive(true);

            } else if (product.equalsIgnoreCase(AutomationConstant.GETTING_AROUND)) {

                paymentForm.setFlightGettingAroundActive(true);

            } else if (product.equalsIgnoreCase(AutomationConstant.GETTING_BACK)) {

                paymentForm.setFlightGettingBackActive(true);

            }

            paymentForm.setFlightList(flightList);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.TRANSFER)) {

            List<Transfer> transferList = new ArrayList<>();

            for (Object object : list) {

                transferList.add((Transfer) object);
            }

            paymentForm.setTransferActive(true);
            paymentForm.setTransferList(transferList);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.FLIGHTS_AND_TC)) {

            List<Flight> flightList = new ArrayList<>();

            for (Object object : list) {

                flightList.add((Flight) object);
            }

            paymentForm.setFlightList(flightList);
            paymentForm.setFlightDetailsActive(true);
            paymentForm.setFlightGettingAroundActive(true);
            paymentForm.setFlightGettingBackActive(true);
            paymentForm.setFlightGettingThereActive(true);

            paymentForm.setImportantInstructionsActive(true);
            paymentForm.setImportantInstructions(IMPORTANT_INSTRUCTIONS);

            TermsAndCondition termsAndCondition = new TermsAndCondition();
            termsAndCondition.setFinalDepositActive(true);
            termsAndCondition.setFinalDepositDate(utilities.getCurrentDate());
            termsAndCondition.setFinalPaymentActive(true);
            termsAndCondition.setFinalPaymentDueDate(utilities.getCurrentDate());

            paymentForm.setTermsAndCondition(termsAndCondition);

        } else if (product.equalsIgnoreCase(AutomationConstant.EXTRA_AND_STOPOVER)) {

            List<Extra> extraList = new ArrayList<>();
            List<Stopover> stopOverList = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Extra) {
                    extraList.add((Extra) list.get(i));

                } else if (list.get(i) instanceof Stopover) {
                    stopOverList.add((Stopover) list.get(i));
                }
            }

            paymentForm.setExtrasActive(true);
            paymentForm.setExtra(extraList);

            paymentForm.setStopoversActive(true);
            paymentForm.setStopover(stopOverList);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.PASSENGER_INFO) || product.equalsIgnoreCase(AutomationConstant.ADDRESS_INFO)) {

            List<HtmlField> fieldList = new ArrayList<>();

            for (Object object : list) {

                fieldList.add((HtmlField) object);
            }

            paymentForm.setHtmlFieldList(fieldList);
            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.ACCOMMODATION)) {

            List<Accommodation> accommodationList = new ArrayList<>();

            for (Object object : list) {

                accommodationList.add((Accommodation) object);
            }

            paymentForm.setAccommodationList(accommodationList);
            paymentForm.setAccommodationActive(true);
            paymentForm.setTermsAndCondition(new TermsAndCondition());
        }

        return paymentForm;

    }

    /**
     * 
     * @param costType
     *            costType
     * @param product
     *            product
     * @return payment form with given cost type and product.
     * @throws ParseException
     *             ParseException
     */
    public PaymentForm buildPaymentForm(final String costType, final String product) throws ParseException {

        PaymentForm paymentForm = this.buildPaymentForm(costType);

        if (product.equalsIgnoreCase("impoInstruction")) {

            paymentForm.setImportantInstructionsActive(true);
            paymentForm.setImportantInstructions(IMPORTANT_INSTRUCTIONS);

            paymentForm.setTermsAndCondition(new TermsAndCondition());

        } else if (product.equalsIgnoreCase(AutomationConstant.FINAL_DEPOSIT_AND_FINAL_PAYMENT)
                || product.equalsIgnoreCase(AutomationConstant.FINAL_DEPOSIT) || product.equalsIgnoreCase(AutomationConstant.FINAL_PAYMENT)) {

            TermsAndCondition termsAndCondition = new TermsAndCondition();

            if (product.equalsIgnoreCase(AutomationConstant.FINAL_DEPOSIT_AND_FINAL_PAYMENT)
                    || product.equalsIgnoreCase(AutomationConstant.FINAL_DEPOSIT)) {
                termsAndCondition.setFinalDepositActive(true);
                termsAndCondition.setFinalDepositDate(utilities.getCurrentDate());
                termsAndCondition.setFinalDepositDescription(AutomationConstant.FINAL_DEPOSIT_DATE_DESCRIPTION);
            }
            if (product.equalsIgnoreCase(AutomationConstant.FINAL_DEPOSIT_AND_FINAL_PAYMENT)
                    || product.equalsIgnoreCase(AutomationConstant.FINAL_PAYMENT)) {
                termsAndCondition.setFinalPaymentActive(true);
                termsAndCondition.setFinalPaymentDueDate(utilities.getCurrentDate());
                termsAndCondition.setFinalPaymentDescription(AutomationConstant.FINAL_PAYMENT_DATE_DESCRIPTION);
            }
            paymentForm.setTermsAndCondition(termsAndCondition);

        }

        return paymentForm;
    }

}

package com.statravel.autoqa.page.b2b.paymentform;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.Utilities;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.b2b.paymentform.Address;
import com.statravel.autoqa.domain.b2b.paymentform.Cost;
import com.statravel.autoqa.domain.b2b.paymentform.Meal;
import com.statravel.autoqa.domain.b2b.paymentform.PassengerInformation;
import com.statravel.autoqa.domain.b2b.paymentform.PaymentForm;
import com.statravel.autoqa.domain.b2b.paymentform.Seat;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class PaymentFormPage extends Page<PaymentFormPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private Utilities utilities;

    private PaymentForm paymentForm;

    private PaymentFormPageElements paymentFormPageElements;

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#isPageLoaded()
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentFormPageElements.getFormName());

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#init()
     */
    @Override
    public void init() {

        paymentFormPageElements = new PaymentFormPageElements();

        super.initialiseElements(paymentFormPageElements);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.statravel.autoqa.page.Page#getPageElements()
     */
    @Override
    public PaymentFormPageElements getPageElements() {

        return paymentFormPageElements;
    }

    /**
     * Toggle Flight section active.
     */
    public void toggleFlightSection() {

        webDriverCommons.click(paymentFormPageElements.getFlightsActiveBarInactiveMode());

    }

    /**
     * Clicks on edit button on Flights Getting There.
     */
    public void editGettingThereFlightDetails() {

        webDriverCommons.click(paymentFormPageElements.getGettingThereEditButton());

    }

    /**
     * Clicks on edit button on Flights Around There.
     */
    public void editGettingAroundFlightDetails() {

        webDriverCommons.click(paymentFormPageElements.getGettingAroundEditButton());

    }

    /**
     * Clicks on edit button on Flights Around There.
     */
    public void editGettingBackFlightDetails() {

        webDriverCommons.click(paymentFormPageElements.getGettingBackEditButton());

    }

    /**
     * Adds New Transfer.
     */
    public void addNewTransfer() {

        webDriverCommons.click(paymentFormPageElements.getTransferAddNewButton());

    }

    /**
     * Creates new Payment Form.
     */
    public void createPaymentForm() {

        webDriverCommons.click(paymentFormPageElements.getCreateFormButton());

    }

    /**
     * click on Accommodation add new.
     */
    public void selectAddNewAccommodation() {

        webDriverCommons.click(paymentFormPageElements.getAccommodationAddNewButton());

    }

    /**
     * click on Accommodation active bar inactive mode.
     */

    public void toggleAccommodationActiveBarInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getAccommodationActiveBarInactiveMode());

    }

    /**
     * click on First Accommodation active bar active mode.
     */
    public void selectFirstAccommodationActiveBarActiveMode() {

        webDriverCommons.click(paymentFormPageElements.getFirstAccommodationActiveBarActiveMode());
    }

    /**
     * click on First Accommodation edit button.
     */
    public void selectFirstAccommodationEditButton() {

        webDriverCommons.click(paymentFormPageElements.getFirstAccommodationEditButton());

    }

    /**
     * click on Others Add New.
     */
    public void selectAdddNewOthers() {

        webDriverCommons.click(paymentFormPageElements.getOthersAddNewButton());

    }

    /**
     * click on Others Active Bar inactive Mode.
     */
    public void toggleOthersSectionActiveBarInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getOthersActiveButtonInactiveMode());

    }

    /**
     * click on Transfer active Bar.
     */
    public void toggleTransferSection() {

        webDriverCommons.click(paymentFormPageElements.getTransferActiveBarInactiveMode());

    }

    /**
     * click on First Transfer active Bar inactive Mode.
     */
    public void toggleFirstTransferActiveBarInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getFirstTransferActiveBarInactiveMode());

    }

    /**
     * click on First Transfer active Bar Active Mode.
     */
    public void toggleFirstTransferActiveBarActiveMode() {

        webDriverCommons.click(paymentFormPageElements.getFirstTransferActiveBarActiveMode());

    }

    /**
     * click on Cancellation Fees Active Bar inactive mode.
     */
    public void toggleCancelltionFeesSectionActiveBarInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getCancellationFeesActiveBarInactiveMode());
    }

    /**
     * click on cancellation Fees Add New.
     */
    public void selectAddNewCancellationFees() {

        webDriverCommons.click(paymentFormPageElements.getCancellationFeesAddNewbutton());

    }

    /**
     * Fill legalCopy details.
     */
    public void fillDetailsForLegalCopy() {

        webDriverCommons.sendKeys(paymentFormPageElements.getLegalCopyInput(), "This is a legal copy");

    }

    /**
     * Click on Extras active Bar.
     */
    public void toggleExtrasSection() {

        webDriverCommons.click(paymentFormPageElements.getExtrasActiveBar());

    }

    /**
     * Click on add new for extras.
     */
    public void seclectAddNewExtras() {

        webDriverCommons.click(paymentFormPageElements.getExtrasAddNewButton());

    }

    /**
     * Click on Misc Product Active Bar.
     */
    public void toggleMiscProduct() {

        webDriverCommons.click(paymentFormPageElements.getMiscProductActiveBar());

    }

    /**
     * Click on add new for Misc Product.
     */
    public void selectAddNewMiscProduct() {

        webDriverCommons.click(paymentFormPageElements.getMiscProductAddNewButton());

    }

    /**
     * 
     * @param name
     *            name
     * 
     */
    public void fillMiscProductName(final String name) {

        webDriverCommons.sendKeys(paymentFormPageElements.getMiscProductTitleNameInput(), name);
    }

    /**
     * 
     */
    public void toggleStopOver() {

        webDriverCommons.click(paymentFormPageElements.getStopOverActiveBar());

    }

    /**
     * 
     */
    public void selectAddNewStopOver() {

        webDriverCommons.click(paymentFormPageElements.getStopOverAddNewButton());

    }

    /**
     * 
     * @param paymentForm
     *            paymentForm
     */
    public void fillDetailsForPaymentForm(final PaymentForm paymentForm) {

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getFormNameInput(), paymentForm.getFormName());

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getPartnerNameInput(), paymentForm.getPartnerName());

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getPartnerLogoInput(), paymentForm.getPartnerLogo());

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getTripNameInput(), paymentForm.getTripName());

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getTravelHeadingInput(), paymentForm.getTravelHeading());

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getTravelIntroTextInput(), paymentForm.getTravelIntro());
        if (paymentForm.isFinalDepositDateActive()) {

            webDriverCommons.click(paymentFormPageElements.getFinalDepositDateCalendarEnableMode());

            webDriverCommons.click(paymentFormPageElements.getFinalDepositDateCalendarDayButton());

            webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getFinalDepositDateDiscriptionEnableMode(),
                    paymentForm.getFinalDepositDescription());
        }

        if (paymentForm.isFinalPaymentDateActive()) {

            webDriverCommons.click(paymentFormPageElements.getFinalPaymentDueDateCalendarEnableMode());

            webDriverCommons.click(paymentFormPageElements.getFinalPaymentDueDateCalendarDayButton());

            webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getFinalPaymentDueDateDiscriptionEnableMode(),
                    paymentForm.getFinalPaymentDescription());

        }

        webDriverCommons.sendKeysWithOutClear(paymentFormPageElements.getImportantInstructionInput(),
                paymentForm.getImportantInstructionDescription());
    }

    /**
     * 
     * @return current date
     */
    public String getCurrentDate() {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        return date1;

    }

    /**
     * Click on Important Instruction Active bar ActiveMode.
     */
    public void toggleImportantInstructionActiveBarActiveMode() {

        webDriverCommons.click(paymentFormPageElements.getImportantInstructionActiveBarInactiveMode());

    }

    /**
     * Click on Important Instruction Active bar InactiveMode.
     */
    public void toggleImportantInstructionActiveBarInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getImportantInstructionActiveBarInactiveMode());
    }

    /**
     * Click on Final Deposit active bar inactive mode.
     */
    public void toggleFinalDepositDateInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getFinalDepositDateActiveBarInactiveMode());

    }

    /**
     * Click on Final Payment Due Date active bar inactive mode.
     */
    public void toggleFinalPaymentDueDateInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getFinalPaymentDueDateActiveBarInactiveMode());

    }

    /**
     * Click on Today button on calendar.
     */
    public void selectTodayFromCalendar() {

        webDriverCommons.click(paymentFormPageElements.getCalendarTodayButton());
    }

    /**
     * Click on Clear button on calendar.
     */
    public void selectClearForCalendar() {

        webDriverCommons.click(paymentFormPageElements.getCalendarClearButton());

    }

    /**
     * Click on final deposit date calendar input enable mode.
     */
    public void clickOnFinalDepositDateCalendarInput() {

        webDriverCommons.click(paymentFormPageElements.getFinalDepositDateCalendarEnableMode());

    }

    /**
     * Click on final payment due date calendar input enable mode.
     */
    public void clickOnFinalPaymentDueDateCalendarInput() {

        webDriverCommons.click(paymentFormPageElements.getFinalPaymentDueDateCalendarEnableMode());

    }

    /**
     * Delete seat preference from payment form.
     */
    public void deleteSeatPreferences() {

        webDriverCommons.click(paymentFormPageElements.getAisleSeatDeleteButton());

        webDriverCommons.click(paymentFormPageElements.getWindowSeatDeleteButton());

    }

    /**
     * Click on seat preference drop down.
     */
    public void clickOnSeatPreferenceDropdown() {

        webDriverCommons.click(paymentFormPageElements.getSeatPreferenceSelect());

    }

    /**
     * Click on seat preference active bar inactive mode.
     */
    public void toggleSeatPreferenceInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getSeatPreferenceActiveBarInactiveMOde());

    }

    /**
     * delete meal preferences from payment form.
     */
    public void deleteMealPreference() {
        webDriverCommons.click(paymentFormPageElements.getOtherMealDeleteButton());

        webDriverCommons.click(paymentFormPageElements.getVeganMealDeleteButton());

        webDriverCommons.click(paymentFormPageElements.getDiabeticMealDeleteButton());

        webDriverCommons.click(paymentFormPageElements.getKosherMealDeleteButton());

        webDriverCommons.click(paymentFormPageElements.getVegetarianMealDeleteButton());

    }

    /**
     * Click on meal preference drop down.
     */
    public void clickOnMealPreferenceDropdown() {

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

    }

    /**
     * Click on meal preference active bar inactive mode.
     */
    public void toggleMealPreferenceInactiveMode() {

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceActiveBarInactiveMode());

    }

    /**
     * select from seat drop down.
     * 
     * @param seat
     *            seat
     */
    public void selectFromSeatOption(final Seat seat) {

        webDriverCommons.click(paymentFormPageElements.getSeatPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getSeatPreferenceSelect(), seat.getAisle());

        webDriverCommons.sendKeys(paymentFormPageElements.getSeatPreferenceSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getSeatPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getSeatPreferenceSelect(), seat.getWindow());

        webDriverCommons.sendKeys(paymentFormPageElements.getSeatPreferenceSelect(), Keys.ENTER);

    }

    /**
     * select from meal drop down.
     * 
     * @param meal
     *            meal
     */
    public void selectFromMealPreference(final Meal meal) {

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), meal.getVegetarian());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), meal.getVegan());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), meal.getOther());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), meal.getKosher());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getMealPreferenceSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), meal.getDiabetic());

        webDriverCommons.sendKeys(paymentFormPageElements.getMealPreferenceSelect(), Keys.ENTER);
    }

    /**
     * select from address drop down.
     * 
     * @param address
     *            address
     */
    public void selectFromAddressPreference(final Address address) {

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getAddressLineOne());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getAddressLineTwo());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getCity());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getState());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getZipCode());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), address.getCountry());

        webDriverCommons.sendKeys(paymentFormPageElements.getAddressSelect(), Keys.ENTER);

    }

    /**
     * click on address drop down.
     */
    public void clickOnAddressDropdown() {

        webDriverCommons.click(paymentFormPageElements.getAddressSelect());

    }

    /**
     * delete address preferences from payment form.
     */
    public void deleteAddressPreference() {

        webDriverCommons.click(paymentFormPageElements.getAddressHeading());
        webDriverCommons.click(paymentFormPageElements.getAddressLineOneDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getAddressLineTwoDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getCityDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getStateDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getZipCodeDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getCountryDeleteButton());
    }

    /**
     * select from passenger information drop down.
     * 
     * @param passengerInformation
     *            passengerInformation
     */
    public void selectFromPassengerInformation(final PassengerInformation passengerInformation) {

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), passengerInformation.getMiddleName());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), passengerInformation.getdateOfBirth());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), passengerInformation.getPassportNumber());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), Keys.ENTER);

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationSelect());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), passengerInformation.getPhoneNumber());

        webDriverCommons.sendKeys(paymentFormPageElements.getPassengerInformationSelect(), Keys.ENTER);

    }

    /**
     * click on passenger information drop down.
     */
    public void clickOnPassengerInformationDropdown() {

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationSelect());

    }

    /**
     * delete all passenger information options from payment forms.
     */
    public void deletePassengerrInformationPreference() {

        webDriverCommons.click(paymentFormPageElements.getPassengerInformationHeading());
        webDriverCommons.click(paymentFormPageElements.getMiddleNameDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getPassportDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getDateOfBirthDeleteButton());
        webDriverCommons.click(paymentFormPageElements.getPhoneNumberDeleteButton());

    }

    /**
     * 
     */
    public void toggleFlightAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getFlightAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleAccommodationAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getAccommodationAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleTransferAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getTransferAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleOtherAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getOtherAmountActiveBarInactiveMode());

    }

    /**
     * 
     * @param cost
     *            cost
     */
    public void fillCost(final Cost cost) {
        if (cost.isFlightAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getFlightAmountInputEnableMode(), Integer.toString(cost.getFlightAmount()));
        }
        if (cost.isAirFareAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getAirFareAmountInputEnableMode(), Integer.toString(cost.getAirFareAmount()));
        }
        if (cost.isTaxesAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getTaxesAmountInputEnableMode(), Integer.toString(cost.getTaxesAmount()));
        }
        if (cost.isTermsAndConditionInputActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getTermsAndConditionInputEnableMode(), cost.getTermsAndConditionInput());

        }
        if (cost.isTransferAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getTransferAmountInputEnableMode(), Integer.toString(cost.getTransferAmount()));

        }
        if (cost.isAccommodationAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getAccommodationAmountInputEnableMode(),
                    Integer.toString(cost.getAccommodationAmount()));

        }
        if (cost.isOtherAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getOtherAmountInputEnableMode(), Integer.toString(cost.getOtherAmount()));

        }
        if (cost.isDepositAmountActive()) {
            webDriverCommons.sendKeys(paymentFormPageElements.getDepositAmountInputEnableMode(), Integer.toString(cost.getDepositAmount()));
        }

    }

    /**
     * 
     */
    public void toggleAirFareAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getAirFareAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleTaxesAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getTaxesAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleTermsAndConditionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getTermsAndConditionActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleDepositAmountSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getDepositAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void toggleBalanceSectionInactiveMode() {
        webDriverCommons.click(paymentFormPageElements.getBalanceAmountActiveBarInactiveMode());

    }

    /**
     * 
     */
    public void clickOnFlightCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getFlightCostHeading());

    }

    /**
     * 
     */
    public void clickOnAirFareCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getAirFareCostHeading());

    }

    /**
     * 
     */
    public void clickOnTaxesCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getTaxesCostHeading());

    }

    /**
     * 
     */
    public void clickOnTermsAndConditionCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getTermsAndConditionCostHeading());

    }

    /**
     * 
     */
    public void clickOnAccommodationCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getAccommodationCostHeading());

    }

    /**
     * 
     */
    public void clickOnTransferCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getTransferCostHeading());

    }

    /**
     * 
     */
    public void clickOnOtherCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getOtherCostHeading());

    }

    /**
     * 
     */
    public void clickOnDepositCostHeading() {
        webDriverCommons.click(paymentFormPageElements.getDepositCostHeading());

    }

    /**
     * fill details for all require field.
     */
    public void fillRequiredFields() {
        paymentForm = new PaymentForm.PaymentFormBuilder().setFormName("Test-Partner" + utilities.getRandomIntUnderTwoHundred())
                                                          .setPartnerName("Test-Partner" + utilities.getRandomIntUnderTwoHundred())
                                                          .setPartnerLogo("")
                                                          .setTripName("Test Trip")
                                                          .setTravelHeading("Test Heading")
                                                          .setTravelIntro("Test Intro")
                                                          .setImportantInstructionDescription("")
                                                          .build();

        fillDetailsForPaymentForm(paymentForm);

    }

    /**
     * Click on Quote active bar inactive mode.
     */
    public void toggleQuoteInactiveBar() {

        webDriverCommons.click(paymentFormPageElements.getQuoteActiveBarInactiveMode());

    }

    /**
     * click on save changes button after editing form.
     */
    public void saveAfterEdit() {

        webDriverCommons.click(paymentFormPageElements.getCreateFormAfterEditButton());

    }

    /**
     * get input value from form name from payment form.
     * 
     * @return text from form name input
     */
    public String getFormNameFormPaymentFormPage() {
        webDriverCommons.scrollTo(paymentFormPageElements.getFormNameInput());

        return paymentFormPageElements.getFormNameInput()
                                      .getAttribute("value");
    }

    /**
     * get input value from partner name from payment form.
     * 
     * @return text from partner name input
     */
    public String getPartnerNameFormPaymentFormPage() {
        webDriverCommons.scrollTo(paymentFormPageElements.getPartnerNameInput());

        return paymentFormPageElements.getPartnerNameInput()
                                      .getAttribute("value");
    }

    /**
     * click on getting back active bar active mode.
     */
    public void disableGettingBackFlight() {

        webDriverCommons.click(paymentFormPageElements.getGettingBackActiveBarActiveMode());

    }

    /**
     * click on getting around active bar active mode.
     */
    public void disableGettingAroundFlight() {
        webDriverCommons.click(paymentFormPageElements.getGettingAroundActiveBarActiveMode());

    }

    /**
     * click on getting there active bar active mode.
     */
    public void disableGettingThereFlight() {
        webDriverCommons.click(paymentFormPageElements.getGettingThereActiveBarActiveMode());

    }

    /**
     * Clear input from form name and partner name from payment form.
     */
    public void clearFormNameAndPartnerNameFromPaymentFormPage() {
        paymentFormPageElements.getFormNameInput()
                               .clear();
        paymentFormPageElements.getPartnerNameInput()
                               .clear();

    }

}

package com.statravel.autoqa.page.b2b.paymentform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentFormPageElements extends PageElements {

    @FindBy(xpath = "//span[contains(text(),'ADD NEW FORM')]")
    private WebElement addNewFormHeader;

    @FindBy(name = "name")
    private WebElement formName;

    // Transfer

    @FindBy(css = "#travel-info-transfer-add")
    private WebElement transferAddNewButton;

    @FindBy(css = "#transfer-active-false")
    private WebElement transferActiveBarInactiveMode;

    @FindBy(css = "#transfer-active-true")
    private WebElement transferActiveBarActiveMode;

    @FindBy(css = "#travel-info-transfer-confirmation-1")
    private WebElement conformationForFirstTrasfer;

    @FindBy(css = "#travel-info-transfer-confirmation-2")
    private WebElement conformationForSecondTrasfer;

    @FindBy(css = "#travel-info-transfer-edit-1")
    private WebElement transferEditButton;

    @FindBy(css = "#travel-info-transfer-active-warning")
    private WebElement transferRequireMessage;

    @FindBy(xpath = "//span[@id='travel-info-transfer-active-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement transferRequireErrorMessage;

    @FindBy(css = "#transfer-active-toggle-false-1")
    private WebElement firstTransferActiveBarInactiveMode;

    @FindBy(css = "#transfer-active-toggle-true-1")
    private WebElement firstTransferActiveBarActiveMode;

    // Flights

    @FindBy(css = "#flights-getting-there-active-true")
    private WebElement gettingThereActiveBarActiveMode;

    @FindBy(css = "#flights-getting-there-active-false")
    private WebElement gettingThereActiveBarInactiveMode;

    @FindBy(css = "#flights-getting-around-active-true")
    private WebElement gettingAroundActiveBarActiveMode;

    @FindBy(css = "#flights-getting-around-active-false")
    private WebElement gettingAroundActiveBarInactiveMode;

    @FindBy(css = "#flights-getting-back-active-true")
    private WebElement gettingBackActiveBarActiveMode;

    @FindBy(css = "#flights-getting-back-active-false")
    private WebElement gettingBackActiveBarInactiveMode;

    @FindBy(xpath = "//b[contains(text(),'Getting There')]")
    private WebElement textGettingThere;

    @FindBy(css = "#flights-getting-there-edit")
    private WebElement gettingThereEditButton;

    @FindBy(xpath = "//b[contains(text(),'Getting Around')]")
    private WebElement textGettingAround;

    @FindBy(css = "#flights-getting-around-edit")
    private WebElement gettingAroundEditButton;

    @FindBy(xpath = "//b[contains(text(),'Getting Back")
    private WebElement textGettingBack;

    @FindBy(css = "#flights-getting-back-edit")
    private WebElement gettingBackEditButton;

    @FindBy(xpath = "//th[contains(text(),'Flight Type Name')]//following::td[1]")
    private WebElement airportCodeDisplayValidation;

    @FindBy(css = "#flights-active-false")
    private WebElement flightsActiveBarInactiveMode;

    @FindBy(css = "#flights-active-true")
    private WebElement flightsActiveBarActiveMode;

    @FindBy(id = "flights-getting-there-active-disabled")
    private WebElement gettingThereActiveBarDisableMode;

    @FindBy(id = "flights-getting-around-active-disabled")
    private WebElement gettingAroundActiveBarDisableMode;

    @FindBy(id = "flights-getting-back-active-disabled")
    private WebElement gettingBackActiveBarDisableMode;

    @FindBy(id = "flights-warning")
    private WebElement flightsAreReqMsg;

    @FindBy(xpath = "//span[@id='flights-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement flightsAreRequireErrorMsg;

    @FindBy(css = "#flights-getting-around-confirmation")
    private WebElement airportCodeDisplayValidationForGettingAround;

    @FindBy(css = "#flights-getting-there-confirmation")
    private WebElement airportCodeDisplayValidationForGettingThere;

    @FindBy(css = "#flights-getting-back-confirmation")
    private WebElement airportCodeDisplayValidationForGettingBack;

    // Accommodation

    @FindBy(css = "#travel-info-accommodation-active-false")
    private WebElement accommodationActiveBarInactiveMode;

    @FindBy(css = "#travel-info-accommodation-active-true")
    private WebElement accommodationActiveBarActiveMode;

    @FindBy(css = "#travel-info-accommodation-add")
    private WebElement accommodationAddNewButton;

    @FindBy(css = "#travel-info-accommodation-warning")
    private WebElement accommodationIsRequireMessage;

    @FindBy(xpath = "//span[@id='travel-info-accommodation-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement accommodationIsRequireErrorMessage;

    @FindBy(css = "#travel-info-accommodation-edit-1")
    private WebElement firstAccommodationEditButton;

    @FindBy(css = "#accommodation-active-true-1")
    private WebElement firstAccommodationActiveBarActiveMode;

    @FindBy(css = "#accommodation-active-false-1")
    private WebElement firstAccommodationActiveBarInactiveMode;

    @FindBy(css = "#travel-info-accommodation-confirmation-1")
    private WebElement confirmationForFirstAccommodation;

    @FindBy(css = "#travel-info-accommodation-edit-2")
    private WebElement secondAccommodationEditButton;

    @FindBy(css = "#accommodation-active-true-2")
    private WebElement secondAccommodationActiveBarActiveMode;

    @FindBy(css = "#accommodation-active-false-2")
    private WebElement secondAccommodationActiveBarInactiveMode;

    @FindBy(css = "#travel-info-accommodation-confirmation-2")
    private WebElement confirmationForSecondAccommodation;

    // Others

    @FindBy(css = "#travel-info-others-active-false")
    private WebElement othersActiveButtonInactiveMode;

    @FindBy(css = "#travel-info-others-active-true")
    private WebElement othersActiveButtonActiveMode;

    @FindBy(css = "#travel-info-others-add")
    private WebElement othersAddNewButton;

    @FindBy(css = "#travel-info-others-active-warning")
    private WebElement othersDetailsRequireMessage;

    @FindBy(xpath = "//span[@id='travel-info-others-active-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement othersDetailsRequireErrorMessage;

    // Cancellation Fees & Legal Copy

    @FindBy(css = "#cancellation-fees-false")
    private WebElement cancellationFeesActiveBarInactiveMode;

    @FindBy(css = "#cancellation-fees-true")
    private WebElement cancellationFeesActiveBarActiveMode;

    @FindBy(css = "#cancellation-fees-add-new")
    private WebElement cancellationFeesAddNewbutton;

    @FindBy(css = "#cancellation-fees-warning")
    private WebElement cancellationFeesRequreMessage;

    @FindBy(xpath = "//span[@id='cancellation-fees-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement cancellationFeesRequreErrorMessage;

    @FindBy(css = "#cancellation-fees-legal-copy")
    private WebElement legalCopyInput;

    // Extra

    @FindBy(css = "#payment-form-extras-active-false")
    private WebElement extrasActiveBar;

    @FindBy(css = "#payment-form-extra-add-new")
    private WebElement extrasAddNewButton;

    @FindBy(css = "#payment-form-extras-active-true")
    private WebElement extraActivebarActiveMode;

    @FindBy(css = "#payment-form-extra-required")
    private WebElement extraIsRequireMessage;

    @FindBy(xpath = "//span[@id='payment-form-extra-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement extraIsRequireErrorMessage;

    // Misc Product

    @FindBy(css = "#payment-form-misc-false")
    private WebElement miscProductActiveBar;

    @FindBy(css = "#payment-form-misc-add-new")
    private WebElement miscProductAddNewButton;

    @FindBy(css = "#payment-form-misc-add-new-required")
    private WebElement miscProductIsRequreMessage;

    @FindBy(xpath = "//span[@id='payment-form-misc-add-new-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement miscProductIsRequreErrorMessage;

    @FindBy(css = "#payment-form-misc-product-name")
    private WebElement miscProductTitleNameInput;

    @FindBy(css = "#payment-form-misc-product-name-required")
    private WebElement miscProductTitleNameIsRequireMessage;

    @FindBy(xpath = "//span[@id='payment-form-misc-product-name-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement miscProductTitleNameIsRequireErrorMessage;

    // StopOver

    @FindBy(css = "#payment-form-stopovers-false")
    private WebElement stopOverActiveBar;

    @FindBy(css = "#payment-form-stopovers-add-new")
    private WebElement stopOverAddNewButton;

    @FindBy(css = "#payment-form-stopovers-true")
    private WebElement stopOverActiveBarActiveMOde;

    @FindBy(css = "#payment-form-stopovers-required")
    private WebElement stopOverRequireMessage;

    @FindBy(xpath = "//span[@id='payment-form-stopovers-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement stopOverRequireErrorMessage;

    @FindBy(css = "#payment-form-create")
    private WebElement createFormButton;

    @FindBy(css = "#payment-form-cancel")
    private WebElement cancelButton;
    
    @FindBy(css = "#payment-form-save")
    private WebElement createFormAfterEditButton;

    // Partner Information

    @FindBy(css = "#partner-information-form-name")
    private WebElement formNameInput;

    @FindBy(css = "#partner-information-form-name-required")
    private WebElement formNameISRequireMsg;

    @FindBy(xpath = "//span[contains(text(),'Form Name is a required field')and@class='error paymentFormWarning paymentFormError']")
    private WebElement formNameISRequireErrorMsg;

    @FindBy(css = "#partner-information-partner-name")
    private WebElement partnerNameInput;

    @FindBy(css = "#partner-information-partner-name-required")
    private WebElement partnerNameIsRequireMsg;

    @FindBy(xpath = "//span[contains(text(),'Partner Name is a required field')and@class='error paymentFormWarning paymentFormError']")
    private WebElement partnerNameIsRequireErrorMsg;

    @FindBy(css = "#partner-information-partner-logo-url")
    private WebElement partnerLogoInput;

    @FindBy(css = "#partner-information-trip-name")
    private WebElement tripNameInput;

    @FindBy(css = "#partner-information-trip-name-required")
    private WebElement tripNameIsRequireMsg;

    @FindBy(xpath = "//span[contains(text(),'Trip Name is a required field')and@class='error paymentFormWarning paymentFormError']")
    private WebElement tripNameIsRequireErrorMsg;

    // Travel Information

    @FindBy(css = "#travel-info-heading")
    private WebElement travelHeadingInput;

    @FindBy(css = "#travel-info-heading-warning")
    private WebElement travelHeadingIsRequireMsg;

    @FindBy(css = "#travel-info-heading-warning")
    private WebElement travelHeadingIsRequireErrorMsg;

    @FindBy(css = "#travel-info-intro-text")
    private WebElement travelIntroTextInput;

    @FindBy(css = "#travel-info-intro-text-warning")
    private WebElement travelIntroIsRequireMsg;

    @FindBy(xpath = "//span[contains(text(),'Intro Text is a required field')and@class='error paymentFormWarning paymentFormError']")
    private WebElement travelIntroIsRequireErrorMsg;

    // T&C

    @FindBy(css = "#travel-info-tcs-final-deposit-date-active-false")
    private WebElement finalDepositDateActiveBarInactiveMode;

    @FindBy(css = "#travel-info-tcs-final-deposit-date-active-true")
    private WebElement finalDepositDateActiveBarActiveMode;

    @FindBy(css = "#travel-info-tcs-final-deposit-date-disabled-input")
    private WebElement finalDepositDateCalendarDisableMode;

    @FindBy(css = "#travel-info-tcs-final-deposit-date-enabled-input")
    private WebElement finalDepositDateCalendarEnableMode;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement finalDepositDateCalendarDayButton;

    @FindBy(css = "#travel-info-tcs-final-deposit-description-disabled")
    private WebElement finalDepositDateDiscriptionDisableMode;

    @FindBy(css = "#travel-info-tcs-final-deposit-description-enabled")
    private WebElement finalDepositDateDiscriptionEnableMode;

    @FindBy(css = "#travel-info-tcs-final-deposit-date-warning")
    private WebElement finalDepositRequireMsg;

    @FindBy(xpath = "//span[@id='travel-info-tcs-final-deposit-date-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement finalDepositRequireErrorMsg;

    @FindBy(css = "#travel-info-tcs-final-payment-date-active-false")
    private WebElement finalPaymentDueDateActiveBarInactiveMode;

    @FindBy(css = "#travel-info-tcs-final-payment-date-active-true")
    private WebElement finalPaymentDueDateActiveBarActiveMode;

    @FindBy(css = "#travel-info-tcs-final-payment-date-disabled-input")
    private WebElement finalPaymentDueDateCalendarDisableMode;

    @FindBy(css = "#travel-info-tcs-final-payment-date-enabled-input")
    private WebElement finalPaymentDueDateCalendarEnableMode;

    @FindBy(xpath = "//table//tr[6]//td[6]//button")
    private WebElement finalPaymentDueDateCalendarDayButton;

    @FindBy(css = "#travel-info-tcs-final-payment-date-description-disabled")
    private WebElement finalPaymentDueDateDiscriptionDisableMode;

    @FindBy(css = "#travel-info-tcs-final-payment-date-description-enabled")
    private WebElement finalPaymentDueDateDiscriptionEnableMode;

    @FindBy(css = "#travel-info-tcs-final-payment-date-warning")
    private WebElement finalPaymentDueDateRequireMsg;

    @FindBy(xpath = "//span[@id='travel-info-tcs-final-payment-date-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement finalPaymentDueDateRequireErrorMsg;

    @FindBy(css = "#travel-info-important-instr-false")
    private WebElement importantInstructionActiveBarInactiveMode;

    @FindBy(css = "#travel-info-important-instr-true")
    private WebElement importantInstructionActiveBarActiveMode;

    @FindBy(css = "#travel-info-important-instructions")
    private WebElement importantInstructionInput;

    @FindBy(css = "#travel-info-important-instructions-warning")
    private WebElement importantInstructionRequireMsg;

    @FindBy(xpath = "//span[@id='travel-info-important-instructions-warning'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement importantInstructionRequireErrorMsg;

    // Passenger Information

    @FindBy(xpath = "//label[@id='payment-form-passenger-information-label']//following::input[@value='Select Field(s)'][1]")
    private WebElement passengerInformationSelect;

    @FindBy(xpath = "//li[@id='Middle Name-active-result']")
    private WebElement middleNameEnableDropdown;

    @FindBy(xpath = "//span[@id='Middle Name-search-choice']")
    private WebElement middleNameConfirmation;

    @FindBy(xpath = "//li[@id='Middle Name-result-selected']")
    private WebElement middleNameDisableDropdown;

    @FindBy(xpath = "//a[@id='Middle Name-search-choice-close']")
    private WebElement middleNameDeleteButton;

    @FindBy(xpath = "//li[@id='Passport Number-active-result']")
    private WebElement passportNumberEnableDropdown;

    @FindBy(xpath = "//span[@id='Passport Number-search-choice']")
    private WebElement passportNumberConfirmation;

    @FindBy(xpath = "//li[@id='Passport Number-result-selected']")
    private WebElement passportNumberDisableDropdown;

    @FindBy(xpath = "//a[@id='Passport Number-search-choice-close']")
    private WebElement passportDeleteButton;

    @FindBy(xpath = "//li[@id='Date of Birth-active-result']")
    private WebElement dateOfBirthEnableDropdown;

    @FindBy(xpath = "//span[@id='Date of Birth-search-choice']")
    private WebElement dateOfBirthConfirmation;

    @FindBy(xpath = "//li[@id='Date of Birth-result-selected']")
    private WebElement dateOfBirthDisableDropdown;

    @FindBy(xpath = "//a[@id='Date of Birth-search-choice-close']")
    private WebElement dateOfBirthDeleteButton;

    @FindBy(xpath = "//li[@id='Phone Number-active-result']")
    private WebElement phoneNumberEnableDropdown;

    @FindBy(xpath = "//span[@id='Phone Number-search-choice']   ")
    private WebElement phoneNumberConfirmation;

    @FindBy(xpath = "//li[@id='Phone Number-result-selected']")
    private WebElement phoneNumberDisableDropdown;

    @FindBy(xpath = "//a[@id='Phone Number-search-choice-close']")
    private WebElement phoneNumberDeleteButton;

    @FindBy(css = "#payment-form-passenger-information-label")
    private WebElement passengerInformationHeading;

    @FindBy(css = "#payment-form-address-label")
    private WebElement addressHeading;

    @FindBy(xpath = "//label[@id='payment-form-address-label']//following::input[@value='Select Field(s)'][1]")
    private WebElement addressSelect;

    @FindBy(xpath = "//li[@id='Address line 1-active-result']")
    private WebElement addressLineOneEnableDropdown;

    @FindBy(xpath = "//span[@id='Address line 1-search-choice']")
    private WebElement addressLineOneConfirmation;

    @FindBy(xpath = "//li[@id='Address line 1-result-selected']")
    private WebElement addressLineOneDisableDropdown;

    @FindBy(xpath = "//li[@id='Address line 2-active-result']")
    private WebElement addressLineTwoEnableDropdown;

    @FindBy(xpath = "//span[@id='Address line 2-search-choice']")
    private WebElement addressLineTwoConfirmation;

    @FindBy(xpath = "//li[@id='Address line 2-result-selected']")
    private WebElement addressLineTwoDisableDropdown;

    @FindBy(css = "#City-active-result")
    private WebElement cityEnableDropdown;

    @FindBy(css = "#City-search-choice")
    private WebElement cityConfirmation;

    @FindBy(css = "#City-result-selected")
    private WebElement cityDisableDropdown;

    @FindBy(css = "#State-active-result")
    private WebElement stateEnableDropdown;

    @FindBy(css = "#State-search-choice")
    private WebElement stateConfirmation;

    @FindBy(css = "#State-result-selected")
    private WebElement stateDisableDropdown;

    @FindBy(xpath = "//li[@id='Zip Code-active-result']")
    private WebElement zipCodeEnableDropdown;

    @FindBy(xpath = "//span[@id='Zip Code-search-choice']")
    private WebElement zipCodeConfirmation;

    @FindBy(xpath = "//li[@id='Zip Code-result-selected']")
    private WebElement zipCodeDisableDropdown;

    @FindBy(css = "#Country-active-result")
    private WebElement countryEnableDropdown;

    @FindBy(css = "#Country-search-choice")
    private WebElement countryConfirmation;

    @FindBy(css = "#Country-result-selected")
    private WebElement countyDisableDropdown;

    @FindBy(xpath = "//a[@id='Address line 1-search-choice-close']")
    private WebElement addressLineOneDeleteButton;

    @FindBy(xpath = "//a[@id='Address line 2-search-choice-close']")
    private WebElement addressLineTwoDeleteButton;

    @FindBy(css = "#City-search-choice-close")
    private WebElement cityDeleteButton;

    @FindBy(css = "#State-search-choice-close")
    private WebElement stateDeleteButton;

    @FindBy(xpath = "//a[@id='Zip Code-search-choice-close']")
    private WebElement zipCodeDeleteButton;

    @FindBy(css = "#Country-search-choice-close")
    private WebElement countryDeleteButton;

    @FindBy(css = "#payment-form-seat-preference-true")
    private WebElement seatPreferenceActiveBarActiveMOde;

    @FindBy(css = "#payment-form-seat-preference-false")
    private WebElement seatPreferenceActiveBarInactiveMOde;

    @FindBy(xpath = "//span[@id='payment-form-seat-preference-required']//following::input[@value='Select Seat(s)']")
    private WebElement seatPreferenceSelect;

    @FindBy(css = "#payment-form-seat-preference-label")
    private WebElement seatPreferenceHeading;

    @FindBy(css = "#payment-form-meal-preference-label")
    private WebElement mealPreferenceHeading;

    @FindBy(css = "#Aisle-active-result")
    private WebElement aisleSeatEnableDropdown;

    @FindBy(css = "#Aisle-search-choice")
    private WebElement aisleSeatConfirmation;

    @FindBy(css = "#Aisle-search-choice-close")
    private WebElement aisleSeatDeleteButton;

    @FindBy(css = "#Aisle-result-selected")
    private WebElement aisleSeatDisableDropdown;

    @FindBy(css = "#Window-active-result")
    private WebElement windowSeatEnableDropdown;

    @FindBy(css = "#Window-search-choice")
    private WebElement windowSeatConfirmation;

    @FindBy(css = "#Window-search-choice-close")
    private WebElement windowSeatDeleteButton;

    @FindBy(css = "#Window-result-selected")
    private WebElement windowSeatDisableDropdown;

    @FindBy(css = "#payment-form-seat-preference-required")
    private WebElement seatPrefenceReqiureMessage;

    @FindBy(xpath = "//span[@id='payment-form-seat-preference-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement seatPrefenceReqiureErrorMessage;

    @FindBy(css = "#payment-form-meal-preference-false")
    private WebElement mealPreferenceActiveBarInactiveMode;

    @FindBy(css = "#payment-form-meal-preference-true")
    private WebElement mealPreferenceActiveBarActiveMode;

    @FindBy(css = "#payment-form-meal-preference-required")
    private WebElement mealPreferenceRequireMessage;

    @FindBy(xpath = "//span[@id='payment-form-meal-preference-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement mealPreferenceRequireErrorMessage;

    @FindBy(xpath = "//span[@id='payment-form-meal-preference-required']//following::input[@value='Select Meal(s)'][1]")
    private WebElement mealPreferenceSelect;

    @FindBy(css = "#Vegetarian-search-choice")
    private WebElement vegetarianMealConfirmation;

    @FindBy(css = "#Vegetarian-active-result")
    private WebElement vegetarianEnableDropdown;

    @FindBy(css = "#Vegetarian-result-selected")
    private WebElement vegetarianegetarianDisableDropdown;

    @FindBy(css = "#Diabetic-active-result")
    private WebElement diabeticEnableDropdown;

    @FindBy(css = "#Diabetic-result-selected")
    private WebElement diabeticDisableDropdown;

    @FindBy(css = "#Kosher-active-result")
    private WebElement kosherEnableDropdown;

    @FindBy(css = "#Kosher-result-selected")
    private WebElement kocherDisableDropdown;

    @FindBy(css = "#Vegan-active-result")
    private WebElement veganEnableDropdown;

    @FindBy(css = "#Vegan-result-selected")
    private WebElement veganDisableDropdown;

    @FindBy(css = "#Other-active-result")
    private WebElement otherEnableDropdown;

    @FindBy(css = "#Other-result-selected")
    private WebElement othersdisableDropdown;

    @FindBy(css = "#Diabetic-search-choice")
    private WebElement diabeticMealConfirmation;

    @FindBy(css = "#Kosher-search-choice")
    private WebElement kosherMealConfirmation;

    @FindBy(css = "#Vegan-search-choice")
    private WebElement veganMealConfirmation;

    @FindBy(css = "#Other-search-choice")
    private WebElement otherMealConfirmation;

    @FindBy(css = "#Vegetarian-search-choice-close")
    private WebElement vegetarianMealDeleteButton;

    @FindBy(css = "#Diabetic-search-choice-close")
    private WebElement diabeticMealDeleteButton;

    @FindBy(css = "#Kosher-search-choice-close")
    private WebElement kosherMealDeleteButton;

    @FindBy(css = "#Vegan-search-choice-close")
    private WebElement veganMealDeleteButton;

    @FindBy(css = "#Other-search-choice-close")
    private WebElement otherMealDeleteButton;

    /**
     * Cost/prices.
     */

    @FindBy(css = "#cost-prices-flight-title")
    private WebElement flightCostHeading;

    @FindBy(css = "#cost-prices-airfare-title")
    private WebElement airFareCostHeading;

    @FindBy(css = "#cost-prices-taxes-title")
    private WebElement taxesCostHeading;

    @FindBy(xpath = "//label[@id='cost-prices-t&c-title']")
    private WebElement termsAndConditionCostHeading;

    @FindBy(css = "#cost-prices-accommodation-title")
    private WebElement accommodationCostHeading;

    @FindBy(css = "#cost-prices-transfer-title")
    private WebElement transferCostHeading;

    @FindBy(css = "#cost-prices-other-title")
    private WebElement otherCostHeading;

    @FindBy(css = "#cost-prices-deposit-title")
    private WebElement depositCostHeading;

    @FindBy(css = "#cost-prices-deposit-title")
    private WebElement balanceCostHeading;

    @FindBy(css = "#cost-prices-flight-toggle-inactive")
    private WebElement flightAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-flight-toggle-active")
    private WebElement flightAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-flight-field-disabled")
    private WebElement flightAmountInputDisableMode;

    @FindBy(css = "#cost-prices-flight-field-enabled")
    private WebElement flightAmountInputEnableMode;

    @FindBy(css = "#cost-prices-flight-warning")
    private WebElement atleastOneCostRequireMessageForFlight;

    @FindBy(xpath = "//span[@id='cost-prices-flight-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement atleastOneCostRequireErrorMessageForFlight;

    @FindBy(css = "#cost-prices-flight-required")
    private WebElement flightAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-flight-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement flightAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-airfare-toggle-inactive")
    private WebElement airFareAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-airfare-toggle-active")
    private WebElement airFareAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-airfare-field-disabled")
    private WebElement airFareAmountInputDisableMode;

    @FindBy(css = "#cost-prices-airfare-field-enabled")
    private WebElement airFareAmountInputEnableMode;

    @FindBy(css = "#cost-prices-airfare-required")
    private WebElement airFareAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-airfare-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement airFareAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-taxes-toggle-inactive")
    private WebElement taxesAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-taxes-toggle-active")
    private WebElement taxesAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-taxes-field-disabled")
    private WebElement taxesAmountInputDisableMode;

    @FindBy(css = "#cost-prices-taxes-field-enabled")
    private WebElement taxesAmountInputEnableMode;

    @FindBy(css = "#cost-prices-taxes-required")
    private WebElement taxesAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-taxes-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement taxesAmountRequireErrorMessage;

    @FindBy(id = "cost-prices-t&c-toggle-inactive")
    private WebElement termsAndConditionActiveBarInactiveMode;

    @FindBy(id = "cost-prices-t&c-toggle-active")
    private WebElement termsAndConditionActiveBarActiveMode;

    @FindBy(id = "cost-prices-t&c-field-disabled")
    private WebElement termsAndConditionInputDisableMode;

    @FindBy(id = "cost-prices-t&c-field-enabled")
    private WebElement termsAndConditionInputEnableMode;

    @FindBy(id = "cost-prices-t&c-required")
    private WebElement termsAndConditionRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-t&c-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement termsAndConditionRequireErrorMessage;

    @FindBy(css = "#cost-prices-accommodation-toggle-inactive")
    private WebElement accommodationAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-accommodation-toggle-active")
    private WebElement accommodationAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-accommodation-field-disabled")
    private WebElement accommodationAmountInputDisableMode;

    @FindBy(css = "#cost-prices-accommodation-field-enabled")
    private WebElement accommodationAmountInputEnableMode;

    @FindBy(css = "#cost-prices-accommodation-warning")
    private WebElement atleastOneCostRequireMessageForAccommodation;

    @FindBy(xpath = "//span[@id='cost-prices-accommodation-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement atleastOneCostRequireErrorMessageForAccommodation;

    @FindBy(css = "#cost-prices-accommodation-required")
    private WebElement accommodationAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-accommodation-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement accommodationAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-transfer-toggle-inactive")
    private WebElement transferAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-transfer-toggle-active")
    private WebElement tranferAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-transfer-field-disabled")
    private WebElement transferAmountInputDisableMode;

    @FindBy(css = "#cost-prices-transfer-field-enabled")
    private WebElement transferAmountInputEnableMode;

    @FindBy(css = "#cost-prices-transfer-warning")
    private WebElement atleastOneCostRequireMessageForTranfer;

    @FindBy(xpath = "//span[@id='cost-prices-transfer-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement atleastOneCostRequireErrorMessageForTranfer;

    @FindBy(css = "#cost-prices-transfer-required")
    private WebElement tranferAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-transfer-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement tranferAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-other-toggle-inactive")
    private WebElement otherAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-other-toggle-active")
    private WebElement otherAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-other-field-disabled")
    private WebElement otherAmountInputDisableMode;

    @FindBy(css = "#cost-prices-other-field-enabled")
    private WebElement otherAmountInputEnableMode;

    @FindBy(css = "#cost-prices-other-warning")
    private WebElement atleastOneCostRequireMessageForOther;

    @FindBy(xpath = "//span[@id='cost-prices-other-warning'and@class='error paymentFormWarning paymentFormError']")
    private WebElement atleastOneCostRequireErrorMessageForOther;

    @FindBy(css = "#cost-prices-other-required")
    private WebElement otherAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-other-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement otherAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-deposit-toggle-inactive")
    private WebElement depositAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-deposit-toggle-active")
    private WebElement depositAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-deposit-field-disabled")
    private WebElement depositAmountInputDisableMode;

    @FindBy(css = "#cost-prices-deposit-field-enabled")
    private WebElement depositAmountInputEnableMode;

    @FindBy(css = "#cost-prices-deposit-required")
    private WebElement depositAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-deposit-required'and@class='error paymentFormWarning paymentFormError']")
    private WebElement depositAmountRequireErrorMessage;

    @FindBy(css = "#cost-prices-balance-toggle-inactive")
    private WebElement balanceAmountActiveBarInactiveMode;

    @FindBy(css = "#cost-prices-balance-toggle-active")
    private WebElement balanceAmountActiveBarActiveMode;

    @FindBy(css = "#cost-prices-balance-field-disabled")
    private WebElement balanceAmountInputDisableMode;

    @FindBy(css = "#cost-prices-balance-required")
    private WebElement balanceAmountRequireMessage;

    @FindBy(xpath = "//span[@id='cost-prices-balance-required'and@class='ng-scope error paymentFormWarning paymentFormError']")
    private WebElement balanceAmountRequireErrorMessage;

    /**
     * General.
     */

    @FindBy(css = ".btn.btn-sm.btn-danger.ng-binding")
    private WebElement calendarClearButton;

    @FindBy(css = ".btn.btn-sm.btn-info.ng-binding")
    private WebElement calendarTodayButton;

    @FindBy(css = ".dropdown-menu.ng-pristine.ng-untouched.ng-valid.ng-scope.ng-valid-date-disabled")
    private WebElement calendarLightBox;

    @FindBy(css = "#partner-information-quote-toggle-active")
    private WebElement quoteActiveBarActiveMode;

    @FindBy(css = "#partner-information-quote-toggle-inactive")
    private WebElement quoteActiveBarInactiveMode;

    /**
     * @return the addNewFormHeader
     */
    public WebElement getAddNewFormHeader() {
        return addNewFormHeader;
    }

    /**
     * @return the formName
     */
    public WebElement getFormName() {
        return formName;
    }

    /**
     * @return the transferAddNewButton
     */

    public WebElement getTransferAddNewButton() {
        return transferAddNewButton;
    }

    /**
     * @return the transferActiveBar
     */

    public WebElement getTransferActiveBarInactiveMode() {
        return transferActiveBarInactiveMode;
    }

    /**
     * @return the transferActiveBarActiveMode
     */
    public WebElement getTransferActiveBarActiveMode() {
        return transferActiveBarActiveMode;
    }

    /**
     * @return the transferRequireMessage
     */
    public WebElement getTransferRequireMessage() {
        return transferRequireMessage;
    }

    /**
     * @return the transferEditButton
     */
    public WebElement getTransferEditButton() {
        return transferEditButton;
    }

    /**
     * @return the createFormButton
     */

    public WebElement getCreateFormButton() {
        return createFormButton;
    }

    /**
     * @return the cancelButton
     */

    public WebElement getCancelButton() {
        return cancelButton;
    }

    /**
     * @return the transferNameConformation
     */

    public WebElement getConformationForFirstTrasfer() {
        return conformationForFirstTrasfer;
    }

    /**
     * @return the firstTransferActiveBar
     */
    public WebElement getFirstTransferActiveBarInactiveMode() {
        return firstTransferActiveBarInactiveMode;
    }

    /**
     * @return the firstTransferActiveBarActiveMode
     */
    public WebElement getFirstTransferActiveBarActiveMode() {
        return firstTransferActiveBarActiveMode;
    }

    /**
     * @return the conformationForSecondTrasfer
     */
    public WebElement getConformationForSecondTrasfer() {
        return conformationForSecondTrasfer;
    }

    /**
     * @return the gettingThereActiveButton
     */

    public WebElement getGettingThereActiveBarActiveMode() {
        return gettingThereActiveBarActiveMode;
    }

    /**
     * @return the gettingThereActiveBarInactive Mode
     */
    public WebElement getGettingThereActiveBarInactiveMode() {
        return gettingThereActiveBarInactiveMode;
    }

    /**
     * @return the gettingAroundActiveBarActiveMode
     */
    public WebElement getGettingAroundActiveBarActiveMode() {
        return gettingAroundActiveBarActiveMode;
    }

    /**
     * @return the gettingAroundActiveBarInactive Mode
     */
    public WebElement getGettingAroundActiveBarInactiveMode() {
        return gettingAroundActiveBarInactiveMode;
    }

    /**
     * @return the gettingBackActiveBarActiveMode
     */
    public WebElement getGettingBackActiveBarActiveMode() {
        return gettingBackActiveBarActiveMode;
    }

    /**
     * @return the gettingBackActiveBarInactive Mode
     */
    public WebElement getGettingBackActiveBarInactiveMode() {
        return gettingBackActiveBarInactiveMode;
    }

    /**
     * @return the flightsActiveBarActiveMode
     */
    public WebElement getFlightsActiveBarActiveMode() {
        return flightsActiveBarActiveMode;
    }

    /**
     * @return the textGettingThere
     */

    public WebElement getTextGettingThere() {
        return textGettingThere;
    }

    /**
     * @return the gettingThereEditButton
     */

    public WebElement getGettingThereEditButton() {
        return gettingThereEditButton;
    }

    /**
     * @return the textGettingAround
     */

    public WebElement getTextGettingAround() {
        return textGettingAround;
    }

    /**
     * @return the gettingAroundEditButton
     */

    public WebElement getGettingAroundEditButton() {
        return gettingAroundEditButton;
    }

    /**
     * @return the textGettingBack
     */

    public WebElement getTextGettingBack() {
        return textGettingBack;
    }

    /**
     * @return the gettingBackEditButton
     */

    public WebElement getGettingBackEditButton() {
        return gettingBackEditButton;
    }

    /**
     * @return the AirportCodeDisplayValidation
     */

    public WebElement getAirportCodeDisplayValidation() {
        return airportCodeDisplayValidation;
    }

    /**
     * @return the flightsActiveBar
     */

    public WebElement getFlightsActiveBarInactiveMode() {
        return flightsActiveBarInactiveMode;
    }

    /**
     * @return the gettingThereActiveBarInactiveMode
     */

    public WebElement getGettingThereActiveBarDisableMode() {
        return gettingThereActiveBarDisableMode;
    }

    /**
     * @return the gettingAroundActiveBarInactiveMode
     */

    public WebElement getGettingAroundActiveBarDisableMode() {
        return gettingAroundActiveBarDisableMode;
    }

    /**
     * @return the gettingBackActiveBarInactiveMode
     */
    public WebElement getGettingBackActiveBarDisableMode() {
        return gettingBackActiveBarDisableMode;
    }

    /**
     * @return the flightsAreReqMsg
     */

    public WebElement getFlightsAreReqMsg() {
        return flightsAreReqMsg;
    }

    /**
     * @return the AirportCodeDisplayValidationForGettingAround
     */
    public WebElement getAirportCodeDisplayValidationForGettingAround() {
        return airportCodeDisplayValidationForGettingAround;
    }

    /**
     * @return the AirportCodeDisplayValidationForGettingThere
     */
    public WebElement getAirportCodeDisplayValidationForGettingThere() {
        return airportCodeDisplayValidationForGettingThere;
    }

    /**
     * @return the AirportCodeDisplayValidationForGettingBack
     */
    public WebElement getAirportCodeDisplayValidationForGettingBack() {
        return airportCodeDisplayValidationForGettingBack;
    }

    /**
     * @return the accommodationActiveBar
     */
    public WebElement getAccommodationActiveBarInactiveMode() {
        return accommodationActiveBarInactiveMode;
    }

    /**
     * @return the accommodationActiveBarActiveMode
     */
    public WebElement getAccommodationActiveBarActiveMode() {
        return accommodationActiveBarActiveMode;
    }

    /**
     * @return the accommodationAddNewButton
     */
    public WebElement getAccommodationAddNewButton() {
        return accommodationAddNewButton;
    }

    /**
     * @return the accommodationIsRequireMessage
     */
    public WebElement getAccommodationIsRequireMessage() {
        return accommodationIsRequireMessage;
    }

    /**
     * @return the firstAccommodationEditButton
     */
    public WebElement getFirstAccommodationEditButton() {
        return firstAccommodationEditButton;
    }

    /**
     * @return the firstAccommodationActiveBar
     */
    public WebElement getFirstAccommodationActiveBarActiveMode() {
        return firstAccommodationActiveBarActiveMode;
    }

    /**
     * @return the firstAccommodationActiveBarInactiveMode
     */
    public WebElement getFirstAccommodationActiveBarInactiveMode() {
        return firstAccommodationActiveBarInactiveMode;
    }

    /**
     * @return the secondAccommodationActiveBarInactiveMode
     */
    public WebElement getSecondAccommodationActiveBarInactiveMode() {
        return secondAccommodationActiveBarInactiveMode;
    }

    /**
     * @return the secondAccommodationEditButton
     */
    public WebElement getSecondAccommodationEditButton() {
        return secondAccommodationEditButton;
    }

    /**
     * @return the secondAccommodationActiveBar
     */
    public WebElement getSecondAccommodationActiveBarActiveMode() {
        return secondAccommodationActiveBarActiveMode;
    }

    /**
     * @return the confirmationForFirstAccommodation
     */
    public WebElement getConfirmationForFirstAccommodation() {
        return confirmationForFirstAccommodation;
    }

    /**
     * @return the confirmationForSecondAccommodation
     */
    public WebElement getConfirmationForSecondAccommodation() {
        return confirmationForSecondAccommodation;
    }

    /**
     * @return the othersActiveButton
     */
    public WebElement getOthersActiveButtonInactiveMode() {
        return othersActiveButtonInactiveMode;
    }

    /**
     * @return the othersActiveButtonActiveMode
     */
    public WebElement getOthersActiveButtonActiveMode() {
        return othersActiveButtonActiveMode;
    }

    /**
     * @return the othersAddNewButton
     */
    public WebElement getOthersAddNewButton() {
        return othersAddNewButton;
    }

    /**
     * @return the othersDetailsRequireMessage
     */
    public WebElement getOthersDetailsRequireMessage() {
        return othersDetailsRequireMessage;
    }

    /**
     * @return the extrasActiveBar
     */
    public WebElement getExtrasActiveBar() {
        return extrasActiveBar;
    }

    /**
     * @return the extrasAddNewButton
     */
    public WebElement getExtrasAddNewButton() {
        return extrasAddNewButton;
    }

    /**
     * @return the extraIsRequireMessage
     */
    public WebElement getExtraIsRequireMessage() {
        return extraIsRequireMessage;
    }

    /**
     * @return the cancellationFeesActiveBar
     */
    public WebElement getCancellationFeesActiveBarInactiveMode() {
        return cancellationFeesActiveBarInactiveMode;
    }

    /**
     * @return the cancellationFeesActiveBarActiveMode
     */
    public WebElement getCancellationFeesActiveBarActiveMode() {
        return cancellationFeesActiveBarActiveMode;
    }

    /**
     * @return the cancellationFeesAddNewbutton
     */
    public WebElement getCancellationFeesAddNewbutton() {
        return cancellationFeesAddNewbutton;
    }

    /**
     * @return the cancellationFeesRequreMessage
     */
    public WebElement getCancellationFeesRequreMessage() {
        return cancellationFeesRequreMessage;
    }

    /**
     * @return the legalCopyInput
     */
    public WebElement getLegalCopyInput() {
        return legalCopyInput;
    }

    /**
     * @return the miscProductActiveBar
     */
    public WebElement getMiscProductActiveBar() {
        return miscProductActiveBar;
    }

    /**
     * @return the miscProductAddNewButton
     */
    public WebElement getMiscProductAddNewButton() {
        return miscProductAddNewButton;
    }

    /**
     * @return the miscProductIsRequreMessage
     */
    public WebElement getMiscProductIsRequreMessage() {
        return miscProductIsRequreMessage;
    }

    /**
     * @return the miscProductNameInput
     */
    public WebElement getMiscProductTitleNameInput() {
        return miscProductTitleNameInput;
    }

    /**
     * @return the miscProductNameIsRequireMessage
     */
    public WebElement getMiscProductTitleNameIsRequireMessage() {
        return miscProductTitleNameIsRequireMessage;
    }

    /**
     * @return the stopOverActiveBar
     */
    public WebElement getStopOverActiveBar() {
        return stopOverActiveBar;
    }

    /**
     * @return the stopOverAddNewButton
     */
    public WebElement getStopOverAddNewButton() {
        return stopOverAddNewButton;
    }

    /**
     * @return the stopOverRequireMessage
     */
    public WebElement getStopOverRequireMessage() {
        return stopOverRequireMessage;
    }

    /**
     * @return the formNameInput
     */
    public WebElement getFormNameInput() {
        return formNameInput;
    }

    /**
     * @return the formNameISRequireMsg
     */
    public WebElement getFormNameISRequireMsg() {
        return formNameISRequireMsg;
    }

    /**
     * @return the formNameISRequireErrorMsg
     */
    public WebElement getFormNameISRequireErrorMsg() {
        return formNameISRequireErrorMsg;
    }

    /**
     * @return the partnerNameInput
     */
    public WebElement getPartnerNameInput() {
        return partnerNameInput;
    }

    /**
     * @return the partnerNameIsRequireMsg
     */
    public WebElement getPartnerNameIsRequireMsg() {
        return partnerNameIsRequireMsg;
    }

    /**
     * @return the partnerNameIsRequireErrorMsg
     */
    public WebElement getPartnerNameIsRequireErrorMsg() {
        return partnerNameIsRequireErrorMsg;
    }

    /**
     * @return the partnerLogoInput
     */
    public WebElement getPartnerLogoInput() {
        return partnerLogoInput;
    }

    /**
     * @return the tripNameInput
     */
    public WebElement getTripNameInput() {
        return tripNameInput;
    }

    /**
     * @return the tripNameIsRequireMsg
     */
    public WebElement getTripNameIsRequireMsg() {
        return tripNameIsRequireMsg;
    }

    /**
     * @return the tripNameIsRequireErrorMsg
     */
    public WebElement getTripNameIsRequireErrorMsg() {
        return tripNameIsRequireErrorMsg;
    }

    /**
     * @return the travelHeadingInput
     */
    public WebElement getTravelHeadingInput() {
        return travelHeadingInput;
    }

    /**
     * @return the travelHeadingIsRequireMsg
     */
    public WebElement getTravelHeadingIsRequireMsg() {
        return travelHeadingIsRequireMsg;
    }

    /**
     * @return the travelHeadingIsRequireErrorMsg
     */
    public WebElement getTravelHeadingIsRequireErrorMsg() {
        return travelHeadingIsRequireErrorMsg;
    }

    /**
     * @return the travelIntroTextInput
     */
    public WebElement getTravelIntroTextInput() {
        return travelIntroTextInput;
    }

    /**
     * @return the travelIntroIsRequireMsg
     */
    public WebElement getTravelIntroIsRequireMsg() {
        return travelIntroIsRequireMsg;
    }

    /**
     * @return the travelIntroIsRequireErrorMsg
     */
    public WebElement getTravelIntroIsRequireErrorMsg() {
        return travelIntroIsRequireErrorMsg;
    }

    /**
     * @return the finalDepositDateActiveBarInactiveMode
     */
    public WebElement getFinalDepositDateActiveBarInactiveMode() {
        return finalDepositDateActiveBarInactiveMode;
    }

    /**
     * @return the finalDepositDateActiveBarActiveMode
     */
    public WebElement getFinalDepositDateActiveBarActiveMode() {
        return finalDepositDateActiveBarActiveMode;
    }

    /**
     * @return the finalDepositDateCalendarDisableMode
     */
    public WebElement getFinalDepositDateCalendarDisableMode() {
        return finalDepositDateCalendarDisableMode;
    }

    /**
     * @return the finalDepositDateCalendarEnableMode
     */
    public WebElement getFinalDepositDateCalendarEnableMode() {
        return finalDepositDateCalendarEnableMode;
    }

    /**
     * @return the finalDepositDateCalendarDayButton
     */
    public WebElement getFinalDepositDateCalendarDayButton() {
        return finalDepositDateCalendarDayButton;
    }

    /**
     * @return the finalDepositDateDiscriptionDisableMode
     */
    public WebElement getFinalDepositDateDiscriptionDisableMode() {
        return finalDepositDateDiscriptionDisableMode;
    }

    /**
     * @return the finalDepositDateDiscriptionEnableMode
     */
    public WebElement getFinalDepositDateDiscriptionEnableMode() {
        return finalDepositDateDiscriptionEnableMode;
    }

    /**
     * @return the finalDepositRequireMsg
     */
    public WebElement getFinalDepositRequireMsg() {
        return finalDepositRequireMsg;
    }

    /**
     * @return the finalDepositRequireErrorMsg
     */
    public WebElement getFinalDepositRequireErrorMsg() {
        return finalDepositRequireErrorMsg;
    }

    /**
     * @return the finalPaymentDueDateActiveBarInactiveMode
     */
    public WebElement getFinalPaymentDueDateActiveBarInactiveMode() {
        return finalPaymentDueDateActiveBarInactiveMode;
    }

    /**
     * @return the finalPaymentDueDateActiveBarActiveMode
     */
    public WebElement getFinalPaymentDueDateActiveBarActiveMode() {
        return finalPaymentDueDateActiveBarActiveMode;
    }

    /**
     * @return the finalPaymentDueDateCalendarDisableMode
     */
    public WebElement getFinalPaymentDueDateCalendarDisableMode() {
        return finalPaymentDueDateCalendarDisableMode;
    }

    /**
     * @return the finalPaymentDueDateCalendarEnableMode
     */
    public WebElement getFinalPaymentDueDateCalendarEnableMode() {
        return finalPaymentDueDateCalendarEnableMode;
    }

    /**
     * @return the finalPaymentDueDateCalendarDayButton
     */
    public WebElement getFinalPaymentDueDateCalendarDayButton() {
        return finalPaymentDueDateCalendarDayButton;
    }

    /**
     * @return the finalPaymentDueDateDiscriptionDisableMode
     */
    public WebElement getFinalPaymentDueDateDiscriptionDisableMode() {
        return finalPaymentDueDateDiscriptionDisableMode;
    }

    /**
     * @return the finalPaymentDueDateDiscriptionEnableMode
     */
    public WebElement getFinalPaymentDueDateDiscriptionEnableMode() {
        return finalPaymentDueDateDiscriptionEnableMode;
    }

    /**
     * @return the finalPaymentDueDateRequireMsg
     */
    public WebElement getFinalPaymentDueDateRequireMsg() {
        return finalPaymentDueDateRequireMsg;
    }

    /**
     * @return the finalPaymentDueDateRequireErrorMsg
     */
    public WebElement getFinalPaymentDueDateRequireErrorMsg() {
        return finalPaymentDueDateRequireErrorMsg;
    }

    /**
     * @return the importantInstructionActiveBarInactiveMode
     */
    public WebElement getImportantInstructionActiveBarInactiveMode() {
        return importantInstructionActiveBarInactiveMode;
    }

    /**
     * @return the importantInstructionActiveBarActiveMode
     */
    public WebElement getImportantInstructionActiveBarActiveMode() {
        return importantInstructionActiveBarActiveMode;
    }

    /**
     * @return the importantInstructionInput
     */
    public WebElement getImportantInstructionInput() {
        return importantInstructionInput;
    }

    /**
     * @return the importantInstructionRequireMsg
     */
    public WebElement getImportantInstructionRequireMsg() {
        return importantInstructionRequireMsg;
    }

    /**
     * @return the importantInstructionRequireErrorMsg
     */
    public WebElement getImportantInstructionRequireErrorMsg() {
        return importantInstructionRequireErrorMsg;
    }

    /**
     * @return the passengerInformationSelect
     */
    public WebElement getPassengerInformationSelect() {
        return passengerInformationSelect;
    }

    /**
     * @return the middleNameEnableDropdown
     */
    public WebElement getMiddleNameEnableDropdown() {
        return middleNameEnableDropdown;
    }

    /**
     * @return the middleNameConfirmation
     */
    public WebElement getMiddleNameConfirmation() {
        return middleNameConfirmation;
    }

    /**
     * @return the middleNameDisableDropdown
     */
    public WebElement getMiddleNameDisableDropdown() {
        return middleNameDisableDropdown;
    }

    /**
     * @return the passportNumberEnableDropdown
     */
    public WebElement getPassportNumberEnableDropdown() {
        return passportNumberEnableDropdown;
    }

    /**
     * @return the passportNumberConfirmation
     */
    public WebElement getPassportNumberConfirmation() {
        return passportNumberConfirmation;
    }

    /**
     * @return the passportNumberDisableDropdown
     */
    public WebElement getPassportNumberDisableDropdown() {
        return passportNumberDisableDropdown;
    }

    /**
     * @return the dateOfBirthEnableDropdown
     */
    public WebElement getDateOfBirthEnableDropdown() {
        return dateOfBirthEnableDropdown;
    }

    /**
     * @return the dateOfBirthConfirmation
     */
    public WebElement getDateOfBirthConfirmation() {
        return dateOfBirthConfirmation;
    }

    /**
     * @return the dateOfBirthDisableDropdown
     */
    public WebElement getDateOfBirthDisableDropdown() {
        return dateOfBirthDisableDropdown;
    }

    /**
     * @return the phoneNumberEnableDropdown
     */
    public WebElement getPhoneNumberEnableDropdown() {
        return phoneNumberEnableDropdown;
    }

    /**
     * @return the phoneNumberConfirmation
     */
    public WebElement getPhoneNumberConfirmation() {
        return phoneNumberConfirmation;
    }

    /**
     * @return the phoneNumberDisableDropdown
     */
    public WebElement getPhoneNumberDisableDropdown() {
        return phoneNumberDisableDropdown;
    }

    /**
     * @return the middleNameDeleteButton
     */
    public WebElement getMiddleNameDeleteButton() {
        return middleNameDeleteButton;
    }

    /**
     * @return the passportDeleteButton
     */
    public WebElement getPassportDeleteButton() {
        return passportDeleteButton;
    }

    /**
     * @return the dateOfBirthDeleteButton
     */
    public WebElement getDateOfBirthDeleteButton() {
        return dateOfBirthDeleteButton;
    }

    /**
     * @return the phoneNumberDeleteButton
     */
    public WebElement getPhoneNumberDeleteButton() {
        return phoneNumberDeleteButton;
    }

    /**
     * @return the addressSelect
     */
    public WebElement getAddressSelect() {
        return addressSelect;
    }

    /**
     * @return the addressLineOneEnableDropdown
     */
    public WebElement getAddressLineOneEnableDropdown() {
        return addressLineOneEnableDropdown;
    }

    /**
     * @return the addressLineOneConfirmation
     */
    public WebElement getAddressLineOneConfirmation() {
        return addressLineOneConfirmation;
    }

    /**
     * @return the addressLineOneDisableDropdown
     */
    public WebElement getAddressLineOneDisableDropdown() {
        return addressLineOneDisableDropdown;
    }

    /**
     * @return the addressLineTwoEnableDropdown
     */
    public WebElement getAddressLineTwoEnableDropdown() {
        return addressLineTwoEnableDropdown;
    }

    /**
     * @return the addressLineTwoConfirmation
     */
    public WebElement getAddressLineTwoConfirmation() {
        return addressLineTwoConfirmation;
    }

    /**
     * @return the addressLineTwoDisableDropdown
     */
    public WebElement getAddressLineTwoDisableDropdown() {
        return addressLineTwoDisableDropdown;
    }

    /**
     * @return the cityEnableDropdown
     */
    public WebElement getCityEnableDropdown() {
        return cityEnableDropdown;
    }

    /**
     * @return the cityConfirmation
     */
    public WebElement getCityConfirmation() {
        return cityConfirmation;
    }

    /**
     * @return the cityDisableDropdown
     */
    public WebElement getCityDisableDropdown() {
        return cityDisableDropdown;
    }

    /**
     * @return the stateEnableDropdown
     */
    public WebElement getStateEnableDropdown() {
        return stateEnableDropdown;
    }

    /**
     * @return the stateConfirmation
     */
    public WebElement getStateConfirmation() {
        return stateConfirmation;
    }

    /**
     * @return the stateDisableDropdown
     */
    public WebElement getStateDisableDropdown() {
        return stateDisableDropdown;
    }

    /**
     * @return the zipCodeEnableDropdown
     */
    public WebElement getZipCodeEnableDropdown() {
        return zipCodeEnableDropdown;
    }

    /**
     * @return the zipCodeConfirmation
     */
    public WebElement getZipCodeConfirmation() {
        return zipCodeConfirmation;
    }

    /**
     * @return the zipCodeDisableDropdown
     */
    public WebElement getZipCodeDisableDropdown() {
        return zipCodeDisableDropdown;
    }

    /**
     * @return the countryEnableDropdown
     */
    public WebElement getCountryEnableDropdown() {
        return countryEnableDropdown;
    }

    /**
     * @return the countryConfirmation
     */
    public WebElement getCountryConfirmation() {
        return countryConfirmation;
    }

    /**
     * @return the countyDisableDropdown
     */
    public WebElement getCountyDisableDropdown() {
        return countyDisableDropdown;
    }

    /**
     * @return the seatPreferenceActiveBarActiveMOde
     */
    public WebElement getSeatPreferenceActiveBarActiveMOde() {
        return seatPreferenceActiveBarActiveMOde;
    }

    /**
     * @return the seatPreferenceActiveBarInactiveMOde
     */
    public WebElement getSeatPreferenceActiveBarInactiveMOde() {
        return seatPreferenceActiveBarInactiveMOde;
    }

    /**
     * @return the seatPreferenceSelect
     */
    public WebElement getSeatPreferenceSelect() {
        return seatPreferenceSelect;
    }

    /**
     * @return the aisleSeatEnableDropdown
     */
    public WebElement getAisleSeatEnableDropdown() {
        return aisleSeatEnableDropdown;
    }

    /**
     * @return the aisleSeatConfirmation
     */
    public WebElement getAisleSeatConfirmation() {
        return aisleSeatConfirmation;
    }

    /**
     * @return the aisleSeatDeleteButton
     */
    public WebElement getAisleSeatDeleteButton() {
        return aisleSeatDeleteButton;
    }

    /**
     * @return the aisleSeatDisableDropdown
     */
    public WebElement getAisleSeatDisableDropdown() {
        return aisleSeatDisableDropdown;
    }

    /**
     * @return the windowSeatEnableDropdown
     */
    public WebElement getWindowSeatEnableDropdown() {
        return windowSeatEnableDropdown;
    }

    /**
     * @return the windowSeatConfirmation
     */
    public WebElement getWindowSeatConfirmation() {
        return windowSeatConfirmation;
    }

    /**
     * @return the windowSeatDeleteButton
     */
    public WebElement getWindowSeatDeleteButton() {
        return windowSeatDeleteButton;
    }

    /**
     * @return the windowSeatDisableDropdown
     */
    public WebElement getWindowSeatDisableDropdown() {
        return windowSeatDisableDropdown;
    }

    /**
     * @return the seatPrefenceReqiureMessage
     */
    public WebElement getSeatPrefenceReqiureMessage() {
        return seatPrefenceReqiureMessage;
    }

    /**
     * @return the mealPreferenceActiveBarInactiveMode
     */
    public WebElement getMealPreferenceActiveBarInactiveMode() {
        return mealPreferenceActiveBarInactiveMode;
    }

    /**
     * @return the mealPreferenceActiveBarActiveMode
     */
    public WebElement getMealPreferenceActiveBarActiveMode() {
        return mealPreferenceActiveBarActiveMode;
    }

    /**
     * @return the mealPreferenceRequireMessage
     */
    public WebElement getMealPreferenceRequireMessage() {
        return mealPreferenceRequireMessage;
    }

    /**
     * @return the mealPreferenceSelect
     */
    public WebElement getMealPreferenceSelect() {
        return mealPreferenceSelect;
    }

    /**
     * @return the vegetarianMealConfirmation
     */
    public WebElement getVegetarianMealConfirmation() {
        return vegetarianMealConfirmation;
    }

    /**
     * @return the vegetarianEnableDropdown
     */
    public WebElement getVegetarianEnableDropdown() {
        return vegetarianEnableDropdown;
    }

    /**
     * @return the vegetarianegetarianDisableDropdown
     */
    public WebElement getVegetarianegetarianDisableDropdown() {
        return vegetarianegetarianDisableDropdown;
    }

    /**
     * @return the diabeticEnableDropdown
     */
    public WebElement getDiabeticEnableDropdown() {
        return diabeticEnableDropdown;
    }

    /**
     * @return the diabeticDisableDropdown
     */
    public WebElement getDiabeticDisableDropdown() {
        return diabeticDisableDropdown;
    }

    /**
     * @return the kosherEnableDropdown
     */
    public WebElement getKosherEnableDropdown() {
        return kosherEnableDropdown;
    }

    /**
     * @return the kocherDisableDropdown
     */
    public WebElement getKocherDisableDropdown() {
        return kocherDisableDropdown;
    }

    /**
     * @return the veganEnableDropdown
     */
    public WebElement getVeganEnableDropdown() {
        return veganEnableDropdown;
    }

    /**
     * @return the veganDisableDropdown
     */
    public WebElement getVeganDisableDropdown() {
        return veganDisableDropdown;
    }

    /**
     * @return the otherEnableDropdown
     */
    public WebElement getOtherEnableDropdown() {
        return otherEnableDropdown;
    }

    /**
     * @return the othersdisableDropdown
     */
    public WebElement getOthersdisableDropdown() {
        return othersdisableDropdown;
    }

    /**
     * @return the diabeticMealConfirmation
     */
    public WebElement getDiabeticMealConfirmation() {
        return diabeticMealConfirmation;
    }

    /**
     * @return the kosherMealConfirmation
     */
    public WebElement getKosherMealConfirmation() {
        return kosherMealConfirmation;
    }

    /**
     * @return the veganMealConfirmation
     */
    public WebElement getVeganMealConfirmation() {
        return veganMealConfirmation;
    }

    /**
     * @return the otherMealConfirmation
     */
    public WebElement getOtherMealConfirmation() {
        return otherMealConfirmation;
    }

    /**
     * @return the vegetarianMealDeleteButton
     */
    public WebElement getVegetarianMealDeleteButton() {
        return vegetarianMealDeleteButton;
    }

    /**
     * @return the diabeticMealDeleteButton
     */
    public WebElement getDiabeticMealDeleteButton() {
        return diabeticMealDeleteButton;
    }

    /**
     * @return the kosherMealDeleteButton
     */
    public WebElement getKosherMealDeleteButton() {
        return kosherMealDeleteButton;
    }

    /**
     * @return the veganMealDeleteButton
     */
    public WebElement getVeganMealDeleteButton() {
        return veganMealDeleteButton;
    }

    /**
     * @return the otherMealDeleteButton
     */
    public WebElement getOtherMealDeleteButton() {
        return otherMealDeleteButton;
    }

    /**
     * @return the addressLineOneDeleteButton
     */
    public WebElement getAddressLineOneDeleteButton() {
        return addressLineOneDeleteButton;
    }

    /**
     * @return the addressLineTwoDeleteButton
     */
    public WebElement getAddressLineTwoDeleteButton() {
        return addressLineTwoDeleteButton;
    }

    /**
     * @return the cityDeleteButton
     */
    public WebElement getCityDeleteButton() {
        return cityDeleteButton;
    }

    /**
     * @return the stateDeleteButton
     */
    public WebElement getStateDeleteButton() {
        return stateDeleteButton;
    }

    /**
     * @return the zipCodeDeleteButton
     */
    public WebElement getZipCodeDeleteButton() {
        return zipCodeDeleteButton;
    }

    /**
     * @return the countryDeleteButton
     */
    public WebElement getCountryDeleteButton() {
        return countryDeleteButton;
    }

    /**
     * @return the passengerInformationHeading
     */
    public WebElement getPassengerInformationHeading() {
        return passengerInformationHeading;
    }

    /**
     * @return the addressHeading
     */
    public WebElement getAddressHeading() {
        return addressHeading;
    }

    /**
     * 
     * @return the flightAmountActiveBarInactiveMode
     */
    public WebElement getFlightAmountActiveBarInactiveMode() {
        return flightAmountActiveBarInactiveMode;
    }

    /**
     * @return the flightAmountActiveBarActiveMode
     */
    public WebElement getFlightAmountActiveBarActiveMode() {
        return flightAmountActiveBarActiveMode;
    }

    /**
     * @return the flightAmountInputDisableMode
     */
    public WebElement getFlightAmountInputDisableMode() {
        return flightAmountInputDisableMode;
    }

    /**
     * @return the flightAmountInputEnableMode
     */
    public WebElement getFlightAmountInputEnableMode() {
        return flightAmountInputEnableMode;
    }

    /**
     * @return the atleastOneCostRequireMessageForFlight
     */
    public WebElement getAtleastOneCostRequireMessageForFlight() {
        return atleastOneCostRequireMessageForFlight;
    }

    /**
     * @return the flightAmountRequireMessage
     */
    public WebElement getFlightAmountRequireMessage() {
        return flightAmountRequireMessage;
    }

    /**
     * @return the airFareAmountActiveBarInactiveMode
     */
    public WebElement getAirFareAmountActiveBarInactiveMode() {
        return airFareAmountActiveBarInactiveMode;
    }

    /**
     * @return the airFareAmountActiveBarActiveMode
     */
    public WebElement getAirFareAmountActiveBarActiveMode() {
        return airFareAmountActiveBarActiveMode;
    }

    /**
     * @return the airFareAmountInputDisableMode
     */
    public WebElement getAirFareAmountInputDisableMode() {
        return airFareAmountInputDisableMode;
    }

    /**
     * @return the airFareAmountInputEnableMode
     */
    public WebElement getAirFareAmountInputEnableMode() {
        return airFareAmountInputEnableMode;
    }

    /**
     * @return the airFareAmountRequireMessage
     */
    public WebElement getAirFareAmountRequireMessage() {
        return airFareAmountRequireMessage;
    }

    /**
     * @return the taxesAmountActiveBarInactiveMode
     */
    public WebElement getTaxesAmountActiveBarInactiveMode() {
        return taxesAmountActiveBarInactiveMode;
    }

    /**
     * @return the taxesAmountActiveBarActiveMode
     */
    public WebElement getTaxesAmountActiveBarActiveMode() {
        return taxesAmountActiveBarActiveMode;
    }

    /**
     * @return the taxesAmountInputDisableMode
     */
    public WebElement getTaxesAmountInputDisableMode() {
        return taxesAmountInputDisableMode;
    }

    /**
     * @return the taxesAmountInputEnableMode
     */
    public WebElement getTaxesAmountInputEnableMode() {
        return taxesAmountInputEnableMode;
    }

    /**
     * @return the taxesAmountRequireMessage
     */
    public WebElement getTaxesAmountRequireMessage() {
        return taxesAmountRequireMessage;
    }

    /**
     * @return the termsAndConditionActiveBarInactiveMode
     */
    public WebElement getTermsAndConditionActiveBarInactiveMode() {
        return termsAndConditionActiveBarInactiveMode;
    }

    /**
     * @return the termsAndConditionActiveBarActiveMode
     */
    public WebElement getTermsAndConditionActiveBarActiveMode() {
        return termsAndConditionActiveBarActiveMode;
    }

    /**
     * @return the termsAndConditionInputDisableMode
     */
    public WebElement getTermsAndConditionInputDisableMode() {
        return termsAndConditionInputDisableMode;
    }

    /**
     * @return the termsAndConditionInputEnableMode
     */
    public WebElement getTermsAndConditionInputEnableMode() {
        return termsAndConditionInputEnableMode;
    }

    /**
     * @return the termsAndConditionRequireMessage
     */
    public WebElement getTermsAndConditionRequireMessage() {
        return termsAndConditionRequireMessage;
    }

    /**
     * @return the accommodationAmountActiveBarInactiveMode
     */
    public WebElement getAccommodationAmountActiveBarInactiveMode() {
        return accommodationAmountActiveBarInactiveMode;
    }

    /**
     * @return the accommodationAmountActiveBarActiveMode
     */
    public WebElement getAccommodationAmountActiveBarActiveMode() {
        return accommodationAmountActiveBarActiveMode;
    }

    /**
     * @return the accommodationAmountInputDisableMode
     */
    public WebElement getAccommodationAmountInputDisableMode() {
        return accommodationAmountInputDisableMode;
    }

    /**
     * @return the accommodationAmountInputEnableMode
     */
    public WebElement getAccommodationAmountInputEnableMode() {
        return accommodationAmountInputEnableMode;
    }

    /**
     * @return the atleastOneCostRequireMessageForAccommodation
     */
    public WebElement getAtleastOneCostRequireMessageForAccommodation() {
        return atleastOneCostRequireMessageForAccommodation;
    }

    /**
     * @return the accommodationAmountRequireMessage
     */
    public WebElement getAccommodationAmountRequireMessage() {
        return accommodationAmountRequireMessage;
    }

    /**
     * @return the transferAmountActiveBarInactiveMode
     */
    public WebElement getTransferAmountActiveBarInactiveMode() {
        return transferAmountActiveBarInactiveMode;
    }

    /**
     * @return the tranferAmountActiveBarActiveMode
     */
    public WebElement getTranferAmountActiveBarActiveMode() {
        return tranferAmountActiveBarActiveMode;
    }

    /**
     * @return the transferAmountInputDisableMode
     */
    public WebElement getTransferAmountInputDisableMode() {
        return transferAmountInputDisableMode;
    }

    /**
     * @return the transferAmountInputEnableMode
     */
    public WebElement getTransferAmountInputEnableMode() {
        return transferAmountInputEnableMode;
    }

    /**
     * @return the atleastOneCostRequireMessageForTranfer
     */
    public WebElement getAtleastOneCostRequireMessageForTranfer() {
        return atleastOneCostRequireMessageForTranfer;
    }

    /**
     * @return the tranferAmountRequireMessage
     */
    public WebElement getTransferAmountRequireMessage() {
        return tranferAmountRequireMessage;
    }

    /**
     * @return the otherAmountActiveBarInactiveMode
     */
    public WebElement getOtherAmountActiveBarInactiveMode() {
        return otherAmountActiveBarInactiveMode;
    }

    /**
     * @return the otherAmountActiveBarActiveMode
     */
    public WebElement getOtherAmountActiveBarActiveMode() {
        return otherAmountActiveBarActiveMode;
    }

    /**
     * @return the otherAmountInputDisableMode
     */
    public WebElement getOtherAmountInputDisableMode() {
        return otherAmountInputDisableMode;
    }

    /**
     * @return the otherAmountInputEnableMode
     */
    public WebElement getOtherAmountInputEnableMode() {
        return otherAmountInputEnableMode;
    }

    /**
     * @return the atleastOneCostRequireMessageForOther
     */
    public WebElement getAtleastOneCostRequireMessageForOther() {
        return atleastOneCostRequireMessageForOther;
    }

    /**
     * @return the otherAmountRequireMessage
     */
    public WebElement getOtherAmountRequireMessage() {
        return otherAmountRequireMessage;
    }

    /**
     * @return the depositAmountActiveBarInactiveMode
     */
    public WebElement getDepositAmountActiveBarInactiveMode() {
        return depositAmountActiveBarInactiveMode;
    }

    /**
     * @return the depositAmountActiveBarActiveMode
     */
    public WebElement getDepositAmountActiveBarActiveMode() {
        return depositAmountActiveBarActiveMode;
    }

    /**
     * @return the depositAmountInputDisableMode
     */
    public WebElement getDepositAmountInputDisableMode() {
        return depositAmountInputDisableMode;
    }

    /**
     * @return the depositAmountInputEnableMode
     */
    public WebElement getDepositAmountInputEnableMode() {
        return depositAmountInputEnableMode;
    }

    /**
     * @return the depositAmountRequireMessage
     */
    public WebElement getDepositAmountRequireMessage() {
        return depositAmountRequireMessage;
    }

    /**
     * @return the balanceAmountActiveBarInactiveMode
     */
    public WebElement getBalanceAmountActiveBarInactiveMode() {
        return balanceAmountActiveBarInactiveMode;
    }

    /**
     * @return the balanceAmountActiveBarActiveMode
     */
    public WebElement getBalanceAmountActiveBarActiveMode() {
        return balanceAmountActiveBarActiveMode;
    }

    /**
     * @return the balanceAmountInputDisableMode
     */
    public WebElement getBalanceAmountInputDisableMode() {
        return balanceAmountInputDisableMode;
    }

    /**
     * @return the balanceAmountRequireMessage
     */
    public WebElement getBalanceAmountRequireMessage() {
        return balanceAmountRequireMessage;
    }

    /**
     * @return the flightCostHeading
     */
    public WebElement getFlightCostHeading() {
        return flightCostHeading;
    }

    /**
     * @return the airFareCostHeading
     */
    public WebElement getAirFareCostHeading() {
        return airFareCostHeading;
    }

    /**
     * @return the taxesCostHeading
     */
    public WebElement getTaxesCostHeading() {
        return taxesCostHeading;
    }

    /**
     * @return the termsAndConditionCostHeading
     */
    public WebElement getTermsAndConditionCostHeading() {
        return termsAndConditionCostHeading;
    }

    /**
     * @return the accommodationCostHeading
     */
    public WebElement getAccommodationCostHeading() {
        return accommodationCostHeading;
    }

    /**
     * @return the transferCostHeading
     */
    public WebElement getTransferCostHeading() {
        return transferCostHeading;
    }

    /**
     * @return the otherCostHeading
     */
    public WebElement getOtherCostHeading() {
        return otherCostHeading;
    }

    /**
     * @return the depositCostHeading
     */
    public WebElement getDepositCostHeading() {
        return depositCostHeading;
    }

    /**
     * @return the balanceCostHeading
     */
    public WebElement getBalanceCostHeading() {
        return balanceCostHeading;
    }

    /**
     * @return the tranferAmountRequireMessage
     */
    public WebElement getTranferAmountRequireMessage() {
        return tranferAmountRequireMessage;
    }

    /**
     * @return the seatPreferenceHeading
     */
    public WebElement getSeatPreferenceHeading() {
        return seatPreferenceHeading;
    }

    /**
     * @return the mealPreferenceHeading
     */
    public WebElement getMealPreferenceHeading() {
        return mealPreferenceHeading;

    }

    /**
     * @return the calendarClearButton
     */
    public WebElement getCalendarClearButton() {
        return calendarClearButton;
    }

    /**
     * @return the calendarTodayButton
     */
    public WebElement getCalendarTodayButton() {
        return calendarTodayButton;
    }

    /**
     * @return the calendarLightBox
     */
    public WebElement getCalendarLightBox() {
        return calendarLightBox;
    }

    /**
     * @return the flightsAreRequireErrorMsg
     */
    public WebElement getFlightsAreRequireErrorMsg() {
        return flightsAreRequireErrorMsg;
    }

    /**
     * @return the accommodationIsRequireErrorMessage
     */
    public WebElement getAccommodationIsRequireErrorMessage() {
        return accommodationIsRequireErrorMessage;
    }

    /**
     * @return the othersDetailsRequireErrorMessage
     */
    public WebElement getOthersDetailsRequireErrorMessage() {
        return othersDetailsRequireErrorMessage;
    }

    /**
     * @return the cancellationFeesRequreErrorMessage
     */
    public WebElement getCancellationFeesRequreErrorMessage() {
        return cancellationFeesRequreErrorMessage;
    }

    /**
     * @return the extraIsRequireErrorMessage
     */
    public WebElement getExtraIsRequireErrorMessage() {
        return extraIsRequireErrorMessage;
    }

    /**
     * @return the miscProductIsRequreErrorMessage
     */
    public WebElement getMiscProductIsRequreErrorMessage() {
        return miscProductIsRequreErrorMessage;
    }

    /**
     * @return the miscProductTitleNameIsRequireErrorMessage
     */
    public WebElement getMiscProductTitleNameIsRequireErrorMessage() {
        return miscProductTitleNameIsRequireErrorMessage;
    }

    /**
     * @return the stopOverRequireErrorMessage
     */
    public WebElement getStopOverRequireErrorMessage() {
        return stopOverRequireErrorMessage;
    }

    /**
     * @return the seatPrefenceReqiureErrorMessage
     */
    public WebElement getSeatPrefenceReqiureErrorMessage() {
        return seatPrefenceReqiureErrorMessage;
    }

    /**
     * @return the mealPreferenceRequireErrorMessage
     */
    public WebElement getMealPreferenceRequireErrorMessage() {
        return mealPreferenceRequireErrorMessage;
    }

    /**
     * @return the flightAmountRequireErrorMessage
     */
    public WebElement getFlightAmountRequireErrorMessage() {
        return flightAmountRequireErrorMessage;
    }

    /**
     * @return the airFareAmountRequireErrorMessage
     */
    public WebElement getAirFareAmountRequireErrorMessage() {
        return airFareAmountRequireErrorMessage;
    }

    /**
     * @return the taxesAmountRequireErrorMessage
     */
    public WebElement getTaxesAmountRequireErrorMessage() {
        return taxesAmountRequireErrorMessage;
    }

    /**
     * @return the termsAndConditionRequireErrorMessage
     */
    public WebElement getTermsAndConditionRequireErrorMessage() {
        return termsAndConditionRequireErrorMessage;
    }

    /**
     * @return the accommodationAmountRequireErrorMessage
     */
    public WebElement getAccommodationAmountRequireErrorMessage() {
        return accommodationAmountRequireErrorMessage;
    }

    /**
     * @return the tranferAmountRequireErrorMessage
     */
    public WebElement getTranferAmountRequireErrorMessage() {
        return tranferAmountRequireErrorMessage;
    }

    /**
     * @return the otherAmountRequireErrorMessage
     */
    public WebElement getOtherAmountRequireErrorMessage() {
        return otherAmountRequireErrorMessage;
    }

    /**
     * @return the depositAmountRequireErrorMessage
     */
    public WebElement getDepositAmountRequireErrorMessage() {
        return depositAmountRequireErrorMessage;
    }

    /**
     * @return the balanceAmountRequireErrorMessage
     */
    public WebElement getBalanceAmountRequireErrorMessage() {
        return balanceAmountRequireErrorMessage;
    }

    /**
     * @return the transferRequireErrorMessage
     */
    public WebElement getTransferRequireErrorMessage() {
        return transferRequireErrorMessage;
    }

    /**
     * @return the atleastOneCostRequireErrorMessageForFlight
     */
    public WebElement getAtleastOneCostRequireErrorMessageForFlight() {
        return atleastOneCostRequireErrorMessageForFlight;
    }

    /**
     * @return the atleastOneCostRequireErrorMessageForAccommodation
     */
    public WebElement getAtleastOneCostRequireErrorMessageForAccommodation() {
        return atleastOneCostRequireErrorMessageForAccommodation;
    }

    /**
     * @return the atleastOneCostRequireErrorMessageForTranfer
     */
    public WebElement getAtleastOneCostRequireErrorMessageForTranfer() {
        return atleastOneCostRequireErrorMessageForTranfer;
    }

    /**
     * @return the atleastOneCostRequireErrorMessageForOther
     */
    public WebElement getAtleastOneCostRequireErrorMessageForOther() {
        return atleastOneCostRequireErrorMessageForOther;
    }

    /**
     * @return the extraActivebarActiveMode
     */
    public WebElement getExtraActivebarActiveMode() {
        return extraActivebarActiveMode;
    }

    /**
     * @return the stopOverActiveBarActiveMOde
     */
    public WebElement getStopOverActiveBarActiveMOde() {
        return stopOverActiveBarActiveMOde;
    }

    /**
     * @return the quoteActiveBarActiveMode
     */
    public WebElement getQuoteActiveBarActiveMode() {
        return quoteActiveBarActiveMode;
    }

    /**
     * @return the quoteActiveBarInactiveMode
     */
    public WebElement getQuoteActiveBarInactiveMode() {
        return quoteActiveBarInactiveMode;
    }

    /**
     * @return the createFormAfterEditButton
     */
    public WebElement getCreateFormAfterEditButton() {
        return createFormAfterEditButton;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormPageElements [addNewFormHeader=" + addNewFormHeader + ", formName=" + formName + ", transferAddNewButton="
                + transferAddNewButton + ", transferActiveBarInactiveMode=" + transferActiveBarInactiveMode + ", transferActiveBarActiveMode="
                + transferActiveBarActiveMode + ", conformationForFirstTrasfer=" + conformationForFirstTrasfer + ", conformationForSecondTrasfer="
                + conformationForSecondTrasfer + ", transferEditButton=" + transferEditButton + ", transferRequireMessage=" + transferRequireMessage
                + ", transferRequireErrorMessage=" + transferRequireErrorMessage + ", firstTransferActiveBarInactiveMode="
                + firstTransferActiveBarInactiveMode + ", firstTransferActiveBarActiveMode=" + firstTransferActiveBarActiveMode
                + ", gettingThereActiveBarActiveMode=" + gettingThereActiveBarActiveMode + ", gettingThereActiveBarInactiveMode="
                + gettingThereActiveBarInactiveMode + ", gettingAroundActiveBarActiveMode=" + gettingAroundActiveBarActiveMode
                + ", gettingAroundActiveBarInactiveMode=" + gettingAroundActiveBarInactiveMode + ", gettingBackActiveBarActiveMode="
                + gettingBackActiveBarActiveMode + ", gettingBackActiveBarInactiveMode=" + gettingBackActiveBarInactiveMode + ", textGettingThere="
                + textGettingThere + ", gettingThereEditButton=" + gettingThereEditButton + ", textGettingAround=" + textGettingAround
                + ", gettingAroundEditButton=" + gettingAroundEditButton + ", textGettingBack=" + textGettingBack + ", gettingBackEditButton="
                + gettingBackEditButton + ", airportCodeDisplayValidation=" + airportCodeDisplayValidation + ", flightsActiveBarInactiveMode="
                + flightsActiveBarInactiveMode + ", flightsActiveBarActiveMode=" + flightsActiveBarActiveMode + ", gettingThereActiveBarDisableMode="
                + gettingThereActiveBarDisableMode + ", gettingAroundActiveBarDisableMode=" + gettingAroundActiveBarDisableMode
                + ", gettingBackActiveBarDisableMode=" + gettingBackActiveBarDisableMode + ", flightsAreReqMsg=" + flightsAreReqMsg
                + ", flightsAreRequireErrorMsg=" + flightsAreRequireErrorMsg + ", airportCodeDisplayValidationForGettingAround="
                + airportCodeDisplayValidationForGettingAround + ", airportCodeDisplayValidationForGettingThere="
                + airportCodeDisplayValidationForGettingThere + ", airportCodeDisplayValidationForGettingBack="
                + airportCodeDisplayValidationForGettingBack + ", accommodationActiveBarInactiveMode=" + accommodationActiveBarInactiveMode
                + ", accommodationActiveBarActiveMode=" + accommodationActiveBarActiveMode + ", accommodationAddNewButton="
                + accommodationAddNewButton + ", accommodationIsRequireMessage=" + accommodationIsRequireMessage
                + ", accommodationIsRequireErrorMessage=" + accommodationIsRequireErrorMessage + ", firstAccommodationEditButton="
                + firstAccommodationEditButton + ", firstAccommodationActiveBarActiveMode=" + firstAccommodationActiveBarActiveMode
                + ", firstAccommodationActiveBarInactiveMode=" + firstAccommodationActiveBarInactiveMode + ", confirmationForFirstAccommodation="
                + confirmationForFirstAccommodation + ", secondAccommodationEditButton=" + secondAccommodationEditButton
                + ", secondAccommodationActiveBarActiveMode=" + secondAccommodationActiveBarActiveMode + ", secondAccommodationActiveBarInactiveMode="
                + secondAccommodationActiveBarInactiveMode + ", confirmationForSecondAccommodation=" + confirmationForSecondAccommodation
                + ", othersActiveButtonInactiveMode=" + othersActiveButtonInactiveMode + ", othersActiveButtonActiveMode="
                + othersActiveButtonActiveMode + ", othersAddNewButton=" + othersAddNewButton + ", othersDetailsRequireMessage="
                + othersDetailsRequireMessage + ", othersDetailsRequireErrorMessage=" + othersDetailsRequireErrorMessage
                + ", cancellationFeesActiveBarInactiveMode=" + cancellationFeesActiveBarInactiveMode + ", cancellationFeesActiveBarActiveMode="
                + cancellationFeesActiveBarActiveMode + ", cancellationFeesAddNewbutton=" + cancellationFeesAddNewbutton
                + ", cancellationFeesRequreMessage=" + cancellationFeesRequreMessage + ", cancellationFeesRequreErrorMessage="
                + cancellationFeesRequreErrorMessage + ", legalCopyInput=" + legalCopyInput + ", extrasActiveBar=" + extrasActiveBar
                + ", extrasAddNewButton=" + extrasAddNewButton + ", extraActivebarActiveMode=" + extraActivebarActiveMode + ", extraIsRequireMessage="
                + extraIsRequireMessage + ", extraIsRequireErrorMessage=" + extraIsRequireErrorMessage + ", miscProductActiveBar="
                + miscProductActiveBar + ", miscProductAddNewButton=" + miscProductAddNewButton + ", miscProductIsRequreMessage="
                + miscProductIsRequreMessage + ", miscProductIsRequreErrorMessage=" + miscProductIsRequreErrorMessage + ", miscProductTitleNameInput="
                + miscProductTitleNameInput + ", miscProductTitleNameIsRequireMessage=" + miscProductTitleNameIsRequireMessage
                + ", miscProductTitleNameIsRequireErrorMessage=" + miscProductTitleNameIsRequireErrorMessage + ", stopOverActiveBar="
                + stopOverActiveBar + ", stopOverAddNewButton=" + stopOverAddNewButton + ", stopOverActiveBarActiveMOde="
                + stopOverActiveBarActiveMOde + ", stopOverRequireMessage=" + stopOverRequireMessage + ", stopOverRequireErrorMessage="
                + stopOverRequireErrorMessage + ", createFormButton=" + createFormButton + ", cancelButton=" + cancelButton
                + ", createFormAfterEditButton=" + createFormAfterEditButton + ", formNameInput=" + formNameInput + ", formNameISRequireMsg="
                + formNameISRequireMsg + ", formNameISRequireErrorMsg=" + formNameISRequireErrorMsg + ", partnerNameInput=" + partnerNameInput
                + ", partnerNameIsRequireMsg=" + partnerNameIsRequireMsg + ", partnerNameIsRequireErrorMsg=" + partnerNameIsRequireErrorMsg
                + ", partnerLogoInput=" + partnerLogoInput + ", tripNameInput=" + tripNameInput + ", tripNameIsRequireMsg=" + tripNameIsRequireMsg
                + ", tripNameIsRequireErrorMsg=" + tripNameIsRequireErrorMsg + ", travelHeadingInput=" + travelHeadingInput
                + ", travelHeadingIsRequireMsg=" + travelHeadingIsRequireMsg + ", travelHeadingIsRequireErrorMsg=" + travelHeadingIsRequireErrorMsg
                + ", travelIntroTextInput=" + travelIntroTextInput + ", travelIntroIsRequireMsg=" + travelIntroIsRequireMsg
                + ", travelIntroIsRequireErrorMsg=" + travelIntroIsRequireErrorMsg + ", finalDepositDateActiveBarInactiveMode="
                + finalDepositDateActiveBarInactiveMode + ", finalDepositDateActiveBarActiveMode=" + finalDepositDateActiveBarActiveMode
                + ", finalDepositDateCalendarDisableMode=" + finalDepositDateCalendarDisableMode + ", finalDepositDateCalendarEnableMode="
                + finalDepositDateCalendarEnableMode + ", finalDepositDateCalendarDayButton=" + finalDepositDateCalendarDayButton
                + ", finalDepositDateDiscriptionDisableMode=" + finalDepositDateDiscriptionDisableMode + ", finalDepositDateDiscriptionEnableMode="
                + finalDepositDateDiscriptionEnableMode + ", finalDepositRequireMsg=" + finalDepositRequireMsg + ", finalDepositRequireErrorMsg="
                + finalDepositRequireErrorMsg + ", finalPaymentDueDateActiveBarInactiveMode=" + finalPaymentDueDateActiveBarInactiveMode
                + ", finalPaymentDueDateActiveBarActiveMode=" + finalPaymentDueDateActiveBarActiveMode + ", finalPaymentDueDateCalendarDisableMode="
                + finalPaymentDueDateCalendarDisableMode + ", finalPaymentDueDateCalendarEnableMode=" + finalPaymentDueDateCalendarEnableMode
                + ", finalPaymentDueDateCalendarDayButton=" + finalPaymentDueDateCalendarDayButton + ", finalPaymentDueDateDiscriptionDisableMode="
                + finalPaymentDueDateDiscriptionDisableMode + ", finalPaymentDueDateDiscriptionEnableMode=" + finalPaymentDueDateDiscriptionEnableMode
                + ", finalPaymentDueDateRequireMsg=" + finalPaymentDueDateRequireMsg + ", finalPaymentDueDateRequireErrorMsg="
                + finalPaymentDueDateRequireErrorMsg + ", importantInstructionActiveBarInactiveMode=" + importantInstructionActiveBarInactiveMode
                + ", importantInstructionActiveBarActiveMode=" + importantInstructionActiveBarActiveMode + ", importantInstructionInput="
                + importantInstructionInput + ", importantInstructionRequireMsg=" + importantInstructionRequireMsg
                + ", importantInstructionRequireErrorMsg=" + importantInstructionRequireErrorMsg + ", passengerInformationSelect="
                + passengerInformationSelect + ", middleNameEnableDropdown=" + middleNameEnableDropdown + ", middleNameConfirmation="
                + middleNameConfirmation + ", middleNameDisableDropdown=" + middleNameDisableDropdown + ", middleNameDeleteButton="
                + middleNameDeleteButton + ", passportNumberEnableDropdown=" + passportNumberEnableDropdown + ", passportNumberConfirmation="
                + passportNumberConfirmation + ", passportNumberDisableDropdown=" + passportNumberDisableDropdown + ", passportDeleteButton="
                + passportDeleteButton + ", dateOfBirthEnableDropdown=" + dateOfBirthEnableDropdown + ", dateOfBirthConfirmation="
                + dateOfBirthConfirmation + ", dateOfBirthDisableDropdown=" + dateOfBirthDisableDropdown + ", dateOfBirthDeleteButton="
                + dateOfBirthDeleteButton + ", phoneNumberEnableDropdown=" + phoneNumberEnableDropdown + ", phoneNumberConfirmation="
                + phoneNumberConfirmation + ", phoneNumberDisableDropdown=" + phoneNumberDisableDropdown + ", phoneNumberDeleteButton="
                + phoneNumberDeleteButton + ", passengerInformationHeading=" + passengerInformationHeading + ", addressHeading=" + addressHeading
                + ", addressSelect=" + addressSelect + ", addressLineOneEnableDropdown=" + addressLineOneEnableDropdown
                + ", addressLineOneConfirmation=" + addressLineOneConfirmation + ", addressLineOneDisableDropdown=" + addressLineOneDisableDropdown
                + ", addressLineTwoEnableDropdown=" + addressLineTwoEnableDropdown + ", addressLineTwoConfirmation=" + addressLineTwoConfirmation
                + ", addressLineTwoDisableDropdown=" + addressLineTwoDisableDropdown + ", cityEnableDropdown=" + cityEnableDropdown
                + ", cityConfirmation=" + cityConfirmation + ", cityDisableDropdown=" + cityDisableDropdown + ", stateEnableDropdown="
                + stateEnableDropdown + ", stateConfirmation=" + stateConfirmation + ", stateDisableDropdown=" + stateDisableDropdown
                + ", zipCodeEnableDropdown=" + zipCodeEnableDropdown + ", zipCodeConfirmation=" + zipCodeConfirmation + ", zipCodeDisableDropdown="
                + zipCodeDisableDropdown + ", countryEnableDropdown=" + countryEnableDropdown + ", countryConfirmation=" + countryConfirmation
                + ", countyDisableDropdown=" + countyDisableDropdown + ", addressLineOneDeleteButton=" + addressLineOneDeleteButton
                + ", addressLineTwoDeleteButton=" + addressLineTwoDeleteButton + ", cityDeleteButton=" + cityDeleteButton + ", stateDeleteButton="
                + stateDeleteButton + ", zipCodeDeleteButton=" + zipCodeDeleteButton + ", countryDeleteButton=" + countryDeleteButton
                + ", seatPreferenceActiveBarActiveMOde=" + seatPreferenceActiveBarActiveMOde + ", seatPreferenceActiveBarInactiveMOde="
                + seatPreferenceActiveBarInactiveMOde + ", seatPreferenceSelect=" + seatPreferenceSelect + ", seatPreferenceHeading="
                + seatPreferenceHeading + ", mealPreferenceHeading=" + mealPreferenceHeading + ", aisleSeatEnableDropdown=" + aisleSeatEnableDropdown
                + ", aisleSeatConfirmation=" + aisleSeatConfirmation + ", aisleSeatDeleteButton=" + aisleSeatDeleteButton
                + ", aisleSeatDisableDropdown=" + aisleSeatDisableDropdown + ", windowSeatEnableDropdown=" + windowSeatEnableDropdown
                + ", windowSeatConfirmation=" + windowSeatConfirmation + ", windowSeatDeleteButton=" + windowSeatDeleteButton
                + ", windowSeatDisableDropdown=" + windowSeatDisableDropdown + ", seatPrefenceReqiureMessage=" + seatPrefenceReqiureMessage
                + ", seatPrefenceReqiureErrorMessage=" + seatPrefenceReqiureErrorMessage + ", mealPreferenceActiveBarInactiveMode="
                + mealPreferenceActiveBarInactiveMode + ", mealPreferenceActiveBarActiveMode=" + mealPreferenceActiveBarActiveMode
                + ", mealPreferenceRequireMessage=" + mealPreferenceRequireMessage + ", mealPreferenceRequireErrorMessage="
                + mealPreferenceRequireErrorMessage + ", mealPreferenceSelect=" + mealPreferenceSelect + ", vegetarianMealConfirmation="
                + vegetarianMealConfirmation + ", vegetarianEnableDropdown=" + vegetarianEnableDropdown + ", vegetarianegetarianDisableDropdown="
                + vegetarianegetarianDisableDropdown + ", diabeticEnableDropdown=" + diabeticEnableDropdown + ", diabeticDisableDropdown="
                + diabeticDisableDropdown + ", kosherEnableDropdown=" + kosherEnableDropdown + ", kocherDisableDropdown=" + kocherDisableDropdown
                + ", veganEnableDropdown=" + veganEnableDropdown + ", veganDisableDropdown=" + veganDisableDropdown + ", otherEnableDropdown="
                + otherEnableDropdown + ", othersdisableDropdown=" + othersdisableDropdown + ", diabeticMealConfirmation=" + diabeticMealConfirmation
                + ", kosherMealConfirmation=" + kosherMealConfirmation + ", veganMealConfirmation=" + veganMealConfirmation
                + ", otherMealConfirmation=" + otherMealConfirmation + ", vegetarianMealDeleteButton=" + vegetarianMealDeleteButton
                + ", diabeticMealDeleteButton=" + diabeticMealDeleteButton + ", kosherMealDeleteButton=" + kosherMealDeleteButton
                + ", veganMealDeleteButton=" + veganMealDeleteButton + ", otherMealDeleteButton=" + otherMealDeleteButton + ", flightCostHeading="
                + flightCostHeading + ", airFareCostHeading=" + airFareCostHeading + ", taxesCostHeading=" + taxesCostHeading
                + ", termsAndConditionCostHeading=" + termsAndConditionCostHeading + ", accommodationCostHeading=" + accommodationCostHeading
                + ", transferCostHeading=" + transferCostHeading + ", otherCostHeading=" + otherCostHeading + ", depositCostHeading="
                + depositCostHeading + ", balanceCostHeading=" + balanceCostHeading + ", flightAmountActiveBarInactiveMode="
                + flightAmountActiveBarInactiveMode + ", flightAmountActiveBarActiveMode=" + flightAmountActiveBarActiveMode
                + ", flightAmountInputDisableMode=" + flightAmountInputDisableMode + ", flightAmountInputEnableMode=" + flightAmountInputEnableMode
                + ", atleastOneCostRequireMessageForFlight=" + atleastOneCostRequireMessageForFlight + ", atleastOneCostRequireErrorMessageForFlight="
                + atleastOneCostRequireErrorMessageForFlight + ", flightAmountRequireMessage=" + flightAmountRequireMessage
                + ", flightAmountRequireErrorMessage=" + flightAmountRequireErrorMessage + ", airFareAmountActiveBarInactiveMode="
                + airFareAmountActiveBarInactiveMode + ", airFareAmountActiveBarActiveMode=" + airFareAmountActiveBarActiveMode
                + ", airFareAmountInputDisableMode=" + airFareAmountInputDisableMode + ", airFareAmountInputEnableMode="
                + airFareAmountInputEnableMode + ", airFareAmountRequireMessage=" + airFareAmountRequireMessage
                + ", airFareAmountRequireErrorMessage=" + airFareAmountRequireErrorMessage + ", taxesAmountActiveBarInactiveMode="
                + taxesAmountActiveBarInactiveMode + ", taxesAmountActiveBarActiveMode=" + taxesAmountActiveBarActiveMode
                + ", taxesAmountInputDisableMode=" + taxesAmountInputDisableMode + ", taxesAmountInputEnableMode=" + taxesAmountInputEnableMode
                + ", taxesAmountRequireMessage=" + taxesAmountRequireMessage + ", taxesAmountRequireErrorMessage=" + taxesAmountRequireErrorMessage
                + ", termsAndConditionActiveBarInactiveMode=" + termsAndConditionActiveBarInactiveMode + ", termsAndConditionActiveBarActiveMode="
                + termsAndConditionActiveBarActiveMode + ", termsAndConditionInputDisableMode=" + termsAndConditionInputDisableMode
                + ", termsAndConditionInputEnableMode=" + termsAndConditionInputEnableMode + ", termsAndConditionRequireMessage="
                + termsAndConditionRequireMessage + ", termsAndConditionRequireErrorMessage=" + termsAndConditionRequireErrorMessage
                + ", accommodationAmountActiveBarInactiveMode=" + accommodationAmountActiveBarInactiveMode
                + ", accommodationAmountActiveBarActiveMode=" + accommodationAmountActiveBarActiveMode + ", accommodationAmountInputDisableMode="
                + accommodationAmountInputDisableMode + ", accommodationAmountInputEnableMode=" + accommodationAmountInputEnableMode
                + ", atleastOneCostRequireMessageForAccommodation=" + atleastOneCostRequireMessageForAccommodation
                + ", atleastOneCostRequireErrorMessageForAccommodation=" + atleastOneCostRequireErrorMessageForAccommodation
                + ", accommodationAmountRequireMessage=" + accommodationAmountRequireMessage + ", accommodationAmountRequireErrorMessage="
                + accommodationAmountRequireErrorMessage + ", transferAmountActiveBarInactiveMode=" + transferAmountActiveBarInactiveMode
                + ", tranferAmountActiveBarActiveMode=" + tranferAmountActiveBarActiveMode + ", transferAmountInputDisableMode="
                + transferAmountInputDisableMode + ", transferAmountInputEnableMode=" + transferAmountInputEnableMode
                + ", atleastOneCostRequireMessageForTranfer=" + atleastOneCostRequireMessageForTranfer
                + ", atleastOneCostRequireErrorMessageForTranfer=" + atleastOneCostRequireErrorMessageForTranfer + ", tranferAmountRequireMessage="
                + tranferAmountRequireMessage + ", tranferAmountRequireErrorMessage=" + tranferAmountRequireErrorMessage
                + ", otherAmountActiveBarInactiveMode=" + otherAmountActiveBarInactiveMode + ", otherAmountActiveBarActiveMode="
                + otherAmountActiveBarActiveMode + ", otherAmountInputDisableMode=" + otherAmountInputDisableMode + ", otherAmountInputEnableMode="
                + otherAmountInputEnableMode + ", atleastOneCostRequireMessageForOther=" + atleastOneCostRequireMessageForOther
                + ", atleastOneCostRequireErrorMessageForOther=" + atleastOneCostRequireErrorMessageForOther + ", otherAmountRequireMessage="
                + otherAmountRequireMessage + ", otherAmountRequireErrorMessage=" + otherAmountRequireErrorMessage
                + ", depositAmountActiveBarInactiveMode=" + depositAmountActiveBarInactiveMode + ", depositAmountActiveBarActiveMode="
                + depositAmountActiveBarActiveMode + ", depositAmountInputDisableMode=" + depositAmountInputDisableMode
                + ", depositAmountInputEnableMode=" + depositAmountInputEnableMode + ", depositAmountRequireMessage=" + depositAmountRequireMessage
                + ", depositAmountRequireErrorMessage=" + depositAmountRequireErrorMessage + ", balanceAmountActiveBarInactiveMode="
                + balanceAmountActiveBarInactiveMode + ", balanceAmountActiveBarActiveMode=" + balanceAmountActiveBarActiveMode
                + ", balanceAmountInputDisableMode=" + balanceAmountInputDisableMode + ", balanceAmountRequireMessage=" + balanceAmountRequireMessage
                + ", balanceAmountRequireErrorMessage=" + balanceAmountRequireErrorMessage + ", calendarClearButton=" + calendarClearButton
                + ", calendarTodayButton=" + calendarTodayButton + ", calendarLightBox=" + calendarLightBox + ", quoteActiveBarActiveMode="
                + quoteActiveBarActiveMode + ", quoteActiveBarInactiveMode=" + quoteActiveBarInactiveMode + "]";
    }

}

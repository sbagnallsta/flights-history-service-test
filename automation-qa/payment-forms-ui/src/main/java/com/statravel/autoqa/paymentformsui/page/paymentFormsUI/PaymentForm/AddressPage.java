package com.statravel.autoqa.paymentformsui.page.paymentFormsUI.PaymentForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.paymentformsui.commons.WebDriverCommons;
import com.statravel.autoqa.paymentformsui.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class AddressPage extends Page<AddressPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private PaymentFormPage paymentFormPage;

    private AddressPageElements addressPageElements;

    public static final String ADDRESS_LINE_ONE = "Address one";

    public static final String ADDRESS_LINE_TWO = "Address two";

    public static final String CITY = "Devon";

    public static final String UNITED_KINGDOM = "United Kingdom";

    public static final String AUSTRALIA = "Australia";

    public static final String U_S_A = "United States Of America";

    public static final String STATE = "Devon";

    public static final String ZIP_CODE = "zip code";

    String[] aus = { "State", "New South Wales (NSW)", "Queensland (Qld)", "South Australia (SA)", "Tasmania (Tas)", "Victoria (Vic.)",
            "Western Australia (WA)" };

    String[] us = { "State", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
            "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
            "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington DC", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

    String[] uk = { "State", "Aberdeenshire", "Anglesey/Sir Fon", "Angus/Forfarshire", "Argyllshire", "Ayrshire", "Banffshire", "Bedfordshire",
            "Berkshire", "Berwickshire", "Brecknockshire/Sir Frycheiniog", "Buckinghamshire", "Buteshire", "Caernarfonshire/Sir Gaernarfon",
            "Caithness", "Cambridgeshire", "Cardiganshire/Ceredigion", "Carmarthenshire/Sir Gaerfyrddin", "Cheshire", "Clackmannanshire", "Cornwall",
            "Cromartyshire", "Cumbria (Cumberland)", "Denbighshire/Sir Ddinbych", "Derbyshire", "Devon", "Dorset", "Dumfriesshire",
            "Dunbartonshire/Dumbartonshire", "Durham", "East Lothian/Haddingtonshire", "Essex", "Fife", "Flintshire/Sir Fflint",
            "Glamorgan/Morgannwg", "Gloucestershire", "Hampshire", "Hertfordshire", "Huntingdonshire", "Inverness-shire", "Kent", "Kincardineshire",
            "Kinross-shire", "Kirkcudbrightshire", "Lanarkshire", "Lancashire", "Leicestershire", "Lincolnshire", "Merioneth/Meirionnydd",
            "Middlesex", "Midlothian/Edinburghshire", "Monmouthshire/Sir Fynwy", "Montgomeryshire/Sir Drefaldwyn", "Morayshire", "Nairnshire",
            "Norfolk", "Northamptonshire", "Northumberland", "Nottinghamshire", "Orkney", "Oxfordshire", "Peeblesshire", "Pembrokeshire/Sir Benfro",
            "Perthshire", "Radnorshire/Sir Faesyfed", "Renfrewshire", "Ross-shire", "Rutland", "Selkirkshire", "Shetland", "Shropshire", "Somerset",
            "Staffordshire", "Stirlingshire", "Suffolk", "Surrey", "Sussex", "Sutherland", "Warwickshire", "West Lothian/Linlithgowshire",
            "Westmoreland", "Wigtownshire", "Wiltshire", "Worcestershire", "Yorkshire" };

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(paymentFormPage.getPageElements()
                                                           .getRefrenceNo());
    }

    /**
     * 
     */
    @Override
    public void init() {
        addressPageElements = new AddressPageElements();
        super.initialiseElements(addressPageElements);

    }

    /**
     * 
     */
    @Override
    public AddressPageElements getPageElements() {

        return addressPageElements;
    }

    /**
     * 
     * @param address
     *            address
     */
    public void fillAddressDetils(final String address) {
        if (address.equalsIgnoreCase("all") || (address.equalsIgnoreCase("required"))) {

            if (address.equalsIgnoreCase("all")) {
                webDriverCommons.sendKeys(addressPageElements.getAddressLineTwo(), ADDRESS_LINE_TWO);
            }

            webDriverCommons.sendKeys(addressPageElements.getAddressLineOne(), ADDRESS_LINE_ONE);
            webDriverCommons.sendKeys(addressPageElements.getCity(), CITY);
            webDriverCommons.selectFromDropdown(addressPageElements.getCountry(), UNITED_KINGDOM);
            webDriverCommons.selectFromDropdown(addressPageElements.getState(), STATE);
            webDriverCommons.sendKeys(addressPageElements.getZipCode(), ZIP_CODE);

        }
    }

    /**
     * get state list from state drop down.
     * 
     * @return list of state from state drop down.
     */
    public List<String> getStateFromPaymentFormUI() {

        Select state = new Select(addressPageElements.getState());

        List<WebElement> listState = state.getOptions();
        List<String> stateList = new ArrayList<String>();

        for (WebElement element : listState) {
            stateList.add(element.getText()
                                 .replaceAll("[\r\n]+", "")
                                 .trim());
        }
        return stateList;
    }

    /**
     * 
     * @param country
     *            country
     * @return list from string of array
     */
    public List<String> expectedStateList(final String country) {

        List<String> list = null;
        if (country.equals(UNITED_KINGDOM)) {
            list = Arrays.asList(uk);
            return list;
        } else if (country.equals(AUSTRALIA)) {
            list = Arrays.asList(aus);
            return list;
        } else if (country.equals(U_S_A)) {
            list = Arrays.asList(us);
            return list;
        }
        return list;
    }

    /**
     * select country from drop down as given country.
     * 
     * @param country
     *            country
     */
    public void selectCountry(final String country) {
        webDriverCommons.selectFromDropdown(addressPageElements.getCountry(), country);
    }
}

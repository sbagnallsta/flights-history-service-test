package com.statravel.autoqa.paymentformsui.commons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class Utilities {

    private static final int ADD_THOUSAND = 1000;

    private static final int RANDOM_INT_UNDER_HUNDRED = 100;

    private static final int ADD_TWO_HUNDRED = 200;

    public static final int MULTIPLY_BY_THOUSAND = 1000;

    /**
     * get random int over thousand.
     * 
     * @return random no over thousand
     */
    public int getRandomIntOverOneThousand() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_INT_UNDER_HUNDRED) + ADD_THOUSAND;

    }

    /**
     * get random int under two hundred.
     * 
     * @return random no under two hundred
     */

    public int getRandomIntUnderTwoHundred() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_INT_UNDER_HUNDRED) + ADD_TWO_HUNDRED;

    }

    /**
     * get random alphabet string as length given.
     * 
     * @param lenghtOfNumber
     *            Length Of Number
     * @return generate random alphabet
     * 
     */
    public String getRandomString(final int lenghtOfNumber) {
        return RandomStringUtils.randomAlphabetic(lenghtOfNumber);
    }

    /**
     * get random special character except -,*.
     * 
     * @return special character
     */
    public char randomChar() {
        char[] spl = { '!', '"', '£', '@', '#', '$', '%', '^', '&', '(', ')' };
        Random r = new Random();
        int low = 0;
        int high = spl.length + 1;
        int result = r.nextInt(high - low) + low;
        return spl[result];
    }

    /**
     * 
     * @param time
     *            time
     * @throws InterruptedException
     *             InterruptedException
     */
    public void timeInterval(final int time) throws InterruptedException {
        Thread.sleep(time * MULTIPLY_BY_THOUSAND);
    }

    /**
     * 
     * @return current date in Date format.
     * @throws ParseException
     *             ParseException
     */
    public Date getCurrentDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        return dateFormat.parse(date1);

    }

    /**
     * 
     * @return current date in Date format.
     * @throws ParseException
     *             ParseException
     */
    public Date getCurrentDateWithHourAndMin() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        return dateFormat.parse(date1);

    }

    /**
     * 
     * @return current date in string.
     */
    public String getCurrentDateInString() {

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        Date date = new Date();

        return dateFormat.format(date);

    }

    /**
     * 
     * @param amount
     *            amount
     * @return amount in double from given string.
     */
    public Double getAmountAsDoubleFromString(String amount) {
        amount = amount.substring(1);
        if (amount.contains(",")) {
            amount = amount.replace(",", "");
        }

        return Double.parseDouble(amount);
    }

    /**
     * 
     * @param date
     *            date
     * @param type
     *            type
     * @return date in string from given data base date and time.
     */
    public String getDateFromDataBase(final Date date, final String type) {
        DateFormat dateFormat = null;
        String date1 = null;

        if (type.equalsIgnoreCase("flight")) {

            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            date1 = dateFormat.format(date);
            return date1;
        } else if (type.equalsIgnoreCase("transfer")) {

            dateFormat = new SimpleDateFormat("ddMMMYYYY");
            date1 = dateFormat.format(date);
            return date1.toUpperCase();
        } else if (type.equalsIgnoreCase(PaymentFormsAsseartionMessages.FINAL_DEPOSITE_DATE)
                || type.equalsIgnoreCase(PaymentFormsAsseartionMessages.FINAL_PAYMENT_DATE)) {
            dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            date1 = dateFormat.format(date);
            return date1;
        }

        return date1;
    }

    /**
     * 
     * @param date
     *            date
     * @return min and sec in string from given data base date and time.
     */
    public String getMinAndSecFromDataBase(final Date date) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mma");
        String date1 = dateFormat.format(date);
        return date1.toLowerCase();
    }

    /**
     * 
     * @param noOfDay
     *            noOfDay
     * @return future date as per given days.
     * @throws ParseException
     *             ParseException
     */
    public Date getNextDate(final int noOfDay) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, noOfDay);
        date = c.getTime();
        String date1 = dateFormat.format(date);
        return dateFormat.parse(date1);
    }

}

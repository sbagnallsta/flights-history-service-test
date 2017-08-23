package com.statravel.autoqa.commons;

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
     * get random alphabet string as lenght given.
     * 
     * @param lenghtOfNumber
     *            lenght Of Number
     * @return generate random alphabet
     * 
     */
    public String getRandomString(final int lenghtOfNumber) {
        return RandomStringUtils.randomAlphabetic(lenghtOfNumber);
    }

    /**
     * get rando special character except -,*.
     * 
     * @return special character
     */
    public char randomChar() {
        char[] spl = {'!', '"', '£', '@', '#', '$', '%', '^', '&', '(', ')'};
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

}

package io.github.jonaslins.urlshortener.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomShortCodeGenerator {

    public static String generateCode(){
        return RandomStringUtils.randomAlphanumeric(7);
    }

}

package com.taosdata.kafka.connect.config;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class OutFormatValidator implements ConfigDef.Validator {
    private static final Logger log = LoggerFactory.getLogger(OutFormatValidator.class);

    public static final OutFormatValidator INSTANCE = new OutFormatValidator();

    @Override
    public void ensureValid(String name, Object value) {
        Set<String> set = Arrays.stream(new String[]{"json", "telnet"}).collect(Collectors.toSet());
        if (!set.contains(String.valueOf(value).toLowerCase())){
            throw new ConfigException(name, value, "outFormat config must one of telnet/json");
        }
    }
}

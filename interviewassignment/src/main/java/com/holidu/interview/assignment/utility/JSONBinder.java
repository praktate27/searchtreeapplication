/**
 * 
 */
package com.holidu.interview.assignment.utility;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author prachi
 *
 */
@Component
public class JSONBinder {

    private static final ObjectMapper OBJECT_MAPPER = createMapper();

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
        return mapper;
    }
    
    public static <T> T fromJSON(Class<T> beanClass, String json) {
        try {
            return OBJECT_MAPPER.readValue(json, beanClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String toJSON(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

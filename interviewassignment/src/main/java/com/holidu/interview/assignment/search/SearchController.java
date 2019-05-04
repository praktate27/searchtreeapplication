/**
 * 
 */
package com.holidu.interview.assignment.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.holidu.interview.assignment.request.CartesianPoint;
import com.holidu.interview.assignment.service.SearchService;
import com.holidu.interview.assignment.service.SearchServiceImpl;

/**
 * @author prachi
 *
 */
@RestController
public class SearchController {

    private static final ObjectMapper OBJECT_MAPPER = createMapper();

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
        return mapper;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
    
    @Autowired
    SearchService searchService;

    @RequestMapping(name = "searchEndPoint", method = RequestMethod.GET, value = "/search")
    public Map<String, Integer> getSearchResponse(@RequestParam("cartesianPoint") String cartesianPoint, @RequestParam("radius") Double radius) {
        CartesianPoint point;
        try {
            point = OBJECT_MAPPER.readValue(cartesianPoint, CartesianPoint.class);
            return searchService.countOfCommonName(point.getxCoordinate(), point.getyCoordinate(), radius);
        } catch (JsonParseException e) {
            LOGGER.error("SearchController::getSearchResponse JsonParserException {}", e);
        } catch (JsonMappingException e) {
            LOGGER.error("SearchController::getSearchResponse JsonMappingException {}", e);
        } catch (IOException e) {
            LOGGER.error("SearchController::getSearchResponse IOException {}", e);
        }
        return new HashMap<>();
    }
}

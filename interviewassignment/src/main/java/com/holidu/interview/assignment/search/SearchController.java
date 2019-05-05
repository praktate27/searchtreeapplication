/**
 * 
 */
package com.holidu.interview.assignment.search;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.holidu.interview.assignment.request.CartesianPoint;
import com.holidu.interview.assignment.service.SearchService;
import com.holidu.interview.assignment.utility.JSONBinder;

/**
 * @author prachi
 *
 */
@RestController
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
    
    @Autowired
    SearchService searchService;
    
    @RequestMapping(name = "searchEndPoint", method = RequestMethod.GET, value = "/search")
    public Map<String, Integer> getSearchResponse(@RequestParam("cartesianPoint") String cartesianPoint, @RequestParam("radius") Double radius) {
        CartesianPoint point;
        try {
            point = JSONBinder.fromJSON(CartesianPoint.class, cartesianPoint);
            LOGGER.info("SearchController::getSearchResponse point {}, radius {}", point, radius);
            return searchService.getSearchResponse(point.getxCoordinate(), point.getyCoordinate(), radius);
        } catch (Exception e) {
            LOGGER.error("SearchController::getSearchResponse Exception {}", e);
        }
        return new HashMap<>();
    }
}

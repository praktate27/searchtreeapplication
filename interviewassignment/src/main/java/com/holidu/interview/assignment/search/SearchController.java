/**
 * 
 */
package com.holidu.interview.assignment.search;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.holidu.interview.assignment.request.CartesianPoint;
import com.holidu.interview.assignment.service.SearchService;

/**
 * @author prachi
 *
 */
@RestController
public class SearchController {

    @Autowired
    SearchService searchService;
    
    @RequestMapping(name = "searchEndPoint", method = RequestMethod.POST, value = "/search")
    public Map<String, Integer> getSearchResponse(@RequestBody CartesianPoint point, @RequestParam("radius") Double radius) {
        return searchService.countOfCommonName(point.getxCoordinate(), point.getyCoordinate(), radius);
    }
}

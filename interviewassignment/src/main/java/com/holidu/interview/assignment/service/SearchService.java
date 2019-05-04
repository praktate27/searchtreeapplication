/**
 * 
 */
package com.holidu.interview.assignment.service;

import java.util.Map;

/**
 * @author prachi
 *
 */
public interface SearchService {

    String helloRest();
    
    Map<String, Integer> countOfCommonName(Double point, Double radius);
}

package com.holidu.interview;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.holidu.interview.assignment.request.CartesianPoint;
import com.holidu.interview.assignment.service.SearchService;

public class DummyTest {

    private final SearchService searchService;
    
    public DummyTest() {
        this.searchService = Mockito.mock(SearchService.class);
    }
    
    @Test
    public void someTest() {
        Assert.assertTrue(true);
    }
    
    @Test
    public void getSearchResponseTest() {
        Map<String, Integer> map = new HashMap<>();
        CartesianPoint cp = new CartesianPoint();
        cp.setxCoordinate(1043105.317);
        cp.setyCoordinate(3661800.8675);
        Assert.assertEquals(map, searchService.getSearchResponse(cp.getxCoordinate(), cp.getyCoordinate(), 8000000.0));
    }
    
}

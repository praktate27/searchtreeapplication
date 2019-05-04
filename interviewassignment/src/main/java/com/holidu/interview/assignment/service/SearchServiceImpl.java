/**
 * 
 */
package com.holidu.interview.assignment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.holidu.interview.assignment.domain.StreetTreeCensusData;

/**
 * @author prachi
 *
 */
@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);
    
    private static List<StreetTreeCensusData> list;
    
    private final Double feetToMeterConverter = 3.281;

    @Override
    public String helloRest() {
        return "HelloRest";
    }

    @Override
    public Map<String, Integer> countOfCommonName(Double xCoordinate, Double yCoordinate, Double radius) {
        Map<String, Integer> map = new HashMap<>();
        try {
            
            list = buildStreetTreeCensusDataFromString();
            if (!CollectionUtils.isEmpty(list)) {
                list.forEach(l -> {
                    if (isInsideArea(l.getXsp(), l.getYsp(), xCoordinate, yCoordinate, radius)) {
                        Integer count = map.getOrDefault(l.getSpcCommon(), 0);
                        count++;
                        map.put(l.getSpcCommon(), count);
                    }
                });
            }
        } catch (Exception e) {
            LOGGER.error("Exception {}", e);
        }
        return map;
    }

    private String makeHttpGetCallToFetchData() throws ParseException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "https://data.cityofnewyork.us/resource/nwxe-4ae8.json?";
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity());
    }

    private List<StreetTreeCensusData> buildStreetTreeCensusDataFromString() throws ParseException, IOException {
        if (!CollectionUtils.isEmpty(list)) {
            LOGGER.info("fetching from static");
            return list;
        }
        String result = makeHttpGetCallToFetchData();
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(result, JsonElement.class);
        list = new ArrayList<>();
        jsonElement.getAsJsonArray().forEach(a -> {
            StreetTreeCensusData data = new StreetTreeCensusData();
            JsonObject obj = a.getAsJsonObject();
            if (null != obj.get("spc_common")) {
                data.setSpcCommon(obj.get("spc_common").getAsString());
            } else {
                data.setSpcCommon("Unknown");
            }
            data.setXsp(obj.get("x_sp").getAsDouble() / feetToMeterConverter);
            data.setYsp(obj.get("y_sp").getAsDouble() / feetToMeterConverter);
            list.add(data);
        });
        return list;
    }

    private boolean isInsideArea(Double xcoordinate, Double ycoordinate, Double xCartesianPoint, Double yCartesianPoint, Double radius) {
        return (((xcoordinate - xCartesianPoint) * (xcoordinate - xCartesianPoint)) + ((ycoordinate - yCartesianPoint) * (ycoordinate - yCartesianPoint))) <= (radius * radius);
    }
}

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
import org.springframework.beans.factory.annotation.Value;
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

    private final Double meterToFeetRatio = 3.281;

    @Value("${streettreecensus.resource}")
    private String streetTreeCensusResource;

    @Override
    public String helloRest() {
        return "HelloRest";
    }

    /**
     * @param xCoordinate
     * @param yCoordinate
     * @param radius
     * @return HashMap<String, Integer>()
     */
    @Override
    public Map<String, Integer> getSearchResponse(Double xCoordinate, Double yCoordinate, Double radius) {
        Map<String, Integer> map = new HashMap<>();
        try {
            list = buildStreetTreeCensusDataFromString();
            if (!CollectionUtils.isEmpty(list)) {
                list.forEach(l -> {
                    if (isInsideRadius(l.getXsp(), l.getYsp(), xCoordinate, yCoordinate, radius)) {
                        map.put(l.getSpcCommon(), map.getOrDefault(l.getSpcCommon(), 0) + 1);
                    }
                });
            }
        } catch (Exception e) {
            LOGGER.error("SearchServiceImpl::getSearchResponse Exception {}", e);
        }
        return map;
    }

    private String makeHttpGetCallToFetchData() throws ParseException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(streetTreeCensusResource);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity());
    }

    private List<StreetTreeCensusData> buildStreetTreeCensusDataFromString() throws ParseException, IOException {
        if (!CollectionUtils.isEmpty(list)) {
//            LOGGER.info("fetching from static");
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
            data.setXsp(obj.get("x_sp").getAsDouble());
            data.setYsp(obj.get("y_sp").getAsDouble());
            list.add(data);
        });
        return list;
    }

    private boolean isInsideRadius(Double xCoordinate, Double yCoordinate, Double xCartesianPoint, Double yCartesianPoint, Double radius) {
        double xDelta = (xCoordinate - xCartesianPoint) / meterToFeetRatio;
        double yDelta = (yCoordinate - yCartesianPoint) / meterToFeetRatio;
        return ((xDelta * xDelta) + (yDelta * yDelta)) < (radius * radius);
    }
}

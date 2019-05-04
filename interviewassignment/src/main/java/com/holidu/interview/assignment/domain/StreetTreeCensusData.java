/**
 * 
 */
package com.holidu.interview.assignment.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author prachi
 *
 */
public class StreetTreeCensusData implements Serializable {

    @JsonProperty("spc_common")
    private String spcCommon;
    @JsonProperty("x_sp")
    private Double xsp;
    @JsonProperty("y_sp")
    private Double ysp;

    public StreetTreeCensusData() {
        super();
    }

    public String getSpcCommon() {
        return spcCommon;
    }

    public void setSpcCommon(String spcCommon) {
        this.spcCommon = spcCommon;
    }

    public Double getXsp() {
        return xsp;
    }

    public void setXsp(Double xsp) {
        this.xsp = xsp;
    }

    public Double getYsp() {
        return ysp;
    }

    public void setYsp(Double ysp) {
        this.ysp = ysp;
    }

}

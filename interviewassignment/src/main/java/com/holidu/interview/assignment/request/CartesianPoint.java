/**
 * 
 */
package com.holidu.interview.assignment.request;

/**
 * @author prachi
 *
 */
public class CartesianPoint {

    private Double xCoordinate;
    private Double yCoordinate;

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "CartesianPoint [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
    }

}

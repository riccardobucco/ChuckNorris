/*
* Name: BarChartElementInPlaceUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-22  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
* This class represents an element of the in place update package of a bar chart.
*/
public class BarChartElementInPlaceUpdate {
    private double value;
    private double xpos;
    private double ypos;

    /**
    * This method is the constructor to create the update package.
    * @param xpos value of abscissa
    * @param ypos value of ordinate
    * @param value value of the chart
    */
    public BarChartElementInPlaceUpdate(double xpos, double ypos, double value){
        this.xpos=xpos;
        this.ypos=ypos;
        this.value=value;
    }

    /**
    * This method is responsible for returning the new data of the update package.
    * @return getData data of the update package
    */
    public double getData(){
        return value;
    }

    /**
    * This method has the task of returning the abscissa of the data to be modified.
    * @return double value of abscissa to be modified
    */
    public double getX(){
        return xpos;
    }

    /**
    * This method has the task of returning the ordinate of data to be modified.
    * @return double value of ordinate to be modified
    */
    public double getY(){
        return ypos;
    }
}

/*
* Name: TableCell.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import android.graphics.Color;

/**
 * This class represents the data of a cell of a table.
 */
public class TableCell {
    /**
     * This attribute represents the value of a cell of the table.
     */
    private String value;

    /**
     * This attribute is the text color of a cell in the table.
     */
    private Color fontColor;

    /**
     * This attribute represents the background color of a cell in the table.
     */
    private Color bgColor;

    /**
     * This method is the constructor of TableRow. It has as a parameter data values of the cells of the table row.
     * @param value
     * @param fontColor
     * @param bgColor
     */
    public TableCell(String value, Color fontColor, Color bgColor){
        this.value=value;
        this.fontColor=fontColor;
        this.bgColor=bgColor;
    }

    /**
     * This method has the task of returning the data of the cell.
     * @return the data of the cell
     */
    public String getData(){
        return value;
    }

    /**
     * This method has the task to return the background color of the cell.
     * @return the background color of the cell
     */
    public Color getBackgroundColor(){
        return bgColor;
    }

    /**
     * This method has the task of returning the text color of the cell.
     * @return the text color of the cell
     */
    public Color getFontColor(){
        return fontColor;
    }

    /**
     * This method has the task to set the data of the cell.
     * @param value
     */
    public void setData(String value){
        this.value= value;
    }

    /**
     * This method has the task to set the background color of the cell.
     * @param bgColor
     */
    public void setBackgroundColor(Color bgColor){
        this.bgColor= bgColor;
    }

    /**
     * This method has the duty to set the font color of the cell.
     * @param fontColor
     */
    public void setFontColor(Color fontColor){
        this.fontColor= fontColor;
    }
}

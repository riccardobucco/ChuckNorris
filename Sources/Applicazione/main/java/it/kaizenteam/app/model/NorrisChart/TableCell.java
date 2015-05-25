package it.kaizenteam.app.model.NorrisChart;

import android.graphics.Color;

/**
 * Created by Moro on 24/05/15.
 */
public class TableCell {
    private String value;
    private Color fontColor;
    private Color bgColor;

    /**
     *
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
     *
     * @return
     */
    public String getData(){
        return value;
    }

    /**
     *
     * @return
     */
    public Color getBackgroundColor(){
        return bgColor;
    }

    /**
     *
     * @return
     */
    public Color getFontColor(){
        return fontColor;
    }

    /**
     *
     * @param value
     */
    public void setData(String value){
        this.value= value;
    }

    /**
     *
     * @param bgColor
     */
    public void setBackgroundColor(Color bgColor){
        this.bgColor= bgColor;
    }

    /**
     *
     * @param fontColor
     */
    public void setFontColor(Color fontColor){
        this.fontColor= fontColor;
    }
}

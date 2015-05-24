package it.kaizenteam.app.model.NorrisChart;

import android.graphics.Color;

/**
 * Created by Moro on 24/05/15.
 */
public class TableCell {
    private String value;
    private Color fontColor;
    private Color bgColor;

    public TableCell(String value, Color fontColor, Color bgColor){
        this.value=value;
        this.fontColor=fontColor;
        this.bgColor=bgColor;
    }

    public String getData(){
        return value;
    }

    public Color getBackgroundColor(){
        return bgColor;
    }

    public Color getFontColor(){
        return fontColor;
    }

    public void setData(String value){
        this.value= value;
    }

    public void setBackgroundColor(Color bgColor){
        this.bgColor= bgColor;
    }

    public void setFontColor(Color fontColor){
        this.fontColor= fontColor;
    }
}

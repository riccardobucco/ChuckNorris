/*
* Name: {ListActivity.java}
* Package: {it.kaizenteam.app.view}
* Location: {src.main.java.it.kaizenteam.view}
* Date: {data di creazione del file}
* Version: {0.01}
*
* History:
*
* =================================================================
* Version Date Programmer Changes
* =================================================================
* 0.01 GG-MM-AAAA Aessandro Moretto {creation}
* =================================================================
*
*/
package it.kaizenteam.app.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import it.kaizenteam.app.R;
import it.kaizenteam.app.presenter.ListPresenter;
import it.kaizenteam.app.presenter.PresenterImpl;


/**
 *
 */
public class ListActivity extends BaseActivity implements ListView,AdapterView.OnItemClickListener {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ((android.widget.ListView)findViewById(R.id.chartslist)).setOnItemClickListener(this);
        presenter= PresenterImpl.create(PresenterImpl.LIST_TYPE,this);
        ((ListPresenter)presenter).onResume();
    }

    /**
     *
     */
    @Override
    public void navigateToLoginView() {
        //TODO
        Intent i =new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    /**
     *
     * @param view
     */
    @Override
    public void onLogoutClick(View view) {
        ((ListPresenter)presenter).onLogoutClick();
    }

    /**
     *
     * @param list
     */
    @Override
    public void renderList(ArrayList<String[]> list) {
        ArrayList<HashMap<String, Object>> data=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            HashMap<String,Object> dataMap=new HashMap<>();//creiamo una mappa di valori
            dataMap.put("id", list.get(i)[0]);
            dataMap.put("type", list.get(i)[1]);
            if(list.get(i)[1].equals("barchart"))
                dataMap.put("img", BitmapFactory.decodeResource(getResources(), R.drawable.barchart));
            if(list.get(i)[1].equals("linechart"))
                dataMap.put("img", BitmapFactory.decodeResource(getResources(), R.drawable.linechart));
            if(list.get(i)[1].equals("mapchart"))
                dataMap.put("img", BitmapFactory.decodeResource(getResources(), R.drawable.mapchart));
            if(list.get(i)[1].equals("table"))
                dataMap.put("img", BitmapFactory.decodeResource(getResources(), R.drawable.table));

            data.add(dataMap);  //aggiungiamo la mappa di valori alla sorgente dati
        }

        String[] from={"id","type","img"}; //dai valori contenuti in queste chiavi
        int[] to={R.id.id_listitem,R.id.type_listitem,R.id.image_listitem};//agli id delle view
        //costruzione dell adapter
        SimpleAdapter adapter=new SimpleAdapter(
                getApplicationContext(),
                data,//sorgente dati
                R.layout.listitem, //layout contenente gli id di "to"
                from,
                to);
        adapter.setViewBinder(new SimpleAdapter.ViewBinder(){
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                if( (view instanceof ImageView) & (data instanceof Bitmap) ) {
                    ImageView iv = (ImageView) view;
                    Bitmap bm = (Bitmap) data;
                    iv.setImageBitmap(bm);
                    return true;
                }
                return false;

            }

        });
        //utilizzo dell'adapter
        ((android.widget.ListView)findViewById(R.id.chartslist)).setAdapter(adapter);
    }

    /**
     *
     * @param type
     * @param id
     */
    @Override
    public void showChartDetailView(String type, String id) {
        Intent i=null;
        if(type.equals("barchart"))
            i=new Intent(this,BarChartActivity.class);
        if(type.equals("linechart"))
            i=new Intent(this,LineChartActivity.class);
        if(type.equals("mapchart"))
            i=new Intent(this,MapChartActivity.class);
        if(type.equals("table"))
            i=new Intent(this,TableActivity.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    /**
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((ListPresenter)presenter).onItemClicked(((TextView) view.findViewById(R.id.type_listitem)).getText().toString(), ((TextView) view.findViewById(R.id.id_listitem)).getText().toString());
    }
}

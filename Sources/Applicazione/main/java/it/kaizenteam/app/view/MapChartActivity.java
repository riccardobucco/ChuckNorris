/*
* Name: MapChartActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.presenter.PresenterImpl;
import it.kaizenteam.app.view.ChartActivity;

/**
 * MapChartActivity specializes ChartActivity and constitutes an Activity for map charts. It provides static constants that represent the possible values to be passed to methods to change the view.
 */
public class MapChartActivity extends ChartActivity implements MapChartView {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_chart);
        setUpMapIfNeeded();
        presenter= PresenterImpl.create(PresenterImpl.MAPCHART_TYPE,this);
    }

    /**
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    @Override
    public void renderChart(ChartData data) {
    //TODO
    }

    /**
     * This method provides the ability to change the display position of the map chart, or the coordinates of the central point.
     * @param latitude latitude coordinate of the central point
     * @param longitude longitude coordinate of the central point
     */
    @Override
    public void setCameraCoordinate(int latitude, int longitude) {
//TODO
    }

    /**
     * This method provides the ability to change the display height of the map chart. The permitted heights are available in static constants of class (X_ZOOM_LEVEL) or intermediate values to them.
     * @param zoomLevel level of display height
     */
    @Override
    public void setCameraZoom(int zoomLevel) {
//TODO
    }

    /**
     * This method provides the ability to change the map markers chart. The markers permits are available in static constants of class (X_SHAPE).
     * @param shape map marker to change
     */
    @Override
    public void setMarkerShape(String shape) {
//TODO
    }

    /**
     * This method provides the ability to change the color of various series Data chart.
     * @param colors colour to change
     */
    @Override
    public void setSeriesColor(String[] colors) {
//TODO
    }

    /**
     * This method allows the display in the correct way the title of the chart.
     * @param title title of the chart
     */
    @Override
    public void setTitle(String title) {
//TODO
    }
}

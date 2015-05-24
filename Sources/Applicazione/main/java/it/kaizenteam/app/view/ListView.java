package it.kaizenteam.app.view;

import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by Moro on 23/05/15.
 */
public interface ListView extends View {
    void navigateToLoginView();
    void onLogoutClick(android.view.View view);
    void renderList(ArrayList<String[]> list);
    void showChartDetailView(String type, String id);
}

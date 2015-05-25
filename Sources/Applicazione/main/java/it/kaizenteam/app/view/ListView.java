package it.kaizenteam.app.view;

import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by Moro on 23/05/15.
 */
public interface ListView extends View {
    /**
     *
     */
    void navigateToLoginView();

    /**
     *
     * @param view
     */
    void onLogoutClick(android.view.View view);

    /**
     *
     * @param list
     */
    void renderList(ArrayList<String[]> list);

    /**
     *
     * @param type
     * @param id
     */
    void showChartDetailView(String type, String id);
}

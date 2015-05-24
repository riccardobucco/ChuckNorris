package it.kaizenteam.app.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;

import it.kaizenteam.app.presenter.Presenter;

/**
 * Created by Moro on 22/05/15.
 */
public class BaseActivity extends Activity implements View {
    protected Presenter presenter;
}

package it.kaizenteam.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import it.kaizenteam.app.R;
import it.kaizenteam.app.presenter.LoginPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;


public class LoginActivity extends BaseActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter= PresenterImpl.create(PresenterImpl.LOGIN_TYPE,this);
    }

    @Override
    public void showAuthenticationError() {
        ((TextView)findViewById(R.id.errorloginlbl)).setVisibility(View.VISIBLE);
    }

    @Override
    public void showListView() {
        Intent i = new Intent(this,ListActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); //TODO BUG torna nella home
        startActivity(i);
    }

    @Override
    public void showProgress(boolean show) {
        if(show)
            ((ImageView)findViewById(R.id.progressimage)).setVisibility(View.VISIBLE);
        else
            ((ImageView)findViewById(R.id.progressimage)).setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginClick(View view) {
        ((LoginPresenter)presenter).onLoginClick(
                ((EditText)findViewById(R.id.addresstbx)).getText().toString(),
                ((EditText)findViewById(R.id.usernametbx)).getText().toString(),
                ((EditText)findViewById(R.id.passwordtbx)).getText().toString()
        );
        //TODO
    }
}

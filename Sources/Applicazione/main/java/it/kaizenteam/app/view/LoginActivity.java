/*
* Name: LoginActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

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


/**
 * LoginActivity shows the authentication screen, where the user can enter the address of the instance of Norris, uername and password. If the user clicks the login button will be experienced its presenter who will handle the request.
 */
public class LoginActivity extends BaseActivity implements LoginView{

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter= PresenterImpl.create(PresenterImpl.LOGIN_TYPE,this);
    }

    /**
     * This method shows the view of the message authentication failure.
     */
    @Override
    public void showAuthenticationError() {
        ((TextView)findViewById(R.id.errorloginlbl)).setVisibility(View.VISIBLE);
    }

    /**
     * This method starts the activity in which it will present the list of the instance of the Norris chart.
     */
    @Override
    public void showListView() {
        Intent i = new Intent(this,ListActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); //TODO BUG torna nella home
        startActivity(i);
    }

    /**
     * This method displays the view of a waiting signal if the parameter is true and hides otherwise.
     * @param show display / hide the view of a waiting signal
     */
    @Override
    public void showProgress(boolean show) {
        if(show)
            ((ImageView)findViewById(R.id.progressimage)).setVisibility(View.VISIBLE);
        else
            ((ImageView)findViewById(R.id.progressimage)).setVisibility(View.INVISIBLE);
    }

    /**
     * This method is called automatically by Android when the button is clicked login. It will notify its presenter have pressed.
     * @param view
     */
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

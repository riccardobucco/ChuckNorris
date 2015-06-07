/*
* Name: BarChartPresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
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

package it.kaizenteam.app.presenter;

import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * This class extends httpclient implementing the ability to add any requests also http cookies. It has the aim to use the api external Norris such as authentication and request the list of graphics. It saves the information in the model of the session.
 */
public class HttpRequesterWithCookie {
    private static HttpRequesterWithCookie instance;

    private HttpRequesterWithCookie(){
        instance=this;
    }

    static HttpRequesterWithCookie getInstance(){
        if(instance!=null)
            return instance;
        return new HttpRequesterWithCookie();
    }

    public JSONObject getlist(){

        // Create http cliient object to send request to server

        HttpClient Client = new DefaultHttpClient();

        // Create URL string

        String URL = "http://95.239.241.28:9000/list";

        //Log.i("httpget", URL);

        try
        {
            String SetServerString = "";

            // Create Request to server and get response

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            SetServerString = Client.execute(httpget, responseHandler);

            // Show response on activity

            Log.d("", SetServerString);
        }
        catch(Exception ex)
        {
            Log.d("", "Fail!");
        }

        return null;
    }

    public boolean Login(String addressNorris, String username, String password){
        /*try {
            DefaultHttpClient httpclient = new DefaultHttpClient();

            //url with the post data
            HttpPost httpost = new HttpPost(addressNorris+"/auth/login");

            //passes the results to a string builder/entity
            StringEntity se = new StringEntity("username=" + username +"&password=" + password);

            //sets the post request as the resulting string
            httpost.setEntity(se);
            //sets a request header so the page receving the request
            //will know what to do with it
            httpost.setHeader("Accept", "application/json");

            //Handles what is returned from the page
            ResponseHandler responseHandler = new BasicResponseHandler();
            Object res=httpclient.execute(httpost, responseHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return true;
    }


    public boolean Logout(){
        //TODO
        return true;
    }

    public boolean KeepAlive(){
        //TODO
        return false;
    }
}

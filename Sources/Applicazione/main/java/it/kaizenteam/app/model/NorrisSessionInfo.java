package it.kaizenteam.app.model;

/**
 * Created by Moro on 23/05/15.
 */
public interface NorrisSessionInfo {
    String getAddress();
    void setAddress(String address);
    void login();
    void logout();
    boolean isLogged();
    /*TODO public Cookie[] getAuthCookie();*/
}

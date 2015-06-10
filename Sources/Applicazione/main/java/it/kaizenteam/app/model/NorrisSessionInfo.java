/*
* Name: NorrisSessionInfo.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model;

import org.apache.http.cookie.Cookie;

import java.util.ArrayList;

/** NorrisSessionInfo is the interface NorrisSessionInfoImpl */
public interface NorrisSessionInfo {
    /** This method has the task to return the address of the instance of Norris.
     * @return String address of Norris instance
     */
    String getAddress();

    /** This method has the task of storing the address of the instance of Norris accessed.
     * @param address address of Norris instance
     */
    void setAddress(String address);

    /** This method has the task to return the endpoint of the instance of Norris.
     * @return String endpoint of Norris instance
     */
    String getEndpoint();

    /** This method has the task of storing the endpoint of the instance of Norris accessed.
     * @param endpoint endpoint of Norris instance
     */
    void setEndpoint(String endpoint);

    /** This method has the task of storing that login done in instance of Norris.
    */
    void login();

    /** This method has the task of storing that logout done in instance of Norris. */
    void logout();

    /** This method has the task of informing through a Boolean value if the session instance of Norris is active.
    * @return boolean Norris instance active / not active
    */
    boolean isLogged();

    /**
    * This method is responsible for returning the list of authentication cookies for the instance of Norris.
    * @return Cookie[] list of authentication cookies for the instance of Norris
     */
    ArrayList<Cookie> getAuthCookie();

    void setAuthCookie(ArrayList<Cookie> cookies);

}

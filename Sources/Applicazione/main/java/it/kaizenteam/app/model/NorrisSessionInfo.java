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
* v0.01	2015-05-19	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model;

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

    /** This method has the task of storing that login done in instance of Norris.
    */
    void login();

    /** This method has the task of storing that logout done in instance of Norris. */
    void logout();

    /** This method has the task of informing through a Boolean value if the session instance of Norris is active.
    * @param boolean Norris instance active / not active
    */
    boolean isLogged();

    /**TODO
    * This method is responsible for returning the list of authentication cookies for the instance of Norris.
    * @return Cookie[] list of authentication cookies for the instance of Norris
    public Cookie[] getAuthCookie();
    */
}

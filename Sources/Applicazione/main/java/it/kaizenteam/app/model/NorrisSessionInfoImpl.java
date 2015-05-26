/*
* Name: NorrisSessionInfoImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model
* Date: 23/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-23	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model;

/** This class stores the various data necessary for the session. In fact it contains the various authentication cookie and the address to which the session belongs. */
public class NorrisSessionInfoImpl implements NorrisSessionInfo {
    /**
    * The static attribute is the unique instance of that class.
    */
    private static NorrisSessionInfoImpl instance;

    /**
    * This attribute is the address belonging to Norris active session.
    */
    private String address="";

    /**
    * This attribute represents the state of the session.
    */
    private boolean isLogged=false;

    /**
    * This attribute represents the cookie authentication session to be sent to make requests.
    */
    //TODO private Cookie[] authCookie;

    /**
    * This method is responsible for returning the unique instance of this class and creating it if it not exists.
    * @return the unique Norris instance
    */
    public static NorrisSessionInfo getInstance(){
        if(instance!=null)
            return instance;
        return new NorrisSessionInfoImpl();
    }

    /**
    * This method is the constructor of the class. It is private because only through getInstance() method it is allowed to create the instance.
    */
    private NorrisSessionInfoImpl(){}

    /**
    * This method has the task to return the address of the instance of Norris.
    * @return Norris instance address
    */
    public String getAddress(){
        return address;
    }

    /**
    * This method has the task of storing the address of the instance of Norris accessed.
    * @param address Norris instance address
    */
    public void setAddress(String address){
        this.address=address;
    }

    /**
    * This method has the task of storing that login happened in instance of Norris.
    */
    public void login(){
        isLogged=true;
    }

    /**
    * This method has the task of storing that logout happened in instance of Norris.
    */
    public void logout(){
        isLogged=false;
    }

    /**
    * This method has the task of informing through a Boolean value if the session instance of Norris is active.
    * @return Norris instance active / not active
    */
    public boolean isLogged(){
        return isLogged;
    }

    /**
    * This method is responsible for returning the list of authentication cookies for the instance of Norris.
    * @return Cookie[] list of authentication cookies
    */
    /**TODO
    public Cookie[] getAuthCookie(){
        return authCookie;
    }*/
}

package it.kaizenteam.app.model;

/**
 * Created by Moro on 23/05/15.
 */
public class NorrisSessionInfoImpl implements NorrisSessionInfo {
    private static NorrisSessionInfoImpl instance;
    private String address="";
    private boolean isLogged=false;
//TODO    private Cookie[] authCookie;

    /**
     *
     * @return
     */
    public static NorrisSessionInfo getInstance(){
        if(instance!=null)
            return instance;
        return new NorrisSessionInfoImpl();
    }

    /**
     *
     */
    private NorrisSessionInfoImpl(){}

    /**
     *
     * @return
     */
    public String getAddress(){
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     *
     */
    public void login(){
        isLogged=true;
    }

    /**
     *
     */
    public void logout(){
        isLogged=false;
    }

    /**
     *
     * @return
     */
    public boolean isLogged(){
        return isLogged;
    }

    /*TODO
    public Cookie[] getAuthCookie(){
        return authCookie;
    }*/
}

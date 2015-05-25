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

/* Tale classe ha lo scopo di salvare i vari dati necessari alla sessione. Infatti in essa sono contenuti i vari cookie di autenticazione e l’indirizzo al quale la sessione appartiene. */
public class NorrisSessionInfoImpl implements NorrisSessionInfo {
    /*
    * Tale attributo statico rappresenta l’istanza univoca di tale classe.
    */
    private static NorrisSessionInfoImpl instance;

    /*
    * Tale attributo rappresenta l’indirizzo di Norris appartenente alla sessione attiva.
    */
    private String address="";

    /*
    * Tale attributo rappresenta lo stato della sessione.
    */
    private boolean isLogged=false;

    /*
    * Tale attributo rappresenta i cookie di l’autenticazione della sessione che dovranno essere inviati per effettuare le richieste.
    */
    //TODO private Cookie[] authCookie;

    /*
    * Tale metodo ha il compito di ritornare l’istanza unica di tale classe e se non esiste la crea.
    * @return NorrisSessionInfo - istanza unica di Norris
    */
    public static NorrisSessionInfo getInstance(){
        if(instance!=null)
            return instance;
        return new NorrisSessionInfoImpl();
    }

    /*
    * Tale metodo è il costruttore della classe. Esso è privato perchè non si vuole permettere a nessuno di poter creare un’istanza se non utilizzando il metodo getInstance().
    */
    private NorrisSessionInfoImpl(){}

    /*
    * Tale metodo ha il compito di ritornare l’indirizzo dell’istanza di Norris.
    * @return String - indirizzo instanza di Norris
    */
    public String getAddress(){
        return address;
    }

    /*
    * Tale metodo ha il compito di memorizzare l’indirizzo dell’istanza di Norris acceduta.
    * @param String - indirizzo dell'instanza di Norris
    */
    public void setAddress(String address){
        this.address=address;
    }

    /*
    * Tale metodo ha il compito di memorizzare il fatto che è avvenuto il login all’istanza di Norris.
    */
    public void login(){
        isLogged=true;
    }

    /*
    * Tale metodo ha il compito di memorizzare il fatto che è avvenuto il logout all’istanza di Norris.
    */
    public void logout(){
        isLogged=false;
    }

    /*
    * Tale metodo ha il compito di informare attraverso una valore booleano se la sessione all’istanza di Norris è attiva.
    * @return boolean - instanza di Norris attiva / disattiva
    */
    public boolean isLogged(){
        return isLogged;
    }

    /*
    * Tale metodo ha il compito di ritornare l’inieme dei cookie di autenticazione per l’istanza di Norris.
    * @return Cookie[] - insieme dei cookie di autenticazione
    */
    /*TODO
    public Cookie[] getAuthCookie(){
        return authCookie;
    }*/
}

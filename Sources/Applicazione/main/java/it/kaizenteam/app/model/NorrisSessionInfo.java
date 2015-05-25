/*
* Name: NorrisSessionInfo.java
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

/* NorrisSessionInfo è l’interfaccia di NorrisSessionInfoImpl */
public interface NorrisSessionInfo {
    /* Tale metodo ha il compito di ritornare l’indirizzo dell’istanza di Norris.
    * @return String - indirizzo dell'instanza di Norris
    */
    String getAddress();

    /* Tale metodo ha il compito di memorizzare l’indirizzo dell’istanza di Norris acceduta.
    * @param address - indirizzo dell'istanza di Norris
    */
    void setAddress(String address);

    /* Tale metodo ha il compito di memorizzare il fatto che è avvenuto il login all’istanza di Norris.
    */
    void login();

    /* Tale metodo ha il compito di memorizzare il fatto che è avvenuto il logout all’istanza
di Norris. */
    void logout();

    /* Tale metodo ha il compito di informare attraverso una valore booleano se la sessione all’istanza di Norris è attiva.
    * @param boolean - instanza di Norris attiva / non attiva
    */
    boolean isLogged();

    /*TODO
    * Tale metodo ha il compito di ritornare l’insieme dei cookie di autenticazione per l’istanza di Norris.
    * @return Cookie[] - insieme dei cookie di autenticazione per l'istanza di Norris
    public Cookie[] getAuthCookie();
    */
}

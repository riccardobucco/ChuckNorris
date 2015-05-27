/*
* Name: PresenterImpl.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-25  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import java.util.HashMap;
import java.util.Map;

import it.kaizenteam.app.view.View;

/**
 * This class represents a generic presenter and therefore is an abstract class. It contains inside the reference to the view in which it is associated.
 * It contains also the interface PresenterFactory and a hashmap that deals with the correspondence between the types of presenters and their factory classes.
 * The class contains constants static serving to identify the various types of presenter.
 */
public class PresenterImpl implements Presenter{
    /**
     * Hashmap that deals with the correspondence between the types of presenters and their factory classes
     */
    private static Map<Integer,PresenterFactory> factories=new HashMap<>();

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer LOGIN_TYPE=0;

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer LIST_TYPE=1;

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer BARCHART_TYPE=2;

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer MAPCHART_TYPE=3;

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer LINECHART_TYPE=4;

    /**
     * This static constant represents a type of presenter to be used for the construction of the presenter (required by the create method).
     */
    public static Integer TABLE_TYPE=5;

    /**
     * This attribute is a reference to the view on the presenter.
     */
    protected View view;


    static {
        //carico le classi per formare gli hashmap statici
        String[] classi=new String[]{
                "it.kaizenteam.app.presenter.MapChartPresenterImpl",
                "it.kaizenteam.app.presenter.BarChartPresenterImpl",
                "it.kaizenteam.app.presenter.LineChartPresenterImpl",
                "it.kaizenteam.app.presenter.TablePresenterImpl",
                "it.kaizenteam.app.presenter.ListPresenterImpl",
                "it.kaizenteam.app.presenter.LoginPresenterImpl",
        };

        new ClassLoader() {
            public void load(String[] classi){
                for (int i=0;i<classi.length;i++){
                    try {
                        Class.forName(classi[i]);
                    }catch (Exception e){}
                }
            }
        }.load(classi);
    }

    /**
     * This method is used to record a certain factory to its presenter nell'hashmap class.
     * @param presenterType
     * @param factory
     */
    protected static void registerFactory(Integer presenterType, PresenterFactory factory){
        factories.put(presenterType,factory);
    }

    /**
     * This method creates the presenter of the parameter presenterType, initializes the view field with the parameter view and finally returns the interface Presenter of the instance created.
     * @param presenterType
     * @param view
     * @return the interface Presenter of the instance created
     */
    public static Presenter create(Integer presenterType, View view){
        PresenterImpl ret = factories.get(presenterType).createPresenter();
        ret.view=view;
        return ret;
    }

    /**
     * This method is the constructor of the class. It is protected to disallow direct creation of an instance of that class by classes not authorized.
     */
    protected PresenterImpl(){}

    /**
     * PresenterFactory is the interface of the factory classes that deal creation of various types of presenter. It is internal to the class PresenterImpl.
     */
    protected interface PresenterFactory{
        PresenterImpl createPresenter();
    }
}

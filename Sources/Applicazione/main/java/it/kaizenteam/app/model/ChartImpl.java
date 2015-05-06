/*
* Name: {ChartImpl.java}
* Package: {it.kaizenteam.app.model}
* Location: {src.main.java.it.kaizenteam.model}
* Date: {data di creazione del file}
* Version: {0.01}
*
* History:
*
* =================================================================
* Version Date Programmer Changes
* =================================================================
* 0.01 GG-MM-AAAA Aessandro Moretto {creation}
* =================================================================
*
*/
package it.kaizenteam.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * This class rapresent an abstract Chart. It contains data and settings.
 */
public abstract class ChartImpl extends Observable implements Chart{

    // DI grafici specifici

    private static Map<String,ChartFactory> chartfactories = new HashMap<>();

    protected static void registerFactory(String type, ChartFactory factory) {
        chartfactories.put(type, factory);
    }

    public static ChartImpl create(String type, String id) throws Exception {
        ChartFactory factory = chartfactories.get(type);

        if(factory != null)
            return factory.create(id);
        else
            throw new Exception();
    }

    protected interface ChartFactory {
        ChartImpl create(String id);
    }

    // DI updater

    private HashMap<String,Updater> updaters = new HashMap<String,Updater>();

    protected void registerUpdater(String type, Updater updater) {
        updaters.put(type, updater);
    }

    protected interface Updater {
        void update(UpdateObject object);
    }


    // classe vera e propria

    final String id;
    DataObject data;
    SettingsObject settings;

    protected ChartImpl(String id) {
        this.id = id;
    }

    public abstract void setSettings(SettingsObject object);
    public abstract void setData(DataObject object);

    public void update(String type, UpdateObject object) throws Exception {
        Updater updater = updaters.get(type);

        if(updater != null)
            updater.update(object);
        else
            throw new Exception();
    }
}
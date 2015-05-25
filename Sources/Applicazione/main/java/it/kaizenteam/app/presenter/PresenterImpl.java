package it.kaizenteam.app.presenter;

import java.util.HashMap;
import java.util.Map;

import it.kaizenteam.app.view.View;

/**
 * Created by Moro on 19/05/15.
 */
public class PresenterImpl implements Presenter{
    private static Map<Integer,PresenterFactory> factories=new HashMap<>();
    public static Integer LOGIN_TYPE=0;
    public static Integer LIST_TYPE=1;
    public static Integer BARCHART_TYPE=2;
    public static Integer MAPCHART_TYPE=3;
    public static Integer LINECHART_TYPE=4;
    public static Integer TABLE_TYPE=5;
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
     *
     * @param presenterType
     * @param factory
     */
    protected static void registerFactory(Integer presenterType, PresenterFactory factory){
        factories.put(presenterType,factory);
    }

    /**
     *
     * @param presenterType
     * @param view
     * @return
     */
    public static Presenter create(Integer presenterType, View view){
        PresenterImpl ret = factories.get(presenterType).createPresenter();
        ret.view=view;
        return ret;
    }

    /**
     *
     */
    protected PresenterImpl(){}

    /**
     *
     */
    protected interface PresenterFactory{
        PresenterImpl createPresenter();
    }
}

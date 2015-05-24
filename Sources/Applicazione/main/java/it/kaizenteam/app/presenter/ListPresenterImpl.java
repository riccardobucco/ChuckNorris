package it.kaizenteam.app.presenter;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisSessionInfoImpl;
import it.kaizenteam.app.view.ListView;

/**
 * Created by Moro on 19/05/15.
 */
public class ListPresenterImpl extends PresenterImpl implements ListPresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(LIST_TYPE, ListPresenterFactory.getInstance());
    }

    @Override
    public void onItemClicked(String type, String id) {
        ((ListView)view).showChartDetailView(type, id);
    }

    @Override
    public void onLogoutClick() {
        NorrisSessionInfoImpl.getInstance().logout();
        ((ListView)view).navigateToLoginView();
    }

    @Override
    public void onResume() {
        //TODO
        ArrayList<String[]> a= new ArrayList<>();
        a.add(new String[]{"id1","barchart"});
        a.add(new String[]{"id2","linechart"});
        a.add(new String[]{"id3","mapchart"});
        a.add(new String[]{"id4","table"});
        ((ListView)view).renderList(a);
    }

    private ListPresenterImpl(){}

    protected static class ListPresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new ListPresenterFactory();
        }

        private ListPresenterFactory(){
            instance=this;
        }

        @Override
        public PresenterImpl createPresenter() {
            return new ListPresenterImpl();
        }
    }
}

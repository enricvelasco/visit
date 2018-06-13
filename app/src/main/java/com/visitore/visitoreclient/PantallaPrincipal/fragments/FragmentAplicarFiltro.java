package com.visitore.visitoreclient.PantallaPrincipal.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.visitore.visitoreclient.R;
import com.visitore.visitoreclient.core.domain.CategoriaProductos;
import com.visitore.visitoreclient.core.model.CategoriaProductosModel;
import com.visitore.visitoreclient.core.model.dao.categoriaProductos.DaoCategoriaProductosList;

import java.util.ArrayList;
import java.util.List;

public class FragmentAplicarFiltro extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CategoriaProductosModel categoriaProductosModel = new CategoriaProductosModel();
    private String TAG = "[fragment descubrir]";

    public static FragmentAplicarFiltro newInstance() {
        FragmentAplicarFiltro fragment = new FragmentAplicarFiltro();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtros, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(final ViewPager viewPager) {
        categoriaProductosModel.listado(new DaoCategoriaProductosList() {
            @Override
            public void onSuccessList(List<CategoriaProductos> categoriaProductosList) {
                if(categoriaProductosList.size()<5){
                    tabLayout.setTabMode(1);//fixed
                }else{
                    tabLayout.setTabMode(0);//scrollable
                }
                ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
                for(CategoriaProductos cat:categoriaProductosList){
                    adapter.addFragment(new Fragment1(), cat.getNombre());
                    if(cat.getCategoriasHijas() !=null && cat.getCategoriasHijas().size()>0){
                        Log.d(TAG, "tiene subcategorias");
                        recorrerSubcategorias(cat.getCategoriasHijas());
                    }
                }
                viewPager.setAdapter(adapter);
            }

            @Override
            public void onFailed(String e) {
                Toast toast = Toast.makeText(getContext(), "Error recuperar Categorias", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void recorrerSubcategorias(List<CategoriaProductos> categoriasHijas) {
        for(CategoriaProductos subCat:categoriasHijas){
            Log.d("Subcategoria nombre",subCat.getNombre());

        }
    }
}
class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}

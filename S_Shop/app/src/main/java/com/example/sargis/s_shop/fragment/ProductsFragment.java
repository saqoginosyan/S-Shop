package com.example.sargis.s_shop.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.sargis.s_shop.Categories;
import com.example.sargis.s_shop.R;
import com.example.sargis.s_shop.adapter.ProductsAdapter;
import com.example.sargis.s_shop.provider.ProductProvider;

public class ProductsFragment extends Fragment {

    private RecyclerView productsList;
    private ProductsAdapter adapter;
    private SearchView searchView;

    public ProductsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_products, container, false);
        adapter = new ProductsAdapter(getContext(), ProductProvider.getProductsList(getContext()));

        productsList = view.findViewById(R.id.products_recycler);
        productsList.setHasFixedSize(true);
        productsList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        productsList.setAdapter(adapter);
        setHasOptionsMenu(true);

        return view;
    }

    public void getCategory(Enum<Categories> category) {
        productsList.setAdapter(new ProductsAdapter(getActivity(), ProductProvider.getProductsByCategory(category)));
    }

    public void getFavorites() {
        productsList.setAdapter(new ProductsAdapter(getActivity(), ProductProvider.getFavProductsList()));
    }

    public void getCart() {
        productsList.setAdapter(new ProductsAdapter(getActivity(), ProductProvider.getCardProductsList()));
    }

    public void getAllProducts() {
        productsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search_id);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }
}

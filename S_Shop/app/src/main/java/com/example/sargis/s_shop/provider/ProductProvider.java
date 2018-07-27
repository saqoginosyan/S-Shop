package com.example.sargis.s_shop.provider;

import android.content.Context;

import com.example.sargis.s_shop.Categories;
import com.example.sargis.s_shop.R;
import com.example.sargis.s_shop.model.ProductModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.sargis.s_shop.Categories.ELECTRIC;
import static com.example.sargis.s_shop.Categories.MECHANICAL;
import static com.example.sargis.s_shop.Categories.QUARTZ;

public class ProductProvider {

    private static List<ProductModel> productsList = new ArrayList<>();

    public static List<ProductModel> getProductsList(Context context) {

        if (!productsList.isEmpty()) {
            productsList.clear();
        }

        productsList.add(new ProductModel("Vacheron Constantin", context.getResources().getStringArray(R.array.vacheron_constantin), MECHANICAL, context.getString(R.string.large_text), "13100$", context.getString(R.string.vacheron_video), false, false, 4.5f));
        productsList.add(new ProductModel("Patek Phillipe", context.getResources().getStringArray(R.array.patek_phillipe), MECHANICAL, context.getString(R.string.large_text), "36160$", context.getString(R.string.patek_video), false, false, 5f));
        productsList.add(new ProductModel("Frank Muller", context.getResources().getStringArray(R.array.frank_muller), MECHANICAL, context.getString(R.string.large_text), "19700$", context.getString(R.string.muller_video), false, false, 4f));
        productsList.add(new ProductModel("CASIO Mens", context.getResources().getStringArray(R.array.casio_mens), ELECTRIC, context.getString(R.string.large_text), "2980$", context.getString(R.string.casio_video), false, false, 4.5f));
        productsList.add(new ProductModel("Omega Seamaster", context.getResources().getStringArray(R.array.omega), ELECTRIC, context.getString(R.string.large_text), "2700$", context.getString(R.string.omega_video), false, false, 4f));
        productsList.add(new ProductModel("Hamilton", context.getResources().getStringArray(R.array.hamilton), ELECTRIC, context.getString(R.string.large_text), "1500$", context.getString(R.string.hamilton_video), false, false, 3.5f));
        productsList.add(new ProductModel("Uwood UW", context.getResources().getStringArray(R.array.uwood), QUARTZ, context.getString(R.string.large_text), "66000$", context.getString(R.string.uwood_video), false, false, 5f));
        productsList.add(new ProductModel("Audemars Piguet", context.getResources().getStringArray(R.array.audemars), QUARTZ, context.getString(R.string.large_text), "28890$", context.getString(R.string.audemars_video), false, false, 4.5f));
        productsList.add(new ProductModel("Cartier", context.getResources().getStringArray(R.array.cartier), QUARTZ, context.getString(R.string.large_text), "11500$", context.getString(R.string.cartier_video), false, false, 4f));

        Collections.shuffle(productsList);
        return productsList;
    }

    public static ProductModel getProductByPosition(int position) {
        return productsList.get(position);
    }

    public static List<ProductModel> getProductsByCategory(Enum<Categories> category) {

        List<ProductModel> categoryList = new ArrayList<>();

        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getCategory().equals(category)) {
                categoryList.add(productsList.get(i));
            }
        }
        return categoryList;
    }


    public static List<ProductModel> getFavProductsList() {

        List<ProductModel> favProductsList = new ArrayList<>();

        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getLiked()) {
                favProductsList.add(productsList.get(i));
            }
        }
        return favProductsList;
    }


    public static List<ProductModel> getCardProductsList() {

        List<ProductModel> cardProductsList = new ArrayList<>();

        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getToBasket()) {
                cardProductsList.add(productsList.get(i));
            }
        }
        return cardProductsList;
    }
}

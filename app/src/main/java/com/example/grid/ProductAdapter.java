package com.example.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductModel> productData;
    LayoutInflater layoutInflater;
    ProductModel productModel;

    public ProductAdapter(Context context, ArrayList<ProductModel> productData) {
        this.context = context;
        this.productData = productData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return productData.size();
    }

    @Override
    public Object getItem(int i) {
        return productData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View view1 = view;
        if (view1==null) {
            view1 = layoutInflater.inflate(R.layout.list_product,null, true);
        }
        //getting view in row_data
        ImageView avata = view1.findViewById(R.id.imagehinh);
        TextView tensp = view1.findViewById(R.id.tensp);
        TextView giasp = view1.findViewById(R.id.giasp);

        productModel = productData.get(position);

        avata.setImageResource(productModel.getAvata());
        tensp.setText(productModel.getTensp());
        giasp.setText(productModel.getGiasp());
        return view1;
    }
}
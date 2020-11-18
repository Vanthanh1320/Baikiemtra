package com.example.grid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    GridView gridview;
    Context context;

    RelativeLayout gridviewdata;

    ArrayList<ProductModel> productData;
    ProductAdapter productAdapter;
    ProductModel productModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        gridview = findViewById(R.id.gridview);
        gridviewdata = (RelativeLayout) findViewById(R.id.gridviewdata);
        productData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        gridview.setOnItemLongClickListener(new ItemLongClickRemove());
        productAdapter = new ProductAdapter(context,productData);
        gridview.setAdapter(productAdapter);
        registerForContextMenu(gridview);
        gridview = findViewById(R.id.gridview);
        gridview.setOnItemLongClickListener(new ItemLongClickRemove());
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,productData.get(position).getTensp(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),GridActivity.class);
                intent.putExtra("avata",productData.get(position).getAvata());
                intent.putExtra("tensp",productData.get(position).getTensp());
                intent.putExtra("giasp",productData.get(position).getGiasp());
                startActivity(intent);
            }
        });

    }
    private void populateProductData() {
        //product1
        productModel = new ProductModel();
        productModel.setId(1);
        productModel.setAvata(R.drawable.dt1);
        productModel.setTensp("Samsung Galaxy11");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);

        productModel = new ProductModel();
        productModel.setId(2);
        productModel.setAvata(R.drawable.dt2);
        productModel.setTensp("Samsung Galaxy Note 20");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);

        productModel = new ProductModel();
        productModel.setId(3);
        productModel.setAvata(R.drawable.dt3);
        productModel.setTensp("Iphone 12");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);

        productModel = new ProductModel();
        productModel.setId(4);
        productModel.setAvata(R.drawable.dt4);
        productModel.setTensp("VS Mart 2020");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);

        productModel = new ProductModel();
        productModel.setId(5);
        productModel.setAvata(R.drawable.dt5);
        productModel.setTensp("Samsung Galaxy J7 Prime");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);

        productModel = new ProductModel();
        productModel.setId(6);
        productModel.setAvata(R.drawable.dt6);
        productModel.setTensp("Xiaomi 2019");
        productModel.setGiasp("475.000 VND");
        productData.add(productModel);



    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này?");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productData.remove(position);
                    //cập nhật lại gridview
                    productAdapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}
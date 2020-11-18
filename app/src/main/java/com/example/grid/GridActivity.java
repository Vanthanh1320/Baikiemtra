package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {
    ImageView idavata;
    TextView idtensp,idgiasp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        idavata=(ImageView) findViewById(R.id.idavata);
        idtensp=(TextView) findViewById(R.id.idtensp);
        idgiasp=(TextView) findViewById(R.id.idgiasp);

        Intent intent = getIntent();
        int receivedAvata = intent.getIntExtra("avata",0);
        String receivedTensp =  intent.getStringExtra("tensp");
        String receivedGiasp =  intent.getStringExtra("giasp");

        idavata.setImageResource(receivedAvata);
        idtensp.setText(receivedTensp);
        idgiasp.setText(receivedGiasp);
        //hiện nút quay lại
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
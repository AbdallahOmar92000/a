package com.example.retrofit.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.adapter.ProductAdapter;
import com.example.retrofit.api.ServiceApi;
import com.example.retrofit.model.ProductList;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity2 extends AppCompatActivity {
    private static final String BASEURL = "";
    ListView lv;
    List<ProductList> list;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=(ListView)findViewById(R.id.listview);

        getData();

    }
    private void getData(){
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(BASEURL).build();

        ServiceApi api = adapter.create(ServiceApi.class);

        api.getproduct(new Callback<List<ProductList>>() {
            @Override
            public void success(List<ProductList> productLists, Response response) {
                list = productLists;
                productAdapter = new ProductAdapter(MainActivity2.this,R.layout.records_list,list);
                lv.setAdapter(productAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity2.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.retrofit.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.api.ServiceApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String BASEURL = "https://abdallah92.000webhostapp.com";
//    private static final String BASEURL = "https://192.168.10.108";

    EditText name,des,price;
    Button sendData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =(EditText)findViewById(R.id.nameeditText);
        des =(EditText)findViewById(R.id.desceditText);
        price =(EditText)findViewById(R.id.priceeditText);

        sendData=(Button)findViewById(R.id.addbutton);
        sendData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        productAdd();
        name.setText("");
        des.setText("");
        price.setText("");
    }

    private void productAdd(){

        String pname = name.getText().toString().trim();
        String pdesc = des.getText().toString().trim();
        String pprice = price.getText().toString().trim();
        String pp = price.getText().toString();



        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASEURL).build();

        ServiceApi serviceApi = restAdapter.create(ServiceApi.class);

        serviceApi.addProduct(
                pname,
                pdesc,
                pp,
                new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        BufferedReader reader = null;
                        String result = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                            result = reader.readLine();

                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }

                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


                    }
                }
        );



    }
}

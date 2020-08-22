package com.example.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retrofit.R;
import com.example.retrofit.model.ProductList;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductList> {

    private  Context context;
    private List<ProductList>list;


    public ProductAdapter(Context context, int layout, List<ProductList> list){

        super(context,layout,list);
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.records_list,parent,false);
        }

        TextView id=(TextView)view.findViewById(R.id.textView);
        TextView name =(TextView)view.findViewById(R.id.textView2);
        TextView desc=(TextView)view.findViewById(R.id.textView3);
        TextView price=(TextView)view.findViewById(R.id.textView4);

        ProductList productList = list.get(position);
        id.setText(""+productList.getId());
        name.setText(""+productList.getName());
        desc.setText(""+productList.getDesc());
        price.setText(""+productList.getPrice());


        return view;
    }
}

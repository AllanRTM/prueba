package com.example.Coca_cola_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Product> products = new ArrayList<>();
    Button btnPlaceOrder;
    ArrayList<Product> productOrders = new ArrayList<>();

    ArrayList<String> lOrderItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getProduct();
        listView = (ListView) findViewById(R.id.customListView);
        listAdapter = new ListAdapter(this,products);
        listView.setAdapter(listAdapter);
        btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }


    public void getProduct() {
        products.add(new Product("Coca-cola en Lata",10.0d,R.mipmap.primer));
        products.add(new Product("Coca-cola Mini",10.0d,R.mipmap.segunda));
        products.add(new Product("Coca-cola Portatil",10.0d,R.mipmap.tercera));
        products.add(new Product("Coca-cola Medio Litro",10.0d,R.mipmap.cuarta));
        products.add(new Product("Coca-cola Litro",10.0d,R.mipmap.quinta));
        products.add(new Product("Coca-cola 1.1 Litros",10.0d,R.mipmap.sexta));
        products.add(new Product("Coca-cola 1.25 Litros",10.0d,R.mipmap.septima));
        products.add(new Product("Coca-cola 1.5 Litros",10.0d,R.mipmap.octava));
        products.add(new Product("Coca-cola Dos Litros",10.0d,R.mipmap.novena));
        products.add(new Product("Coca-cola Dos y medio Litros",10.0d,R.mipmap.decima));
        products.add(new Product("Coca-cola Tres Litros",10.0d,R.mipmap.eleven));

    }

    private void placeOrder()
    {
        productOrders.clear();
        lOrderItems.clear();

        for(int i=0;i<listAdapter.listProducts.size();i++)
        {
            if(listAdapter.listProducts.get(i).CartQuantity > 0)
            {
                Product products = new Product(
                        listAdapter.listProducts.get(i).ProductName
                        ,listAdapter.listProducts.get(i).ProductPrice
                        ,listAdapter.listProducts.get(i).ProductImage
                );

                products.CartQuantity = listAdapter.listProducts.get(i).CartQuantity;
                productOrders.add(products);

                lOrderItems.add(products.getJsonObject().toString());

            }
        }


        JSONArray jsonArray = new JSONArray(lOrderItems);
        openSummary(jsonArray.toString());



    }

    //COCA COLA
 /* public void openSummary(String orderItems)
  {
    Intent summaryIntent = new Intent(this,Summary.class);
    summaryIntent.putExtra("orderItems",orderItems);
    startActivity(summaryIntent);
  }*/

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void openSummary(String orderItems)
    {
        Intent summaryIntent = new Intent(this, Summary.class);
        summaryIntent.putExtra("orderItems",orderItems);
        startActivity(summaryIntent);
    }



}

package com.alexis.rios.appfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.serverbpw.com/cm//2020-1/products.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<Product> products = new ArrayList<Product>();

                        try {
                            JSONArray reader = new JSONArray(response);
                            int longitud = reader.length();
                            for (int i = 0; i < longitud; i++) {
                                JSONObject datos = reader.getJSONObject(i);
                                Long id = datos.getLong("id");
                                String name = datos.getString("name");
                                String url_imagen = datos.getString("thumbnail_url");
                                Double price = datos.getDouble("price");
                                String provider = datos.getString("provider");
                                Double delivery = datos.getDouble("delivery");
                                products.add(new Product(id, name, url_imagen, price, provider, delivery));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(), R.layout.list_items_view, products);
                        listViewProducts.setAdapter(productAdapter);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }

    private void inicializar() {
        listViewProducts = findViewById(R.id.main_listView_products);
        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p =  (Product) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), InformacionActivity.class);
                intent.putExtra("id", p.getId());
                startActivity(intent);
            }
        });
    }
}

package com.alexis.rios.appfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

public class InformacionActivity extends AppCompatActivity {

    TextView textViewNombre, textViewDescripcion;
    ImageView imageViewThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Long id = getIntent().getLongExtra("id", 0);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.serverbpw.com/cm/2020-1/product_detail.php?id=" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<Product> products = new ArrayList<Product>();

                        try {
                            JSONObject reader = new JSONObject(response);
                            String name = reader.getString("name");
                            String url_imagen = reader.getString("imag_url");
                            String descripcion = reader.getString("desc");
                            textViewNombre.setText(name);
                            textViewDescripcion.setText(descripcion);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }

    private void inicializar() {
        textViewDescripcion = findViewById(R.id.informacion_textView_datos);
        textViewNombre = findViewById(R.id.informacion_textView_nombre);
        imageViewThumbnail = findViewById(R.id.informacion_imageView_imagen);
    }
}

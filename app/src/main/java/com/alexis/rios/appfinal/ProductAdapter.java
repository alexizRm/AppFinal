package com.alexis.rios.appfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, int layout, ArrayList<Product> products) {
        this.context = context;
        this.layout = layout;
        this.products = products;
    }

    public int getCount() {
        return this.products.size();
    }

    public Object getItem(int position) {
        return this.products.get(position);
    }

    public long getItemId(int id) {
        return id;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_items_view, null);
        Product product = products.get(position);
        ImageView imagen = (ImageView) v.findViewById(R.id.list_items_imageView_imagen);
        TextView nombre = (TextView) v.findViewById(R.id.list_items_textView_nombre);
        TextView proveedor = (TextView) v.findViewById(R.id.lists_items_textView_proveedor);
        TextView precio = (TextView) v.findViewById(R.id.list_items_textView_precio);

        nombre.setText(product.getNombre());
        proveedor.setText(product.getProveedor());
        precio.setText(String.format("%f", product.getPrecio()));

        return v;
    }

}

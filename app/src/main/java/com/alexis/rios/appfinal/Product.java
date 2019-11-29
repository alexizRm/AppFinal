package com.alexis.rios.appfinal;

public class Product {

    private Long id;
    private String nombre;
    private String urlImage;
    private Double precio;
    private String proveedor;
    private Double entrega;

    public Product(Long id, String nombre, String urlImage, Double precio, String proveedor, Double entrega) {
        this.id = id;
        this.nombre = nombre;
        this.urlImage = urlImage;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

}

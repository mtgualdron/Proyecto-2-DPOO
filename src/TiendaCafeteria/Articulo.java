package TiendaCafeteria;

import Excepciones.UbicacionInvalidaException;

public class Articulo {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidadDisponible;
    private String ubicacion;

    public Articulo(String nombre, String categoria, double precio, int cantidadDisponible, String ubicacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean estaAgotado() {
        return this.cantidadDisponible <= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void mover(String nuevaUbicacion) throws UbicacionInvalidaException{ 
        if (nuevaUbicacion.equals("")){
            throw new UbicacionInvalidaException("No se ingresó una ubicación valida. Verifique que el campo no esté vacío.");}
        this.ubicacion = nuevaUbicacion;

        }
    public void abastecer(int cantidad){
        this.cantidadDisponible += cantidad;
    }

        
    }


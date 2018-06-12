package com.visitore.visitoreclient.core.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Tienda {
    private String _id = UUID.randomUUID().toString();
    private String nombre;
    private Direccion direccion;
    private String observaciones;
    private List<Producto> productos;
    private String idAsociacion;

    Date fechaCreacion = new Date();
    Date fechaModificacion = new Date();

    public Tienda() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(String idAsociacion) {
        this.idAsociacion = idAsociacion;
    }
}

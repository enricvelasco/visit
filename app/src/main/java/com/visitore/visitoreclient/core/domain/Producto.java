package com.visitore.visitoreclient.core.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Producto {
    private String _id = UUID.randomUUID().toString();
    private String nombre;
    private String observaciones;
    private List<Producto> productosHijos;
    private String idTienda;
    private String idAsociacion;
    private String idCategoriaProducto;

    Date fechaCreacion = new Date();
    Date fechaModificacion = new Date();

    public Producto() {
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Producto> getProductosHijos() {
        return productosHijos;
    }

    public void setProductosHijos(List<Producto> productosHijos) {
        this.productosHijos = productosHijos;
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

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(String idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public String getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(String idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }
}

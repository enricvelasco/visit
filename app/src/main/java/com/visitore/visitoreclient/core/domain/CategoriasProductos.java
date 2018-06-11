package com.visitore.visitoreclient.core.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CategoriasProductos {
    private String _id = UUID.randomUUID().toString();
    private String nombre;
    private String descripcion;
    private List<CategoriasProductos> categoriasHijas;

    Date fechaCreacion = new Date();
    Date fechaModificacion = new Date();

    public CategoriasProductos() {
    }

    public CategoriasProductos(String nombre) {
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CategoriasProductos> getCategoriasHijas() {
        return categoriasHijas;
    }

    public void setCategoriasHijas(List<CategoriasProductos> categoriasHijas) {
        this.categoriasHijas = categoriasHijas;
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democlient.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Owner
 */
//Se asocia una tabla a la clase
@Table
@Entity(name="cliente")
public class Clientes implements Serializable {
    //se asocian los atributos (columnas)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idcliente")
    private Integer idcliente;
    @Column(name="nombre")
    private String nombre;
    @Column(name="telefono")
    private Integer telefono;
    @Column(name="correo")
    private String correo;

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}

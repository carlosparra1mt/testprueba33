/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democlient.services;


import com.example.democlient.model.Clientes;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface ClienteService {
    //agregamos métodos de CrudRepository: save, deletebyId, findById, findAll
    public Clientes save(Clientes cliente);  //guardar objeto cliente
    public void delete(Integer idcliente); //borra
    public Clientes findById(Integer idcliente); //encuentra por id
    public List<Clientes> findAll(); //encuentra todos
}

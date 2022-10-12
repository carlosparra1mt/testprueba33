/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democlient.dao;


import com.example.democlient.model.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Owner
 */
@Repository
public interface ClienteDao extends CrudRepository<Clientes,Integer> {
    
}

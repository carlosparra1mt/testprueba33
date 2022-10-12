/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democlient.services.implement;


import com.example.democlient.dao.ClienteDao;
import com.example.democlient.model.Clientes;
import com.example.democlient.services.ClienteService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    //Conectar con el dao
    @Autowired
    private ClienteDao clientedao;
    
    //Se implementa el guardado en la tabla cliente
    @Override
    @Transactional
    public Clientes save(Clientes cliente){
        return clientedao.save(cliente);
    }
    @Override
    @Transactional
    public void delete(Integer idcliente) {
        clientedao.deleteById(idcliente);
    }
    @Override
    @Transactional
    public Clientes findById(Integer idcliente) {
        return clientedao.findById(idcliente).orElse(null);
    }
    @Override
    @Transactional
    public List<Clientes> findAll() {
        return (List<Clientes>) clientedao.findAll();
    } 
}

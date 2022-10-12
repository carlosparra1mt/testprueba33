/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.democlient.controller;


import com.example.democlient.model.Clientes;
import com.example.democlient.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Owner
 */
//Esta clase va a manejar las operaciones REST (Get, Post, Put, Delete)
@RestController
//Se admiten las peticiones de todas partes, para que no haya problema por permiso de acceso
// 132.25.21.54/
@CrossOrigin("*")
//Lo que se le agrega a la URL para que el servidor de páginas lo acceda
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteservice;
    //Valor del mapping se denomina endpoint
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/cliente/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/cliente/321
    //Peticiones GET
    //Traer todos los clientes
    @GetMapping(value="/list")
    public List<Clientes> recuperarTodos() {
        return (List<Clientes>) clienteservice.findAll();
    }
    //Traer un solo cliente por el idcliente
    @GetMapping(value="/list/{idcliente}")
    public Clientes recuperaUno(@PathVariable Integer idcliente){
        return clienteservice.findById(idcliente);
    }
    //Peticiones POST para insertar
    @PostMapping(value="/")
    public ResponseEntity<Clientes> agregar(@RequestBody Clientes cliente) {
        Clientes cli;
        cli = clienteservice.save(cliente);
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    //Petición PUT para actualizar
    @PutMapping(value="/")
    public ResponseEntity<Clientes> actualizar(@RequestBody Clientes cliente) {
        //Buscamos el cliente que se quiere actualizar, por su idcliente
        Clientes cli = clienteservice.findById(cliente.getIdcliente());
        //Puede ocurrir que lo encuentre o no
        if (cli!=null) {
            //Lo encontró
            cli.setNombre(cliente.getNombre()); //Actualiza valor del objeto encontrado
            cli.setTelefono(cliente.getTelefono());
            cli.setCorreo(cliente.getCorreo());
            clienteservice.save(cli);
        } else {
            //No lo encontró
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    //Petición DELETE
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Clientes> borrar(@PathVariable Integer idcliente) {
        //Buscar al cliente
        Clientes cli = clienteservice.findById(idcliente);
        if (cli!=null) {
            clienteservice.delete(idcliente);
        } else {
            //No lo encontró
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
}

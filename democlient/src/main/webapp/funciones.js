/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function traerInformacion(){
    $.ajax({
        url:"http://localhost:8080/democlient-0.0.1-SNAPSHOT/cliente/list",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta(respuesta.items);
        }
    });
}
function pintarRespuesta(items){
    let myTable ="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].idcliente+"</td>";
        myTable+="<td>"+items[i].nombre+"</td>";
        myTable+="<td>"+items[i].correo+"</td>";
        myTable+="<td>"+items[i].telefono+"</td>";
        myTable+="<td> <button onclick='borrarElemento("+items[i].idcliente+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}
function guardarInformacion(){
    let myData={
        idcliente:$("#idcliente").val(),
        nombre:$("#nombre").val(),
        correo:$("#correo").val(),
        telefono:$("#telefono").val(),
        
    };
    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:"http://localhost:8080/democlient-0.0.1-SNAPSHOT/cliente/",
        type:"POST",
        data:myData,
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#idcliente").val("");
            $("#nombre").val("");
            $("#correo").val("");
            $("#telefono").val("");
            traerInformacion();
            alert("Se ha guardado el dato");
        }
    });   
}

function editarInformacion(){
    let myData={
        id:$("#idcliente").val(),
        nombre:$("#nombre").val(),
        correo:$("#correo").val(),
        telefono:$("#telefono").val(),
        
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);


    $.ajax({
        url:"http://localhost:8080/democlient-0.0.1-SNAPSHOT/cliente/",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#idcliente").val("");
            $("#nombre").val("");
            $("#correo").val("");
            $("#telefono").val("");
            traerInformacion();
            alert("Se ha actualizado el dato");
        }
    });   
}

function borrarElemento(idElemento){
    let myData={
        idcliente:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/democlient-0.0.1-SNAPSHOT/cliente/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            traerInformacion();
            alert("Se ha eliminado el dato");
        }
    });    
}


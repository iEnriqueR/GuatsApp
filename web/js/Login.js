/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function login() {

    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var usuario = document.getElementById("usuario").value;
    var contrasena = document.getElementById("contrasena").value;
    
    $.post("Registro",
            {
                nombre: nombre,
                apellido: apellido,
                usuario: usuario,
                contrasena: contrasena
            }, function (data) {
        console.log("Hey tu data" + data);
        
    });
}


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function enviarMensaje(){
    var mensaje = document.getElementById("campoMensaje").value;
    document.getElementById("campoMensaje").value = "";
    $.post("GuardarMensaje",
    {
        mensaje: mensaje
    },
    function(retorno){
        if(retorno.resultado === true){
            console.log("Mensaje enviado");
        } else{
            console.log("Mensaje fallido");
        }
    }
    );   
}

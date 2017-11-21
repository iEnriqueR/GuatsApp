/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarLogin(){
    var usuario = document.getElementById("usuario").value;
    var pass = document.getElementById("password").value;
    
    $.post("ValidarLogin",
    {
        usuario: usuario,
        pass: pass
    },
    function(retorno){
        if(retorno.resultado === true){
            //window.alert("Usuario: " + retorno.id);
//            $.post("IniciarUsuario",
//            {
//                id: retorno.id
//            },
//            function(data){});
            location.href="chat.html";
        }
        else{
            window.alert("Datos incorrectos");
        }
    }
    );
}

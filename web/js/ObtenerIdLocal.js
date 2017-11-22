/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function obtenerIdLocal(){
    var id;
//    $.get("IniciarUsuario",
//    function(retorno){
//      id = retorno.id;  
//    });
//    $.get("IniciarUsuario", retorno,
//        id = retorno.id
//    );
    
    $.ajax({

            url : "IniciarUsuario",
            dataType : 'json',
            error : function() {
                alert("Error Occured");
            },
            success : function(data) {
                id = data.id;

            }
        });
    
    window.alert(id);
    console.log(id);
}
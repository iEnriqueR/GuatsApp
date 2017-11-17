/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var moldeIzquierdo = "<li class=\"left clearfix\">\n" +
        "                                <span class=\"chat-img pull-left\">\n" +
        "                                    <img src=\"https://bootdey.com/img/Content/user_3.jpg\" alt=\"User Avatar\">\n" +
        "                                </span>\n" +
        "                                <div class=\"chat-body clearfix\">\n" +
        "                                    <div class=\"header\">\n" +
        "                                        <strong class=\"primary-font\" >{nombre}</strong>\n" +
        "                                        <small class=\"pull-right text-muted\"><i class=\"fa fa-clock-o\"></i> 12 mins ago</small>\n" +
        "                                    </div>\n" +
        "                                    <p>\n" +
        "                                        {mensaje}" +
        "                                    </p>\n" +
        "                                </div>\n" +
        "                            </li>";



//var moldeDerecho = "<li class=\"right clearfix\">\n" +
//        "                                <span class=\"chat-img pull-right\">\n" +
//        "                                    <img src=\"https://bootdey.com/img/Content/user_1.jpg\" alt=\"User Avatar\">\n" +
//        "                                </span>\n" +
//        "                                <div class=\"chat-body clearfix\">\n" +
//        "                                    <div class=\"header\">\n" +
//        "                                        <strong class=\"primary-font\">{nombre}</strong>\n" +
//        "                                        <small class=\"pull-right text-muted\"><i class=\"fa fa-clock-o\"></i> 13 mins ago</small>\n" +
//        "                                    </div>\n" +
//        "                                    <p>\n" +
//        "                                        {mensaje}" +
//        "                                    </p>\n" +
//        "                                </div>\n" +
//        "                            </li> ";

function updateMensaje() {
    //var idB=document.getElementById(idB);

    //var mensaje=document.getElementById(mensaje);
    $.get("ObtenerConversacion",
            function (mensajes) {
                mensajes.forEach(function (mensaje) {
                    var auxmolde = moldeIzquierdo;
                    auxmolde = auxmolde.replace("{mensaje}", mensaje.mensaje);
                    auxmolde = auxmolde.replace("{nombre}", mensaje.usuario);
                    document.getElementById("aquiVanMensajes").innerHTML = document.getElementById("aquiVanMensajes").innerHTML + auxmolde;
                });
            }
    );



}


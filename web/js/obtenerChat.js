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
        "                                        <small class=\"pull-right text-muted\"><i class=\"fa fa-clock-o\"></i> {ago} ago</small>\n" +
        "                                    </div>\n" +
        "                                    <p>\n" +
        "                                        {mensaje}" +
        "                                    </p>\n" +
        "                                </div>\n" +
        "                            </li>";



var moldeDerecho = "<li class=\"right clearfix\">\n" +
        "                                <span class=\"chat-img pull-right\">\n" +
        "                                    <img src=\"https://bootdey.com/img/Content/user_1.jpg\" alt=\"User Avatar\">\n" +
        "                                </span>\n" +
        "                                <div class=\"chat-body clearfix\">\n" +
        "                                    <div class=\"header\">\n" +
        "                                        <strong class=\"primary-font\">{nombre}</strong>\n" +
        "                                        <small class=\"pull-right text-muted\"><i class=\"fa fa-clock-o\"></i> {ago} ago</small>\n" +
        "                                    </div>\n" +
        "                                    <p>\n" +
        "                                        {mensaje}" +
        "                                    </p>\n" +
        "                                </div>\n" +
        "                            </li> ";

function aiax(destinatario){
    document.getElementById("aquiVanMensajes").innerHTML = "";
    $.post("ObtenerConversacion",
    {
        destinatario: destinatario
    },
    function(mensajes){
        document.getElementById("aquiVanMensajes").innerHTML = "";
        mensajes.forEach(function (mensaje) {
                    console.log(mensaje);                    
                    var moldeIzq = moldeIzquierdo;
                    moldeIzq = moldeIzq.replace("{mensaje}", mensaje.contenido);
                    moldeIzq = moldeIzq.replace("{nombre}", mensaje.id);
                    moldeIzq = moldeIzq.replace("{ago}", mensaje.ago);
                    var moldeDer = moldeDerecho;
                    moldeDer = moldeDer.replace("{mensaje}", mensaje.contenido);
                    moldeDer = moldeDer.replace("{nombre}", mensaje.id);
                    moldeDer = moldeDer.replace("{ago}", mensaje.ago);
                    if(mensaje.identacion === true){
                        document.getElementById("aquiVanMensajes").innerHTML = document.getElementById("aquiVanMensajes").innerHTML + moldeIzq;
                    }
                    else{
                        document.getElementById("aquiVanMensajes").innerHTML = document.getElementById("aquiVanMensajes").innerHTML + moldeDer;
                    }
                    
                });
    }
    );
}

function obtenerChat(contacto){
    var destinatario = contacto.id;
    document.getElementById("aquiVanMensajes").innerHTML = "";
    aiax(destinatario);
    setInterval(aiax(destinatario), 1);
}


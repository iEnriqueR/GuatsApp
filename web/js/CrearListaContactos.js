/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var Listacontactos = "<li class=\"active bounceInDown\" id=\"{id}\" onclick=\"obtenerChat(this)\">\n" +
        "                	<a href=\"#\" class=\"clearfix\">\n" +
        "                		<img src=\"https://bootdey.com/img/Content/user_1.jpg\" alt=\"\" class=\"img-circle\">\n" +
        "                		<div class=\"friend-name\">	\n" +
        "                			<strong>{nombre}</strong>\n" +
        "                		</div>\n" +
        "                		<div class=\"last-message text-muted\">{estado}</div>\n" +
        "                		<small class=\"time text-muted\">Just now</small>\n" +
        "                		<small class=\"chat-alert label label-danger\">!</small>\n" +
        "                	</a>\n" +
        "                </li>";


function crearListaContactos() {

    $.get("ObtenerContactos",
            function (contactos) {
                contactos.forEach(function (contacto) {
                    var auxmolde = Listacontactos;
                    auxmolde = auxmolde.replace("{estado}", contacto.estado);
                    auxmolde = auxmolde.replace("{nombre}", contacto.nombre);
                    auxmolde = auxmolde.replace("{id}", contacto.id);
                    document.getElementById("aquiVanContactos").innerHTML = document.getElementById("aquiVanContactos").innerHTML + auxmolde;
                });
            }
    );
}


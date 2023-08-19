var c = 1;

 /Efecto del carrusell/
 function efecto() {
    document.querySelector("#imgcab").style.opacity = "0"; /rango[0-1]/
    document.querySelector("#imgcab").style.transition = "all 1s";  
    setTimeout(carrusel, 500);
}

/Carrusell/
function carrusel() {
    c++;
    if (c > 8) c = 1;
    document.getElementById("imgcab").setAttribute("src", "imagenes/IMG" +c+ ".jpg");
   document.querySelector("#imgcab").style.opacity = "1"; /rango[0-1]/
    document.querySelector("#imgcab").style.transition = "all 1s";
    setTimeout(efecto, 5000);
}
document.body.setAttribute("onload","carrusel()");

function redespost(e){
     e.style.transition="all 0.5s";
     e.style.transform="scale(1.5,1.5)";
     e.style.filter="brightness(120%)";
 }
 
 function redesactual(e){
	 /e.style.opacity="1";/
     e.style.transition="all 0.5s";
     e.style.transform="scale(1.0,1.0)";
     e.style.filter="brightness(100%)";
     
 }

/Direccionamiento/
function ig(e) {
    window.open("https://www.instagram.com/");
}

/Direccionamiento/
function twit(e) {
    window.open("https://twitter.com/");
}

/Direccionamiento/
function face(e) {
    window.open("https://www.facebook.com");
}

/Direccionamiento/
function yt(e) {
    window.open("https://www.youtube.com/");
}
 
 document.getElementById("r1").setAttribute("onmouseover","redespost(this)");
 document.getElementById("r1").setAttribute("onmouseout","redesactual(this)");
 document.getElementById("r2").setAttribute("onmouseover","redespost(this)");
 document.getElementById("r2").setAttribute("onmouseout","redesactual(this)");
 document.getElementById("r3").setAttribute("onmouseover","redespost(this)");
 document.getElementById("r3").setAttribute("onmouseout","redesactual(this)");
 document.getElementById("r4").setAttribute("onmouseover","redespost(this)");
 document.getElementById("r4").setAttribute("onmouseout","redesactual(this)");
 document.getElementById("r5").setAttribute("onmouseover","redespost(this)");
 document.getElementById("r5").setAttribute("onmouseout","redesactual(this)");

document.getElementById("r1").setAttribute("onclick", "face(this)");
document.getElementById("r2").setAttribute("onclick", "ig(this)");
document.getElementById("r3").setAttribute("onclick", "twit(this)");
document.getElementById("r4").setAttribute("onclick", "yt(this)");



//mostrando seccion
function mostrarSeccion(id) {
    // Ocultar todas las secciones
    var secciones = document.getElementsByTagName('section');
    for (var i = 0; i < secciones.length; i++) {
        secciones[i].style.display = 'none';
    }

    // Mostrar la sección seleccionada
    var seccion = document.getElementById(id);
    if (seccion) {
        seccion.style.display = 'block';
    }
}



/*
function mostrarVino() {
  window.location.href = "Carta.jsp?showVino=true";
}

function mostrarWhisky() {
    window.location.href = "Carta.jsp?showWhisky=true";
}*/




/sumando cantidad detalle/
const decrementButton = document.getElementById("decrement");
const incrementButton = document.getElementById("increment");
const quantityInput = document.getElementById("quantity");
const totalSpan = document.getElementById("subtotal");
const precioSpan = document.getElementById("precio"); // Cambia "precio" a "precioSpan"
const totalSpan2 = document.getElementById("subtotal2");

let quantity = 0;
const precio = parseFloat(precioSpan.textContent); // Convierte el texto del precio a número

decrementButton.addEventListener("click", () => {
    if (quantity > 0) {
        quantity--;
        updateQuantityAndTotal();
    }
});

incrementButton.addEventListener("click", () => {
    quantity++;
    updateQuantityAndTotal();
});

function updateQuantityAndTotal() {
    quantityInput.value = quantity;
    totalSpan.textContent = (precio * quantity).toFixed(2);
}















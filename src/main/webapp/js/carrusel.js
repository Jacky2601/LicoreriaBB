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



const { text } = require("express");
const { TEXT } = require("sequelize/types");

function hide() {
    abs.classList.add('none');
}
function show(numero) {
    switch(numero){
        case 1:
            icon.classList.add('fa-exclamation-triangle');
            icon.classList.remove('fa-exclamation-circle');
            icon.classList.remove('fa-check-circle');
            txtAlert.innerHTML = `Alerta`;
            hostname.innerHTML = `HS347A`;
            tempGpu.innerHTML = `65°C`;
            tempCpu.innerHTML = `54°C`;
            txtAlert.classList.add('Alerta');
            txtAlert.classList.remove('Critico');
            txtAlert.classList.remove('Normal');
            update(1);
            break;
        case 2:
            icon.classList.add('fa-exclamation-circle');
            icon.classList.remove('fa-exclamation-triangle');
            icon.classList.remove('fa-check-circle');
            txtAlert.innerHTML = `Crítico`;
            hostname.innerHTML = `HS346B`;
            tempGpu.innerHTML = `94°C`;
            tempCpu.innerHTML = `96°C`;
            txtAlert.classList.add('Critico');
            txtAlert.classList.remove('Alerta');
            txtAlert.classList.remove('Normal');
            update(2);
            break;
        case 3:
            icon.classList.add('fa-check-circle');
            icon.classList.remove('fa-exclamation-triangle');
            icon.classList.remove('fa-exclamation-circle');
            txtAlert.innerHTML = `Normal`;
            hostname.innerHTML = `HS345C`;
            tempGpu.innerHTML = `47°C`;
            tempCpu.innerHTML = `52°C`;
            txtAlert.classList.add('Normal');
            txtAlert.classList.remove('Alerta');
            txtAlert.classList.remove('Critico');
            update(3);

    }
    abs.classList.remove('none');
}
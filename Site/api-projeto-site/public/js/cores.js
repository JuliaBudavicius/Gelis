var totalNormal = 0;
var totalAlerta = 0;
var totalCritico = 0;
function cores(usoRamP, tempGP, tempCP, iconEstado) {
    var ram = usoRamP.innerText;
    var gpu = tempGP.innerText;
    var cpu = tempCP.innerText;
    icon = iconEstado
    var critico = 0;
    var alerta = 0;
    var normal = 0;

    if (ram >= 7.9) {
        usoRamP.classList.add('Critico');
        critico++;
    }
    if (ram >= 4) {
        usoRamP.classList.add('Alerta');
        alerta++;
    }
    if (ram < 4) {
        usoRamP.classList.add('Normal');
        normal++;
    }
    if (cpu > 80) {
        tempCP.classList.add('Critico');
        critico++;
    }
    if (cpu > 60) {
        tempCP.classList.add('Alerta');
        alerta++;
    }
    if (cpu < 60) {
        tempCP.classList.add('Normal');
        normal++;
    }
    if (gpu > 80) {
        tempGP.classList.add('Critico');
        critico++;
    }
    if (gpu > 60) {
        tempGP.classList.add('Alerta');
        alerta++;
    }
    if (gpu < 60) {
        tempGP.classList.add('Normal');
        normal++;
    }

    if (normal > critico && normal > alerta) {
        icon.classList.add("fas", "fa-check-circle", "fa-3x");
        totalNormal++;
    }
    if (alerta > critico && alerta > normal) {
        icon.classList.add("fas", "fa-exclamation-triangle", "fa-3x");
        totalAlerta++;
    }
    if (critico >= alerta && critico >= normal) {
        icon.classList.add("fas", "fa-exclamation-circle", "fa-3x");
        totalCritico++;
    }
    if (normal == critico && normal == alerta) {
        icon.classList.add("fas", "fa-exclamation-triangle", "fa-3x");
        totalAlerta++;
    }
    
    qtdNormal.innerHTML = totalNormal + " Computadores";
    qtdAlerta.innerHTML = totalAlerta + " Computadores";
    qtdCritico.innerHTML = totalCritico + " Computadores";

}

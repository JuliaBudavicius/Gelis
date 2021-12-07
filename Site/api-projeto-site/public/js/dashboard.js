function hide() {
    remove();
    abs.classList.add('none');
}

function show(numero, estado) {
    update(numero);
    processos(numero);
    switch (estado) {
        case "Alerta":
            iconeaAlert.className = "";
            iconeaAlert.classList.add("fas", "fa-exclamation-triangle", "fa-3x");
            txtAlert.className = "";
            txtAlert.classList.add('Alerta');
            txtAlert.classList.add('txtAlerta');
            break;
        case "Normal":
            iconeaAlert.className = "";
            iconeaAlert.classList.add("fas", "fa-check-circle", "fa-3x");
            txtAlert.className = "";
            txtAlert.classList.add('Normal');
            txtAlert.classList.add('txtAlerta');
            break;
        case "Critico":
            iconeaAlert.className = "";
            iconeaAlert.classList.add("fas", "fa-exclamation-circle", "fa-3x");
            txtAlert.className = "";
            txtAlert.classList.add('Critico');
            txtAlert.classList.add('txtAlerta');
            break;
    }
    txtAlert.innerHTML = estado
    abs.classList.remove('none');
}
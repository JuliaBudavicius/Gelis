function hide() {
    remove();
    abs.classList.add('none');
}
function show(numero) {
    update(numero);
    processos(numero);
    abs.classList.remove('none');
}
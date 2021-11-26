const { text } = require("express");
const { TEXT } = require("sequelize/types");

function hide() {
    abs.classList.add('none');
}
function show(numero) {
    update(numero);
    abs.classList.remove('none');
}
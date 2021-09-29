function validarnome() {
    var nomeEmpresa = idNomeEmpresa.value;

    if (nomeEmpresa.length >= 3) {
        idNomeEmpresa.style.border = '2px solid #04d361';
    } else if (nomeEmpresa.length == "") {
        idNomeEmpresa.style.border = 'none';
    } else {
        idNomeEmpresa.style.border = '2px solid #EE1E46';
    }
}

function validarcnpj() {
    var cnpj = idCNPJ.value;
    document.getElementById('idCNPJ').addEventListener('input', function (e) {
        var x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,3})(\d{0,3})(\d{0,4})(\d{0,2})/);
        e.target.value = !x[2] ? x[1] : x[1] + '.' + x[2] + '.' + x[3] + '/' + x[4] + (x[5] ? '-' + x[5] : '');
    });

    if (cnpj.length == 18) {
        idCNPJ.style.border = '2px solid #04d361';
    } else if (cnpj.length == "") {
        idCNPJ.style.border = 'none';
    } else {
        idCNPJ.style.border = '2px solid #EE1E46';
    }
}

function validaremail() {
    var email = idEmail.value;
    var validarArroba = email.indexOf('@');
    var validarPonto = email.indexOf('.com');

    if (validarArroba > 0 && validarPonto > 0) {
        idEmail.style.border = '2px solid #04d361';
    } else if (email == '') {
        idEmail.style.border = 'none';
    } else {
        idEmail.style.border = '2px solid #EE1E46';
    }
}

var senha;
function validaresenha() {
     senha = idSenha.value;

    if (senha.length >= 5) {
        idSenha.style.border = '2px solid #04d361';
    } else if (senha == "") {
        idSenha.style.border = 'none';
    } else {
        idSenha.style.border = '2px solid #EE1E46';
    }
}

function confirmaSenha() {
    var validaSenha = idVerificaSenha.value;
    
    if(validaSenha != senha){
        idVerificaSenha.style.border = '2px solid #EE1E46';
    }else{
        idVerificaSenha.style.border = '2px solid #04d361';
    }


}



function validartelefone() {
    var telefone = idTelefone.value;

    if (telefone.length == 11) {
        idTelefone.style.border = '2px solid #04d361';
    } else if (telefone.length == "") {
        idTelefone.style.border = 'none';
    } else {
        idTelefone.style.border = '2px solid #EE1E46';
    }
}
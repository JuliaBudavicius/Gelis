function cores(usoRamP, tempGP, tempCP) {
    var ram = usoRamP.innerText;
    var gpu = tempGP.innerText;
    var cpu = tempCP.innerText;
    console.log(ram)
    // ifs
    if (ram >= 7.9)
        usoRamP.classList.add('Critico');
    if (ram >= 4)
        usoRamP.classList.add('Alerta');
    if (ram < 4)
        usoRamP.classList.add('Normal');
    if (cpu > 80)
        tempCP.classList.add('Critico');
    if (cpu > 60)
        tempCP.classList.add('Alerta');
    if (cpu < 60)
        tempCP.classList.add('Normal');
    if (gpu > 80)
        tempGP.classList.add('Critico');
    if (gpu > 60)
        tempGP.classList.add('Alerta');
    if (gpu < 60)
        tempGP.classList.add('Normal');

    console.log("aaa caio hideki")
}
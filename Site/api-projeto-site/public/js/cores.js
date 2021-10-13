    function cores(){
    var primeiraRam = parseFloat(document.getElementById('ram1').textContent);
    var segundaRam = parseFloat(document.getElementById('ram2').textContent);
    var terceiraRam = parseFloat(document.getElementById('ram3').textContent);
    var primeiraCpu = parseFloat(document.getElementById('cpu1').textContent);
    var segundaCpu = parseFloat(document.getElementById('cpu2').textContent);
    var terceiraCpu = parseFloat(document.getElementById('cpu3').textContent);
    var primeiraGpu = parseFloat(document.getElementById('gpu1').textContent);
    var segundaGpu = parseFloat(document.getElementById('gpu2').textContent);
    var terceiraGpu = parseFloat(document.getElementById('gpu3').textContent);
    // ifs
    if (primeiraRam >= 7)
        ram1.classList.add('Critico');
    if (segundaRam >= 7)
        ram2.classList.add('Critico');
    if (terceiraRam >= 7)
        ram3.classList.add('Critico');
    if (primeiraRam >= 4)
        ram1.classList.add('Alerta');
    if (segundaRam >= 4)
        ram2.classList.add('Alerta');
    if (terceiraRam >= 4)
        ram3.classList.add('Alerta');
    if (primeiraRam < 4)
        ram1.classList.add('Normal');
    if (segundaRam < 4)
        ram2.classList.add('Normal');
    if (terceiraRam < 4)
        ram3.classList.add('Normal');
    if (primeiraCpu > 80)
        cpu1.classList.add('Critico');
    if (segundaCpu > 80)
        cpu2.classList.add('Critico');
    if (terceiraCpu > 80)
        cpu3.classList.add('Critico');
    if (primeiraCpu > 60)
        cpu1.classList.add('Alerta');
    if (segundaCpu > 60)
        cpu2.classList.add('Alerta');
    if (terceiraCpu > 60)
        cpu3.classList.add('Alerta');
    if (primeiraCpu < 60)
        cpu1.classList.add('Normal');
    if (segundaCpu < 60)
        cpu2.classList.add('Normal');
    if (terceiraCpu < 60)
        cpu3.classList.add('Normal');
    if (primeiraGpu > 80)
        gpu1.classList.add('Critico');
    if (segundaGpu > 80)
        gpu2.classList.add('Critico');
    if (terceiraGpu > 80)
        gpu3.classList.add('Critico');
    if (primeiraGpu > 60)
        gpu1.classList.add('Alerta');
    if (segundaGpu > 60)
        gpu2.classList.add('Alerta');
    if (terceiraGpu > 60)
        gpu3.classList.add('Alerta');
    if (primeiraGpu < 60)
        gpu1.classList.add('Normal');
    if (segundaGpu < 60)
        gpu2.classList.add('Normal');
    if (terceiraGpu < 60)
        gpu3.classList.add('Normal');
    }
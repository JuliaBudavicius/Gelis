window.onscroll = function () {
    if (window.scrollY < home.offsetHeight) {
        logo.style = " transform: translateY(0) ; ";
        sobreli.classList.remove('destaque');
        homeli.classList.add('destaque');
        servicosli.classList.remove('destaque');
        downloadli.classList.remove('destaque');
        contatoli.classList.remove('destaque');
    }
    if (window.scrollY >= home.offsetHeight) {
        logo.style = " transform: translateY(-110%) ; ";
        sobreli.classList.add('destaque');
        homeli.classList.remove('destaque');
        servicosli.classList.remove('destaque');
        downloadli.classList.remove('destaque');
        contatoli.classList.remove('destaque');
    }
    if (window.scrollY >= sobre.offsetHeight + home.offsetHeight - 50) {
        logo.style = " transform: translateY(0) ; ";
        downloadli.classList.remove('destaque');
        servicosli.classList.add('destaque');
        sobreli.classList.remove('destaque');
        homeli.classList.remove('destaque');
        contatoli.classList.remove('destaque');
    }
    if (window.scrollY >= servicos.offsetHeight + sobre.offsetHeight + home.offsetHeight - 50) {
        downloadli.classList.add('destaque');
        sobreli.classList.remove('destaque');
        servicosli.classList.remove('destaque');
        homeli.classList.remove('destaque');
        contatoli.classList.remove('destaque');
    }
    if (window.scrollY >= download.offsetHeight + servicos.offsetHeight + sobre.offsetHeight + home.offsetHeight - 50) {
        downloadli.classList.remove('destaque');
        sobreli.classList.remove('destaque');
        servicosli.classList.remove('destaque');
        homeli.classList.remove('destaque');
        contatoli.classList.add('destaque');
    }
}
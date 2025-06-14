const dropdowns = document.querySelectorAll('.dropdown');

const locaisPorMaterial = {
    "Esponja de cozinha": [
        "CMEI Zeferino Mosato Krukoski - R. Pioneiro Olindo Alcini, 815. Conj. Hab. Sanenge",
        "IAM - Instituto Ambiental de Maringá - Av. Cerro Azul, 544. Zona 02",
        "Secretaria de Limpeza urbana - Av. das Indústrias, 700. Parque Industrial II",
        "Teatro Calil Haddad. Av. Dr - Luiz Teixeira Mendes, 2500. Zona 05"
    ],
    "Óleo de Fritura pós-consumo": [
        "Supermercado Cidade Canção - Av. das Palmeiras, 356. Pq. das Palmeiras",
        "Supermercado Cidade Canção - Av. Mandacaru, 2824. Jd Brasil.",
        "Supermercado Cidade Canção - Av. Arq. Nildo Ribeiro da Rocha, 343. Zona 28",
        "Supermercado Cidade Canção - Av. Tuiuti, 1672. Zona 37",
        "Supermercado Cidade Canção - Av. Brasil, 4734. Zona 04"
    ],
    "Baterias, Pilhas ou Sucatas Eletrônicas": [
        "4ª Batalhão de Polícia Militar - Rua Mitsuzu Taguchi, 99. Vila Nova",
        "Câmara Municipal de Maringá - Av. Papa João XXIII, 239. Zona 02",
        "Faculdades Maringá - Av. Prudente de Morais, 815. Zona 09",
        "Paço Municipal Silvio Magalhães Barros - Av. XV de Novembro, 701. Zona 01",
        "Tiro de Guerra - Av. Mandacaru, 730. Zona 06"
    ],
    "Lâmpadas": [
        "Muffato Max - Av. Colombo, 2720. Vila Morangueira",
        "Depósito Areião - Av.Senador Petrônio Portela,1075. Jd. Aclimação",
        "SuperMuffato - Av. Colombo, 9161 (Catuaí). Zona 43",
        "Supermercado Cidade Canção - Av. das Palmeiras, 356. Pq. das Palmeiras",
        "Supermercado Cidade Canção - Av. Lucílio de Held, 1477. jd. Alvorada",
        "Supermercado Cidade Canção - Av. Mandacaru, 277. Zona 21"
    ],
    "Resíduos de Vidros": [
        "Paróquia Menino Jesus de Praga - Rua Monsenhor Kimura, 36. Jd. Novo Horizonte",
        "Tiro de Guerra - Av. Mandacaru, 730. Zona 06",
        "Paróquia Santa Izabel de Portugal - R. Jalbas Rodrigues Alves, 188. Vila Santa Izabel"
    ],
    "Ecolix - (plástico, metal, vidro e papel)": [
        "Upa Zona Sul", "Eurogarden", "Parque Alfredo Nyffeler",
        "Parque linear Gralha Azul", "Instituto Municipal",
        "Parque Alfredo Nyffeler", "Upa Zona Norte", "Estádio Regional Willie Davids"
    ]
};

dropdowns.forEach(dropdown => {
    const select = dropdown.querySelector('.select');
    const caret = dropdown.querySelector('.caret');
    const menu = dropdown.querySelector('.menu');
    const options = dropdown.querySelectorAll('.menu li');
    const selected = dropdown.querySelector('.selected');
    const cardsContainer = document.querySelector('.cards-container');

    select.addEventListener('click', () => {
        select.classList.toggle('select-clicked');
        caret.classList.toggle('caret-rotate');
        menu.classList.toggle('menu-open');
    });

    options.forEach(option => {
        option.addEventListener('click', () => {
            selected.innerText = option.innerText;
            select.classList.remove('select-clicked');
            caret.classList.remove('caret-rotate');
            menu.classList.remove('menu-open');

            options.forEach(opt => opt.classList.remove('active'));
            option.classList.add('active');

            // Atualiza os cards
            const locais = locaisPorMaterial[option.innerText] || [];
            cardsContainer.innerHTML = ''; // limpa

            locais.forEach(local => {
                const card = document.createElement('div');
                card.classList.add('card');

                const icon = document.createElement('div');
                icon.classList.add('card-icon');
                icon.innerHTML = '📍';

                const text = document.createElement('div');
                text.classList.add('card-text');
                text.innerText = local;

                card.appendChild(icon);
                card.appendChild(text);
                cardsContainer.appendChild(card);
            });
        });
    });
});

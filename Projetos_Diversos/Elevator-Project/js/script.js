// Variáveis dos elevadores 
var elev1 = document.getElementById("elevator-right");
var elev2 = document.getElementById("elevator-left");
var btn = document.getElementById("btn-test");
var elevDoor1 = document.getElementById("door-1");
var elevDoor2 = document.getElementById("door-2");

// Variáveis de imagem
var arrow1 = document.getElementById("arrow-1");
var arrow2 = document.getElementById("arrow-2");
var arrowUp = "../img/seta-up.png";
var arrowDown = "../img/seta-down.png";
var transparent = "../img/transparent.png";

// Porta dos Elevadores
var doorRight1 = document.getElementById("door-left-1");
var doorRight2 = document.getElementById("door-right-1");

var doorLeft1 = document.getElementById("door-left-2");
var doorLeft2 = document.getElementById("door-right-2");

// Variável da div fade-in
var divFadeIn = document.getElementsByClassName("div-fade-in")[0];

// variáveis aleatórias
var dist = 0, dist2 = 0;
var timeOut = 0;
var doorVerify = true;
// Função de entrar no elevador
function elevador() {
    // Altera a URL para a página desejada
    if (divFadeIn) {
        divFadeIn.style.display = 'block';
    }
    setTimeout(function () {
        window.location.href = 'elevator.html';
    }, 1000);
}

// Adiciona o evento de clique à div quando o documento estiver carregado
document.addEventListener('DOMContentLoaded', function () {
    if (elev1) {
        elev1.addEventListener('click', elevador);
    }
    if (elev2) {
        elev2.addEventListener('click', elevador);
    }
});

// Função de gerar números aleatórios
function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

// RNG dos andares
function andaresRNG() {
    var n1 = getRandomInt(7);
    var n2 = getRandomInt(7);

    // Atualiza os elementos do DOM com os números gerados
    document.getElementById("n1").textContent = n1;
    document.getElementById("n2").textContent = n2;
}

andaresRNG();

function chamarElevador() {
    let n1 = parseInt(document.getElementById("n1").textContent);
    let n2 = parseInt(document.getElementById("n2").textContent);
    let andarAtual = 0;  // Certifique-se de inicializar com o valor correto

    let dist = Math.abs(andarAtual - n1);
    let dist2 = Math.abs(andarAtual - n2);

    if (dist < dist2) {
        // Mover o elevador n1 para o andar atual com animação
        animarContagemRegressiva(n1, andarAtual, "n1", elev1, elevDoor1, arrow1, doorRight1, doorRight2);
    } else {
        // Mover o elevador n2 para o andar atual com animação
        animarContagemRegressiva(n2, andarAtual, "n2", elev2, elevDoor2, arrow2, doorLeft1, doorLeft2);
    }
}

function animarContagemRegressiva(from, to, elementId, elevator, elevDoor, arrow, doorLeft, doorRight) {
    let current = from;
    let element = document.getElementById(elementId);

    function animacao() {
        if (current !== to) {
            element.textContent = current--;
            setTimeout(animacao, 4000);  // Ajuste o intervalo conforme necessário
            arrow.src = arrowDown;
        } else {
            // Exibir o elevador quando a animação estiver concluída
            element.textContent = "0";
            arrow.src = transparent;
            timeOut = 5;
            closeTime(doorLeft, doorRight);
        }
    }

    function closeTime(doorLeft, doorRight) {
        console.log("ID: ");
        console.log(doorLeft);  // Verifique as classes antes da adição
        console.log(doorRight);

        doorLeft.classList.remove('fecharEsquerdo');
        doorRight.classList.remove('fecharDireito');

        console.log("Antes de adicionar classes de abrir:");
        console.log(doorLeft.classList);  // Verifique as classes antes da adição
        console.log(doorRight.classList);

        doorLeft.classList.add('abrirEsquerdo');
        doorRight.classList.add('abrirDireito');

        console.log("Antes de adicionar classes de abrir:");
        console.log(doorLeft.classList);  // Verifique as classes antes da adição
        console.log(doorRight.classList);

        doorLeft.classList.add('abrirEsquerdo');
        doorRight.classList.add('abrirDireito');

        console.log("Depois de adicionar classes de abrir:");
        console.log(doorLeft.classList);  // Verifique as classes após a adição
        console.log(doorRight.classList);

        setTimeout(function () {
            elevator.style.display = 'block';
            elevDoor.style.display = 'none';
            setTimeout(function () {
                elevator.style.display = 'none';
                elevDoor.style.display = 'flex';
                doorLeft.classList.add('fecharEsquerdo');
                doorRight.classList.add('fecharDireito');
                doorLeft.classList.remove('abrirEsquerdo');
                doorRight.classList.remove('abrirDireito');
            }, 5000);
        }, 2000)


    }

    animacao();
}

document.addEventListener('DOMContentLoaded', function () {
    if (btn) {
        btn.addEventListener('click', chamarElevador);
    }
});
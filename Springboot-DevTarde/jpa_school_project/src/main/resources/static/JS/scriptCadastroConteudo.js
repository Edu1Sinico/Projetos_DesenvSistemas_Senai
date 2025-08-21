// Atributos
// Atributos de elementos da página cadastro de conteúdo
const radioButtons = document.querySelectorAll('input[name="tipoConteudo"]');
const ElementDiv = document.getElementById('div-element-id');
const inputIdElement = document.getElementById('input-id-element');
const inputNomeElement = document.getElementById("input-name-element");
// divs com listas
const divListarCursos = document.getElementById("div-listar-cursos-id");
const divListarTurmas = document.getElementById("div-listar-turmas-id");
const divListarDisc = document.getElementById("div-listar-disc-id");

// Realiza a troca dos campos
radioButtons.forEach(radioButton => {
    radioButton.addEventListener('change', () => {
        if (radioButton.value === '0') { // curso
            inputIdElement.name = "id_curso";
            inputNomeElement.placeholder = "Curso";
            inputNomeElement.name = "nome_curso";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "block";
            divListarTurmas.style.display = "none";
            divListarDisc.style.display = "none";
        } else if (radioButton.value === '1') { // turma
            inputIdElement.name = "id_turma";
            inputNomeElement.placeholder = "Turma";
            inputNomeElement.name = "ano_turma";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "none";
            divListarTurmas.style.display = "block";
            divListarDisc.style.display = "none";
        } else if (radioButton.value === '2') { // disciplina
            inputIdElement.name = "id_disciplina";
            inputNomeElement.placeholder = "Disciplina";
            inputNomeElement.name = "nome_disciplina";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "none";
            divListarTurmas.style.display = "none";
            divListarDisc.style.display = "block";
        }
    });
});

// Estado inicial das Divs ao carregar a página
window.onload = function () {
    const selectedRadioButton = document.querySelector('input[name="tipoConteudo"]:checked');
    if (selectedRadioButton) {
        const value = selectedRadioButton.value;
        if (value === '0') {
            inputIdElement.name = "id_curso";
            inputNomeElement.placeholder = "Curso";
            inputNomeElement.name = "nome_curso";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "block";
            divListarTurmas.style.display = "none";
            divListarDisc.style.display = "none";
        } else if (value === '1') {
            inputIdElement.name = "id_turma";
            inputNomeElement.placeholder = "Turma";
            inputNomeElement.name = "ano_turma";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "none";
            divListarTurmas.style.display = "block";
            divListarDisc.style.display = "none";
        } else if (value === '2') {
            inputIdElement.name = "id_disciplina";
            inputNomeElement.placeholder = "Disciplina";
            inputNomeElement.name = "nome_disciplina";
            inputIdElement.value = "";
            inputNomeElement.value = "";
            divListarCursos.style.display = "none";
            divListarTurmas.style.display = "none";
            divListarDisc.style.display = "block";
        }
    }
};
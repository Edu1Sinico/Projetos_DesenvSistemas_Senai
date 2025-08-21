// Atributos
// Atributos de elementos da página cadastro
const radioButtons = document.querySelectorAll('input[name="tipoUser"]');
const alunoDiv = document.getElementById('user-aluno-group-id');
const professorDiv = document.getElementById('user-prof-group-id');
const tituloGroup = document.getElementById('secao-user-title');



// Realiza a troca dos campos
radioButtons.forEach(radioButton => {
    radioButton.addEventListener('change', () => {
        if (radioButton.value === '0') { // Administrador
            alunoDiv.style.display = 'none';
            professorDiv.style.display = 'none';
            tituloGroup.innerHTML = "";
        } else if (radioButton.value === '1') { // Professor
            alunoDiv.style.display = 'none';
            professorDiv.style.display = 'block';
            tituloGroup.innerHTML = "PROFESSOR";
        } else if (radioButton.value === '2') { // Aluno
            alunoDiv.style.display = 'block';
            professorDiv.style.display = 'none';
            tituloGroup.innerHTML = "ALUNO";
        }
    });
});

// Estado inicial das Divs ao carregar a página
window.onload = function () {
    const selectedRadioButton = document.querySelector('input[name="tipoUser"]:checked');
    if (selectedRadioButton) {
        const value = selectedRadioButton.value;
        if (value === '0') {
            alunoDiv.style.display = 'none';
            professorDiv.style.display = 'none';
            tituloGroup.innerHTML = "";
        } else if (value === '1') {
            alunoDiv.style.display = 'none';
            professorDiv.style.display = 'block';
            tituloGroup.innerHTML = "PROFESSOR";
        } else if (value === '2') {
            alunoDiv.style.display = 'block';
            professorDiv.style.display = 'none';
            tituloGroup.innerHTML = "ALUNO";
        }
    }
};
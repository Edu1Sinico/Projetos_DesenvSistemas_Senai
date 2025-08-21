document.getElementById('newsletterForm').addEventListener('submit', function(event) {
    event.preventDefault();
  
    // Simular envio do formulário (pode ser substituído por uma chamada AJAX para um servidor real)
    // Neste exemplo, apenas exibimos uma mensagem de agradecimento
    document.getElementById('thankYouMessage').classList.remove('hidden');
  });
  
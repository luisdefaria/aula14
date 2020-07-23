function fazerLogin(event){
    
    event.preventDefault(); //nao permite o envio padrao do formulario
    let txtUser = document.getElementById("txtUser").value;
    let txtSenha = document.getElementById("txtSenha").value;

    let msgLogin = {
        email: txtUser,
        racf: txtUser,
        senha: txtSenha
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(msgLogin),
        headers: {
            'Content-type': 'application/json'
        }
    }

    //Promises
    fetch("http://localhost:8080/login",cabecalho)
        .then(res => tratarResposta(res));
}

function tratarResposta(res){
    //Verifica se retornou HTTP 200
    if(res.status == 200){
        res.json().then(res => gravarUsuario(res));
    }else{
        document.getElementById ("msgError").innerHTML = "<p> Login/Senha invalido</p>";
    }

}

function gravarUsuario(res){
    localStorage.setItem("userLogged",JSON.stringify(res));
    window.location = "dados.html"
    }
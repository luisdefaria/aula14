function validaLogin(){
    //alert("chamou");
    let userTxt = localStorage.getItem("userLogged");

    if(!userTxt){
        windows.location = "index.html";
    }

    let user = JSON.parse(userTxt);

    document.getElementById("nomeUser").innerHTML = user.nome;
    document.getElementById("imagem").innerHTML = `<img src = "${user.linkFoto}">`;
    

    //alert(user.nome);
}

function logout(){
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function carregarDados(){
    //Quando nao por cabecalho, o metodo padrao é o get
    fetch("http://localhost:8080/usuarios")
    .then(res => res.json())
    .then(res => exibirDados(res));
}

function exibirDados(res){
    let tabelaTxt = "<table> <tr> <th>Nome</th> <th>Email</th> <th>RACF</th> </tr>"

    res.forEach(user => {
        tabelaTxt = tabelaTxt + `<tr> <td> ${user.nome} </td>
                                    <td> ${user.email} </td>
                                    <td> ${user.racf} </td> </tr>`
    });

    tabelaTxt = tabelaTxt + "</table>";

    document.getElementById("tabela").innerHTML = tabelaTxt;

}
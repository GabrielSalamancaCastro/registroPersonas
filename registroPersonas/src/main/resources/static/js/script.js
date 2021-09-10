
// METODO POST 
let botonRegistrar = document.querySelector('#registro-btn');
let nombrePost = document.querySelector('#nombre');
let apellidoPost = document.querySelector('#apellido');
let procesado = document.querySelector('#FALSO');


let dataPost={
    nombre: nombrePost.value,
    apellido: apellidoPost.value,
    procesado: procesado.value
}


botonRegistrar.addEventListener("click", function(event){
    event.preventDefault(); 
    fetch('http://localhost:8080/',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(dataPost),
    })
    .then(function(response){
        return response.json()
    })
    .then(function(data){
        console.log('Success:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
})


//METODO GET
let listarTodos = document.querySelector('#listado');

listarTodos.addEventListener("click",function(event){
    event.preventDefault();
    fetch('http://localhost:8080/todos')
    .then(function(response){
        return response.json();
    })
    .then(function(lista){
        console.log(lista);
        /*
        lista.forEach((element) => {
            listarTodos.innerHTML+=`
            <h1>${element.nombre}</h1>
            <h1>${element.apellido}</h1>
            <h1>${element.procesado}</h1>
            ` 
        }); */
    })
    .catch(function(err){
        console.error(err);
    })
})





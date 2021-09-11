
// METODO POST 
let botonRegistrar = document.querySelector('#registro-btn');

botonRegistrar.addEventListener("click", function(event){
    event.preventDefault(); 

let procesado = document.querySelector('#FALSO');
let nombrePost = document.querySelector('#nombre');
let apellidoPost = document.querySelector('#apellido');
let confirmacionRegistro = document.querySelector('#confirmacionRegistro')

let dataPost={
    nombre: nombrePost.value,
    apellido: apellidoPost.value,
    procesado: procesado.value
}




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
        confirmacionRegistro.innerHTML=`
        <h3>SE HA REGISTRADO A LA PERSONA CON ID: ${data.id}
        ` 
      })
      .catch((error) => {
        console.error('Error:', error);
      });
})









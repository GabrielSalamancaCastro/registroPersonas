
//METODO GET (LISTAR TODOS)
let listarTodos = document.querySelector('#botonListado');
let listaCompleta = document.querySelector('.listaPersonas');

listarTodos.addEventListener("click",function(event){
    event.preventDefault();
    fetch('http://localhost:8080/todos')
    .then(function(response){
        return response.json();
    })
    .then(function(personas){
        personas.forEach((element) => {
            listaCompleta.innerHTML+=`
            <div id='personaRegistrada'>
            <p>ID: ${element.id}<p>
            <p>NOMBRE: ${element.nombre}<p>
            <p>APELLIDO: ${element.apellido}</p>
            <p>PROCESADO: ${element.procesado}</p>
            ` 
        }); 
    })
    .catch(function(err){
        console.error(err);
    })
})


//METODO GET (GET BY ID)


let getPersonaByID = document.querySelector('#getByID');


getPersonaByID.addEventListener('click', function(event){
    event.preventDefault();

    let personaID= document.querySelector('#id-persona').value;

    fetch(`http://localhost:8080/${personaID}`)
    .then(function(response){
       return response.json();
    }).then(function(persona){
        listaCompleta.innerHTML+=`
            <div id='personaRegistrada'>
            <p>ID: ${persona.id}<p>
            <p>NOMBRE: ${persona.nombre}<p>
            <p>APELLIDO: ${persona.apellido}</p>
            <p>PROCESADO: ${persona.procesado}</p>
            <div id='botones'>
            <button id="eliminarPersona">ELIMINAR</button>
            <button id="procesarPersona">PROCESAR</button>
            </div>
            </div>
            ` 
            //METODO DELETE
            let eliminar = document.querySelector("#eliminarPersona");

            eliminar.addEventListener("click", function(event){
            event.preventDefault();
                let confirmacionDelete=confirm("¿ESTAS SEGURO QUE QUIERES ELIMINAR ESTA PERSONA DEL SISTEMA?")
                if(confirmacionDelete){
                console.log("CLICKE EN ACEPTAR");
                fetch(`http://localhost:8080/${personaID}`,{
                    method: 'DELETE',
                })
                .then(function(response){
                    return response.json();
                }).then(function(data){
                    console.log('Success',data);
                }).catch(function(err){
                    console.error(err);
                })
                }
                });

                //METODO PUT
                let procesar=document.querySelector('#procesarPersona');

                procesar.addEventListener("click", function(event){
                    event.preventDefault();
                    let confircionProcesar=confirm("¿DESEAS PROCESAR ESTA PERSONA?")
                    let procesarData={
                        id: persona.id,
                        nombre: persona.nombre,
                        apellido: persona.apellido,
                        procesado: "TRUE"
                    }
                    console.log(procesarData);
                    if(confircionProcesar){
                        fetch('http://localhost:8080/',{
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json',
                              },
                              body: JSON.stringify(procesarData),
                            })
                            .then(function(response){
                                return response.json()
                            })
                            .then(function(respuesta){
                                console.log('Success:', respuesta);
                              })
                              .catch((error) => {
                                console.error('Error:', error);
                              });
                    }
                })



    }).catch(function(err){
        console.error(err);
    })

})






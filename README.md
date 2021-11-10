# alfredotoolbox

prueba técnica para toolbox

Como ejecutarlo:

Al descargar el repositorio solo se tiene que descargar las dependencias del proyecto
una vez terminado ya se puede correr el proyecto.Al

Instrucciones:

SplashFragment -> Vista donde se obtiene las peliculas, puede ocurrir dos escenarios:
1) Si no hay token se mostrara el mensaje correspondiente.
2) Si el token esta expirado tambien muestra el mensaje.
3) Si hay un error de los ya mencionados se muestra un botón de login.
4) al darle el botón de login se hará la petición para obtener nuevo token.
5) Se llama la ruta de obtener peliculas.
6) Al estar listo el paso anterior pasa al siguiente fragment.

ContentFragment -> Vista donde se muestra los carousel:
1) Se muestran las peliculas el post arriba y el thumb abajo.
2) Al darle click a una pelicula esta verificara si tiene un VideoUrl
3) Si no tiene VideoUrl se muestra el mensaje correspondiente.
4) Si tiene videoUrl entonces pasa a la siguiente vista DetailFragment.

DetailFragment -> Vista donde muestra detalle de la pelicula:
1) La pelicula empezara automaticamente
2) Se muestran los datos en general.

Adicionales ->
1) Modo oscuro del light y night.
2) Dialogo de alerta antes de cerrar el app.
3) El app responde en vertical como horizontal.
4) Test unitarios del login y obtener peliculas.

App hecha en Kotlin con:

MVVM

DaggerHilt para inyección de dependencias.

Room para almacenamiento local.

Ktor para consumo de API Rest.

ExoPlayer para reproducir videos.

Flows y LiveData.

Navigation component.

SharedViewModel.

Glide para las imagenes. 

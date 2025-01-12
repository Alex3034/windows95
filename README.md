> [!NOTE]  
> 🌐 This README is also available in [English](README.en.md).

# Windows 95 - Kotlin Multiplatform

Este proyecto es una implementación con Kotlin Multiplatform (KMP) del icónico Windows 95. Combina prácticas modernas de desarrollo con una interfaz nostálgica.

<p align="center">
<img src="img/win95.webp" style="height: 75%; width:75%;"/></center></a></p>

<p align="center"> <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white" alt="Kotlin">  <img src="https://img.shields.io/badge/Kotlin-Multiplatform-%237f52ff?style=for-the-badge&logo=kotlin"> <img src="https://img.shields.io/badge/Windows%2095-%F0%9F%96%BC-lightgrey?style=for-the-badge" alt="Windows 95"> </p>

----------

## 🛠 Instalación

### Requisitos

- **Kotlin 2.0.21+**
- **Compose Multiplatform 1.7.0+**
- **IDE compatible con KMP**: Fleet o Android Studio.
- Conocimientos básicos de Kotlin y KMP.

### Configuración

1. Clona este repositorio:

    ```bash
    git clone https://github.com/Alex3034/windows95.git
    ```
2. 
3. Abre el proyecto en Android Studio o Fleet.
4. Sincroniza el proyecto Gradle para descargar las dependencias.

## Imágenes del proyecto

|                       Pantalla de Inicio                        |
|:---------------------------------------------------------------:|
| <img src="img/winSplash.webp" style="height: 50%; width:70%;"/> |

|                      Pantalla principal                       |
|:-------------------------------------------------------------:|
| <img src="img/win95-1.webp" style="height: 50%; width:70%;"/> |

|                         Menú inferior                         |
|:-------------------------------------------------------------:|
| <img src="img/winMenu.webp" style="height: 50%; width:70%;"/> |


----------

## ✏️ Estructura del proyecto

### Componentes

Puedes acceder a `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/components` para acceder a todos los componentes. Se han programado lo más genéricos posibles para poder personalizarlos y reutilizarlos en cualquier lugar. Por ejemplo **WindowsButton**

```kotlin
WindowsButton(){
    Text("Ejemplo básico")
}

WindowsButton(Modifier.height(60.dp), onClick = {print("Example"}, dotPadding = 6.dp)){
    //Cualquier vista
}

```

### Helpers

Desde `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/helper` dispones del `SoundManager`, el encargado de reproducir la música del splash.

### Extensions

En `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/extensions` tendrás todas las funciones de extensión generadas para el proyecto.

```kotlin

Modifier.onRightClick {}

Modifier.clickableWithoutRipple {}

Modifier.rotateVertically()

//Entre otras

```

### Model

Todos los modelos de datos se encuentran en `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/model`.

### Splash Screen

Primera vista del proyecto que se lanzará siempre que se ejecute la app. `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/splash/SplashScreen.kt`.

### Windows 95

Vista principal del proyecto `ComposeApp/src/desktopMain/kotlin/com/alex/windows95/windows/Windows95Screen.kt`.

## 🌍 Plataformas Soportadas

- **Windows**
- **MacOS**
- **Linux**

----------

## 🤝 Contacto

Si tienes preguntas o sugerencias, no dudes en contactarme:
- **Email:** alejandrohm98a@gmail.com
- **GitHub:** [@Alex3034](https://github.com/Alex3034)

----------
¡Gracias por visitar este repositorio! Espero que encuentres útil este proyecto y te inspire en tus propios desarrollos.
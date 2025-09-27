# Dividir Cuentas App 📱💰

Una aplicación Android desarrollada en Kotlin con Jetpack Compose para dividir cuentas de restaurantes de manera fácil y rápida entre varios comensales, con la opción de añadir propina basada en la calidad del servicio.

## ✨ Características

- 📊 **División automática**: Divide cualquier cantidad entre el número de participantes especificado
- 💳 **Entrada decimal**: Acepta cantidades con decimales para mayor precisión
- 👥 **Múltiples comensales**: Calcula la parte correspondiente para cualquier número de participantes
- 🍽️ **Sistema de propina**: Incluye un sistema de valoración del servicio del 0% al 25%
- 🔄 **Activación opcional**: Switch para habilitar/deshabilitar el cálculo de propina
- 📱 **Interfaz moderna**: Desarrollada con Jetpack Compose para una experiencia de usuario fluida
- 🔢 **Resultados claros**: Muestra tanto el total con propina como la cantidad por persona

## 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - Framework moderno para UI declarativa
- **Material 3** - Componentes de diseño siguiendo las últimas directrices de Material Design
- **Android SDK** - Desarrollo nativo para Android

## 📱 Capturas de Pantalla

*(Aquí puedes añadir capturas de pantalla de tu aplicación)*

## 🚀 Instalación

### Prerrequisitos

- Android Studio Arctic Fox o superior
- SDK de Android 21 o superior
- Kotlin 1.5.0 o superior

### Pasos de instalación

1. Clona este repositorio:
```bash
git clone https://github.com/tu-usuario/dividir-cuentas-app.git
```

2. Abre el proyecto en Android Studio

3. Sincroniza el proyecto con Gradle

4. Ejecuta la aplicación en tu dispositivo o emulador

## 💡 Uso

1. **Ingresa la cantidad total**: Escribe el monto total de la cuenta en el campo "Cantidad"

2. **Especifica los comensales**: Introduce el número de personas que van a dividir la cuenta en el campo "Comensales"

3. **Configura la propina (opcional)**:
   - Activa el switch "Redondear Propina" si deseas añadir propina
   - Usa el slider de "Valoración" para seleccionar el porcentaje de propina (0-5, donde cada punto equivale al 5%)

4. **Calcula**: Presiona el botón "Calcular" para obtener los resultados

5. **Ve los resultados**: La app mostrará:
   - El monto total incluyendo la propina
   - La cantidad que debe pagar cada persona

## 🏗️ Arquitectura

La aplicación sigue los principios de Jetpack Compose con una arquitectura simple y funcional:

### Componentes principales:

- **MainActivity**: Actividad principal que configura el contenido de la aplicación
- **CantidadTextField**: Componente para ingresar la cantidad total
- **ComensalesTextField**: Componente para ingresar el número de comensales
- **RedondearPropinaSwitch**: Switch para activar/desactivar la propina
- **SliderPropina**: Slider para seleccionar el porcentaje de propina
- **Calcular**: Botón que ejecuta el cálculo
- **pagarTotal**: Función que realiza los cálculos matemáticos

### Gestión del estado:

La aplicación utiliza `remember` y `mutableStateOf` para manejar el estado local de los componentes, siguiendo las mejores prácticas de Compose.

## 🧮 Lógica de cálculo

### Fórmulas utilizadas:

1. **División básica**: `cantidad total / número de comensales`

2. **Cálculo de propina**: 
   - Porcentaje de propina = `valor del slider * 5%`
   - Propina por persona = `cantidad por persona * (porcentaje de propina / 100)`

3. **Total por persona**: `cantidad por persona + propina por persona`

4. **Total general**: `cantidad total + (cantidad total * porcentaje de propina)`

## 🎨 Diseño

La aplicación utiliza Material 3 Design con los siguientes elementos:

- **OutlinedTextField**: Para la entrada de datos
- **Slider**: Para la selección de propina
- **Switch**: Para activar/desactivar funciones
- **Button**: Para ejecutar acciones
- **Text**: Para mostrar resultados y etiquetas

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 🔮 Futuras Mejoras

- [ ] Historial de cuentas divididas
- [ ] Diferentes monedas
- [ ] Modo oscuro
- [ ] Compartir resultados
- [ ] Calculadora de propina personalizada
- [ ] Soporte para múltiples idiomas
- [ ] Exportar resultados a PDF

---

⭐ Si este proyecto te ha sido útil, ¡no olvides darle una estrella!

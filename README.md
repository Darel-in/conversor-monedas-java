# 💱 Conversor de Monedas en Java

Aplicación de consola desarrollada en **Java** que permite convertir dólares estadounidenses (USD) a diferentes monedas utilizando una **API de tipos de cambio en tiempo real**.

## 🚀 Tecnologías utilizadas

- Java
- Maven
- HttpClient
- Gson
- API REST (ExchangeRate API)

## ⚙️ Funcionalidades

- Conversión de USD a múltiples monedas
- Menú interactivo en consola
- Validación de opciones del usuario
- Validación de monedas incorrectas
- Consumo de API externa para obtener tasas de cambio

## 📌 Ejemplo de uso

╔══════════════════════════════╗
CONVERSOR DE MONEDAS
╚══════════════════════════════╝

USD → MXN

USD → ARS

USD → BRL

Elegir otra moneda

Salir

Cantidad en USD:
20

━━━━━━━━ RESULTADO ━━━━━━━━
20.00 USD = 354.97 MXN
━━━━━━━━━━━━━━━━━━━━━━━━━━


## 🔑 Configuración

Para ejecutar el proyecto necesitas una API key de:

https://www.exchangerate-api.com/

Luego agrega tu clave en el archivo:

Principal.java
String apiKey = "COLOCA_TU_API_KEY_AQUI";


## 📂 Estructura del proyecto

src
└─ main
└─ java
├─ Principal.java
├─ ConsultaMoneda.java
└─ RespuestaMoneda.java


---

Proyecto realizado como práctica de consumo de APIs y manejo de JSON en Java.
# 🌦️ InfoTempo

InfoTempo é uma aplicação Java de console que permite ao usuário informar sua cidade e bairro e, a partir disso, obter:

* 📍 **Latitude e Longitude** (via API PositionStack)
* 🌡️ **Dados climáticos em tempo real** (via API OpenWeather)

O projeto foi desenvolvido com foco em aprendizado de consumo de APIs, manipulação de JSON e organização de código em camadas.

---

## 📌 Funcionalidades

* Leitura de localidade via terminal
* Conversão de endereço em coordenadas geográficas
* Consulta de clima com base nas coordenadas
* Exibição de temperatura, sensação térmica, pressão e umidade

---

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Gson** (para manipulação de JSON)
* **HTTP Client (java.net.http)**
* **APIs externas:**

  * PositionStack (geocoding)
  * OpenWeather (clima)

---

## 📂 Estrutura do Projeto

```
InfoTempo
└── src
    └── br.com.InfoTempo
        ├── principal
        │   └── Principal.java
        └── modelos
            ├── ConsultaCoordenadas.java
            ├── ConsultaClima.java
            ├── Endereco.java
            └── Clima.java
```

---

## 🚀 Como Executar

1. Clone o repositório
2. Abra em sua IDE (IntelliJ, Eclipse, VS Code, etc.)
3. Execute a classe:

```
br.com.InfoTempo.principal.Principal
```

4. Digite sua cidade e bairro quando solicitado

---

## 🔁 Fluxo da Aplicação

1. O usuário informa a localidade
2. O sistema consulta a **PositionStack API** para obter latitude e longitude
3. Com as coordenadas, o sistema consulta a **OpenWeather API**
4. Os dados de clima são exibidos no console

---

## 📦 Exemplo de Uso

```
Seja bem vindo ao InfoTempo
Escreva sua cidade e bairro
Mooca, São Paulo

Endereco[latitude=-23.556875, longitude=-46.597011]
Clima[temperatura=25.3°, sensação termica=26.1°, pressao=1013atm, humidade=78%]
```

---

## 🔐 Configuração das APIs

O projeto utiliza duas APIs externas:

### PositionStack

Usada para converter endereço em coordenadas.

Endpoint:

```
https://api.positionstack.com/v1/forward
```

Parâmetros:

* `access_key`
* `query`

---

### OpenWeather

Usada para obter dados climáticos.

Endpoint:

```
https://api.openweathermap.org/data/2.5/weather
```

Parâmetros:

* `lat`
* `lon`
* `appid`
* `units=metric`

---

## 🧠 Conceitos Aplicados

* Consumo de API REST
* Desserialização manual de JSON
* Uso de Records (Java)
* Organização por responsabilidade (principal / modelos)
* Tratamento de exceções

---

## 📈 Melhorias Futuras (sugestões)

* Exibir descrição do clima (ex: "céu limpo")
* Tratar múltiplos resultados de localização
* Criar interface gráfica
* Cache de resultados
* Internacionalização (i18n)

---

## 👨‍💻 Autor

Desenvolvido por **Mateus Ribeiro Azevedo**

Projeto educacional para estudo de Java + APIs + JSON

---

## 🏁 Conclusão

InfoTempo é um projeto simples, direto e bem estruturado para demonstrar na prática como integrar Java com serviços externos, tratar JSON e organizar código de forma profissional.

Perfeito para portfólio e evolução técnica 🚀

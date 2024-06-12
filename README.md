# API Advice Generator

## Descrição

Uma API REST em Java usando Spring Boot para consumir a API [Advice Slip](https://api.adviceslip.com) via OpenFeign, seguindo os princípios da arquitetura limpa.

## Funcionalidades

- Obter um conselho aleatório
- Consultar um conselho por ID

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- OpenFeign

## Como Executar

1. Clone o repositório:
    ```
    git clone https://github.com/systemnegro/advice-generator.git
    ```

2. Instale as dependências com Maven:

## Endpoints

- **Obter Conselho Aleatório:**
    ```
    GET /advice
    ```
- **Obter Conselho Por ID:**
    ```
    GET /advice/{id}
    ```

# 💳 EcoPay — Plataforma de Processamento de Pagamentos

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5.11-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

## 📖 Sobre o Projeto

O **EcoPay** é um projeto educacional "EM DESENVOLVIMENTO" com o objetivo de simular uma **plataforma de processamento de pagamentos**, inspirada na arquitetura utilizada por empresas fintech e plataformas financeiras modernas.

Este projeto foi criado com foco em:

- Demonstrar **boas práticas de desenvolvimento backend em Java**
- Utilizar **arquitetura em camadas**
- Implementar **Spring Boot com JPA, Segurança e APIs REST**
- Aplicar **padrões modernos de desenvolvimento**
- Demonstrar o uso **ético e produtivo de Inteligência Artificial no desenvolvimento de software**

Além disso, o projeto busca reforçar a importância de utilizar ferramentas de **IA como apoio ao raciocínio analítico e crítico**, e não como substituição do conhecimento técnico do desenvolvedor.

---

# 🎯 Objetivos do Projeto

O **EcoPay** tem como objetivo principal construir uma **API REST para gerenciamento e processamento de pagamentos**, contendo funcionalidades como:

- Criação de pagamentos
- Consulta de pagamentos
- Processamento de diferentes métodos de pagamento
- Gerenciamento de status do pagamento
- Persistência de dados em banco relacional

O sistema foi projetado de forma didática para demonstrar como estruturar um backend moderno utilizando **Spring Boot e Java 21**.

---

# 🧠 Uso Consciente de Inteligência Artificial no Desenvolvimento

Este projeto também reforça a importância do uso correto da **Inteligência Artificial no desenvolvimento de software moderno**.

A IA deve ser utilizada para:

✔ auxiliar na pesquisa técnica  
✔ validar raciocínios arquiteturais  
✔ acelerar consultas de documentação  
✔ sugerir melhorias de código

Por outro lado, o desenvolvedor continua sendo responsável por:

- entender o problema
- modelar corretamente a solução
- validar o código gerado
- garantir qualidade e segurança da aplicação

Ou seja, **a IA é uma ferramenta de apoio ao pensamento crítico**, e não um substituto da capacidade analítica do engenheiro de software.

---

# 🏗️ Arquitetura do Projeto

O EcoPay segue uma **arquitetura em camadas**, amplamente utilizada em sistemas corporativos, garantindo:

* Separação de responsabilidades
* Facilidade de manutenção
* Escalabilidade
* Código mais organizado e testável

## 📂 Estrutura de Pastas

```bash
src/main/java/com/ecopay/ecopay
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   └── PagamentoController.java
│
├── dto
│   ├── PagamentoRequestDTO.java
│   └── PagamentoResponseDTO.java
│
├── entity
│   └── Pagamento.java
│
├── enums
│   ├── MetodoPagamento.java
│   └── StatusPagamento.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── repository
│   └── PagamentoRepository.java
│
├── service
│   └── PagamentoService.java
│
└── EcopayApplication.java
```

## 📌 Descrição das Camadas

### 🔹 Controller

#### Responsável por expor os endpoints da API REST.

#### Recebe requisições HTTP

* Valida dados de entrada
* Chama a camada de service
* Retorna respostas para o cliente

### 🔹 Service

#### Camada onde fica a lógica de negócio da aplicação.

* Processamento de pagamentos
* Definição de regras de negócio
* Controle de status
* Comunicação com o repository

### 🔹 Repository

#### Responsável pelo acesso ao banco de dados.

* Utiliza Spring Data JPA
* Executa operações CRUD
* Abstrai o acesso à persistência

### 🔹 Entity

#### Representa as tabelas do banco de dados.

* Mapeamento com JPA (@Entity)
* Define os campos persistidos

### 🔹 DTO (Data Transfer Object)

#### Utilizado para transferência de dados entre camadas.

* Evita expor diretamente a entidade
* Controla entrada e saída de dados

### 🔹 Enums

#### Define valores fixos do sistema.

* Tipos de pagamento
* Status do pagamento

### 🔹 Exception

#### Camada responsável pelo tratamento global de erros.

* Padroniza respostas de erro
* Evita stacktrace exposto ao cliente

### 🔹 Config

#### Configurações da aplicação.

* Segurança (Spring Security)
* Filtros e autenticação

### ⚙️ Fluxo de Funcionamento da Aplicação

#### 🔄 1. Requisição do Cliente

##### O cliente envia uma requisição HTTP para criar um pagamento:

```http request
POST /pagamentos
```
* Com um JSON:

```json
{
  "valor": 150.00,
  "metodo": "PIX"
}
```

#### 🔄 2. Controller Recebe a Requisição

##### O PagamentoController:

* Recebe os dados via DTO (PagamentoRequestDTO)
* Valida a entrada
* Encaminha para o service

### 🔄 3. Service Processa a Regra de Negócio

##### O PagamentoService:

* Cria a entidade Pagamento
* Define status inicial (ex: PENDENTE)
* Aplica regras de negócio:
* Tipo de pagamento
* Simulação de processamento
* Atualiza status (ex: APROVADO ou RECUSADO)

### 🔄 4. Persistência no Banco

##### O PagamentoRepository:

* Salva os dados no banco (H2 ou outro)
* Retorna a entidade persistida

### 🔄 5. Conversão para DTO de Resposta

##### O Service:

* Converte a entidade Pagamento em PagamentoResponseDTO
* Remove dados desnecessários
* Prepara resposta segura

### 🔄 6. Retorno ao Cliente

##### O Controller retorna:

````json
{
  "id": 1,
  "valor": 150.00,
  "metodo": "PIX",
  "status": "APROVADO"
}
````

### 🔄 7. Tratamento de Erros

##### Caso ocorra algum problema:

* O GlobalExceptionHandler intercepta
* Retorna uma resposta padronizada:

```json
{
"erro": "Pagamento não encontrado",
"status": 404
}
```

## 📌 Observação

Este projeto foi desenvolvido com finalidade **didática**, visando o aprimoramento de **boas práticas de desenvolvimento de software**, incluindo organização em camadas, padrões de arquitetura e uso de tecnologias modernas do ecossistema Java.

---

## 👩‍💻 Desenvolvido By

**Brunna Dornelles** ✨

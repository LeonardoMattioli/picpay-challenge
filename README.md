# PicPay Simplificado API 🚀

## Descrição do Projeto

Este projeto é uma implementação simplificada de uma API de pagamentos inspirada no PicPay. A plataforma permite que usuários realizem depósitos e transferências de dinheiro entre si, com suporte a dois tipos de usuários: comuns e lojistas.

## Funcionalidades Principais

- Cadastro de usuários (comuns e lojistas)
- Depósito de dinheiro na carteira
- Transferências entre usuários
- Validação de saldo antes das transferências
- Integração com serviço autorizador externo

## Regras de Negócio

1. Dois tipos de usuários: comuns e lojistas
2. Cadastro de usuários requer: Nome Completo, CPF, e-mail e Senha
3. CPF/CNPJ e e-mails são únicos no sistema
4. Usuários comuns podem enviar e receber dinheiro
5. Lojistas apenas recebem transferências
6. Validação de saldo antes da transferência
7. Consulta a serviço autorizador externo antes de finalizar a transferência

## Tecnologias Utilizadas
- Java
- Spring Boot
- JPA
- Maven
- h2 database

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/LeonardoMattioli/picpay-challenge

# executar o projeto
./mvnw spring-boot:run
```

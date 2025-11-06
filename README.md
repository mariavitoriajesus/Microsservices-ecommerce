# Microsservices-ecommerce
##  🎯 Sobre o Desafio: Arquitetura de Microsserviços com Spring Boot
Este projeto visa o desenvolvimento de uma arquitetura de microsserviços robusta em Java, utilizando o framework Spring Boot. O escopo abrange desde a criação e configuração dos serviços até a integração de mecanismos de mensageria e o uso de ferramentas de apoio ao desenvolvimento.

O cerne do desafio é a construção de dois microsserviços principais que devem se comunicar de forma eficiente:
* 📦 **warehouse (Armazém)**: Responsável pela gestão do estoque.
* 🛍️ **storefront (Vitrine)**: Responsável pela interface de vendas e exibição dos produtos.

### 🌐 Comunicação entre Serviços
Os microsserviços deverão interagir utilizando dois padrões distintos de comunicação:

1. **Síncrona**: Via HTTP, ideal para consultas diretas e operações que exigem resposta imediata.
2. **Assíncrona**: Via RabbitMQ, para operações que não exigem resposta imediata, garantindo resiliência e desacoplamento.

## ✅ Objetivos do Projeto
Os objetivos a serem alcançados com este desafio são cruciais para a consolidação de conhecimentos e a demonstração de proficiência técnica:
* **Reprodução e/ou Melhoria**: Reproduzir a arquitetura de um projeto base existente, aplicando melhorias e refinamentos técnicos.
* **Aplicação Prática**: Aplicar os conceitos de microsserviços, Spring Boot, Mensageria (RabbitMQ) e Comunicação Síncrona/Assíncrona em um cenário de aplicação real.
* **Documentação Técnica**: Documentar de forma clara e organizada o raciocínio técnico, as decisões de arquitetura e as justificativas para as escolhas tecn
* **Versionamento e Exposição**: Utilizar o GitHub como plataforma principal para o versionamento do código, acompanhamento do histórico de desenvolvimento e exposição do trabalho realizado.
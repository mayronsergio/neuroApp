# NeuroApp

## Configuração e execução do projeto em Docker

Este documento fornece instruções passo a passo para preparar o ambiente e executar o projeto em Docker. Certifique-se de ter os requisitos necessários instalados em sua máquina antes de prosseguir.

## Requisitos

Antes de iniciar, verifique se você possui os seguintes requisitos instalados em sua máquina:

- Docker (versão 20.0 ou superior)
- Docker Compose (versão 1.29 ou superior)

## Preparação do ambiente

Siga as etapas abaixo para preparar o ambiente:

1. Certifique-se de que o Docker esteja instalado e funcionando corretamente. Verifique executando o comando `docker --version` em um terminal para exibir a versão instalada do Docker.

2. Verifique se o Docker Compose está instalado em sua máquina executando o comando `docker-compose --version` em um terminal para exibir a versão instalada do Docker Compose.

3. Clone o repositório do projeto para sua máquina local usando este comando:
```bash
git clone https://github.com/mayronsergio/neuroApp.git
```

4. Navegue até o diretório raiz do projeto no terminal.

## Execução do projeto em Docker

Siga as etapas abaixo para executar o projeto em Docker:

1. No terminal, execute o comando a seguir para construir as imagens Docker do projeto:
```bash
docker-compose build
```
2. Após a conclusão da construção das imagens, execute o comando a seguir para iniciar os contêineres:
```bash
docker-compose up
```
3. Aguarde até que o projeto seja iniciado e as mensagens de log indiquem que está em execução.

4. Após a inicialização bem-sucedida, você poderá acessar o projeto em execução no seguinte endereço: [http://localhost:8181](http://localhost:8181)
5. A partir deste momento a api já está pronta para receber requisições.

Certifique-se de substituir `8181` pela porta definida no arquivo `docker-compose.yml`, se você tiver alterado a configuração.

## Parar a execução do projeto

Para interromper a execução do projeto em Docker, abra um terminal e execute o comando a seguir:
```bash
docker-compose down
```
Isso encerrará os contêineres em execução.


# BotTelegram

Este repositório contém o código-fonte para um **Bot do Telegram** desenvolvido em **Java** utilizando o gerenciador de dependências **Maven**. O bot foi projetado para responder a comandos específicos, fornecendo informações úteis e interativas, como a data e hora atuais, frases motivacionais e um simulador de rolagem de dado.

## Tecnologias

O projeto é construído com as seguintes tecnologias:

*   **Linguagem de Programação:** Java
*   **Gerenciador de Dependências:** Apache Maven
*   **API do Telegram:** `telegrambots` (versão 5.3.0)

## Funcionalidades

O bot responde a uma variedade de comandos e mensagens. A seguir, está uma tabela detalhada dos comandos disponíveis e suas respectivas ações:

| Comando / Mensagem | Descrição |
| :--- | :--- |
| `/help` | Exibe a lista de todos os comandos disponíveis. |
| `/data` | Retorna a data atual no formato `dd/MM/yyyy`. |
| `/hora` | Retorna a hora atual no formato `HH:mm:ss`. |
| `/quem é você?` | Resposta fixa de identificação do bot. |
| `/d20` | Simula a rolagem de um dado de 20 faces, retornando um número aleatório entre 1 e 20. |
| `/motivacao` | Envia uma frase motivacional aleatória de uma lista pré-definida. |
| `/creditos` | Fornece links para o portfólio e canal do YouTube do autor. |
| `olá` | Responde com uma saudação amigável e reconhecimento sobre BOTS. |
| *Qualquer outra mensagem* | Retorna uma mensagem de erro e sugere o uso do comando `/help`. |

## Pré-requisitos

Para compilar e executar este projeto, você precisará ter instalado em seu ambiente:

1.  **Java Development Kit (JDK):** Versão 11 ou superior (conforme configurado no `pom.xml`).
2.  **Apache Maven:** Para gerenciar as dependências e o ciclo de vida do projeto.
3.  **Token de Acesso do Bot do Telegram:** Um token obtido através do BotFather no Telegram.

## Instalação e Configuração

Siga os passos abaixo para configurar e rodar o bot:

### 1. Clonar o Repositório

Utilize o comando `git clone` para baixar o código-fonte para sua máquina local:

```bash
git clone https://github.com/GilvanPedro/BotTelegram.git
cd BotTelegram/BotTelegram
```

### 2. Configurar o Token do Bot

O token e o nome de usuário do bot são definidos no arquivo `DadosBot.java`. Você deve substituir os valores de *placeholder* pelos dados reais do seu bot.

Localize e edite o arquivo: `src/main/java/br/com/BotTelegram/DadosBot.java`

```java
package br.com.BotTelegram;

public class DadosBot {
    // Substitua pelo seu token real
    public static final String BOT_TOKEN = "SEU_TOKEN_AQUI"; 
    // Substitua pelo nome de usuário do seu bot (ex: @MeuBotExemplo)
    public static final String BOT_USER_NAME = "SEU_NOME_DE_USUARIO_AQUI"; 
}
```

### 3. Compilar o Projeto

Navegue até o diretório raiz do projeto (`BotTelegram/BotTelegram`) e utilize o Maven para compilar o projeto e gerar o arquivo JAR executável:

```bash
mvn clean install
```

O arquivo JAR será gerado no diretório `target/`.

### 4. Executar o Bot

Execute o arquivo JAR gerado para iniciar o bot. O nome exato do arquivo pode variar, mas geralmente segue o padrão `BotTelegram-1.0-SNAPSHOT.jar`.

```bash
java -jar target/BotTelegram-1.0-SNAPSHOT.jar
```

O bot estará agora online e pronto para responder às mensagens no Telegram.

## Uso

Após a execução, o bot estará ativo. Você pode interagir com ele no Telegram enviando qualquer um dos comandos listados na seção **Funcionalidades**.

## Licença

Este projeto está licenciado sob a **Licença MIT**. Para mais detalhes, consulte o arquivo [LICENSE](LICENSE) no repositório.

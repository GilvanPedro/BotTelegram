package br.com.BotTelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return DadosBot.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return DadosBot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) {
        var textoMensagem = update.getMessage().getText().toLowerCase();
        var chatId = update.getMessage().getChatId().toString();

        var resposta = "";

        if ("data".equals(textoMensagem)) {
            resposta = getData();
        } else if (textoMensagem.startsWith("hora")) {
            resposta = getHora();
        } else if (textoMensagem.startsWith("ola") || textoMensagem.startsWith("olá") || textoMensagem.startsWith("oi")) {
            resposta = "Olá, vejo que você entende muito sobre BOTS!";
        } else if (textoMensagem.startsWith("quem é você") || textoMensagem.startsWith("quem e voce")) {
            resposta = "Eu sou um bot \uD83E\uDD16";
        } else if (textoMensagem.startsWith("/d20")) {
            int numero = getNumero();
            resposta = "Você rolou um D20 e caiu em: *" + numero + "*";
        } else if (textoMensagem.startsWith("/motivacao")) {
            resposta = getFraseMotivacional();
        } else if (textoMensagem.startsWith("/help")) {
            resposta = "Utilize um dos comandos:\n" +
                    "----------------------------\n" +
                    "olá\n" +
                    "data\n" +
                    "hora\n" +
                    "quem é você?\n" +
                    "/d20\n" +
                    "/motivacao\n" +
                    "/creditos";
        } else if(textoMensagem.startsWith("/creditos")){
            resposta = "Twitter: https://x.com/gilvannp\nPortifólio: https://t.co/oAOB3thKw1\nYoutube: https://www.youtube.com/@gilvannp";
        }
        else {
            resposta = "Não entendi!\nDigite /help para ver os comandos disponíveis.";
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }


    private String getData() {
        var formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "A data atual é: " + formatter.format(new Date());
    }

    private String getHora() {
        var formatter = new SimpleDateFormat("HH:mm:ss");
        return "A hora atual é: " + formatter.format(new Date());
    }

    private int getNumero(){
        return (int) (Math.random() * 20) + 1;
    }

    private String getFraseMotivacional() {
        String[] frases = {
                "Acredite em você e tudo será possível!",
                "O sucesso é a soma de pequenos esforços repetidos diariamente.",
                "Você é mais forte do que imagina.",
                "Nunca pare de tentar, nunca pare de acreditar, nunca desista.",
                "O futuro depende das escolhas que você faz hoje.",
                "Coragem é saber que pode não dar certo e tentar mesmo assim.",
                "Seja melhor que ontem!",
                "Grandes coisas começam com pequenos passos.",
                "A persistência é o caminho do êxito.",
                "Você consegue. Apenas continue."
        };

        int index = (int)(Math.random() * frases.length);
        return frases[index];
    }

}
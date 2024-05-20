import javax.swing.JOptionPane;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Criando método de entrada de dados
        //Scanner entrada = new Scanner(System.in);

        //Criando método aleatório
        Random aleatoria = new Random();
        int PosicaoVetor;

        //Inicializando as variáveis
        String palavracerta, palavrainserida, dicas;

        //Verificadores
        int NumTentativas; //Define o número de tentativas
        int LoopTentativa; //Verificar se há tentativas restantes
        int LoopTotal; //Verifica se o jogador deseja iniciar nova rodada

        //Pontuação
        int Pontuacao, PontuacaoTotal = 0;

        JOptionPane.showMessageDialog(null, "Bem vindo ao Quiz!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Este programa trata-se de um projeto acadêmico para a disciplina Linguagens de Programação,\nonde o objetivo é demonstrar de forma prática o nosso conhecimento adquirido durante as aulas,\nassim criando do zero um programa funcional.", "Quiz", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Neste jogo você precisa acertar a resposta correta, onde há duas categorias disponíveis para jogar,\ncada categoria possui 7 possíveis respostas. Você terá 5 tentativas para acertar,\ncaso precise de uma ajuda para advinhar a palavra, basta digitar: DICA.", "Quiz", JOptionPane.INFORMATION_MESSAGE);

        do {

            LoopTentativa = 0;

            Object[] categoria = {"As sete maravilhas do Mundo", "Os sete maiores estados brasileiros", "Sair"};

            Object OpcaoSelecionada = JOptionPane.showInputDialog(null, "Escolha uma das categoria abaixo", "Quiz", JOptionPane.INFORMATION_MESSAGE, null, categoria, categoria[0]);

            if (OpcaoSelecionada == "As sete maravilhas do Mundo") {
                //Declarando vetor
                String[] sete = {"Chichén Itzá", "Coliseu", "Cristo Redentor", "Grande Muralha da China", "Machu Picchu", "Ruínas de Petra", "Taj Mahal"};
                String[] dicaSete = {"Sou um importante sítio arqueológico Maia!", "Sou lembrado pelos grandes duelos entre gladiadores!", "Sempre estou de braços abertos para te receber!", "A minha extensão ultrapassa 21 quilômetros!", "Sou uma grande construção que foi desconhecida por séculos!", "Sou considerada uma cidade esculpida nas montanhas!", "Sou considerado uma prova de amor!"};
                //Método para selecionar palavra de forma aleatória
                //As informações abaixo são apresentadas apenas para manter um melhor entendimento durante o desenvolvimento do jogo
                //Na versão final não será apresentado qual a palavra que foi selecionada
                PosicaoVetor = aleatoria.nextInt(6);
                //System.out.println(PosicaoVetor);
                palavracerta = sete[PosicaoVetor];
                //System.out.println(sete[PosicaoVetor]);
                dicas = dicaSete[PosicaoVetor];
                //System.out.println(dicas);
            } else if (OpcaoSelecionada == "Os sete maiores estados brasileiros") {
                //Declarando vetor
                String[] estados = {"Amazonas", "Pará", "Mato Grosso", "Minas Gerais", "Bahia", "Mato Grosso do Sul", "Goiás"};
                String[] dicaEstados = {"Estou localizado na região Norte", "Estou localizado na região Norte", "Estou localizado na região Centro-Oeste", "Estou localizado na região Sudeste", "Estou localizado na região Nordeste", "Estou localizado na região Centro-Oeste", "Estou localizado na região Centro-Oeste"};
                //Método para selecionar palavra de forma aleatória
                //As informações abaixo são apresentadas apenas para manter um melhor entendimento durante o desenvolvimento do jogo
                //Na versão final não será apresentado qual a palavra que foi selecionada
                PosicaoVetor = aleatoria.nextInt(6);
                //System.out.println(PosicaoVetor);
                palavracerta = estados[PosicaoVetor];
                //System.out.println(frutas[PosicaoVetor]);
                dicas = dicaEstados[PosicaoVetor];
                //System.out.println(dicas);
            } else {
                JOptionPane.showMessageDialog(null, "Você está saindo do jogo!\n\nBYE!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            NumTentativas = 5;

            while (LoopTentativa != 1) {

                //Inicia o jogo com 5 tentativas e utiliza o if para verificar a quantidade de tentativas.
                if (NumTentativas > 1) {

                    if(OpcaoSelecionada == "Os sete maiores estados brasileiros"){
                        palavrainserida = JOptionPane.showInputDialog(null, "Obs: São os maiores estados em extensão territorial!\n\nVocê possui " + NumTentativas + " tentativas restantes\nCaso precise de uma ajude, digite DICA\nDigite uma palavra", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        NumTentativas--;
                    } else{
                        palavrainserida = JOptionPane.showInputDialog(null, "Você possui " + NumTentativas + " tentativas restantes\nCaso precise de uma ajude, digite DICA\nDigite uma palavra", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        NumTentativas--;
                    }

                    //Verifica se a palavra está correta, se estiver errada o irá definir o verificador do while para iniciar novamente.
                    //Caso a palavra esteja correta, irá definir o verificador do while para não inicar novamente.


                    if (palavrainserida == null) {
                        JOptionPane.showMessageDialog(null, "Você anulou a rodada atual.", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        LoopTentativa = 1;
                    } else if (palavrainserida.equalsIgnoreCase("dica")) {
                        JOptionPane.showMessageDialog(null, "Aqui vai a dica.\n\n" + dicas, "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        NumTentativas++;
                    } else if (!palavracerta.equalsIgnoreCase(palavrainserida)) {
                        JOptionPane.showMessageDialog(null, "Você não acertou a palavra!\nTente novamente.", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Parabéns!\n\nVocẽ acertou a palavra!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        LoopTentativa = 1;
                        Pontuacao = (NumTentativas + 1) * 2;
                        PontuacaoTotal = PontuacaoTotal + Pontuacao;
                        JOptionPane.showMessageDialog(null, "Você fez " + Pontuacao + " pontos nessa rodada!\n\nSua pontuação total é de " + PontuacaoTotal + " pontos!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                    }

                    //Verifica se está na última tentativa.
                } else if (NumTentativas == 1) {

                    if(OpcaoSelecionada == "Os sete maiores estados brasileiros"){
                        palavrainserida = JOptionPane.showInputDialog(null, "Obs: São os maiores estados em extensão territorial!\n\nVocê possui " + NumTentativas + " tentativas restantes\nCaso precise de uma ajude, digite DICA\nDigite uma palavra", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        NumTentativas--;
                    } else{
                        palavrainserida = JOptionPane.showInputDialog(null, "Você possui " + NumTentativas + " tentativas restantes\nCaso precise de uma ajude, digite DICA\nDigite uma palavra", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        NumTentativas--;
                    }
                    //Verifica se a palavra está correta, em ambas situações irá definir o verificador do while para não inicar novamente.
                    if (palavrainserida == null) {
                        JOptionPane.showMessageDialog(null, "Você anulou a rodada atual.", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        LoopTentativa = 1;
                    } else if (palavrainserida.equalsIgnoreCase("dica")) {
                        JOptionPane.showMessageDialog(null, "Aqui vai a dica.\n\n" + dicas, "Quiz", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!palavracerta.equalsIgnoreCase(palavrainserida)) {
                        JOptionPane.showMessageDialog(null, "Você não acertou a palavra! \n\nGame Over!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Você não pontuou nessa rodada!\n\nSua pontuação total é de " + PontuacaoTotal + " pontos!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        LoopTentativa = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Parabéns!\nVocẽ acertou a palavra!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                        LoopTentativa = 1;
                        Pontuacao = (NumTentativas + 1) * 2;
                        PontuacaoTotal = PontuacaoTotal + Pontuacao;
                        JOptionPane.showMessageDialog(null, "Você fez " + Pontuacao + " pontos nessa rodada!\nSua pontuação total é de " + PontuacaoTotal + " pontos!", "Quiz", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            //Verifica se o jogador deseja iniciar nova rodada
            LoopTotal = Integer.parseInt(String.valueOf(JOptionPane.showConfirmDialog(null, "Deseja iniciar uma nova rodada?", "Quiz", JOptionPane.YES_NO_OPTION)));

            if (LoopTotal == 1) {
                JOptionPane.showMessageDialog(null, "Você está saindo do jogo!\n\nObrigado por jogar.", "Quiz", JOptionPane.INFORMATION_MESSAGE);
            }

        } while (LoopTotal == 0);
    }
}
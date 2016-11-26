package pkg4.imprimebrancotablinha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class LeituraArquivo {

    static void ler() {

        File file = new File("C:\\Users\\cem\\Desktop\\BD\\Estudos\\FATEC\\4Semestre\\POO\\Atividade\\4 - ImprimeBrancoTabLinha\\Texto.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);

            String linha;
            int contLNull = 0;
            int contLEspa = 0;
            int contLTab = 0;

            while ((linha = input.readLine()) != null) {

                System.out.println(linha);

                if (linha == null || linha.isEmpty()) {
                    contLNull += 1;//verifica se a linha é nula ou vazia
                }
                
                String[] separacao = linha.split("\t");
                if (separacao != null) {
                        contLTab += 1;//verifica se tem tabulação de linha
                    }
                
                if (linha != null) {
                    for (int i = 0; i < linha.length(); i++) {
                        if (linha.charAt(i) == ' ') {
                            contLEspa += 1;// verifica os espaçamentos na linha
                        }
                    }
                }
            }
            input.close();
            JOptionPane.showMessageDialog(null, "Quantidade de linhas no texto " + contLTab);
            JOptionPane.showMessageDialog(null, "Quantidade de linha em branco " + contLNull);
            JOptionPane.showMessageDialog(null, "Quantidade de espaços em branco no texto " + contLEspa);
        } catch (Exception ioe) {
            System.out.println(ioe);
            JOptionPane.showMessageDialog(null, ioe);
        }
    }
}

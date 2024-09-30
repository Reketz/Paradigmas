package br.com.exemplos.calibracao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static br.com.exemplos.calibracao.Calibracao.valorCalibracao;

public class Main {
    public static void main(String[] args) throws IOException {

        long tempoInicial = System.currentTimeMillis();

        Path path = Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\br\\com\\exemplos\\calibracao\\resource\\new_calibration_text.txt");
        List<String> calibrations = Files.readAllLines(path);

        int soma = 0;
        int count = 0;

        for (String line: calibrations) {
            soma += valorCalibracao(line);
            count++;
        }

        System.out.println("A soma dos valores é: " + soma);
        System.out.println("Total de linhas: " + count);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
}

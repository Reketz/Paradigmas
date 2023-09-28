package br.com.exemplos.excessoes;
public class ExemploCheckedUnchecked {
    // Exceção verificada (checked)
    public static void metodoComExcecaoVerificada() throws Exception {
        throw new Exception("Isso é uma exceção verificada.");
    }

    // Exceção não verificada (unchecked)
    public static void metodoComExcecaoNaoVerificada() {
        throw new RuntimeException("Isso é uma exceção não verificada.");
    }

    public static void main(String[] args) {
        try {
            // Chama o método com exceção verificada
            metodoComExcecaoVerificada();
        } catch (Exception e) {
            System.out.println("Exceção verificada capturada: " + e.getMessage());
        }

        // Chama o método com exceção não verificada
        metodoComExcecaoNaoVerificada();
    }
}

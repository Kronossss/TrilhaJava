package companhia;




public class Imoveis {
        private static int proxMatricula = 1;
        private double penultimaLeitura;
        private String endereco;
        private double ultimaLeitura;
        private String matricula;

    
    
        public Imoveis(java.lang.String endereco, double penultimaLeitura, double ultimaLeitura) {
        //this.matricula = setMatricula();
        this.endereco = endereco;
        this.penultimaLeitura = penultimaLeitura;
        this.ultimaLeitura = ultimaLeitura;
    }

        private void setMatricula(){
    }



    public static String converterLetrasParaDigitos(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (char letra : texto.toCharArray()) {
            int valorAscii = (int) letra;
            resultado.append(String.format("%08d", valorAscii));
        }

        return resultado.toString();
    }


    
    public static void main(String[] args) {
        System.out.println(converterLetrasParaDigitos("hello"));
    }
}

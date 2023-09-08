package br.com.meuprojeto;

public class Main {
    public static void main(String[] args) {
        Mapa<String, Integer> mapa = new Mapa<>();
        mapa.colocar("um", 1);
        mapa.colocar("dois", 2);
        System.out.println(mapa.obter("um"));  // Deve imprimir 1
        System.out.println(mapa.obter("dois"));  // Deve imprimir 2

        mapa.remover("um");
        System.out.println(mapa.obter("um"));  // Deve imprimir null
    }
}

package br.com.meuprojeto;

public class Mapa <K, V> {
    private No inicio = null;

    private class No {
        K chave;
        V valor;
        No proximo;
        No anterior;

        No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    public void colocar(K chave, V valor) {
        No novoNo = new No(chave, valor);

        if (inicio == null) {
            inicio = novoNo;
            return;
        }

        No atual = inicio;
        while (atual.proximo != null) {
            if (atual.chave.equals(chave)) {
                atual.valor = valor;
                return;
            }
            atual = atual.proximo;
        }

        if (atual.chave.equals(chave)) {
            atual.valor = valor;
            return;
        }

        atual.proximo = novoNo;
        novoNo.anterior = atual;
    }

    public V obter(K chave) {
        No atual = inicio;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public boolean contemChave(K chave) {
        return obter(chave) != null;
    }

    public V remover(K chave) {
        No atual = inicio;

        while (atual != null) {
            if (atual.chave.equals(chave)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                }
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }
}

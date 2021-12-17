package br.com.dhan.arquivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

public class Testador {

    public static void main(String[] args) {
        final Pessoa danilo = new Pessoa("Danilo");

        try {
            Pessoa danilo2 = (Pessoa) danilo.clone();

            System.out.println();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    @Data
    @AllArgsConstructor
    public static class Pessoa implements Cloneable {
        private String nome;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}

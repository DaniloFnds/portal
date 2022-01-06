package br.com.dhan.importacaoarquivo.common;

public interface UseCaseHandler<R, E> {

    R handler(E input);
}

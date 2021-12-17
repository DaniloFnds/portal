package br.com.dhan.arquivo;

import br.com.dhan.entity.ImportacaoArquivoEntity;
import com.datastax.oss.driver.shaded.guava.common.collect.Lists;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;

public class Testador {

    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        ImportacaoArquivoEntity importacaoArquivoEntity = new ImportacaoArquivoEntity();
        importacaoArquivoEntity.setId(UUID.randomUUID());
        importacaoArquivoEntity.setNomeArquivo("teste");
        List<ImportacaoArquivoEntity> lista = Lists.newArrayList(importacaoArquivoEntity);



    }
}

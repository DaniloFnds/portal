package br.com.dhan.testeloadcsv;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

@SpringBootApplication
public class TesteLoadCsvApplication {


    public static void main(String[] args) {
        SpringApplication.run(TesteLoadCsvApplication.class);

    }

    @Component
    @RequiredArgsConstructor
    public class TestRunner {

        private final DataSource dataSource;

        @PostConstruct
        public void execute() {


            final StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            try (final FileOutputStream fileOutputStream = new FileOutputStream(new File("C:/TESTE/testejava.csv"))) {
                new NamedParameterJdbcTemplate(this.dataSource)
                        .query("select top 10000  DT, VL_NOMINAL, VL_PRESENTE, ID_FUNDO from TB_ESTOQUE " +
                                        "where id_fundo = 3 and dt > '2019-07-01'  " +
                                        "order by dt desc", EmptySqlParameterSource.INSTANCE
                                , (rs) -> {
                                    final Date date = rs.getDate(1);
                                    final BigDecimal valorNominal = rs.getBigDecimal(2);
                                    final BigDecimal valorPresente = rs.getBigDecimal(3);
                                    final int idFundo = rs.getInt(4);

                                    try {
                                        fileOutputStream.write(String.format("%s;%s;%s;%s\r\n", date.toString(),
                                                valorNominal.toString(), valorPresente.toString(), String.valueOf(idFundo)).getBytes(StandardCharsets.UTF_8));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                });
            } catch (Exception e) {

            }

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());

        }

    }


}

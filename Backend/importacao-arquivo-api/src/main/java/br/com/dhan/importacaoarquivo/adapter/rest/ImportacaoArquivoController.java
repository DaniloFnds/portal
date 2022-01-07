package br.com.dhan.importacaoarquivo.adapter.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/importacoes/arquivos", produces = APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@Slf4j
public class ImportacaoArquivoController {

 /*   private final ImportacaoArquivoService importacaoArquivoService;

    @Autowired
    public ImportacaoArquivoController(ImportacaoArquivoService importacaoArquivoService) {
        this.importacaoArquivoService = importacaoArquivoService;
    }

    @Operation(summary = "Carregar todas as importacos do usuário logado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Importacoes encontrada", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ImportacaoArquivoDto.class))
            }), @ApiResponse(responseCode = "400", description = "Nenhuma importacao encontrada", content = @Content)})
    @GetMapping
    public ResponseEntity<List<ImportacaoArquivoDto>> findAll() {
        final List<ImportacaoArquivoDto> listaImportacoes = this.importacaoArquivoService.loadImportacoesArquivo();
        if (listaImportacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaImportacoes);
    }

    @Operation(summary = "Importar um novo arquivo"
            , parameters = {@Parameter(name = "fundoId", description = "Id do fundo que pertence o arquivo")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Importacao inserida com Sucesso", content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ImportacaoArquivoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao gravar a importacao", content = @Content)})
    @PostMapping(path = "/{fundoId}", consumes = {APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<List<ImportacaoArquivoDto>> importarArquivo(
            @PathVariable("fundoId") final String fundoId
            , @RequestParam final List<MultipartFile> arquivos) {

        return this.importacaoArquivoService.criarArquivo(fundoId, arquivos)
                .map(imp -> ResponseEntity.status(HttpStatus.CREATED).body(imp))
                .orElseGet(() -> ResponseEntity.internalServerError().build());
    }*/
}

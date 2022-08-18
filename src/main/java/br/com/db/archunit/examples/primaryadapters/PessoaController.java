package br.com.db.archunit.examples.primaryadapters;

import br.com.db.archunit.examples.application.ports.primary.IPessoaUsecase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

  private IPessoaUsecase pessoaUcase;

}

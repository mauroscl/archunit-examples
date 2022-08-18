package br.com.db.archunit.examples.application.usecases;

import br.com.db.archunit.examples.application.ports.primary.IPessoaUsecase;
import br.com.db.archunit.examples.application.ports.secondary.IPessoaRepository;
import org.springframework.stereotype.Service;

@Service
class PessoaUcaseImpl implements IPessoaUsecase {

  private IPessoaRepository pessoaRepository;

  @Override
  public void contratar() {
    //nao implementado
  }
}

package br.com.db.archunit.examples.secondaryadapters;

import br.com.db.archunit.examples.application.domain.model.Pessoa;
import br.com.db.archunit.examples.application.ports.secondary.IPessoaRepository;
import org.springframework.stereotype.Repository;

@Repository
class PessoaRepository implements IPessoaRepository {

  @Override
  public Pessoa salvar(Pessoa pessoa) {
    return pessoa;
  }
}

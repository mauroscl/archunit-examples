package br.com.db.archunit.examples.application.ports.secondary;

import br.com.db.archunit.examples.application.domain.model.Pessoa;

public interface IPessoaRepository {
  Pessoa salvar(Pessoa pessoa);

}

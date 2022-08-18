package br.com.db.archunit.examples.secondaryadapters;

import br.com.db.archunit.examples.application.ports.secondary.IValidadorCpf;
import org.springframework.stereotype.Component;

@Component
class ValidadorCpfClient  implements IValidadorCpf {

  @Override
  public boolean isCpfOk(String numero) {
    return true;
  }
}

package br.com.db.archunit.examples.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

/**
 * O objetivo desta classe é mostrar que também podemos utilizar @Test ao invés de @ArchTest para fazer um teste utilizando ArchUnit
 */
class InterfaceTestPadrao {

  @Test
  void nomesDasInterfacesDevemComecarComI(){

    var javaClasses = new ClassFileImporter().importPackages(
        "br.com.db.archunit.examples");

    var rule = classes().that().areInterfaces().should().haveSimpleNameStartingWith("I");

    rule.check(javaClasses);
  }


}

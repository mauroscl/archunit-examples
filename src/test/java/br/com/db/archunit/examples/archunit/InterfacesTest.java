package br.com.db.archunit.examples.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/**
 * Os dois testes verificam a mesma coisa. Pode ser feito com método ou com field
 */
@AnalyzeClasses(packages = "br.com.db.archunit.examples", importOptions = ImportOption.DoNotIncludeTests.class)
public class InterfacesTest {

  @ArchTest
  void nomesDasInterfacesDevemComecarComIUtilizandoMetodo(JavaClasses javaClasses){
    //Para quebrar este teste renomei a interface IPessoausecase para Pessoausecase
    var rule = classes().that().areInterfaces().should().haveSimpleNameStartingWith("I");

    rule.check(javaClasses);
  }

  @ArchTest
  ArchRule nomesDasInterfacesDevemComecarComIUtilizandoField = classes().that().areInterfaces().should().haveSimpleNameStartingWith("I");




}

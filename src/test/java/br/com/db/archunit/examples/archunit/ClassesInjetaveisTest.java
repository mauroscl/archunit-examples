package br.com.db.archunit.examples.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@AnalyzeClasses(packages = "br.com.db.archunit.examples", importOptions = ImportOption.DoNotIncludeTests.class)
class ClassesInjetaveisTest {

  @ArchTest
  void classesConcretasQueSaoInjetaveisNaoDevemSerPublicas(JavaClasses javaClasses){
    //para quebrar este teste inclua o modifier PUBLIC na classe PessoaUsecase
    var rule = classes().that()
        .areAnnotatedWith(Service.class)
        .or().areAnnotatedWith(Component.class)
        .or().areAnnotatedWith(Repository.class)
        .should().notBePublic()
        .because("Devemos evitar classes concretas públicas para que as outras classes sempre dependam das interfaces");

    rule.check(javaClasses);
  }

}

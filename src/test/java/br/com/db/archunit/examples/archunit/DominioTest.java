package br.com.db.archunit.examples.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.constructors;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.CacheMode;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.Priority;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "br.com.db.archunit.examples.application.domain", cacheMode = CacheMode.PER_CLASS)
public class DominioTest {

  @ArchTest
  void dominioDeveSerAutoContido(JavaClasses javaClasses){
    //para quebrar este teste adicione uma propriedade da classe CidadeDTO na classe Pessoa
    var rule = ArchRuleDefinition.noClasses().that().resideInAPackage("..domain..")
        .should().dependOnClassesThat().resideOutsideOfPackages("..domain..", "java.lang..");
    rule.check(javaClasses);
  }

  @ArchTest
  void construtoresVaziosNaoPodemSerPublicos(JavaClasses javaClasses){
    //para quebrar este teste adicione um construtor publico sem parâmetros na classe Pessoa
    var rule = constructors().that().areNotPrivate().should(
        new ArchCondition<>("construtor nao pode ser vazio") {
          @Override
          public void check(JavaConstructor item, ConditionEvents events) {
            if (item.getParameters().size() == 0) {
              events.add(new SimpleConditionEvent(item, false, item.getDescription()));
            }
          }
        });

    rule.check(javaClasses);
  }

  @ArchTest
  void settersDevemSerPrivados(JavaClasses javaClasses){
    //para quebrar este teste adicione um método set publico na classe Pessoa
    var rule = ArchRuleDefinition.priority(Priority.HIGH)
        .methods()
        .that()
        .haveNameStartingWith("set")
        .should().bePrivate()
        .allowEmptyShould(true);

    rule.check(javaClasses);
  }

}

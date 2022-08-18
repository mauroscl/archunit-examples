package br.com.db.archunit.examples.archunit;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "br.com.db.archunit.examples", importOptions = {ImportOption.DoNotIncludeTests.class})
public class LayersTest{

  @ArchTest
  void deveAcessarCamadasCorretamente(JavaClasses javaClasses) {
    //para quebrar este teste inclua um field da classe CidadeDTO (layer application) no classe Pessoa (layer domain)
    var spec = layeredArchitecture().consideringOnlyDependenciesInLayers()
        .layer("domain").definedBy("br.com.db.archunit.examples.application.domain..")
        .layer("application").definedBy("br.com.db.archunit.examples.application.usecases..")
        .layer("primaryadapters").definedBy("br.com.db.archunit.examples.primaryadapters..")
        .layer("secondaryadapters").definedBy("br.com.db.archunit.examples.secondaryadapters..")
        .whereLayer("application").mayNotBeAccessedByAnyLayer()
        .whereLayer("domain").mayNotAccessAnyLayer();

    spec.check(javaClasses);
  }
}

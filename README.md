
# Java Code Generator Example

- this project demonstrates the usage of 
  [FreeMarker](https://freemarker.apache.org/) template engine
- it generates java files based on ftl-templates (Generator.java)
- there is also some spring boot and reflection involved

### FreeMarker Basic Setup

- use spring-boot-starter-freemarker dependency
- or just take the org.freemarker part without spring
- optional: set some additional [configs](https://freemarker.apache.org/docs/pgui_config.html) 
  (spring has defaults)
- define 
  [data model](https://freemarker.apache.org/docs/pgui_quickstart_createdatamodel.html) 
  (input of generator)
- create 
  [template files](https://freemarker.apache.org/docs/dgui_template_overallstructure.html) 
  (structure of output files)
- [process template](https://freemarker.apache.org/docs/pgui_quickstart_merge.html)
  to receive output (and store as file)

### Generator

- execute Generator via spring boot command line runner in main method
- check generated files under target/generated-sources/generator
- intellij tip: mark this directory as "Sources" in "Project Structure"

### Testing

- afterwards you can introspect the generated classes via reflection (Analyzer.java)
- just run the provided testcase (AnalyzerTest.java)
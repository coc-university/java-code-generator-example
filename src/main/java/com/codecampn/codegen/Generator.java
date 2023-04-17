package com.codecampn.codegen;

import com.codecampn.codegen.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Service
@Log4j2
@RequiredArgsConstructor
public class Generator {

    private final Configuration freemarker;

    public void run() throws IOException, TemplateException {
        Path pathToGeneratedFiles = setupEnv();
        for (DataModel dataModel : getDataModels()) {
            // create java class for each dataModel
            String classAsString = generateClassAsString(dataModel);
            Path filePath = pathToGeneratedFiles.resolve(dataModel.getName() + ".java");
            writeStringToFile(filePath, classAsString);
        }
        log.info("Generator finished");
    }

    private Path setupEnv() throws IOException, TemplateModelException {
        Path basePath = Paths.get("target/generated-sources/generator");
        String packageName = this.getClass().getPackage().getName() + ".model";

        // optional: do some further configurations of the template engine
        freemarker.setSharedVariable("package", packageName); // can be used in all templates

        // prepare folder structure and later create java files there
        Path pathToGeneratedFiles = basePath.resolve(Paths.get(packageName.replace(".", "/")));
        Files.createDirectories(pathToGeneratedFiles);

        return pathToGeneratedFiles;
    }

    private List<DataModel> getDataModels() {
        // this input data model can also be loaded from a file or external system
        return List.of(
                new DataModel("Robin", true, List.of("No_1", "No_2", "No_3")),
                new DataModel("Peter", false, null)
        );
    }

    private String generateClassAsString(DataModel dataModel) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        Template template = freemarker.getTemplate("java-class.ftl"); // from resources
        template.process(dataModel, writer); // merge template with dataModel and write output
        return writer.toString();
    }

    private void writeStringToFile(Path filePath, String classAsString) throws IOException {
        StandardOpenOption[] options = new StandardOpenOption[]{CREATE, TRUNCATE_EXISTING};
        Files.writeString(filePath, classAsString, StandardCharsets.UTF_8, options);
    }

}

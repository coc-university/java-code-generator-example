package com.codecampn.codegen;

import com.codecampn.codegen.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnalyzerTest {

    @Test
    public void checkObjects() throws IllegalAccessException {
        Analyzer analyzer = new Analyzer();

        for (Object testObject : prepareTestObjects()) {
            analyzer.checkObject(testObject);
            System.out.println("---");
        }
    }

    private List<Object> prepareTestObjects() {
        return List.of(
                new Robin(8, "this is Robin"),
                new Peter(9, "this is Peter")
        );
    }
}

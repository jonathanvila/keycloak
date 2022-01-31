package org.keycloak.operator;

import io.javaoperatorsdk.operator.Operator;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;

@QuarkusMain
public class OperatorMain implements QuarkusApplication {
    @Inject
    Operator operator;

    public static void main(String... args) {
        Quarkus.run(OperatorMain.class, args);
    }

    @Override
    public int run(String... args) {
        operator.start();
        Quarkus.waitForExit();
        return 0;
    }
}

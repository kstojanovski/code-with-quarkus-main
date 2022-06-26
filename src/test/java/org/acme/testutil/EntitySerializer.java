package org.acme.testutil;

import org.junit.jupiter.api.Assertions;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class EntitySerializer {

    public String serializeEntity(Object object) {
        final String serializedPerson;
        try (Jsonb jsonb = JsonbBuilder.create()) {
            serializedPerson = jsonb.toJson(object).translateEscapes();
        } catch (Exception e) {
            Assertions.fail();
            throw new RuntimeException(e);
        }
        return serializedPerson;
    }
}

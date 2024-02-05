package de.ossi.generator;

import de.ossi.MyClass;
import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReproducerTest {

    @Test
    void randomShouldNotBeNull() {
        List<Integer> result = Instancio.create(MyClass.class).getValues();
        Assertions.assertThat(result).hasSize(1);
    }
}

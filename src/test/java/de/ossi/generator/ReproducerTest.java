package de.ossi.generator;

import de.ossi.IEnum;
import de.ossi.MyClass;
import de.ossi.MyEnum;
import org.instancio.Instancio;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ReproducerTest {

    @RepeatedTest(1000)
    void a_creatingMyClassOrdinalShouldNotBeFilledByInstancio() {
        MyClass myClass = Instancio.create(MyClass.class);
        assertThat(myClass.getAnEnum().ordinal()).isBetween(0, 10);
    }

    @RepeatedTest(1000)
    void b_creatingMyEnumOrdinalShouldNotBeFilledByInstancio() {
        IEnum myEnum = Instancio.create(IEnum.class);
        assertThat(myEnum.ordinal()).isBetween(0, 10);
    }

    @Test
    void c_constantsShouldNotBeChanged() {
        assertAll(() -> {
            assertThat(MyEnum.ENUM_0.ordinal()).isEqualTo(0);
            assertThat(MyEnum.ENUM_1.ordinal()).isEqualTo(1);
            assertThat(MyEnum.ENUM_2.ordinal()).isEqualTo(2);
        });
    }
}

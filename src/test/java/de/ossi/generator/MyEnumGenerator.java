package de.ossi.generator;

import com.google.auto.service.AutoService;
import de.ossi.IEnum;
import de.ossi.MyEnum;
import org.instancio.Node;
import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.spi.InstancioServiceProvider;

@AutoService(InstancioServiceProvider.class)
public class MyEnumGenerator implements Generator<IEnum>, InstancioServiceProvider {

    @Override
    public InstancioServiceProvider.GeneratorProvider getGeneratorProvider() {
        return (node, generators) -> {
            if (matchesNode(node)) {
                return this;
            }
            return null;
        };
    }


    private boolean matchesNode(Node node) {
        return IEnum.class.isAssignableFrom(node.getTargetClass());
    }

    @Override
    public IEnum generate(Random random) {
        int randomOrdinal = random.intRange(0, 10);
        return new MyEnum(randomOrdinal);
    }
}

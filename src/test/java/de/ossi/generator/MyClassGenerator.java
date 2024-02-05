package de.ossi.generator;

import com.google.auto.service.AutoService;
import de.ossi.MyClass;
import org.instancio.Node;
import org.instancio.generator.GeneratorContext;
import org.instancio.internal.generator.util.CollectionGenerator;
import org.instancio.spi.InstancioServiceProvider;
import org.instancio.support.Global;

import java.lang.reflect.Field;
import java.util.List;

@AutoService(InstancioServiceProvider.class)
public class MyClassGenerator extends CollectionGenerator<MyClass> implements InstancioServiceProvider {

    //NoArgs-Constructor needed for ServiceLoader
    public MyClassGenerator() {
        //random is null here:
        this(Global.generatorContext());

        //FIXME The following fixes the problem:
        // this(new GeneratorContext(Global.generatorContext().getSettings(), new DefaultRandom()));
    }

    public MyClassGenerator(GeneratorContext context) {
        super(context);
        size(1);
    }

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
        Field field = node.getField();
        return field != null
                && MyClass.class.isAssignableFrom(field.getDeclaringClass())
                && node.getTargetClass() == List.class;
    }
}

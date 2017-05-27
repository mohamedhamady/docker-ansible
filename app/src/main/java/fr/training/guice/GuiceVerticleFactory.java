package fr.training.guice;

import com.google.common.base.Preconditions;
import com.google.inject.Injector;

import io.vertx.core.Verticle;
import io.vertx.core.impl.verticle.CompilingClassLoader;
import io.vertx.core.spi.VerticleFactory;

public class GuiceVerticleFactory implements VerticleFactory {
	
    public static final String PREFIX = "vertx-guice";
    
    private final Injector injector;

    public GuiceVerticleFactory(Injector injector) {
        this.injector = Preconditions.checkNotNull(injector);
    }

    @Override
    public String prefix() {
        return PREFIX;
    }

    @Override
    public Verticle createVerticle(String prefixedVerticleName, ClassLoader classLoader) throws Exception {
        String verticleName = VerticleFactory.removePrefix(prefixedVerticleName);

        Class<?> clazz;
        if (verticleName.endsWith(".java")) {
            CompilingClassLoader compilingLoader = new CompilingClassLoader(classLoader, verticleName);
            String className = compilingLoader.resolveMainClassName();
            clazz = compilingLoader.loadClass(className);
        } else {
            clazz = classLoader.loadClass(verticleName);
        }
        Verticle verticle = (Verticle) this.injector.getInstance(clazz);
        return verticle;
    }
}

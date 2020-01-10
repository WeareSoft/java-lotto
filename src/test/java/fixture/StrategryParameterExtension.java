package fixture;

import static java.util.Objects.isNull;

import domain.lotto.strategy.RandomStrategy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class StrategryParameterExtension implements ParameterResolver {

    public enum StrategyType {
        RANDOM,
        NONE;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface LottoBuildStrategy {

        StrategyType type() default StrategyType.NONE;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(LottoBuildStrategy.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        LottoBuildStrategy strategy = null;
        if (parameterContext.isAnnotated((LottoBuildStrategy.class))) {
            strategy = parameterContext.getParameter().getAnnotation(LottoBuildStrategy.class);
        }

        if (!isNull(strategy) && strategy.type() == StrategyType.RANDOM) {
            return new RandomStrategy();
        }

        throw new ParameterResolutionException("Not Supported Annotation in Lotto Extension");
    }
}

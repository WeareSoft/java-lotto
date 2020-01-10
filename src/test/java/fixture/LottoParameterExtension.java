package fixture;

import domain.actor.impl.LottoBuilder;
import domain.lotto.Lotto;
import domain.lotto.strategy.RandomNumberStrategy;
import fixture.StrategryParameterExtension.StrategyType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class LottoParameterExtension implements ParameterResolver {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface MockLottoList {

        int size() default 0;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface MockLotto {

        StrategyType type() default StrategyType.RANDOM;
    }


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(MockLottoList.class) || parameterContext.isAnnotated(MockLotto.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (type == List.class && parameterContext.isAnnotated(MockLottoList.class)) {
            Optional<MockLottoList> annotation = parameterContext.findAnnotation(MockLottoList.class);
            int size = annotation.get().size();
            return new LottoBuilder().build(size, new RandomNumberStrategy(size));
        } else if (type == Lotto.class && parameterContext.isAnnotated(MockLotto.class)) {
            int size = 1;
            return new LottoBuilder().build(size, new RandomNumberStrategy(size)).get(0);
        }

        throw new ParameterResolutionException("Not Supported Annotation in Lotto Extension");
    }
}

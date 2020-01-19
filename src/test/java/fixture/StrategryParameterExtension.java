package fixture;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

import domain.lotto.number.LottoNumbers;
import domain.lotto.strategy.ManualNumberStrategy;
import domain.lotto.strategy.RandomNumberStrategy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class StrategryParameterExtension implements ParameterResolver {

    public enum StrategyType {
        MANUAL,
        RANDOM,
        NONE;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface LottoBuildStrategy {

        int size() default 0;

        int[] item() default {};

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
            int size = strategy.size();
            return new RandomNumberStrategy(size);
        } else if (!isNull(strategy) && strategy.type() == StrategyType.MANUAL) {
            List<Long> items = Arrays.stream(strategy.item()).mapToObj(Long::valueOf).collect(toList());
            return new ManualNumberStrategy(new LottoNumbers(items));
        }

        throw new ParameterResolutionException("Not Supported Annotation in Lotto Extension");
    }
}

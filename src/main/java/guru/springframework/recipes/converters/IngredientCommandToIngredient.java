package guru.springframework.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.recipes.commands.IngredientCommand;
import guru.springframework.recipes.commands.UnitOfMeasureCommand;
import guru.springframework.recipes.domain.Ingredient;
import guru.springframework.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());

        UnitOfMeasureCommand sourceUOM = source.getUom();
        UnitOfMeasure convertedUOM = uomConverter.convert(sourceUOM);
        ingredient.setUom(convertedUOM);

        return ingredient;
    }
}
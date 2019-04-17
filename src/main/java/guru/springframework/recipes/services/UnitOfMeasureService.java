package guru.springframework.recipes.services;

import java.util.Set;

import guru.springframework.recipes.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}

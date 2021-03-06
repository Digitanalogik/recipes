package guru.springframework.converters;

import guru.springframework.recipes.commands.CategoryCommand;
import guru.springframework.recipes.converters.CategoryCommandToCategory;
import guru.springframework.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory conveter;

    @Before
    public void setUp() throws Exception {
        conveter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(conveter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(conveter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        // Given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // When
        Category category = conveter.convert(categoryCommand);

        // Then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}
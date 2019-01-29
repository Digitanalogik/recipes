package guru.springframework.recipes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;
        https://www.udemy.com/spring-framework-5-beginner-to-guru/learn/v4/t/lecture/7497686?start=0
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getRecipes() {
    }
}
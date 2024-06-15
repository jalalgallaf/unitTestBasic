Basic of unit test:

| **Function/Annotation**     | **Description**                                                                                      | **Example Usage**                                                                                          |
|-----------------------------|------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| `assertTrue(condition)`     | Asserts that a condition is true.                                                                    | `assertTrue(value > 0);`                                                                                   |
| `assertEquals(expected, actual)` | Asserts that two values are equal.                                                                  | `assertEquals(5, sum(2, 3));`                                                                              |
| `assertNull(value)`         | Asserts that a value is null.                                                                        | `assertNull(object);`                                                                                      |
| `assertThrows(exception, executable)` | Asserts that an executable throws an exception.                                                 | `Executable executable = () -> { functionThatThrowsException(); }; assertThrows(NullPointerException.class, executable);` |
| `assertAll(assertions)`     | Asserts multiple assertions. All assertions are executed and reported together.                      | `assertAll(()->assertEquals(1, 1), ()->assertTrue(true));`                                                  |
| `assertArrayEquals(expected, actual)` | Asserts that two arrays are equal.                                                           | `int[] expected = {1, 2, 3}; int[] actual = {1, 2, 3}; assertArrayEquals(expected, actual);`               |
| `@BeforeEach`               | Indicates that the annotated method should be executed before each test.                             | `@BeforeEach void setup() { // setup code }`                                                               |
| `@AfterEach`                | Indicates that the annotated method should be executed after each test.                              | `@AfterEach void teardown() { // teardown code }`                                                          |
| `@BeforeAll`                | Indicates that the annotated method should be executed once before all tests.                        | `@BeforeAll static void initAll() { // initialization code }`                                              |
| `@AfterAll`                 | Indicates that the annotated method should be executed once after all tests.                         | `@AfterAll static void tearDownAll() { // cleanup code }`                                                  |

Here's a structured breakdown of how these can be used in code:

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MyTests {

    @BeforeAll
    static void initAll() {
        // Code to be executed once before all tests
    }

    @BeforeEach
    void setup() {
        // Code to be executed before each test
    }

    @Test
    void testAssertions() {
        assertTrue(5 > 1);
        assertEquals(4, 2 + 2);
        assertNull(null);

        Executable executable = () -> { throw new NullPointerException(); };
        assertThrows(NullPointerException.class, executable);

        assertAll(
            () -> assertEquals(1, 1),
            () -> assertTrue(true)
        );

        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
    }

    @AfterEach
    void teardown() {
        // Code to be executed after each test
    }

    @AfterAll
    static void tearDownAll() {
        // Code to be executed once after all tests
    }
}
```

This table and code example cover the primary JUnit 5 functionalities you listed, helping you organize your tests efficiently.
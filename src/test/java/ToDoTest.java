import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void ToDoTest() {
        ToDo todo = new ToDo("Do this");
        assertEquals(todo.toString(), "[T][✗]Do this");
        int x = todo.getDoneInt();
        assertEquals(x, 0);
        assertEquals(todo.getStatusIcon(),"✗");
        todo.markasDone();
        assertEquals(todo.getStatusIcon(), "✓");
        x = todo.getDoneInt();
        assertEquals(x, 1);
        assertEquals(todo.toString(), "[T][✓]Do this");
    }
}

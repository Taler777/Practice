package evenIt;

import evenIt.EvenIt;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EvenItTest {

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        EvenIt it = new EvenIt(
                new int[]{1, 2, 3, 4, 5, 6, 7}
        );
        assertThat(it.hasNext(), is(true)); //current =0
        assertThat(it.next(), is(2)); // current = 1
        assertThat(it.hasNext(), is(true)); //current = 1
        assertThat(it.next(), is(4)); //current = 3
        assertThat(it.hasNext(), is(true)); //current = 3
        assertThat(it.next(), is(6)); //current = 5
        assertThat(it.hasNext(), is(false)); //current = 5
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        EvenIt it = new EvenIt(
                new int[]{1, 2, 3, 4, 5, 6, 7}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        EvenIt it = new EvenIt(
                new int[]{1}
        );
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        EvenIt it = new EvenIt(
                new int[]{2, 4, 6, 8}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}
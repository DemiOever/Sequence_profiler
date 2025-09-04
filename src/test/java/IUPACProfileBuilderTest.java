import Logic.IUPACProfileBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class IUPACProfileBuilderTest {

    @Test
    void testAlignedSequencesAreAccepted() {
        IUPACProfileBuilder builder = new IUPACProfileBuilder();
        List<String> sequences = List.of("ATGC", "ATGC", "ATGC");
        String profile = builder.buildProfile(sequences);
        assertNotNull(profile);
    }

    @Test
    void testUnalignedSequencesThrowException() {
        IUPACProfileBuilder builder = new IUPACProfileBuilder();
        List<String> sequences = List.of("ATGC", "ATG");
        assertThrows(IllegalArgumentException.class, () -> builder.buildProfile(sequences));
    }

    private final IUPACProfileBuilder builder = new IUPACProfileBuilder();

    @Test
    void testSingleBases() {
        assertEquals("A", builder.buildProfile(List.of("A")));
        assertEquals("C", builder.buildProfile(List.of("C")));
        assertEquals("G", builder.buildProfile(List.of("G")));
        assertEquals("T", builder.buildProfile(List.of("T")));
    }

    @Test
    void testDoubleCombinations() {
        assertEquals("R", builder.buildProfile(List.of("A", "G")));
        assertEquals("Y", builder.buildProfile(List.of("C", "T")));
        assertEquals("S", builder.buildProfile(List.of("C", "G")));
        assertEquals("W", builder.buildProfile(List.of("A", "T")));
        assertEquals("K", builder.buildProfile(List.of("G", "T")));
        assertEquals("M", builder.buildProfile(List.of("A", "C")));
    }

    @Test
    void testTripleCombinations() {
        assertEquals("V", builder.buildProfile(List.of("A", "C", "G")));
        assertEquals("H", builder.buildProfile(List.of("A", "C", "T")));
        assertEquals("D", builder.buildProfile(List.of("A", "G", "T")));
        assertEquals("B", builder.buildProfile(List.of("C", "G", "T")));
    }

    @Test
    void testQuadrupleCombination() {
        assertEquals("N", builder.buildProfile(List.of("A", "C", "G", "T"))); // Any base
    }
}

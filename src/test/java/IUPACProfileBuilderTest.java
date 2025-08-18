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
}

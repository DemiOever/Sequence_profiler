import java.util.*;

public class IUPACProfileBuilder {

    private static final Map<Set<Character>, Character> IUPAC_MAP = new HashMap<>();

    static {
        // Single bases
        IUPAC_MAP.put(Set.of('A'), 'A');
        IUPAC_MAP.put(Set.of('C'), 'C');
        IUPAC_MAP.put(Set.of('G'), 'G');
        IUPAC_MAP.put(Set.of('T'), 'T');

        // Double base combinations
        IUPAC_MAP.put(Set.of('A', 'G'), 'R');
        IUPAC_MAP.put(Set.of('C', 'T'), 'Y');
        IUPAC_MAP.put(Set.of('G', 'C'), 'S');
        IUPAC_MAP.put(Set.of('A', 'T'), 'W');
        IUPAC_MAP.put(Set.of('G', 'T'), 'K');
        IUPAC_MAP.put(Set.of('A', 'C'), 'M');

        // Triple base combinations
        IUPAC_MAP.put(Set.of('A', 'C', 'G'), 'V');
        IUPAC_MAP.put(Set.of('A', 'C', 'T'), 'H');
        IUPAC_MAP.put(Set.of('A', 'G', 'T'), 'D');
        IUPAC_MAP.put(Set.of('C', 'G', 'T'), 'B');

        // Quadruple base combinations
        IUPAC_MAP.put(Set.of('A', 'C', 'G', 'T'), 'N');

        // Gaps
        IUPAC_MAP.put(Set.of('-'), '-'); // Gap
        IUPAC_MAP.put(Set.of('.'), '.'); // Gap
    }

    /**
     * Builds an IUPAC profile from multiple aligned DNA sequences.
     *
     * @param sequences list of DNA sequences (must be equal length)
     * @return IUPAC profile as string
     */
    public String buildProfile(List<String> sequences) {
        if (sequences == null || sequences.isEmpty()) {
            throw new IllegalArgumentException("No sequences provided");
        }

        int length = sequences.get(0).length();

        // Check equal length
        for (String seq : sequences) {
            if (seq.length() != length) {
                throw new IllegalArgumentException("Sequences are not aligned (different lengths)");
            }
        }

        StringBuilder profile = new StringBuilder();

        for (int i = 0; i < length; i++) {
            Set<Character> columnBases = new HashSet<>();
            for (String seq : sequences) {
                columnBases.add(seq.charAt(i));
            }

            if (isAllGaps(columnBases)) {
                // Use '-' if present, else '.'
                if (columnBases.contains('-')) {
                    profile.append('-');
                } else {
                    profile.append('.');
                }
                continue;
            }

            // Remove gaps for ambiguity calculation
            columnBases.remove('-');
            columnBases.remove('.');

            profile.append(IUPAC_MAP.getOrDefault(columnBases, 'N'));
        }

        return profile.toString();
    }

    private boolean isAllGaps(Set<Character> bases) {
        for (char c : bases) {
            if (c != '-' && c != '.') {
                return false;
            }
        }
        return true;
    }
}

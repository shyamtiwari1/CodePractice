import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("/Users/shyam/Downloads/medclaimscode_1k_slice.txt"));
        String line = bf.readLine();
        List<String[]> patientsData = new ArrayList<>();

        while (line != null) {
            patientsData.add(line.split(","));
            line = bf.readLine();
        }

        List<Set<Pair>> diseasePairsForEachPatient = new ArrayList<>();

        for (String[] diseases : patientsData) {
            Set<Pair> individualPatientPairSet = new HashSet<>();
            for (int i = 0; i < diseases.length - 1; i++) {
                for (int j = i + 1; j < diseases.length; j++) {
                    individualPatientPairSet.add(new Pair(diseases[i].trim(), diseases[j].trim()));
                }
            }
            diseasePairsForEachPatient.add(individualPatientPairSet);
        }

        Map<Pair, Integer> countPair = new HashMap<>();
        for (Set<Pair> patientPairs : diseasePairsForEachPatient) {
            for (Pair dp : patientPairs) {
                countPair.put(dp, countPair.getOrDefault(dp, 0) + 1);
            }
        }

        for (Map.Entry<Pair, Integer> entry : countPair.entrySet()) {
            System.out.println(entry.getKey() + " has count " + entry.getValue());
        }
    }

    static class Pair {
        String disease1, disease2;

        public Pair(String d1, String d2) {
            // Always order alphabetically so ("A","B") ≡ ("B","A")
            if (d1.compareTo(d2) < 0) {
                this.disease1 = d1;
                this.disease2 = d2;
            } else {
                this.disease1 = d2;
                this.disease2 = d1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return Objects.equals(disease1, other.disease1) && Objects.equals(disease2, other.disease2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(disease1, disease2);
        }

        @Override
        public String toString() {
            return "(" + disease1 + ", " + disease2 + ")";
        }
    }
}

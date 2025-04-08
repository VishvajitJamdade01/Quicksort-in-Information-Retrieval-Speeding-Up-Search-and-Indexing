import java.util.Arrays;

class Document {
    String title;
    double relevanceScore;

    Document(String title, double relevanceScore) {
        this.title = title;
        this.relevanceScore = relevanceScore;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Relevance Score: " + relevanceScore;
    }
}

public class IRQuicksortApplication {

    // Quicksort algorithm to sort documents by relevance score (Descending)
    public static void quickSort(Document[] docs, int low, int high) {
        if (low < high) {
            int pi = partition(docs, low, high);
            quickSort(docs, low, pi - 1);
            quickSort(docs, pi + 1, high);
        }
    }

    // Partition logic for Quicksort
    private static int partition(Document[] docs, int low, int high) {
        double pivot = docs[high].relevanceScore;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (docs[j].relevanceScore > pivot) {  // Descending order
                i++;
                Document temp = docs[i];
                docs[i] = docs[j];
                docs[j] = temp;
            }
        }

        Document temp = docs[i + 1];
        docs[i + 1] = docs[high];
        docs[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Sample documents with relevance scores
        Document[] documents = {
            new Document("Document A - AI Trends", 0.85),
            new Document("Document B - Climate Analysis", 0.65),
            new Document("Document C - Data Mining", 0.95),
            new Document("Document D - Robotics", 0.75),
            new Document("Document E - Cybersecurity", 0.90)
        };

        System.out.println("Before Sorting (Unranked Documents):");
        Arrays.stream(documents).forEach(System.out::println);

        // Sort documents by relevance score using quicksort
        quickSort(documents, 0, documents.length - 1);

        System.out.println("\nAfter Sorting (Ranked Documents by Relevance):");
        Arrays.stream(documents).forEach(System.out::println);
    }
}

/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Caden Chock
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        int length1 = doc1.length();
        int length2 = doc2.length();
        int[][] saved = new int[length1][length2];

        int thing = check(doc1,doc2,0,0,saved);
        return thing;
    }

    public static int check(String doc1, String doc2, int index1, int index2, int[][] saved){
       int biggest = 0;
        // Base Case if either word reaches end
        if(index1 >= doc1.length()){
            return 0;
        }
        if(index2 >= doc2.length()){
            return 0;
        }
        // Memoization Step
        if(saved[index1][index2] != 0){
            return saved[index1][index2];
        }
        // If letter matches include
        // Otherwise remove from doc1 and remove from doc2
        if(doc1.charAt(index1) == doc2.charAt(index2)){
            biggest += check(doc1,doc2,index1+1,index2+1,saved) +1;
        }
        else{
            // Get the biggest answer from the going left or down
            biggest = Math.max(check(doc1,doc2,index1+1,index2,saved), check(doc1,doc2,index1,index2+1,saved));
        }
        saved[index1][index2] = biggest;
        return biggest;
    }
}

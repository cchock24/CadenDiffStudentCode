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

        return check(doc1,doc2,0,0,saved);
    }

    public static int check(String doc1, String doc2, int index1, int index2, int[][] saved){
       int[] length = {0,0,0};
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
            length[0] += check(doc1,doc2,index1+1,index2+1,saved) +1;
        }
        else{
            length[1] += check(doc1,doc2,index1+1,index2,saved);
            length[2] += check(doc1,doc2,index1,index2+1,saved);
        }
        // Get the biggest length from all the paths
        int biggest = 0;
        for(int i = 0; i < length.length; i++){
            if(length[i] > biggest){
                biggest = length[i];
            }
        }
        saved[index1][index2] = biggest;
        return biggest;
    }
}

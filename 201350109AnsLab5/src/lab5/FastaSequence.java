package lab5;

public class FastaSequence {
    // fasta sequence    
    protected String comment;
    protected String sequence;
    
    public FastaSequence (String comment, String sequence) {
        this.comment = comment;
        this.sequence = sequence.toUpperCase();
    }
    
    
    @Override
    public String toString() {
        return this.comment + "\n" + this.sequence + "\n";
    }
    
    public String getID() {
        try {
            return this.comment.split("\\|")[1];
        } catch (Exception e) {
            return this.comment;
        }
    }
}

public class SequenceInfo {

    private String name;
    private String seq;
    private int seqSize;
    private double gcContent;

    public SequenceInfo() {

    }

    public SequenceInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public int getSeqSize() {
        return seq.length();
    }

    public void setSeqSize(int seqSize) {
        this.seqSize = seqSize;
    }

    public double getGcContent() {
        return gcContent;
    }

    public void setGcContent(double gcContent) {
        this.gcContent = gcContent;
    }
}

import utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Genome {
    private List<SequenceInfo> sequenceInfoList;
    private int sequenceCount;

    public void getInfo(File file){
        getSequenceInfoFromFile(file);

        //Get the gc content.
        for(SequenceInfo contig : sequenceInfoList){
            contig.setGcContent(getGCContigForSequence(contig));
        }
    }

    /**
     * Get the info of each contig from the genome from the txt file, and store each contig in the sequence info list
     *
     * @param file The genome file.
     */
    public void getSequenceInfoFromFile(File file) {
        sequenceCount = 0;
        sequenceInfoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;
            SequenceInfo sequenceInfo = new SequenceInfo();

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(">")) {
                    //Increment sequence count by 1, there is a new sequence.
                    sequenceCount++;


                    //Add the previous sequence to the list, and wipe it so we can start again
                    if (sequenceInfo.getName() != null) {
                        sequenceInfo.setSeqSize(sequenceInfo.getSeq().length());
                        sequenceInfoList.add(sequenceInfo);

                        //Now wipe.
                        sequenceInfo = new SequenceInfo();
                    }

                    sequenceInfo.setName(currentLine);
                } else {
                    if (sequenceInfo.getSeq() == null) {
                        sequenceInfo.setSeq(currentLine);
                    } else {
                        sequenceInfo.setSeq(sequenceInfo.getSeq().concat(currentLine));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Get the GC amount in a contig.
     * @param sequenceInfo the contig to check
     * @return The GC amount, a double
     */
    public double getGCContigForSequence(SequenceInfo sequenceInfo){
        String seq = sequenceInfo.getSeq();
        int gc = 0;

        for(char aDNA : seq.toCharArray()){
            if(aDNA == 'G' || aDNA == 'C'){
                gc++;
            }
        }

        return (gc / (double) sequenceInfo.getSeqSize()) * 100;
    }

    /**
     * Get a count of the number of contigs in a genome
     *
     * @return The number of contigs in a genome
     */
    public int getSequenceCount() {
        return sequenceCount;
    }

    /**
     * Get the list of contigs in a genome
     *
     * @return the list of contigs in genome.
     */
    public List<SequenceInfo> getSequenceInfoList() {
        return sequenceInfoList;
    }
}

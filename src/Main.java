import utils.FileUtils;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] files = new String[]{"D:\\Git\\GC\\src\\RUG044.txt", "D:\\Git\\GC\\src\\RUG427.txt", "D:\\Git\\GC\\src\\RUG495.txt", "D:\\Git\\GC\\src\\RUG545.txt"};
        List<File> fileList = FileUtils.openMultipleFiles(files);

        Genome genome = new Genome();

        for (int i = 0; i < fileList.size(); i++) {
            System.out.println("Genomes - " + files[i] + "\n");
            genome.getInfo(fileList.get(i));

            List<SequenceInfo> contigList = genome.getSequenceInfoList();

            //Print it all out.
            System.out.println("Number of sequences in genome: " + contigList.size() + "\n");

            for (SequenceInfo contig : contigList) {
                System.out.println(contig.getName() + " - size = " + contig.getSeqSize() + " - GC = " + contig.getGcContent() + "%");
            }
        }
    }
}
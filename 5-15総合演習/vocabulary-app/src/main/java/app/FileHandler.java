package app;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileHandler {
    public static class ImportResult {
        public final int success, skipped;
        public ImportResult(int s,int k){success=s;skipped=k;}
    }

    private static Path resolve(String raw){
        String s = raw==null? "": raw.trim()
            .replaceFirst("^[\"']+","").replaceFirst("[\"']+$","");
        return s.contains("/")? Path.of(s) : Path.of(System.getProperty("user.dir")).resolve(s);
    }

    public ImportResult importFromCSV(String csvPath, WordManager wm) throws Exception {
        Path p = resolve(csvPath);
        int ok=0, ng=0, line=0;
        try(BufferedReader br=Files.newBufferedReader(p, StandardCharsets.UTF_8)){
            String ln;
            while((ln=br.readLine())!=null){
                line++;
                if(line==1 && ln.toLowerCase().startsWith("english,")) continue;
                String[] a = ln.split(",",-1);
                if(a.length<2){ ng++; continue; }

                var res = wm.addWord(new Word(a[0], a[1]));
                if (res == WordManager.AddResult.OK) ok++; else ng++;
            }
        }
        return new ImportResult(ok, ng);
    }

    public int exportToCSV(List<Word> words, String csvPath) throws Exception {
        Path p = resolve(csvPath);
        int rows=0;
        try(BufferedWriter bw=Files.newBufferedWriter(p, StandardCharsets.UTF_8)){
            bw.write("english,japanese"); bw.newLine();
            for(Word w: words){
                String en=w.getEnglish().replace("\"","\"\"");
                String ja=w.getJapanese().replace("\"","\"\"");
                bw.write("\""+en+"\",\""+ja+"\""); bw.newLine(); rows++;
            }
        }
        return rows;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author valdi
 */
public class Util {
    
    Scanner input;  // Create a Scanner object
    
    int ant = 0;
    int pos = 0;
    int ln = 0;
            
    
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    
    public void confMsg(int ant, int pos, int ln) {
        this.ant = ant;
        this.pos = pos;
        this.ln = ln;
    }

    public String msgi(String text) {
        return this.msgi(text, ant, pos, ln);
    }
    
    public String msgi(String text, int ant, int pos, int ln) {
        String spc_ant = "";
        String spc_pos = "";
        String bn = "";
                
        if (ant != 0) {
            spc_ant = StringUtils.repeat(" ",ant);
        } 
        
        if (pos != 0) {
            spc_pos = StringUtils.repeat(" ",pos);
        }
        
        if (ln != 0) {
            bn = StringUtils.repeat("\n",ln);
        }
        
        System.out.print(spc_ant+text+spc_pos+bn);
        
        input = new Scanner(System.in);
        return input.nextLine();
    }

    public String msgi(String text, int ant, int pos) {
        String spc_ant = "";
        String spc_pos = "";
        
        if (ant != 0) {
            spc_ant = StringUtils.repeat(" ",ant);
        } 
        
        if (pos != 0) {
            spc_pos = StringUtils.repeat(" ",pos);
        }

        System.out.print(spc_ant+text+spc_pos);
        input = new Scanner(System.in);
        
        return input.nextLine();
    }
     
    public void msgo(String text) {
        this.msgo(text, ant, pos, ln);
    }
    
    public void msgo(String text, int ant, int pos, int ln) {
        String spc_ant = "";
        String spc_pos = "";
        String bn = "";
        
        if (ant != 0) {
            spc_ant = StringUtils.repeat(" ",ant);
        } 
        
        if (pos != 0) {
            spc_pos = StringUtils.repeat(" ",pos);
        }
        
        if (ln != 0) {
            bn = StringUtils.repeat("\n",ln);
        }
        
        System.out.print(spc_ant+text+spc_pos+bn);

    }
    
    public void msgo(String text, int ant, int pos) {
        String spc_ant = "";
        String spc_pos = "";
        
        if (ant != 0) {
            spc_ant = StringUtils.repeat(" ",ant);
        } 
        
        if (pos != 0) {
            spc_pos = StringUtils.repeat(" ",pos);
        }

        System.out.print(spc_ant+text+spc_pos);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void showTable() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }   
}

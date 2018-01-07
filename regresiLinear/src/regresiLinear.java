
import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aditya C. Pratama
 */
public class regresiLinear {

    private String inputFile;
    String[][] dataexcel = null;
    double[][] data;
    double[][] datakuadrat;
    double[][] mean;
    double hasilxy, hasilkali, hasildata2, b0, b1, x, y, x2;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);

            dataexcel = new String[sheet.getRows() - 1][sheet.getColumns() - 1];
            data = new double[sheet.getRows() - 1][sheet.getColumns() - 1];
            for (int j = 0; j < sheet.getRows() - 1; j++) {
                for (int i = 0; i < sheet.getColumns() - 1; i++) {
                    Cell cell = sheet.getCell(i + 1, j + 1);
                    //dataexcel[j][i] = cell.getContents();
                    data[j][i] = Double.parseDouble(cell.getContents());
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    double xkaliy(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            hasilxy += data[i][0] * data[i][1];
        }
        return hasilxy;
    }

    double hitungB1() {
        double n = data.length;
        b1 = ((n * hasilxy) - (x * y)) / ((n * (x2)) - (x * x));
        return b1;
    }

    double hitungB0() {
        double n = data.length;
        b0 = ((y) - (b1 * x)) / (n);
        return b0;
    }

    double jumlahX(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            x += data[i][0];
        }
        return x;
    }

    double jumlahY(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            y += data[i][1];
        }
        return y;
    }
    double jumlahX2(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            x2 += data[i][0] * data[i][0];
        }
        return x2;
    }
}

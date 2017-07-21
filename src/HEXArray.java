/**
 * Created by Korybut on 11.07.2017.
 */
public class HEXArray {

    private Object[] columnName = {"Column1", "Column2", "Column3", "Column4"};
    private Object[][] data = new Object[7][4];

    public HEXArray(){
    }

    public Object[][] getData(){
        return data;
    }

    public void setData(String value, int row, int col){
        data[row][col] = value;
    }

    public String getCell(int row, int col){
        return String.valueOf(data[row][col]);
    }

    public Object[] getColumnName(){
        return columnName;
    }
}

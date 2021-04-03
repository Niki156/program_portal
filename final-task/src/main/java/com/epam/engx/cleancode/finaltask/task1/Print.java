package com.epam.engx.cleancode.finaltask.task1;



import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.Command;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.DataSet;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.View;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.DatabaseManager;

import java.util.List;


public class Print implements Command {

    private View view;
    private DatabaseManager manager;
    private String tableName;

    public Print(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;
    }

    public boolean canProcess(String command) {
        return command.startsWith("print ");
    }

    public void process(String input) {
        String[] command = input.split(" ");
        if (command.length != 2) {
            throw new IllegalArgumentException("incorrect number of parameters. Expected 1, but is " + (command.length - 1));
        }
        tableName = command[1];
        List<DataSet> data = manager.getTableData(tableName);
        view.write(getTableString(data));
    }

    private String getTableString(List<DataSet> data) {
        int maxColumnSize;
        maxColumnSize = getMaxColumnSize(data);
        if (maxColumnSize == 0) {
            return getEmptyTable(tableName);
        } else {
            return getHeaderOfTheTable(data) + getStringTableData(data);
        }
    }

    private String getEmptyTable(String tableName) {
        String textEmptyTable = "║ Table '" + tableName + "' is empty or does not exist ║";
        String result = "╔";
        for (int i = 0; i < textEmptyTable.length() - 2; i++) {
            result += "═";
        }
        result += "╗\n";
        result += textEmptyTable + "\n";
        result += "╚";
        for (int i = 0; i < textEmptyTable.length() - 2; i++) {
            result += "═";
        }
        result += "╝\n";
        return result;
    }

    private int getMaxColumnSize(List<DataSet> dataSets) {
        int maxLength = 0;
        if (dataSets.size() > 0) {
            List<String> columnNames = dataSets.get(0).getColumnNames();
            for (String columnName : columnNames) {
                if (columnName.length() > maxLength) {
                    maxLength = columnName.length();
                }
            }
            for (DataSet dataSet : dataSets) {
                List<Object> values = dataSet.getValues();
                for (Object value : values) {
                        if (String.valueOf(value).length() > maxLength) {
                            maxLength = String.valueOf(value).length();
                        }
                }
            }
        }
        return maxLength;
    }

    private String getStringTableData(List<DataSet> dataSets) {
        int rowsCount;
        rowsCount = dataSets.size();
        
        int requiredColumnSize = adjustColumnSize(getMaxColumnSize(dataSets));
        String result = "";
        
        int columnCount = getColumnCount(dataSets);
        for (int row = 0; row < rowsCount; row++) {
            List<Object> values = dataSets.get(row).getValues();
            result += "║";
            for (int column = 0; column < columnCount; column++) {
                int valuesLength = String.valueOf(values.get(column)).length();
                for (int j = 0; j < (requiredColumnSize - valuesLength) / 2; j++) {
                    result += " ";
                }
                result += String.valueOf(values.get(column));
                int iterations = (requiredColumnSize-valuesLength)/2;
                if(valuesLength%2!=0)
                	iterations += 1 ;
                    
                    for (int j = 0; j < iterations ; j++) {
                        result += " ";
                    }
                    result += "║";
                
                
            }
            result += "\n";
            if (row < rowsCount -1) {
                result += generateMiddleLinesOfTable(columnCount, requiredColumnSize);
            }
        }
        result += getBorderLine(columnCount, requiredColumnSize, "╚ ╩ ╝");
        return result;
    }

    private int adjustColumnSize(int maxColumnSize) {
    	if (maxColumnSize % 2 == 0) {
            maxColumnSize += 2;
        } else {
            maxColumnSize += 3;
        }
		return maxColumnSize;
	}

	private int getColumnCount(List<DataSet> dataSets) {
        int result = 0;
        if (dataSets.size() > 0) {
            return dataSets.get(0).getColumnNames().size();
        }
        return result;
    }

    private String getHeaderOfTheTable(List<DataSet> dataSets) {
        int requiredColumnSize = adjustColumnSize(getMaxColumnSize(dataSets));
        String result = "";
        int columnCount = getColumnCount(dataSets);
        result = getBorderLine(columnCount, requiredColumnSize, "╔ ╦ ╗");
        List<String> columnNames = dataSets.get(0).getColumnNames();
        for (int column = 0; column < columnCount; column++) {
            result += "║";
            int columnNamesLength = columnNames.get(column).length();
            for (int j = 0; j < (requiredColumnSize - columnNamesLength) / 2; j++) {
                result += " ";
            }
            result += columnNames.get(column);
            
            for (int j = 0; j < columnNamesLength%2 +  (requiredColumnSize - columnNamesLength) / 2; j++) {
                result += " ";
            }
           
        }
        result += "║\n";

        //last string of the header
        if (dataSets.size() > 0) {
            result += generateMiddleLinesOfTable(columnCount, requiredColumnSize);
        } else {
        	result+=getBorderLine(columnCount, requiredColumnSize, "╚ ╩ ╝" );
            
        }
        return result;
    }

	private String generateMiddleLinesOfTable(int columnCount, int requiredColumnSize) {
		String result = "╠";
        for (int j = 1; j < columnCount; j++) {
            for (int i = 0; i < requiredColumnSize; i++) {
                result += "═";
            }
            result += "╬";
        }
        for (int i = 0; i < requiredColumnSize; i++) {
            result += "═";
        }
        result += "╣\n";
        return result;
	}

	private String getBorderLine(int columnCount, int requiredColumnSize, String pattern) {
		String pieces[] = pattern.split(" ");
		String leftPiece = pieces[0], middlePiece = pieces[1], rightPiece=pieces[2];
		
		String result = leftPiece;
        for (int j = 1; j < columnCount; j++) {
            for (int i = 0; i < requiredColumnSize; i++) {
                result += "═";
            }
            result += middlePiece;
        }
        for (int i = 0; i < requiredColumnSize; i++) {
            result += "═";
        }
        result += rightPiece+"\n";
        return result;
	}
}
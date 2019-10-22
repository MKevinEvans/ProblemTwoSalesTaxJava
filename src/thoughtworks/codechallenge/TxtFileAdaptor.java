package thoughtworks.codechallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TxtFileAdaptor {
    private String fileName;

    public TxtFileAdaptor(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        String[] fileAsArray = this.fileToArray(this.fileName);
        int[] emptyLines = this.findEmptyLines(fileAsArray);
        this.makeBaskets(this.formatDataForBaskets(fileAsArray, emptyLines));
        }


    private String[] fileToArray(String fileName) throws FileNotFoundException{
            Scanner input = new Scanner(new File(fileName));
            String[] fileAsArray = new String[this.scanNumberOfLines(fileName)];
            int lineCount = 0;
            while(input.hasNextLine()){
                fileAsArray[lineCount] = input.nextLine();
                lineCount +=1;
            }
            return fileAsArray;
        }

    private int scanNumberOfLines(String fileName) throws FileNotFoundException{
        Scanner inputForNumberOfLines = new Scanner(new File(fileName));
        int lineCount = 0;
        while(inputForNumberOfLines.hasNextLine()){
            inputForNumberOfLines.nextLine();
            lineCount += 1;
        }
        return lineCount;
    }

    private String[][] formatDataForBaskets(String[] array, int[] emptyIndexes){
        String[][] inputData = new String[(emptyIndexes.length+1)][];
//          FOR CASES WHERE THERE ARE NO EMPTY LINE (I.E. ONLY ONE INPUT IS PRESENT)
        if(emptyIndexes.length == 0)
            emptyIndexes = new int[] {array.length-1};
        for(int i = 0; i < inputData.length; i++){
//          FOR FIRST INPUT, WHERE BEGINNING IS ALWAYS 0:
            if(i == 0){
                inputData[i] = Arrays.copyOfRange(array, 0, emptyIndexes[i]);
            }
//          FOR LAST INPUT, WHERE END IS ALWAYS END OF ARRAY:
            else if(i == emptyIndexes.length){
                inputData[i] = Arrays.copyOfRange(array, (emptyIndexes[emptyIndexes.length-1])+1, array.length);
            }
//          FOR ALL INPUTS AFTER FIRST AND BEFORE LAST:
            else{
                inputData[i] = Arrays.copyOfRange(array, (emptyIndexes[i-1]+1), emptyIndexes[i]);
            }
        }
        return inputData;
    }

    private int[] findEmptyLines(String [] array){
        List<Integer> emptyLines = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if (array[i].isEmpty()){
                emptyLines.add(i);
            }
        }
        return emptyLines.stream().mapToInt(i -> i).toArray();
    }

    private void makeBaskets(String[][] formattedInputData){
        for(String[] basket : formattedInputData){
            new Basket(basket);
        }
    }
}

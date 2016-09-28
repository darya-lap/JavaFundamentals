package Task_1_File_Directory;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class FilleDirectoryTest {
    FileDirectory fileDirectory = new FileDirectory("H:\\Java-EPAM");

    @Test
    public void startWorking(){
        fileDirectory.setRoot(fileDirectory);
        System.out.println("Папки:\n" + fileDirectory.getDirectoriesList() + "\n");
        System.out.println("Текстовые файлы:\n" + fileDirectory.getTextFilesList() + "\n");
        System.out.println("Другие файлы:\n" + fileDirectory.getOtherFilesList() + "\n");

        assertNotNull(fileDirectory);
        assertThat(fileDirectory.getDirectoriesList(),containsString("Tasks"));
        assertEquals(fileDirectory.getTextFilesList(),null);
        assertEquals(fileDirectory.getOtherFilesList(),null);
    }

    @Test
    public void showInDirectoryTest(){
        fileDirectory.setRoot(fileDirectory);
        int i = 5;
        assertEquals(fileDirectory.showInDirectory(i), null);
        i = 3;
        assertEquals(fileDirectory.showInDirectory(i), "Текстовые файлы:\n1. text1.txt\n");
    }

    @Test
    public void CreateTextFile(String fileName){
        fileDirectory.setRoot(fileDirectory);

    }

    @Test
    public void GetBackDirectory(){
        fileDirectory.setRoot(fileDirectory);
        fileDirectory = fileDirectory.goIn(2);
        fileDirectory = fileDirectory.goIn(1);
        fileDirectory = fileDirectory.goBack();
        assertEquals(fileDirectory.getName(),"Tasks");
    }


}

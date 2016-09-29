package Task_1_File_Directory;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class FilleDirectoryTest {
    FileDirectory fileDirectory = new FileDirectory("H:\\Java-EPAM");

    @Test
    public void startWorking(){
        if(fileDirectory.startApp()) {
            System.out.println("Папки:\n" + fileDirectory.getDirectoriesList() + "\n");
            System.out.println("Текстовые файлы:\n" + fileDirectory.getTextFilesList() + "\n");
            System.out.println("Другие файлы:\n" + fileDirectory.getOtherFilesList() + "\n");
        }
        else{
            fileDirectory = null;
        }
        assertNotNull(fileDirectory);
        assertThat(fileDirectory.getDirectoriesList(), containsString("Tasks"));
        assertEquals(fileDirectory.getTextFilesList(), null);
        assertEquals(fileDirectory.getOtherFilesList(), null);

    }




    @Test
    public void showInDirectoryTest() {
        fileDirectory.startApp();
        int i = 6;
        assertEquals(fileDirectory.showInDirectory(i), null);
        i = 4;
        assertEquals(fileDirectory.showInDirectory(i), "Текстовые файлы:\n1. text1.txt\n");
    }
//
//    @Test
//    public void CreateTextFile(){
//        fileDirectory.setRoot(fileDirectory);
//
//    }
//
    @Test
    public void GoInExistAndNonexistDirectories(){
        fileDirectory.startApp();
        try{
            int i = 6;
            fileDirectory.goIn(i);
            assertThat(fileDirectory.getName(), is("Java-EPAM"));
            i = 3;
            fileDirectory.goIn(i);
            assertEquals(fileDirectory.getName(),"Tasks");
            }
            catch (FileNotFoundException e){

            }
    }

    @Test
    public void GetBackDirectoryFromRoot(){
        fileDirectory.startApp();
        try{
            fileDirectory = fileDirectory.goBack();
        }
        catch (FileNotFoundException e){

        }
        assertEquals(fileDirectory.getName(),"Java-EPAM");
    }

    @Test
    public void GetBackDirectory(){
        fileDirectory.startApp();
        try{
            fileDirectory = fileDirectory.goIn(3);
            fileDirectory = fileDirectory.goIn(2);
            fileDirectory = fileDirectory.goBack();
        }
        catch (FileNotFoundException e){

        }
        assertEquals(fileDirectory.getName(),"Tasks");
    }

}

package le.playlistprojectleeannaewing;

/* 
Created by LeeAnna Ewing 
CSC249 Data Structures and Algorithm Analysis
Project - 1 
*/

// Playlist Demo
import java.util.*;



public class PlaylistDemo
{
   public static void main(String[] args)
   {
      int menuOption; 
      Song currentSong = null;
   
      Scanner keyboard = new Scanner(System.in);
   
      Playlist pl = new Playlist();
   
      do
      {
         System.out.println("\nPlease select a playlist function from the list below");
         System.out.println("1. Add a song \n" +
                       "2. Insert a new song after currently playing song \n" +
                       "3. Display playlist contents \n" +
                       "4. Show current song \n" +
                       "5. Delete current song \n" +
                       "6. Fast Forward >>\n" +
                       "7. Rewind <<\n" +
                       "8. Exit ");
         System.out.println("Enter a numerical selection from the menu: ");
         menuOption = keyboard.nextInt();
      
         while(menuOption < 1 || menuOption > 8)
         {
            System.out.println("Invalid menu selection. Please try again: ");
            System.out.println("Enter a numerical selection from the menu: ");
            menuOption = keyboard.nextInt();
         }
      
          //change menu options to show usage of switch as well as if and else tools
          switch (menuOption) {
              case 1:
                  {
                      keyboard.nextLine(); //clear buffer
                      System.out.println("Please enter the song's title: ");
                      String sName = keyboard.nextLine();
                      System.out.println("Please enter the song's artist: ");
                      String sArtist = keyboard.nextLine();
                      System.out.println("Please enter the song's album: ");
                      String sAlbum = keyboard.nextLine();
                      System.out.println("Please enter the song's length in seconds: ");
                      int sLength = keyboard.nextInt();
                      Song song = new Song(sName, sArtist, sAlbum, sLength);
                      if(pl.getHeadPointer() == null)
                      {
                          currentSong = song;
                      }         pl.appendSong(song);
                      break;
                  } //menu option 1
              case 2:
                  {
                      keyboard.nextLine(); //clear buffer
                      System.out.println("Please enter the new song's title: ");
                      String sName = keyboard.nextLine();
                      System.out.println("Please enter the new song's artist: ");
                      String sArtist = keyboard.nextLine();
                      System.out.println("Please enter the new song's album: ");
                      String sAlbum = keyboard.nextLine();
                      System.out.println("Please enter the new song's length in seconds: ");
                      int sLength = keyboard.nextInt();
                      Song song = new Song(sName, sArtist, sAlbum, sLength);
                      pl.insertAfter(currentSong, song);
                      if(currentSong == null)
                          currentSong = song;
                      break;
                  } //menu option 2
          //menu option 3
              case 3:
                  pl.toString();
                  break;
          //menu option 4
              case 4:
                  if (currentSong != null)
                  {
                      System.out.println(currentSong);
                  }
                  else
                  {
                      System.out.println("null");//make this more meaningful
                  }     break;
          //menu option 5
              case 5:
                  if(currentSong == null)
                  {
                      System.out.println("There is nothing to delete. Try adding a song.");
                  }
                  else
                  {
                      Song songAfterCurrent = pl.getSongNext(currentSong);
                      if(songAfterCurrent == currentSong)
                      {
                          pl.removeSong(currentSong);
                          currentSong = null;
                      }
                      else
                      {
                          pl.removeSong(currentSong);
                          currentSong = songAfterCurrent;
                      }
                  }     break;
          // menu option 6
              case 6:
                  if(currentSong == null)
                  {
                      System.out.println("It appears your playlist is empty. Try adding a song.");
                  }
                  else
                  {
                      Song songAfterCurrent = pl.getSongNext(currentSong);
                      currentSong = songAfterCurrent;
                      
                      System.out.println("Now Playing: " + currentSong.getName());
                  }     break;
          // menu option 7
              case 7:
                  if(currentSong == null)
                  {
                      System.out.println("It appears your playlist is empty. Try adding a song.");
                  }
                  else
                  {
                      Song songBeforeCurrent = pl.getSongPrevious(currentSong);
                      currentSong = songBeforeCurrent;
                      
                      System.out.println("Now Playing: " + currentSong.getName());
                  }     break;
              default:
                  break;
          }
           
      
      }while(menuOption != 8);
   }//close main
}//Close class PlaylistDemo
//Fine
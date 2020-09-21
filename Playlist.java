package le.playlistprojectleeannaewing;

/* 
Created by LeeAnna Ewing 
CSC249 Data Structures and Algorithm Analysis
Project - 1 
*/

// Playlist Class

public class Playlist
{
   //fields
   private Song headPointer;
   private Song tailPointer;
   private int playlistSize;     //num of songs in the playlist
   private int playlistLength;   // total playlist duration in seconds
    
   /**
      No Arg Constructor
   */
   public Playlist()
   {
      headPointer = null;
      tailPointer = null;
      playlistSize = 0;
      playlistLength = 0;  
   }// close no-arg constructor

   public void appendSong(Song song) //add a song to empty list or add to end
   {
      //if list is empty
      if(headPointer == null)
      {
         headPointer = song; //head and tail point to the new song
         tailPointer = song;        
         headPointer.setPrevious(tailPointer); //the headpointers previous is set to the tailpointer
         tailPointer.setNext(headPointer); //the tailpointers next is set to the headpointer
      }
      else
      {
         tailPointer.setNext(song); //tailpointers next moved to point to the added song
         song.setPrevious(tailPointer); //songs previous set to the tailpointer
         tailPointer = song;   //tailpointer now points to the added song 
         tailPointer.setNext(headPointer); //tailpointer next now moved to refer back to the headpointer
         headPointer.setPrevious(tailPointer); //headpointer prev now moved to refer back to tailpointer
      }
       
      //consider moving to the demo
      System.out.println("\n\""+song.getName()+"\" has been added to the playlist.\n");
       
      playlistLength += song.getLength(); //songs length value added to the total playlist length
      playlistSize++; //playlist size inscreased by 1 song object
   }
   
 
   public void insertAfter(Song chosenNode, Song song)
   {
      if (headPointer == null || chosenNode == null) 
      { 
        // If List Empty
         System.out.println("\nThe playlist does not contain any songs"); 
         System.out.println("However, \"" + song.getName()+"\" has been added to the playlist.\n");
         appendSong(song);  
      }
      else if (chosenNode == tailPointer)
      {
         //if just adding behind tail
         appendSong(song);
      }
      else
      {  
         //if adding somewhere besides tail       
         Song oldNextSong = chosenNode.getNext();
         song.setNext(oldNextSong);
         song.setPrevious(chosenNode);
         chosenNode.setNext(song);
         oldNextSong.setPrevious(song);   
         
         playlistLength += song.getLength();
         playlistSize++; 
         
         System.out.println("\"" + song.getName() + "\" has been added to the playlist.\n");
      }    
   }//close insertAfter
   
   public void removeSong(Song song)
   {
   
      Song songAfterSong = song.getNext();
      Song songBeforeSong = song.getPrevious();
    
      if(song == headPointer && song != tailPointer)
      {
         headPointer = songAfterSong;
         tailPointer.setNext(songAfterSong);
         songBeforeSong.setNext(songAfterSong);
         songAfterSong.setPrevious(songBeforeSong);
      
         System.out.println("\"" + song.getName() + "\" has been removed from the playlist.\n");
      
      }
      else if(song == tailPointer && song != headPointer)
      {
         tailPointer = songBeforeSong;
         headPointer.setPrevious(songBeforeSong); 
         songBeforeSong.setNext(songAfterSong);
         songAfterSong.setPrevious(songBeforeSong);
      
      
         System.out.println("\"" + song.getName() + "\" has been removed from the playlist.\n");
      
      }
      else if(song == tailPointer && song == headPointer)
      {
         System.out.println("\"" + song.getName() + "\" has been removed from the playlist.\n");
         tailPointer = null;
         headPointer = null;
         System.out.println("Your playlist is now empty");
      
      }
      else
      {
         songBeforeSong.setNext(songAfterSong);
         songAfterSong.setPrevious(songBeforeSong);
      
      
         System.out.println("\"" + song.getName() + "\" has been removed from the playlist.\n");
       }
   
      playlistLength -= song.getLength();
      playlistSize--;  
   }
   //replace for each loop with while loop for formating reasons
   @Override
   public String toString()
   {
      String playListData = "";
      Song i;
      i = headPointer;
   
      // We start at the beginning of the list, @ the first node. Make sure it's not null.
      if( headPointer == null)
      {
         System.out.println("Playlist is empty. No data to show.");
      }
      else if (i != null)
      {
         System.out.println("\n------------------------------");
         do
         {
         // Get a string of the current song.
            playListData += i.toString() + "\n------------------------------\n";
         
         // move on to the next song.
            i = i.getNext();
         
         } while(i != headPointer);
      
         System.out.println(playListData);
      
         System.out.println("Songs in playlist: " + playlistSize);
         int minutes = playlistLength / 60;
         int seconds = playlistLength % 60;
         System.out.println("Playlist length: " + minutes + " minutes " + seconds + " seconds\n");
      }
      return playListData;  
   }
 
   /**
      @return - the value in the headPointer field
   */
   public Song getHeadPointer()
   {
      return headPointer;
   }

   //get the next song object
   public Song getSongNext(Song song)
   {
      
      return song.getNext();
   }
   
   //get the previous song object
   public Song getSongPrevious(Song song)
   {
      return song.getPrevious();
   }

}//Close class Playlist
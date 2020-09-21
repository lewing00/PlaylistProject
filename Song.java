package le.playlistprojectleeannaewing;

// consider adding copy constructor


/* 
Created by LeeAnna Ewing 
CSC249 Data Structures and Algorithm Analysis
Project - 1 
*/

// Song Class

public class Song
{

   //fields
   private String songName;
   private String songArtist;
   private String songAlbum;
   private int songLength; //song length in seconds
   private Song next;
   private Song previous;
   
   /** 
      Constructor that accepts arguments for the Song name, artist, album, and length.    
      This constructor can be used to initialize the fields. 
      @param sName - Song Name    
      @param sArtist - Song Artist
      @param sAlbum - Song Album
      @param sLength - Song Length (seconds)
   */
    
   public Song(String sName, String sArtist, String sAlbum, int sLength)
   {
      songName = sName;
      songArtist = sArtist;
      songAlbum = sAlbum;
      songLength = sLength;
   }// close constructor
   
   /**
      No Arg Constructor
   */
   public Song()
   {
      songName = "NA";
      songArtist = "NA";
      songAlbum = "NA";
      songLength = 0;
   }// close no-arg constructor
  
    //Setters
   
   /**
      The setName method sets the song name.
      @param sName The song's name.
   */
   public void setName(String sName)
   {
      songName = sName;
   }

   /**
      The setArtist method sets the song artist name.
      @param sArtist The song artist's name.
   */
   public void setArtist(String sArtist)
   {
      songArtist = sArtist;
   }
   
   /**
      The setAlbum method sets the song album name.
      @param sAlbum The song album's name.
   */
   public void setAlbum(String sAlbum)
   {
      songAlbum = sAlbum;
   }
   
   /**
      The setLength method sets the song length in seconds.
      @param sLength The song's length in seconds.
   */
   public void setLength(int sLength)
   {
      songLength = sLength;
   }
   
   public void setNext(Song next)
   {
      this.next = next;
   }
   
   public void setPrevious(Song previous)
   {
      this.previous = previous;
   }
   
//Getters

   /**
      @return - the value in the songName field
   */
   public String getName()
   {
      return songName;
   }
   
   /**
      @return - the value in the songArist field
   */
   public String getArtist()
   {
      return songArtist;
   }
   
   /**
      @return - the value in the songAlbum field
   */
   public String getAlbum()
   {
      return songAlbum;
   }
   
   /**
      @return - the value in the songLength field
   */
   public int getLength()
   {
      return songLength;
   }

   /**
      @return - the next song
   */
   public Song getNext()
   {
      return next;
   }
    
   /**
      @return - the previous song
   */
   public Song getPrevious()
   {
      return previous;
   }
   
   @Override
   public String toString()
   {
      return "Name: " + songName + "\n" +
             "Artist: " + songArtist + "\n" +
             "Album: " + songAlbum + "\n" +
             "Duration: " + songLength;
   }
  
}//Close class Song
//Fine
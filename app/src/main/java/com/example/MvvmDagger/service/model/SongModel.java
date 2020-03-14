package com.example.MvvmDagger.service.model;

public class SongModel
{
    private int id;
    private String artist;
    private String song;

    public SongModel(int id, String artist, String song)
    {
        this.id = id;
        this.artist = artist;
        this.song = song;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getSong()
    {
        return song;
    }

    public void setSong(String song)
    {
        this.song = song;
    }
}

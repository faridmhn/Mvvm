package com.example.MvvmDagger.service.model;

public class AlbumModel
{
    private int id;
    private String title;
    private String artist;
    private String pic;

    public AlbumModel(int id, String title, String artist, String pic)
    {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.pic = pic;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPic()
    {
        return pic;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }
}

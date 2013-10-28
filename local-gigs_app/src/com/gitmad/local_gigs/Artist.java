package com.gitmad.local_gigs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thedekel on 10/27/13.
 */
public class Artist {
    @SerializedName("name")
    public String name;

    public int age;

    public String info;

    //Extra code for using gson below
    @SerializedName("listeners")
    public String listeners;

    @SerializedName("mbid")
    public String mbid;

    @SerializedName("url")
    public String url;

    @SerializedName("image")
    public List<ArtistImages> image;
}

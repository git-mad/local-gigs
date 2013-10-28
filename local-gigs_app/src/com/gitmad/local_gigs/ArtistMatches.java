package com.gitmad.local_gigs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thedekel on 10/27/13.
 */
public class ArtistMatches {
    @SerializedName("artist")
    public List<Artist> artists;
}

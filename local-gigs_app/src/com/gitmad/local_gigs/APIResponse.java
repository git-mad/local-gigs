package com.gitmad.local_gigs;

import com.google.gson.annotations.SerializedName;
/**
 * Created by thedekel on 10/27/13.
 */
public class APIResponse {
    @SerializedName("results")
    public SearchResults results;
}

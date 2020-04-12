package com.myfin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Rate {
    @SerializedName("Cur_ID")
    String id;
    @SerializedName("Date")
    String date;
    @SerializedName("Cur_Abbreviation")
    String currencyAbbrev;
    @Expose
    @SerializedName("Cur_OfficialRate")
    double officialRate;
}

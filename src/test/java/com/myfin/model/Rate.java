package com.myfin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Rate {
    @Expose
    @SerializedName("Cur_ID")
    String id;

    @Expose
    @SerializedName("Date")
    String date;
    @Expose
    @SerializedName("Cur_Abbreviation")
    String currencyAbbrev;

    @Expose
    @SerializedName("Cur_OfficialRate")
    double officialRate;
}
